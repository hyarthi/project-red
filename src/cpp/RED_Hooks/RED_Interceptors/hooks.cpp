#pragma once

#include "hooks.hpp"

namespace red {
	namespace hooks {

		// globals
		EID gNoteOps[] = { EM_NSFNOTEOPEN, EM_NSFNOTEOPENBYUNID, EM_NSFNOTEOPENEXTENDED, EM_NSFNOTECLOSE, EM_NSFNOTEUPDATE, 0 };
		EID gNoteInfoOps[] = { EM_NSFNOTEGETINFO, EM_NSFNOTESETINFO, EM_NSFDBGETNOTEINFO, EM_NSFDBGETNOTEINFOBYUNID, 0 };
		EID gNIFOps[] = { 0 };
		HookManager * gHM = (HookManager *)NULL;
		using red::hooks::log::gLog;
		
		HookManager::HookManager(HINSTANCE hInstance) {
			NM = red::hooks::net::gNMInstance;

			// set up
			emhNoteOps = (EMHANDLER)MakeProcInstance((FARPROC)functions::ProcessNoteOps, hInstance);
			//emhNoteInfoOps = (EMHANDLER)MakeProcInstance((FARPROC)ProcessNoteInfoOps, hInstance);
			//emhNIFOps = (EMHANDLER)MakeProcInstance((FARPROC)ProcessNIFOps, hInstance);
			EMCreateRecursionID(&RecursionID);
			hemrNoteOps = new HEMREGISTRATION[5];

			hooksRegistered = false;
		}

		STATUS HookManager::StartUp() {
			// if Network Manager is not running, then there's no point in starting
			if (hooksRegistered)
				return RH_ERR_NM_ERROR;
			if (NULL == NM) {
				return RH_ERR_NM_ERROR;
			}
			char dblistparam[] = INI_PARAM_DBLIST;
			char dblistsetting[MAXENVVALUE + 1];

			//gLog->OpenLogFile(LOGGER_OPEN_APPEND);
			gLog->LogLine("Starting up HookManager...\n");

			dbNameCount = 0;
			dbNames = vector<string>(0);
			// get db names
			if (OSGetEnvironmentString(dblistparam, dblistsetting, (WORD)(MAXENVVALUE))) {
				gLog->LogLine("RED_DB_LIST is %s\n", dblistsetting);
				if (strlen(dblistsetting) > 0) {
					char * part = strtok(dblistsetting, ",");
					if ((char *)NULL == part) {
						gLog->LogLine("No commas found...\n");
						//dbNames = new string[1];
						//dbNames = (string *)malloc(sizeof(string));
						//*dbNames = (char *)malloc(strlen(dblistsetting) + 1);
						//memcpy(*dbNames, dblistsetting, strlen(dblistsetting) + 1);
						string bufstr = dblistsetting;
						replace(bufstr.begin(), bufstr.end(), '/', '|');
						replace(bufstr.begin(), bufstr.end(), '\\', '|');
						dbNames += bufstr;
						dbNameCount = 1;
					}
					else {
						gLog->LogLine("Commas found...\n");
						gLog->LogLine("Comma is: %p (%c)\n", part, *part);
						gLog->FlushNow();
						//dbNameCount = 0;
						//char * bufptr;
						//dbNames = nullptr;
						dbNames = vector<string>(0);
						while ((char *)NULL != part) {
							/*if ((string *)NULL == dbNames)
								dbNames = (string *)malloc(sizeof(string));
							else
								dbNames = (string *)realloc(dbNames, (dbNameCount + 1) * sizeof(string));*/
							//bufptr = dbNames[dbNameCount];
							//bufptr = (char *)malloc(strlen(part) + 1);
							//memcpy(bufptr, part, strlen(part) + 1);
							//dbNames[dbNameCount] = bufptr;
							//memcpy(&bufptr, dbNames[dbNameCount], sizeof(char *));
							string bufstr = part;
							replace(bufstr.begin(), bufstr.end(), '/', '|');
							replace(bufstr.begin(), bufstr.end(), '\\', '|');
							dbNames += bufstr;
							dbNameCount++;
							part = strtok(NULL, ",");
						}
					}
				}
				//else dbNames = (string *)NULL;
			}
			//else dbNames = (string *)NULL;

			//gLog->CloseLogFile();

			if (!hooksRegistered)
				RegisterHooks();

			return RH_ERR_NM_NOERROR;
		}

		bool HookManager::isHooksRegistered() {
			return hooksRegistered;
		}

		::STATUS HookManager::RegisterHooks() {
			::STATUS err = NOERROR;
			gLog->LogLine("Registering hooks...\n");
			gLog->FlushNow();
			// EM_NSFNOTEOPEN
			err = EMRegister(gNoteOps[0], EM_REG_BEFORE | EM_REG_AFTER, emhNoteOps, RecursionID, &(hemrNoteOps[0]));
			// EM_NSFNOTEOPENBYUNID
			err = EMRegister(gNoteOps[1], EM_REG_BEFORE | EM_REG_AFTER, emhNoteOps, RecursionID, &(hemrNoteOps[1]));
			// EM_NSFNOTEOPENEXTENDED
			err = EMRegister(gNoteOps[2], EM_REG_BEFORE | EM_REG_AFTER, emhNoteOps, RecursionID, &(hemrNoteOps[2]));
			// EM_NSFNOTECLOSE
			// EM_NSFNOTEUPDATE

			hooksRegistered = true;
			gLog->LogLine("Done registering hooks...\n");
			gLog->FlushNow();
			return err;
		}

		::STATUS HookManager::DeregisterHooks() {
			::STATUS err = NOERROR;
			// NoteOps
			// EM_NSFNOTEOPEN
			err = EMDeregister(hemrNoteOps[0]);
			// EM_NSFNOTEOPENBYUNID
			err = EMDeregister(hemrNoteOps[1]);
			// EM_NSFNOTEOPENEXTENDED
			err = EMDeregister(hemrNoteOps[2]);
			// EM_NSFNOTECLOSE
			// EM_NSFNOTEUPDATE
			return err;
		}

		HookManager::~HookManager() {
			NM = NULL;
			FreeProcInstance(emhNoteOps);
		}

		int HookManager::GetDbNameCount() {
			return this->dbNameCount;
		}

		char * HookManager::GetDbName(int idx) {
			if (idx >= dbNameCount)
				return "";
			char * cstr = new char[dbNames[idx].length() + 1];
			strcpy(cstr, dbNames[idx].c_str());
			return cstr;
		}

		string HookManager::GetDbNameStr(int idx) {
			string nullres = "";
			if (idx >= dbNameCount)
				return nullres;
			return dbNames[idx];
		}

		namespace functions {

			//typedef google::protobuf::Map<string, Item> Map;

			// Process Ops

			::STATUS LNPUBLIC ProcessNoteOps(EMRECORD * record) {
				::STATUS error = NOERROR;
				VARARG_PTR ap;
				DBHANDLE hDB;
				NOTEHANDLE * hNote;
				NOTEID id;
				DWORD flags, sequence;
				WORD sflags;
				BYTE * key;
				UNID unid;
				char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
				char far path[MAX_PATH + 1];
				char far upath[2 * (MAX_PATH + 1)];
				int matchDB;
				string spath, rpath;

				try {
					// get function args
					ap = record->Ap;
					/*gLog->OpenLogFile(LOGGER_OPEN_APPEND);
					gLog->LogLine("BLING!\n");
					gLog->CloseLogFile();*/

					switch (record->EId)
					{
					case EM_NSFNOTEOPEN:
						hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
						id = (NOTEID)VARARG_GET(ap, NOTEID);
						sflags = (WORD)VARARG_GET(ap, WORD);
						hNote = (NOTEHANDLE *)VARARG_GET(ap, NOTEHANDLE *);

						NSFDbPathGet(hDB, path, buf2);
						spath = path;
						replace(spath.begin(), spath.end(), '/', '|');
						replace(spath.begin(), spath.end(), '\\', '|');
						for (int i = 0; i < gHM->GetDbNameCount(); i++) {
							matchDB = spath.compare(gHM->GetDbNameStr(i));
							if (matchDB == 0)
								break;
						}

						if (matchDB == 0) {
							gLog->OpenLogFile("a+");
							gLog->LogLine("-----------------------------------\n");
							if (record->NotificationType == EM_BEFORE) {
								gLog->LogLine("Intercepted before Note Open.\n");

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("ID: %X\n", id);
								gLog->LogLine("Flags: 0x%X\n", sflags);
								if (*hNote)
									gLog->LogLine("Note handle is: %p\n", *hNote);
								else
									gLog->LogLine("Note handle is not defined\n");
							}
						}

						break;
					case EM_NSFNOTEOPENEXTENDED:
						hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
						id = (NOTEID)VARARG_GET(ap, NOTEID);
						flags = (DWORD)VARARG_GET(ap, DWORD);
						sequence = (DWORD)VARARG_GET(ap, DWORD);
						key = (BYTE *)VARARG_GET(ap, BYTE *);
						hNote = (NOTEHANDLE *)VARARG_GET(ap, NOTEHANDLE *);

						NSFDbPathGet(hDB, path, buf2);
						spath = path;
						replace(spath.begin(), spath.end(), '/', '|');
						replace(spath.begin(), spath.end(), '\\', '|');
						for (int i = 0; i < gHM->GetDbNameCount(); i++) {
							matchDB = spath.compare(gHM->GetDbNameStr(i));
							if (matchDB == 0)
								break;
						}
						/*gLog->OpenLogFile(LOGGER_OPEN_APPEND);
						gLog->LogLine("BLING! - %d\n", matchDB);
						gLog->CloseLogFile();*/

						if (matchDB == 0) {
							gLog->OpenLogFile("a+");
							gLog->LogLine("-----------------------------------\n");
							gLog->FlushNow();
							if (record->NotificationType == EM_BEFORE) {
								gLog->LogLine("Intercepted before Note Open Ext.\n");
								gLog->FlushNow();
								gLog->LogLine("Info: \n");
								gLog->FlushNow();
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->FlushNow();
								gLog->LogLine("ID: %X\n", id);
								gLog->FlushNow();
								gLog->LogLine("Flags: 0x%X\n", flags);
								gLog->FlushNow();
								gLog->LogLine("Sequence: %X\n", sequence);
								gLog->FlushNow();
								if (*hNote)
									gLog->LogLine("Note handle is: %p\n", *hNote);
								else
									gLog->LogLine("Note handle is not defined\n");
								gLog->FlushNow();
							}
							else {
								gLog->LogLine("Intercepted after Note Open Ext.\n");
								gLog->FlushNow();
								gLog->LogLine("Creating Arena...\n");
								gLog->FlushNow();
								Arena * arena = new Arena();
								gLog->LogLine("Creating Message...\n");
								gLog->FlushNow();
								Request * request = Arena::CreateMessage<Request>(arena);
								gLog->LogLine("Creating message content...\n");
								gLog->FlushNow();
								RequestNote * reqnote = Arena::CreateMessage<RequestNote>(arena);
								reqnote->set_noteid(id);
								// set dbid (TEMPORARY)
								rpath = spath.c_str();
								replace(rpath.begin(), rpath.end(), '|', '/');
								reqnote->set_dbid(rpath.c_str());
								// set action
								reqnote->set_action(Action::READ);
								request->set_allocated_note(reqnote);
								Response * response = Arena::CreateMessage<Response>(arena);
								gLog->LogLine("Sending request to RED server...\n");
								gLog->FlushNow();
								//gLog->CloseLogFile();
								//gLog->OpenLogFile("a+");
								STATUS err = red::hooks::net::gNMInstance->ProcessHookRequest(*request, response);
								gLog->LogLine("Request result: %d\n", err);
								gLog->FlushNow();
								if (err == RH_ERR_NOERROR) {
									//gLog->LogLine("Parsing response...\n");
									if (NULL != response) {
										gLog->LogLine("Checking response status...\n");
										gLog->FlushNow();
										uint32 rstate = response->status();
										gLog->LogLine("Response status: %04X\n", rstate);
										gLog->FlushNow();
										if (rstate != RC_SERVER_STATE_OK) {
											gLog->LogLine("Failed to substitute. Reverting to normal mode.\n");
											gLog->FlushNow();
											delete arena;
											gLog->LogLine("-----------------------------------\n");
											gLog->FlushNow();
											gLog->CloseLogFile();
											break;
										}
										gLog->LogLine("Extracting Note...\n");
										gLog->FlushNow();
										Note note = response->note();
										google::protobuf::RepeatedPtrField<Item> items = note.items();
										Item item;
										gLog->LogLine("Processing Items...\n");
										gLog->FlushNow();
										for (int i = 0; i < note.items_size(); i++) {
											// set note fields
											item = items.Get(i);
											// cleanup any existing (garbage) values from note item
											::STATUS err = NSFItemInfo(*hNote, item.name().c_str(), item.name().length(), NULL, NULL, NULL, NULL);
											if (err != ERR_ITEM_NOT_FOUND)
												NSFItemDelete(*hNote, item.name().c_str(), item.name().length());
											// fill note item value
											switch (item.type()) {
											/* TYPE_TEXT:
												if (validateItem(item, TYPE_TEXT))
													NSFItemAppend(*hNote, ITEM_SUMMARY, item.name().c_str(), item.name().length(), TYPE_TEXT, item.tvalue().Get(0).c_str(), item.tvalue().Get(0).length());
												break;*/
											case R_TYPE_TEXT:
												if (validateItem(item, R_TYPE_TEXT)) {
													for (int j = 0; j < item.tvalue_size(); j++) {
														NSFItemAppendTextList(*hNote, item.name().c_str(), item.tvalue().Get(j).c_str(), item.tvalue().Get(j).length(), TRUE);
													}
												}
												break;
											default:
												break;
											}
										}
									}
								}

								delete arena;
							}
							gLog->LogLine("-----------------------------------\n");
							gLog->FlushNow();
							gLog->CloseLogFile();
						}
						break;
					case EM_NSFNOTEOPENBYUNID:
						hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
						unid = (UNID)VARARG_GET(ap, UNID);
						sflags = (WORD)VARARG_GET(ap, WORD);
						hNote = (NOTEHANDLE *)VARARG_GET(ap, NOTEHANDLE *);

						NSFDbPathGet(hDB, path, buf2);
						spath = path;
						replace(spath.begin(), spath.end(), '/', '|');
						replace(spath.begin(), spath.end(), '\\', '|');
						for (int i = 0; i < gHM->GetDbNameCount(); i++) {
							matchDB = spath.compare(gHM->GetDbNameStr(i));
							if (matchDB == 0)
								break;
						}

						if (matchDB == 0) {
							gLog->OpenLogFile("a+");
							gLog->LogLine("-----------------------------------\n");
							if (record->NotificationType == EM_BEFORE) {
								gLog->LogLine("Intercepted before Note Open UNID.\n");

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("UNID: %X%X%X%X\n", unid.File.Innards[1], unid.File.Innards[0], unid.Note.Innards[1], unid.Note.Innards[0]);
								gLog->LogLine("Flags: 0x%X\n", sflags);
								if (*hNote)
									gLog->LogLine("Note handle is: %p\n", *hNote);
								else
									gLog->LogLine("Note handle is not defined\n");
							}
						}

						break;
					default:
						break;
					}
				}
				catch (std::exception e) {
					gLog->LogLine("Error in NoteOps.\n");
					gLog->CloseLogFile();
				}
				if (NOERROR == error)
					return ERR_EM_CONTINUE;
				else {
					gLog->OpenLogFile(LOGGER_OPEN_APPEND);
					gLog->LogLine("error happened somewhere: %d\n", error);
					return error;
				}
			}

			bool validateItem(Item item, WORD type) {
				switch (type) {
				//case TYPE_TEXT:
					/*if (item.name().length() == 0)
						return false;
					if (item.tvalue().size() == 0)
						return false;
					return true;*/
				case R_TYPE_TEXT:
					if (item.name().length() == 0)
						return false;
					if (item.tvalue().size() == 0)
						return false;
					return true;
				default:
					return false;
				}
			}

			::STATUS LNPUBLIC ProcessNoteInfoOps(EMRECORD * record) {
				return ERR_EM_CONTINUE;
			}

			::STATUS LNPUBLIC ProcessNIFOps(EMRECORD * record) {
				return ERR_EM_CONTINUE;
			}
		}
	}
}
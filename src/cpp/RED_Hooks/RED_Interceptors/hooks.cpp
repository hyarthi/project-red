#pragma once

#include "hooks.hpp"

namespace red {
	namespace hooks {

		// globals
		EID gNoteOps[] = { EM_NSFNOTEOPEN, EM_NSFNOTEOPENBYUNID, EM_NSFNOTEOPENEXTENDED, EM_NSFNOTECLOSE, EM_NSFNOTEUPDATE, EM_NSFNOTEUPDATEXTENDED, EM_NSFNOTEDELETE, 0 };
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
			hemrNoteOps = new HEMREGISTRATION[7];
			newUnids = new vector<string>();

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
			err = EMRegister(gNoteOps[4], EM_REG_BEFORE | EM_REG_AFTER, emhNoteOps, RecursionID, &(hemrNoteOps[4]));
			// EM_NSFNOTEUPDATEEXTENDED
			err = EMRegister(gNoteOps[5], EM_REG_BEFORE | EM_REG_AFTER, emhNoteOps, RecursionID, &(hemrNoteOps[5]));
			// EM_NSFNOTEDELETE
			err = EMRegister(gNoteOps[6], EM_REG_BEFORE | EM_REG_AFTER, emhNoteOps, RecursionID, &(hemrNoteOps[6]));

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
			err = EMDeregister(hemrNoteOps[4]);
			// EM_NSFNOTEUPDATEEXTENDED
			err = EMDeregister(hemrNoteOps[5]);
			// EM_NSFNOTEDELETE
			err = EMDeregister(hemrNoteOps[6]);

			return err;
		}

		HookManager::~HookManager() {
			delete newUnids;
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

		void HookManager::AddNoteUNID(string unid) {
			newUnids->push_back(unid);
		}

		void HookManager::RemoveNoteUNID(int idx) {
			gLog->LogLine("Removing UNID at index: %d\n", idx);
			if (idx < 0)
				return;
			if (newUnids->empty())
				return;
			if (idx >= newUnids->size())
				return;
			vector<string> * newvector = new vector<string>();

			for (int i = 0; i < newUnids->size(); i++) {
				if (i != idx) {
					gLog->LogLine("Pushing: [%d] %s\n", i, newUnids->at(i));
					newvector->push_back(newUnids->at(i));
				}
			}
			delete newUnids;
			newUnids = newvector;
		}

		void HookManager::RemoveNoteUNID(string unid) {
			gLog->LogLine("Removing UNID: %s\n", unid);
			for (int i = 0; i < newUnids->size(); i++) {
				if (unid.compare(0, UNID_LENGTH, newUnids->at(i), 0, UNID_LENGTH) == 0) {
					gLog->LogLine("Found match: [%d] %s\n", i, newUnids->at(i));
					this->RemoveNoteUNID(i);
					return;
				}
				else {
					gLog->LogLine("No match: [%d] %s\n", i, newUnids->at(i));
				}
			}
		}

		string HookManager::GetNoteUNID(int idx) {
			string result = "";
			if (idx < 0)
				return result;
			if (newUnids->empty())
				return result;
			if (idx >= newUnids->size())
				return result;

			return newUnids->at(idx);
		}

		int HookManager::NewUnids_Size() {
			return (int)newUnids->size();
		}

		bool HookManager::is_UNID_New(string unid) {
			gLog->LogLine("Checking unid for presence: %s\n", unid);
			for (int i = 0; i < newUnids->size(); i++) {
				if (unid.compare(0, UNID_LENGTH, newUnids->at(i), 0, UNID_LENGTH) == 0) {
					gLog->LogLine("Found match: [%d] %s\n", i, newUnids->at(i));
					return true;
				}
				else {
					gLog->LogLine("No match: [%d] %s\n", i, newUnids->at(i));
				}
			}

			return false;
		}

		namespace functions {

			//typedef google::protobuf::Map<string, Item> Map;

			// Process Ops

			::STATUS LNPUBLIC ProcessNoteOps(EMRECORD * record) {
				::STATUS error = NOERROR;
				VARARG_PTR ap;
				DBHANDLE hDB;
				NOTEHANDLE * hNote, uhNote;
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
				bool newNote;

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
								// get dbid (TEMPORARY)
								rpath = spath.c_str();
								replace(rpath.begin(), rpath.end(), '|', '/');

								NOTEDATA data;
								data.db = hDB;
								data.dbid = rpath;
								data.flags = flags;
								data.note = *hNote;
								data.noteid = id;
								data.seq = sequence;
								STATUS err = ProcessNoteOpen(data);
								if (err != RC_SERVER_STATE_OK) {
									gLog->LogLine("-----------------------------------\n");
									gLog->FlushNow();
									gLog->CloseLogFile();
									break;
								}
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
							gLog->LogLine("-----------------------------------\n");
							gLog->CloseLogFile();
						}

						break;
					case EM_NSFNOTEUPDATE:
						uhNote = (NOTEHANDLE)VARARG_GET(ap, NOTEHANDLE);
						sflags = (WORD)VARARG_GET(ap, WORD);

						NSFNoteGetInfo(uhNote, _NOTE_DB, &hDB);
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
								gLog->LogLine("Intercepted before Note Update.\n");

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("Note handle is: %p\n", uhNote);
								gLog->LogLine("Flags: 0x%X\n", sflags);

								gLog->LogLine("Getting Note ID...\n");
								NSFNoteGetInfo(uhNote, _NOTE_ID, &id);
								gLog->LogLine("Note ID is: %d\n", id);
								newNote = (id == NULL);
								OID oid;
								char sunid[UNID_LENGTH + 1];
								gLog->LogLine("Getting Note UNID...\n");
								NSFNoteGetInfo(uhNote, _NOTE_OID, &oid);
								if (newNote) {
									// don't do anything yet
								}
								else {
									sprintf(sunid, "%08X%08X%08X%08X", oid.File.Innards[1], oid.File.Innards[0], oid.Note.Innards[1], oid.Note.Innards[0]);
									gLog->LogLine("Note UNID is: %s\n", sunid);
								}
								gLog->LogLine("Creating Arena...\n");
								gLog->FlushNow();
								Arena * arena = new Arena();
								gLog->LogLine("Creating Message...\n");
								gLog->FlushNow();
								Request * request = Arena::CreateMessage<Request>(arena);
								gLog->LogLine("Creating message content...\n");
								gLog->FlushNow();
								RequestNote * reqnote = Arena::CreateMessage<RequestNote>(arena);
								//reqnote->set_noteid(id);
								if (newNote) {
									/*NSFDbCreateNoteID(hDB, TRUE, &id);
									reqnote->set_spawnedid(id);*/
								}
								else
									reqnote->set_unid(sunid, UNID_LENGTH);
								// set dbid (TEMPORARY)
								rpath = spath.c_str();
								replace(rpath.begin(), rpath.end(), '|', '/');
								reqnote->set_dbid(rpath.c_str());
								// record items
								SCANDATA data;
								data.reqnote = reqnote;
								data.note = &uhNote;
								NSFItemScan(uhNote, (NSFITEMSCANPROC)AllItemsScanRoutine, &data);
								// set action
								reqnote->set_action(Action::UPDATE);
								request->set_allocated_note(reqnote);
								Response * response = Arena::CreateMessage<Response>(arena);
								gLog->LogLine("Sending request to RED server...\n");
								gLog->FlushNow();
								//gLog->CloseLogFile();
								//gLog->OpenLogFile("a+");
								STATUS err = red::hooks::net::gNMInstance->ProcessHookRequest(*request, response);
								gLog->LogLine("Request result: %d\n", err);
								gLog->FlushNow();
								if (RH_ERR_NOERROR == err) {
									// remove items from original note
									/*for (int i = 0; i < reqnote->items_size(); i++) {
										Item item = reqnote->items().Get(i);
										gLog->LogLine("Removing item \"%s\"\n", item.name());
										gLog->FlushNow();
										NSFItemDelete(uhNote, item.name().c_str(), item.name().size());
									}*/
									if (newNote) {
										gLog->LogLine("Recording generated UNID to a new Note...\n");
										gLog->FlushNow();
										//NSFNoteGetInfo(uhNote, _NOTE_OID, &oid);
										string ssunid = response->note().unid();
										string bufs;
										DWORD bufn;
										for (int i = 0; i += 8; i < UNID_LENGTH) {
											bufs = "0x" + ssunid.substr(i, 8);
											bufn = std::stoul(bufs, nullptr, 16);
											if (i == 0) {
												oid.File.Innards[1] = bufn;
											}
											else if (i == 8) {
												oid.File.Innards[0] = bufn;
											}
											else if (i == 16) {
												oid.Note.Innards[1] = bufn;
											}
											else {
												oid.Note.Innards[0] = bufn;
											}
										}
									}
									gLog->LogLine("Will be removing items here soon...\n");
								}
								else {
									gLog->LogLine("Failed to update on RED Server - reverting to original.\n");
								}
							}
							gLog->LogLine("-----------------------------------\n");
							gLog->CloseLogFile();
						}

						break;
					case EM_NSFNOTEUPDATEXTENDED:
						uhNote = (NOTEHANDLE)VARARG_GET(ap, NOTEHANDLE);
						flags = (DWORD)VARARG_GET(ap, DWORD);

						NSFNoteGetInfo(uhNote, _NOTE_DB, &hDB);
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
								gLog->LogLine("Intercepted before Note Update Extended.\n");

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("Note handle is: %p\n", uhNote);
								gLog->LogLine("Flags: 0x%X\n", flags);

								gLog->LogLine("Getting Note ID...\n");
								NSFNoteGetInfo(uhNote, _NOTE_ID, &id);
								gLog->LogLine("Note ID is: %d\n", id);
								newNote = (id == NULL);
								OID oid;
								char sunid[UNID_LENGTH + 1];
								NSFNoteGetInfo(uhNote, _NOTE_OID, &oid);
								NOTEDATA data;
								data.unid = "";
								data.noteid = NULL;
								if (newNote) {
								}
								else {
									sprintf(sunid, "%08X%08X%08X%08X", oid.File.Innards[1], oid.File.Innards[0], oid.Note.Innards[1], oid.Note.Innards[0]);
									gLog->LogLine("Recording UNID: %s\n", sunid);
									data.unid.assign(sunid, UNID_LENGTH);
									gLog->LogLine("Recording NoteID: %d\n", id);
									data.noteid = id;
								}
								data.note = uhNote;
								data.flags = flags;
								data.db = hDB;
								// set dbid (TEMPORARY)
								rpath = spath.c_str();
								replace(rpath.begin(), rpath.end(), '|', '/');
								data.dbid = rpath;
								data.seq = (uint64)(oid.Sequence);
								
								STATUS err;
								// check if it's an update with a DELETE flag
								if ((flags & UPDATE_DELETED) > 0) {
									gLog->LogLine("Delete flag identified -> will be deleting note.\n");
									data.unid = "";
									err = ProcessNoteDelete(data);
								}
								else {
									gLog->LogLine("No delete flag identified -> will be updating note.\n");
									err = PreProcessNoteUpdate(data);
								}
								if (err != RC_SERVER_STATE_OK) {
									gLog->LogLine("-----------------------------------\n");
									gLog->FlushNow();
									gLog->CloseLogFile();
									break;
								}
								gLog->LogLine("f-----------------------------------\n");
								gLog->FlushNow();
								//gLog->CloseLogFile();
							}
							else {
								// EM_AFTER
								gLog->LogLine("Intercepted after Note Update Extended.\n");

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("Note handle is: %p\n", uhNote);
								gLog->LogLine("Flags: 0x%X\n", flags);

								gLog->LogLine("Status: %d\n", record->Status);
								gLog->FlushNow();
								if (NOERROR == record->Status) {

									OID oid;
									char sunid[UNID_LENGTH + 1];
									gLog->LogLine("Getting Note UNID...\n");
									gLog->FlushNow();
									NSFNoteGetInfo(uhNote, _NOTE_OID, &oid);
									sprintf(sunid, "%08X%08X%08X%08X", oid.File.Innards[1], oid.File.Innards[0], oid.Note.Innards[1], oid.Note.Innards[0]);
									gLog->LogLine("Note UNID is: %s\n", sunid);
									gLog->FlushNow();

									if (gHM->is_UNID_New(sunid)) {

										gLog->LogLine("Getting Note ID...\n");
										gLog->FlushNow();
										NSFNoteGetInfo(uhNote, _NOTE_ID, &id);
										gLog->LogLine("Note ID is: %d\n", id);
										gLog->FlushNow();

										NOTEDATA data;
										data.db = hDB;
										// set dbid (TEMPORARY)
										rpath = spath.c_str();
										replace(rpath.begin(), rpath.end(), '|', '/');
										data.dbid = rpath.c_str();
										data.flags = flags;
										data.note = uhNote;
										data.noteid = id;
										data.seq = oid.Sequence;
										data.unid.assign(sunid, UNID_LENGTH);
										
										STATUS err = PostProcessNoteUpdate(data);
										if (RC_SERVER_STATE_OK == err) {
											gLog->LogLine("Success!\n");
											gLog->FlushNow();
										}
										else {
											gLog->LogLine("Error!\n");
											gLog->FlushNow();
										}
									}
								}
							}
							gLog->LogLine("y-----------------------------------\n");
							gLog->FlushNow();
							gLog->CloseLogFile();
						}

						break;
					case EM_NSFNOTEDELETE:
						hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
						id = (NOTEID)VARARG_GET(ap, NOTEID);
						// TODO find out how to figure out this argument type
						flags = (DWORD)VARARG_GET(ap, DWORD);

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
								gLog->LogLine("Intercepted before Note Delete.\n");

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("Note ID: 0x%X\n", id);
								gLog->LogLine("Flags: 0x%X\n", flags);

								gLog->LogLine("Creating Arena...\n");
								gLog->FlushNow();
								Arena * arena = new Arena();
								gLog->LogLine("Creating Message...\n");
								gLog->FlushNow();
								Request * request = Arena::CreateMessage<Request>(arena);
								gLog->LogLine("Creating message content...\n");
								gLog->FlushNow();
								RequestNote * reqnote = Arena::CreateMessage<RequestNote>(arena);
								// set dbid (TEMPORARY)
								rpath = spath.c_str();
								replace(rpath.begin(), rpath.end(), '|', '/');
								reqnote->set_dbid(rpath.c_str());
								// set NoteID
								reqnote->set_noteid(id);
								// set flags
								reqnote->set_flags(flags);
								// set action
								reqnote->set_action(Action::REMOVE);
								request->set_allocated_note(reqnote);
								Response * response = Arena::CreateMessage<Response>(arena);
								gLog->LogLine("Sending request to RED server...\n");
								gLog->FlushNow();
								STATUS err = red::hooks::net::gNMInstance->ProcessHookRequest(*request, response);
								gLog->LogLine("Request result: %d...\n", err);
								gLog->FlushNow();
								if (RH_ERR_NOERROR == err) {
									gLog->LogLine("Document deleted.\n");
								} // if (RH_ERR_NOERROR == err)
								else {
									gLog->LogLine("Error: %d\n", err);
								}
							} // if (record->NotificationType == EM_BEFORE)
							else {
								gLog->LogLine("Intercepted after Note Delete.\n");
								::STATUS e;

								gLog->LogLine("Info: \n");
								gLog->LogLine("DB Path: %s\n", buf2);
								gLog->LogLine("Note ID: 0x%X\n", id);
								gLog->LogLine("Flags: 0x%X\n", flags);
							} // if (record->NotificationType == EM_BEFORE) -> else
							gLog->LogLine("-----------------------------------\n");
							gLog->CloseLogFile();
						} // if (matchDB == 0)

						break;
					default:
						break;
					}
				}
				catch (std::exception e) {
					gLog->LogLine("Error in NoteOps.\n");
					gLog->LogLine("Errmsg: %s\n", e.what());
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

			::STATUS LNCALLBACK AllItemsScanRoutine(WORD unused, WORD flags, char far * name, WORD nameLength, void far * value, DWORD valLength, void far * data) {
				LIST * list;
				WORD size;
				char * val;
				WORD vallen;

				//SCANDATA sdata = *((SCANDATA *)data);
				gLog->LogLine("PING Item -->\n");
				gLog->FlushNow();
				RequestNote * reqnote = ((SCANDATA *) data)->reqnote;
				NOTEHANDLE * hNote = ((SCANDATA *)data)->note;
				Item * item = reqnote->add_items();
				// set item name
				item->set_name(name, nameLength);
				gLog->LogLine("Item name: %s\n", item->name());
				gLog->FlushNow();
				// set item type
				WORD type;
				NSFItemInfo(*hNote, name, nameLength, NULL, &type, NULL, NULL);
				gLog->LogLine("Item type: %d\n", type);
				gLog->FlushNow();
				// replace this with getting type from first 2 bytes of value
				item->set_type(type);
				// set flags
				gLog->LogLine("Item flags: 0x%X\n", flags);
				gLog->FlushNow();
				item->set_flags(flags);
				// set values
				string textValue, v, bv;
				switch (type) {
				case TYPE_TEXT_LIST:
					gLog->LogLine("It's a text list\n");
					gLog->FlushNow();
					// TEXT and TEXT_LIST are equivalent on RED side, so set type 1281 -> 1280
					item->set_type(item->type() - 1);
					// continue with value assignment
					list = (LIST *)(value) + sizeof(WORD);
					size = list->ListEntries;
					v = "[ ";
					for (int i = 0; i < size; i++) {
						gLog->LogLine("TING!\n");
						gLog->FlushNow();
						ListGetText(list, TRUE, i, &val, &vallen);
						bv.assign(val, vallen);
						v += "\"" + bv + "\", ";
						(item->add_tvalue())->assign(val, vallen);
					}
					v += " ]";
					gLog->LogLine("Item value: %s\n", v);
					gLog->FlushNow();
					break;
				case TYPE_TEXT:
					v.assign(((char far *) value) + sizeof(WORD), valLength - sizeof(WORD));
					gLog->LogLine("It's text: %s\n", v);
					gLog->FlushNow();
					(item->add_tvalue())->assign(((char far *) value) + sizeof(WORD), valLength - sizeof(WORD));
					break;
				default:
					// TEMP
					gLog->LogLine("Unsupported type. Removing item from message.\n");
					gLog->FlushNow();
					reqnote->mutable_items()->ReleaseLast();
					break;
				}
				// done
				gLog->LogLine("--> PING Item\n");
				gLog->FlushNow();

				return NOERROR;
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

			STATUS ProcessNoteOpen(NOTEDATA data) {
				gLog->LogLine("Creating Arena...\n");
				gLog->FlushNow();
				Arena * arena = new Arena();
				gLog->LogLine("Creating Message...\n");
				gLog->FlushNow();
				Request * request = Arena::CreateMessage<Request>(arena);
				gLog->LogLine("Creating message content...\n");
				gLog->FlushNow();
				RequestNote * reqnote = Arena::CreateMessage<RequestNote>(arena);
				// set unid/noteid
				if (!data.unid.empty())
					reqnote->set_unid(data.unid.c_str());
				if (data.noteid != 0)
					reqnote->set_noteid(data.noteid);
				// set db id
				reqnote->set_dbid(data.dbid.c_str());
				// set action
				reqnote->set_action(Action::READ);
				request->set_allocated_note(reqnote);
				Response * response = Arena::CreateMessage<Response>(arena);
				gLog->LogLine("Sending request to RED server...\n");
				gLog->FlushNow();
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
							return rstate;
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
							::STATUS err = NSFItemInfo(data.note, item.name().c_str(), item.name().length(), NULL, NULL, NULL, NULL);
							if (err != ERR_ITEM_NOT_FOUND)
								NSFItemDelete(data.note, item.name().c_str(), item.name().length());
							// fill note item value
							switch (item.type()) {
								/* TYPE_TEXT:
								if (validateItem(item, TYPE_TEXT))
								NSFItemAppend(*hNote, ITEM_SUMMARY, item.name().c_str(), item.name().length(), TYPE_TEXT, item.tvalue().Get(0).c_str(), item.tvalue().Get(0).length());
								break;*/
							case R_TYPE_TEXT:
								if (validateItem(item, R_TYPE_TEXT)) {
									for (int j = 0; j < item.tvalue_size(); j++) {
										NSFItemAppendTextList(data.note, item.name().c_str(), item.tvalue().Get(j).c_str(), item.tvalue().Get(j).length(), TRUE);
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

				return RC_SERVER_STATE_OK;
			}

			STATUS PreProcessNoteUpdate(NOTEDATA data) {
				OID oid;
				char sunid[UNID_LENGTH + 1];
				gLog->LogLine("Getting Note UNID...\n");
				NSFNoteGetInfo(data.note, _NOTE_OID, &oid);
				gLog->LogLine("Creating Arena...\n");
				gLog->FlushNow();
				Arena * arena = new Arena();
				gLog->LogLine("Creating Message...\n");
				gLog->FlushNow();
				Request * request = Arena::CreateMessage<Request>(arena);
				gLog->LogLine("Creating message content...\n");
				gLog->FlushNow();
				RequestNote * reqnote = Arena::CreateMessage<RequestNote>(arena);
				//reqnote->set_noteid(id);
				bool newNote = (data.unid.empty()) && (data.noteid == 0);
				if (newNote) {
					// TODO probably delete this
				}
				else if (!data.unid.empty())
					reqnote->set_unid(data.unid.c_str(), UNID_LENGTH);
				else if (data.noteid != 0)
					reqnote->set_noteid(data.noteid);
				// set dbid
				reqnote->set_dbid(data.dbid.c_str());
				// record items
				SCANDATA sdata;
				sdata.reqnote = reqnote;
				sdata.note = &(data.note);
				NSFItemScan(data.note, (NSFITEMSCANPROC)AllItemsScanRoutine, &sdata);
				// set action
				reqnote->set_action(Action::UPDATE);
				request->set_allocated_note(reqnote);
				Response * response = Arena::CreateMessage<Response>(arena);
				gLog->LogLine("Sending request to RED server...\n");
				gLog->FlushNow();
				//gLog->CloseLogFile();
				//gLog->OpenLogFile("a+");
				STATUS err = red::hooks::net::gNMInstance->ProcessHookRequest(*request, response);
				gLog->LogLine("Request result: %d...\n", err);
				gLog->FlushNow();
				if (RH_ERR_NOERROR == err) {
					// remove items from original note
					/*for (int i = 0; i < reqnote->items_size(); i++) {
					Item item = reqnote->items().Get(i);
					gLog->LogLine("Removing item \"%s\"\n", item.name());
					gLog->FlushNow();
					NSFItemDelete(uhNote, item.name().c_str(), item.name().size());
					}*/
					if (newNote) {
						gLog->LogLine("Recording generated UNID to a new Note...\n");
						gLog->FlushNow();
						//NSFNoteGetInfo(nhNote, _NOTE_OID, &oid);
						string ssunid = response->note().unid();
						string bufs;
						DWORD bufn = 0;
						//NOTEHANDLE nhNote2;
						gLog->LogLine("Processing UNID: %s\n", ssunid.c_str());
						gLog->FlushNow();
						int i = 0;
						while (i < UNID_LENGTH) {
							bufs = "0x" + ssunid.substr(i, 8);
							gLog->LogLine("Converting: %s\n", bufs);
							gLog->FlushNow();
							bufn = std::stoul(bufs, nullptr, 16);
							if (i == 0) {
								oid.File.Innards[1] = bufn;
							}
							else if (i == 8) {
								oid.File.Innards[0] = bufn;
							}
							else if (i == 16) {
								oid.Note.Innards[1] = bufn;
							}
							else {
								oid.Note.Innards[0] = bufn;
							}
							i += 8;
							gLog->LogLine("i: %d\n", i);
							gLog->FlushNow();
						}
						//gLog->LogLine("Spawning note...\n");
						//gLog->FlushNow();
						//NSFNoteCreate(hDB, &nhNote);
						gLog->LogLine("Recording UNID...\n");
						gLog->FlushNow();
						NSFNoteSetInfo(data.note, _NOTE_OID, &oid);
						// record new unid into cache
						gHM->AddNoteUNID(ssunid);
					}
					else {
						// TODO probably don't need this
					}
					gLog->LogLine("Will be removing items here soon...\n");
				}
				else {
					gLog->LogLine("Failed to update on RED Server - reverting to original.\n");
					return err;
				}
				delete arena;

				return RC_SERVER_STATE_OK;
			}

			STATUS PostProcessNoteUpdate(NOTEDATA data) {
				gLog->LogLine("Creating Arena...\n");
				gLog->FlushNow();
				Arena * arena = new Arena();
				gLog->LogLine("Creating Message...\n");
				gLog->FlushNow();
				Request * request = Arena::CreateMessage<Request>(arena);
				gLog->LogLine("Creating message content...\n");
				gLog->FlushNow();
				RequestNoteInfo * reqnoteinfo = Arena::CreateMessage<RequestNoteInfo>(arena);
				// set dbid (TEMPORARY)
				reqnoteinfo->set_dbid(data.dbid.c_str());
				// record items
				reqnoteinfo->set_unid(data.unid.c_str(), UNID_LENGTH);
				reqnoteinfo->set_noteid(data.noteid);
				reqnoteinfo->set_action(Action::UPDATE);
				request->set_allocated_noteinfo(reqnoteinfo);

				Response * response = Arena::CreateMessage<Response>(arena);
				gLog->LogLine("Sending request to RED server...\n");
				gLog->FlushNow();
				//gLog->CloseLogFile();
				//gLog->OpenLogFile("a+");
				STATUS err = red::hooks::net::gNMInstance->ProcessHookRequest(*request, response);
				gLog->LogLine("Request result: %d...\n", err);
				gLog->FlushNow();

				gLog->LogLine("Cleaning up...\n");
				delete arena;

				gHM->RemoveNoteUNID(data.unid.c_str());

				if (RH_ERR_NOERROR == err) {
					gLog->LogLine("Success!\n");
					return RC_SERVER_STATE_OK;
				}
				else {
					gLog->LogLine("Error!\n");
					return err;
				}
			}

			STATUS ProcessNoteDelete(NOTEDATA data) {
				gLog->LogLine("Creating Arena...\n");
				gLog->FlushNow();
				Arena * arena = new Arena();
				gLog->LogLine("Creating Message...\n");
				gLog->FlushNow();
				Request * request = Arena::CreateMessage<Request>(arena);
				gLog->LogLine("Creating message content...\n");
				gLog->FlushNow();
				RequestNote * reqnote = Arena::CreateMessage<RequestNote>(arena);
				// set dbid (TEMPORARY)
				reqnote->set_dbid(data.dbid.c_str());
				// set NoteID
				//reqnote->set_noteid(data.noteid);
				// set UNID
				if (!data.unid.empty())
					reqnote->set_unid(data.unid.c_str());
				else if (data.noteid != 0)
					reqnote->set_noteid(data.noteid);
				// set flags
				reqnote->set_flags(data.flags);
				// set action
				reqnote->set_action(Action::REMOVE);
				request->set_allocated_note(reqnote);
				Response * response = Arena::CreateMessage<Response>(arena);
				gLog->LogLine("Sending request to RED server...\n");
				gLog->FlushNow();
				STATUS err = red::hooks::net::gNMInstance->ProcessHookRequest(*request, response);
				gLog->LogLine("Request result: %d...\n", err);
				gLog->FlushNow();
				if (RH_ERR_NOERROR == err) {
					gLog->LogLine("Document deleted.\n");
					return RC_SERVER_STATE_OK;
				} // if (RH_ERR_NOERROR == err)
				else {
					gLog->LogLine("Error: %d\n", err);
					return err;
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
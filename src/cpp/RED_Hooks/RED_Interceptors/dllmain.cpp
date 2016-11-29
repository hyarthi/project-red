// dllmain.cpp : Defines the entry point for the DLL application.
#pragma once

#include "dllmain.hpp"

// globals
BOOL gHooksRegistered = FALSE;

/* Funcs */

BOOL WINAPI DllMain( HINSTANCE hModule,
					   DWORD  ul_reason_for_call,
					   LPVOID lpReserved
					 )
{
	STATUS error = NOERROR;

	switch (ul_reason_for_call)
	{
	case DLL_PROCESS_ATTACH:
		InitializeCriticalSection(&gCritSection);
		/*gNoteOpenHandlerProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessNoteOpen, hModule);
		gNoteOpenUNIDHandlerProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessNoteOpenUNID, hModule);
		gNoteOpenExtHandlerProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessNoteOpenExt, hModule);
		gDbGetNoteInfoByUnidProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessDbGetNoteInfoByUnid, hModule);
		gDbReadObjectProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessReadDbObject, hModule);
		gDbGetObjectSizeProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessDbGetObjectSize, hModule);
		gDbGetNoteInfoProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessDbGetNoteInfo, hModule);
		gNoteGetInfoProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessNoteGetInfo, hModule);
		gEMProc = (EMHANDLER)MakeProcInstance((FARPROC)ProcessEM, hModule);*/
		if (gLog == NULL)
			gLog = new Logger();
		gLog->OpenLogFile(LOGGER_OPEN_WRITE);
		gLog->LogLine("________________STARTING LOG___________________\n");
		gLog->LogLine("Initializing Network Manager...\n");
		if (gNMInstance == NULL) {
			gNMInstance = new NetworkManager();
			gNMInstance->StartUp();
		}
		gLog->LogLine("Finished initializing Network Manager.\n");
		gLog->LogLine("Initializing Hook Manager...\n");
		if (gHM == NULL)
			gHM = new HookManager(hModule);
		gLog->LogLine("Finished initializing Hook Manager.\n");
		gLog->CloseLogFile();
		break;
	case DLL_THREAD_ATTACH: break;
	case DLL_THREAD_DETACH: break;
	case DLL_PROCESS_DETACH:
		CleanUp();
		/*FreeProcInstance(gNoteOpenHandlerProc);
		FreeProcInstance(gNoteOpenUNIDHandlerProc);
		FreeProcInstance(gNoteOpenExtHandlerProc);
		FreeProcInstance(gDbGetNoteInfoByUnidProc);
		FreeProcInstance(gDbReadObjectProc);
		FreeProcInstance(gDbGetObjectSizeProc);
		FreeProcInstance(gDbGetNoteInfoProc);
		FreeProcInstance(gNoteGetInfoProc);
		FreeProcInstance(gEMProc);
		error = DeregisterEntry();*/
		DeleteCriticalSection(&gCritSection);
		break;
	}
	return TRUE;

	UNREFERENCED_PARAMETER(lpReserved);
}

STATUS LNPUBLIC MainEntryPoint(void) {
	STATUS error;
	WORD wd;
	error = NOERROR;
	if (gHooksRegistered)
		return NOERROR;
	gHooksRegistered = TRUE;

	if (gLog == NULL)
		gLog = new Logger();
	gLog->OpenLogFile(LOGGER_OPEN_APPEND);

	gLog->LogLine("EM Entry point touched.\n");

	// TODO startup & register entries here
	if (!gHM->isHooksRegistered())
		gHM->StartUp();

	gLog->LogLine("Finished with entry point...\n");
	gLog->CloseLogFile();

	return error;
}

void CleanUp() {
	delete gHM;
	delete gNMInstance;
	delete gLog;
}

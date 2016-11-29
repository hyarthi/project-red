// stdafx.h : include file for standard system include files,
// or project specific include files that are used frequently, but
// are changed infrequently
//
#pragma once
#undef AFX_DATA
#define AFX_DATA AFX_EXT_DATA
//#pragma once
#define _CRT_SECURE_NO_DEPRECATE

// TODO: reference additional headers your program requires here
/* Win headers */
/*#if defined(W32) || defined(W64)
	#include <Windows.h>
#endif*/
#include <stdio.h>
#include <stdlib.h>

/* Domino headers */
#include <global.h>
#include <event.h>
#include <kfm.h>
#include <nsfnote.h>
#include <nsferr.h>
#include <nsfdb.h>
#include <nsfdata.h>
#include <nsfnote.h>
#include <osmisc.h>
#include <misc.h>
#include <ostime.h>
#include <extmgr.h>
#include <OSfile.h>
#include <osmem.h>
#include <miscerr.h>
#include <oserr.h>
#include <ft.h>
#include <nif.h>
#include <niferr.h>
#include <osenv.h>
#include <google/protobuf/stubs/port.h>
//#include <pool.h>

/* Definitions */
#define DefLogFile "\\extmgr_test.log"
#define RC_STATUS_STOPPED 0
#define RC_STATUS_STARTING 1
#define RC_STATUS_ERROR 2
#define RC_STATUS_RUNNING 3
//
#define HM_STATUS_STOPPED 0
#define HM_STATUS_STARTING 1
#define HM_STATUS_ERROR 2
#define HM_STATUS_RUNNING 3
//
#define NM_STATUS_STOPPED 0
#define NM_STATUS_STARTING 1
#define NM_STATUS_ERROR 2
#define NM_STATUS_RUNNING 3
//
#define RH_ERR_NOERROR 0x0000
#define RH_ERR_RC_CONNECTION_UNDEFINED 0x0001
#define RH_ERR_RC_ERROR 0x0002
#define RH_ERR_RC_STOPPED 0x0003
//
#define RH_ERR_NM_NOERROR 0x0000
#define RH_ERR_NM_ERROR 0x0001
//
#define LOG_FOLDER "\\IBM_TECHNICAL_SUPPORT"
#define LOG_FILENAME "\\redhooks_debug.log"
//
#define INI_PARAM_DBLIST "RED_DB_LIST"
#define INI_RED_URL "RED_URL"
#define INI_RED_PORT "RED_PORT"
//
#define RC_SERVER_STATE_OK 0x000000C8	//200
#define RC_SERVER_STATE_BAD_REQUEST 0x00000190	// 400
#define RC_SERVER_STATE_UNAUTHORIZED 0x00000191	// 401
#define RC_SERVER_STATE_FORBIDDEN 0x00000193	// 403
#define RC_SERVER_STATE_NOT_FOUND 0x00000194	// 404
#define RC_SERVER_STATE_METHOD_NOT_ALLOWED 0x00000195	// 405
#define RC_SERVER_STATE_NOT_ACCEPTABLE 0x00000196	// 406
#define RC_SERVER_STATE_INTERNAL_SERVER_ERROR 0x000001F4	// 500
#define RC_SERVER_STATE_NOT_IMPLEMENTED 0x000001F5	// 501
//
#define R_TYPE_TEXT 1280
#define R_TYPE_NUMBER 768

// variables/functions definitions
// dllmain.cpp
extern CRITICAL_SECTION gCritSection;
//extern DLL_EXPORT void DLLLogLine(char * line, FILE * stream);
extern BOOL WINAPI DllMain(HINSTANCE hModule, DWORD  ul_reason_for_call, LPVOID lpReserved);
// RED_Interceptors.cpp
extern BOOL gHooksRegistered;
extern char DataDir[];
extern char LogFile[];
extern FILE * gLogStream;
extern WORD gRecursionID;
extern EMHANDLER gNoteOpenHandlerProc;
extern EMHANDLER gNoteOpenUNIDHandlerProc;
extern EMHANDLER gNoteOpenExtHandlerProc;
extern EMHANDLER gDbGetNoteInfoByUnidProc;
extern EMHANDLER gDbReadObjectProc;
extern EMHANDLER gDbGetObjectSizeProc;
extern EMHANDLER gDbGetNoteInfoProc;
extern EMHANDLER gNoteGetInfoProc;
extern EMHANDLER gEMProc;
extern HEMREGISTRATION	  hHandler;
extern HEMREGISTRATION	  hHandlerUNID;
extern HEMREGISTRATION	  hHandlerExt;
extern HEMREGISTRATION hHandlerDbGetNoteInfoByUnid;
extern HEMREGISTRATION hHandlerDbReadObject;
extern HEMREGISTRATION hHandlerDbGetObjectSize;
extern HEMREGISTRATION hHandlerDbGetNoteInfo;
extern HEMREGISTRATION hHandlerNoteGetInfo;
extern HEMREGISTRATION hEM;
extern HCOLLECTION * myColl;
extern unsigned long myCount;
extern void CleanUp(void);
extern STATUS LNPUBLIC MainEntryPoint(void);
#undef AFX_DATA
#define AFX_DATA

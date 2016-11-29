#pragma once

#include "stdafx.h"
#include "logger.hpp"
#include "hooks.hpp"
#include "network_manager.hpp"

#if !defined(ND64) 
#define DHANDLE HANDLE 
#endif

typedef red::hooks::HookManager HookManager;
typedef red::hooks::net::NetworkManager NetworkManager;
typedef red::hooks::log::Logger Logger;

using red::hooks::gHM;
using red::hooks::net::gNMInstance;
using red::hooks::log::gLog;

/* Globals */
CRITICAL_SECTION gCritSection;
HINSTANCE gHInstance;

extern BOOL WINAPI DllMain(HINSTANCE hModule, DWORD  ul_reason_for_call, LPVOID lpReserved);
extern STATUS LNPUBLIC MainEntryPoint(void);
void CleanUp();
#pragma once

#ifndef RED_HOOKS
#define RED_HOOKS

#include "stdafx.h"
#include "base.pb.h"
#include "notes.pb.h"
#include <osenv.h>
#include "network_manager.hpp"
#include "logger.hpp"
#include <google/protobuf/arena.h>
#include <google/protobuf/io/zero_copy_stream_impl.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/message.h>
#include <boost/assign/std/vector.hpp>

namespace red {
	namespace hooks {

		typedef google::protobuf::uint32 STATUS;
		typedef std::string string;
		typedef red::hooks::net::NetworkManager NetworkManager;
		//using red::hooks::net::gNMInstance;
		using namespace std;
		using namespace boost::assign;

		// globals
		extern EID gNoteOps[];
		EID gNoteInfoOps[];
		EID gNIFOps[];

		class HookManager {
		private:
			NetworkManager * NM;	// Network Manager ptr - Network Manager needs to be running!!!
			vector<string> dbNames;		// names of NSFs that are hooked into
			int dbNameCount;
			bool hooksRegistered;
			WORD RecursionID;
			// Processing sets follow
			// Note Ops
			EMHANDLER emhNoteOps;
			HEMREGISTRATION * hemrNoteOps;
			// Note Info Ops
			EMHANDLER emhNoteInfoOps;
			HEMREGISTRATION hemrNoteInfoOps;
			// NIF Ops
			EMHANDLER emhNIFOps;
			HEMREGISTRATION hemrNIFOps;
			int status;
		public:
			HookManager(HINSTANCE hInstance);
			STATUS StartUp();
			bool isHooksRegistered();
			::STATUS RegisterHooks();
			::STATUS DeregisterHooks();
			~HookManager();
			int GetDbNameCount();
			char * GetDbName(int idx);
			string GetDbNameStr(int idx);
		};

		extern HookManager * gHM;

		namespace functions {
			using namespace red::hooks;
			using red::hooks::log::gLog;
			using red::hooks::messages::Item;
			using google::protobuf::Arena;
			using red::hooks::messages::Request;
			using red::hooks::messages::RequestNote;
			using red::hooks::messages::Action;
			using red::hooks::messages::Response;
			using red::hooks::messages::Note;
			using google::protobuf::uint32;

			extern bool validateItem(Item item, WORD type);
			extern ::STATUS LNPUBLIC ProcessNoteOps(EMRECORD * record);
			extern ::STATUS LNPUBLIC ProcessNoteInfoOps(EMRECORD * record);
			extern ::STATUS LNPUBLIC ProcessNIFOps(EMRECORD * record);
		}
	}
}
#endif
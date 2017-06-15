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
			vector<string> * newUnids;	// UNIDs of new documents that need to be kept between EM_BEFORE and EM_AFTER of NSFNOTEUPDATE
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
			void AddNoteUNID(string unid);
			void RemoveNoteUNID(string unid);
			void RemoveNoteUNID(int idx);
			string GetNoteUNID(int idx);
			int NewUnids_Size();
			bool is_UNID_New(string unid);
		};

		extern HookManager * gHM;

		namespace functions {
			using google::protobuf::uint32;
			using google::protobuf::uint64;

			// structs
			struct SCANDATA {
				red::hooks::messages::RequestNote * reqnote;
				NOTEHANDLE * note;
			};
			struct NOTEDATA {
				NOTEHANDLE note;
				DBHANDLE db;
				DWORD flags;
				string dbid;
				uint64 seq;
				string unid;
				WORD noteid;
			};

			using namespace red::hooks;
			using namespace red::hooks::messages;
			using red::hooks::log::gLog;
			//using red::hooks::messages::Item;
			using google::protobuf::Arena;
			/*using red::hooks::messages::Request;
			using red::hooks::messages::RequestNote;
			using red::hooks::messages::Action;
			using red::hooks::messages::Response;
			using red::hooks::messages::Note;*/
			

			extern bool validateItem(Item item, WORD type);
			extern ::STATUS LNPUBLIC ProcessNoteOps(EMRECORD * record);
			extern ::STATUS LNPUBLIC ProcessNoteInfoOps(EMRECORD * record);
			extern ::STATUS LNPUBLIC ProcessNIFOps(EMRECORD * record);
			extern ::STATUS LNCALLBACK AllItemsScanRoutine(WORD unused, WORD flags, char far * name, WORD nameLength, void far * value, DWORD valLength, void far * data);
			extern bool validateItem(Item item, WORD type);
			extern STATUS ProcessNoteOpen(NOTEDATA data);
			extern STATUS PreProcessNoteUpdate(NOTEDATA data);
			extern STATUS PostProcessNoteUpdate(NOTEDATA data);
			extern STATUS ProcessNoteDelete(NOTEDATA data);
		}
	}
}
#endif
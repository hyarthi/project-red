#pragma once

#ifndef RED_NETWORK_MANAGER
#define RED_NETWORK_MANAGER

#include <boost/asio.hpp>
#include "stdafx.h"
#include "base.pb.h"
#include "notes.pb.h"
#include "logger.hpp"
#include <google/protobuf/arena.h>
#include <google/protobuf/io/zero_copy_stream_impl.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/message.h>
#include <chrono>
#include <ctime>
#include <mutex>

namespace red {
	namespace hooks {
		namespace net {
			using boost::asio::ip::tcp;
			using google::protobuf::Arena;
			using boost::asio::io_service;
			using boost::asio::ip::tcp;
			using google::protobuf::io::ArrayInputStream;
			using google::protobuf::io::StringOutputStream;
			using google::protobuf::io::ArrayOutputStream;
			using google::protobuf::io::CodedInputStream;
			using google::protobuf::io::CodedOutputStream;
			//using namespace red::hooks;
			//using namespace red::hooks::messages;
			// typedefs
			typedef tcp::resolver resolver;
			typedef tcp::socket socket;
			typedef resolver::query query;
			typedef tcp::endpoint endpoint;
			typedef std::string string;
			typedef google::protobuf::uint32 uint32;
			typedef google::protobuf::uint8 uint8;
			typedef red::hooks::messages::Response Response;
			typedef red::hooks::messages::Request Request;
			using red::hooks::log::gLog;


			class REDClient {
			private:
				io_service * io;
				resolver * rslvr;
				query * q;
				endpoint * ep;
				//socket * sock;
				resolver::iterator iter, end;
				int status;
				//std::mutex socketMutex;
				string REDUrl, REDPort;

				uint32 getMessageSize(uint8 * hdr);
				STATUS ParseResponse(uint8 * buffer, uint32 bufSize, Arena * arena, Response * response);
				STATUS setupSocket(socket sock);
			public:
				REDClient(string _REDUrl, string _REDPort);
				~REDClient();
				STATUS SendRequest(Request request, Response * retResponse);
				bool isRunning();
			};

			class NetworkManager {
			private:
				REDClient * rclient;
				bool rclient_start_launched;
			public:
				NetworkManager();
				~NetworkManager();
				void StartUp();
				void ShutDown();
				STATUS ProcessHookRequest(Request request, Response * retResponse);
			};

			// globals
			extern NetworkManager * gNMInstance;
		}
	}
}
#endif
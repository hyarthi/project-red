#pragma once

#include "network_manager.hpp"

namespace red {
	namespace hooks {
		namespace net {
			// globals
			NetworkManager * gNMInstance = NULL;

			// REDClient methods

			uint32 REDClient::getMessageSize(uint8 * hdr) {
				uint32 size = 0;
				gLog->LogLine("Response header: 0x%02X%02X%02X%02X\n", hdr[0], hdr[1], hdr[2], hdr[3]);
				ArrayInputStream ais(hdr, 4);
				CodedInputStream coded(&ais);
				coded.ReadLittleEndian32(&size);
				return size;
			}

			STATUS REDClient::ParseResponse(uint8 * buffer, uint32 bufSize, Arena * arena, Response * response) {
				//response = arena->CreateMessage<Response>(arena);
				ArrayInputStream ais(buffer, bufSize);
				//ArrayInputStream ais()
				CodedInputStream coded(&ais);
				//uint32 buf = 0;
				//coded.ReadLittleEndian32(&buf);
				//coded.ReadVarint32(&bufSize);
				CodedInputStream::Limit limit = coded.PushLimit(bufSize);
				bool success = response->ParseFromCodedStream(&coded);
				gLog->LogLine("Successful message parse: %s\n", success ? "true" : "false");
				gLog->LogLine("Consumed whole message: %s\n", coded.ConsumedEntireMessage() ? "true" : "false");
				coded.PopLimit(limit);
				return RH_ERR_NOERROR;
			}

			REDClient::REDClient(string _REDUrl, string _REDPort) {
				REDUrl = "";
				REDUrl += _REDUrl;
				REDPort = "";
				REDPort += _REDPort;

				gLog->LogLine("Starting up RED Client...\n");
				gLog->FlushNow();
				status = RC_STATUS_STARTING;
				gLog->LogLine("Getting IO service...\n");
				gLog->FlushNow();
				io = new io_service();
				gLog->LogLine("Getting resolver...\n");
				gLog->FlushNow();
				rslvr = new resolver(*io);
				gLog->LogLine("Sizes: %d, %d\n", REDUrl.size(), REDPort.size());
				gLog->FlushNow();
				if (REDUrl.size() == 0 || REDPort.size() == 0) {
					// something's wrong - could not initialize
					status = RC_STATUS_STOPPED;
					gLog->LogLine("Something's wrong...\n");
					gLog->FlushNow();
					return;
				}
				else {
					gLog->LogLine("Creating query...\n");
					//gLog->LogLine("Creating endpoint...\n");
					gLog->FlushNow();
					// continue initialization
					q = new query(REDUrl, REDPort);
					// test connection
					// TODO
					try {
						gLog->LogLine("Resolving query...\n");
						gLog->FlushNow();
						iter = rslvr->resolve(*q);
						//tcp::socket sock(*io);
						gLog->LogLine("Creating socket...\n");
						gLog->FlushNow();
						//sock = new socket(*io);
						socket sock(*io);
						//socket sock(*io);
						//gLog->LogLine("Setting non-block...\n");
						//gLog->FlushNow();
						boost::system::error_code err;
						//sock->non_blocking(false, err);
						/*if (err) {
							// error happened
							status = RC_STATUS_ERROR;
							gLog->LogLine("Could not set non-block: %s (%d)\n", err.message().c_str(), err.value());
							gLog->FlushNow();
							return;
						}*/
						/*socket::keep_alive option;
						option = true;
						gLog->LogLine("Setting keepalive option...\n");
						gLog->FlushNow();
						sock->set_option(option, err);
						if (err) {
							// error happened
							status = RC_STATUS_ERROR;
							gLog->LogLine("Could not set keepalive option...\n");
							gLog->FlushNow();
							return;
						}*/
						gLog->LogLine("Trying to connect...\n");
						gLog->FlushNow();
						boost::asio::connect(sock, iter, end, err);
						if (err) {
							// error happened
							status = RC_STATUS_ERROR;
							gLog->LogLine("Failed to connect...\n");
							gLog->LogLine("REASON: (%d) %s\n", err.value(), err.message().c_str());
							gLog->FlushNow();
						}
						else {
							// no error, continue
							//sock.close();
							gLog->LogLine("Setting non-block...\n");
							gLog->FlushNow();
							sock.non_blocking(false, err);
							if (err) {
								// error happened
								status = RC_STATUS_ERROR;
								gLog->LogLine("Could not set non-block: %s (%d)\n", err.message().c_str(), err.value());
								gLog->FlushNow();
								return;
							}
							socket::keep_alive option;
							option = true;
							gLog->LogLine("Setting keepalive option...\n");
							gLog->FlushNow();
							sock.set_option(option, err);
							if (err) {
								// error happened
								status = RC_STATUS_ERROR;
								gLog->LogLine("Could not set keepalive option...\n");
								gLog->FlushNow();
								return;
							}
							sock.close();
						}
					}
					catch (std::exception& e) {
						status = RC_STATUS_ERROR;
						gLog->LogLine("ERROR starting RED Client: %s\n", e.what());
						gLog->FlushNow();
					}
					// done
					if (status == RC_STATUS_STARTING)
						status = RC_STATUS_RUNNING;
					gLog->LogLine("RED Client running.\n");
					gLog->FlushNow();
				}
				gLog->LogLine("RED Client status: %d\n", status);
				gLog->FlushNow();
			}

			STATUS REDClient::setupSocket(socket sock) {
				boost::system::error_code err;

				gLog->LogLine("Setting non-block...\n");
				gLog->FlushNow();
				sock.non_blocking(false, err);
				if (err) {
					// error happened
					status = RC_STATUS_ERROR;
					gLog->LogLine("Could not set non-block: %s (%d)\n", err.message().c_str(), err.value());
					gLog->FlushNow();
					return RC_STATUS_ERROR;
				}
				socket::keep_alive option;
				option = true;
				gLog->LogLine("Setting keepalive option...\n");
				gLog->FlushNow();
				sock.set_option(option, err);
				if (err) {
					// error happened
					status = RC_STATUS_ERROR;
					gLog->LogLine("Could not set keepalive option...\n");
					gLog->FlushNow();
					return RC_STATUS_ERROR;
				}
				return RH_ERR_NOERROR;
			}

			REDClient::~REDClient() {
				// TODO check this
				//sock->close();
				//delete sock;
				delete q;
				delete rslvr;
				delete io;
			}

			STATUS REDClient::SendRequest(Request request, Response * retResponse) {
				if (REDUrl.size() == 0 || REDPort.size() == 0 || status != RC_STATUS_RUNNING) {
					// something's wrong, return errors
					// connection not defined
					if (REDUrl.size() == 0 || REDPort.size() == 0)
						return RH_ERR_RC_CONNECTION_UNDEFINED;
					// RC fails to connect
					if (status == RC_STATUS_ERROR)
						return RH_ERR_RC_ERROR;
					// RC is not running
					if (status == RC_STATUS_STOPPED || status == RC_STATUS_STARTING)
						return RH_ERR_RC_STOPPED;
				}

				gLog->LogLine("RED Client started sending.\n");
				gLog->FlushNow();
				
				string outstring = "";
				int siz = request.ByteSize() + 4;
				uint8 * payload = new uint8[siz];
				StringOutputStream sos(&outstring);
				CodedOutputStream * coded = new CodedOutputStream(&sos);
				gLog->LogLine("Message size is: %d\n", request.ByteSize());
				gLog->FlushNow();
				
				coded->WriteLittleEndian32(request.ByteSize());
				request.SerializeToCodedStream(coded);
				coded->Trim();
				gLog->LogLine("Finished writing header.\n");
				gLog->FlushNow();

				// start synchronized thread part
				//std::lock_guard<std::mutex> lock(socketMutex);
				boost::system::error_code err;
				//if (!sock->is_open())
				gLog->LogLine("Connecting to server socket...\n");
				gLog->FlushNow();
				socket sock(*io);
				boost::asio::connect(sock, iter, end, err);
				if (err) {
					// error happened
					gLog->LogLine("Error happened while trying to reconnect to server: [%d] %s\n", err.value(), err.message().c_str());
					gLog->FlushNow();
					//socketMutex.unlock();
					return RH_ERR_RC_ERROR;
				}
				// no error, continue
				size_t writeBytes;
				gLog->LogLine("Writing message to socket...\n");
				gLog->FlushNow();
				writeBytes = boost::asio::write(sock, boost::asio::buffer(outstring), boost::asio::transfer_all(), err);
				if (err) {
					// error happened
					gLog->LogLine("Error happened while transferring data over the socket: [%d] %s\n", err.value(), err.message().c_str());
					gLog->FlushNow();
					//socketMutex.unlock();
					return RH_ERR_RC_ERROR;
				}

				// TODO block for receive & cycle
				// prepare for timeout
				std::chrono::steady_clock::time_point start = std::chrono::steady_clock::now();
				size_t readBytes;
				uint8 sizeBuf[4], * responseMsg;
				gLog->LogLine("Peeking response...\n");
				gLog->FlushNow();
				boost::asio::read(sock, boost::asio::buffer(sizeBuf, 4), boost::asio::transfer_all(), err);
				if (err) {
					// error happened
					gLog->LogLine("Error happened while reading response data header from the socket: [%d] %s\n", err.value(), err.message().c_str());
					gLog->FlushNow();
					//socketMutex.unlock();
					return RH_ERR_RC_ERROR;
				}
				uint32 respSize = getMessageSize(sizeBuf);
				gLog->LogLine("Response size: %d\n", respSize);
				gLog->FlushNow();
				responseMsg = new uint8[respSize];
				gLog->LogLine("Reading response...\n");
				gLog->FlushNow();
				boost::asio::read(sock, boost::asio::buffer(responseMsg, respSize), boost::asio::transfer_all(), err);
				if (err) {
					// error happened
					gLog->LogLine("Error happened while reading response data from the socket: [%d] %s\n", err.value(), err.message().c_str());
					gLog->FlushNow();
					//socketMutex.unlock();
					return RH_ERR_RC_ERROR;
				}
				gLog->LogLine("Still available in the socket: %lu\n", sock.available());
				gLog->FlushNow();
				sock.close();
				// unlock socket
				//socketMutex.unlock();
				STATUS error;
				gLog->LogLine("Parsing response...\n");
				gLog->FlushNow();
				error = ParseResponse(responseMsg, respSize, request.GetArena(), retResponse);
				gLog->LogLine("Processing done.\n");
				gLog->FlushNow();

				return RH_ERR_NOERROR;
			}

			bool REDClient::isRunning() {
				gLog->LogLine("RED Client status: %d\n", status);
				return status == RC_STATUS_RUNNING;
			}

			// NetworkManager methods
			
			NetworkManager::NetworkManager() {
				rclient_start_launched = false;
			}

			NetworkManager::~NetworkManager() {
				delete rclient;
			}

			void NetworkManager::StartUp() {
				string sredurl, sredport;
				char * cenv = new char[MAXENVVALUE + 1];
				//gLog->OpenLogFile(LOGGER_OPEN_APPEND);
				gLog->LogLine("Starting up Network Manager...\n");
				OSGetEnvironmentString(INI_RED_URL, cenv, MAXENVVALUE + 1);
				sredurl = cenv;
				gLog->LogLine("RED URL: %s\n", sredurl);
				OSGetEnvironmentString(INI_RED_PORT, cenv, MAXENVVALUE + 1);
				sredport = cenv;
				gLog->LogLine("RED Port: %s\n", sredport);
				if (!rclient_start_launched) {
					rclient_start_launched = true;
					rclient = new REDClient(sredurl, sredport);
				}
				gLog->LogLine("Network Manager started.\n");
				//gLog->CloseLogFile();
			}

			void NetworkManager::ShutDown() {
				//delete rclient;
			}

			STATUS NetworkManager::ProcessHookRequest(Request request, Response * retResponse) {
				if (!rclient->isRunning()) {
					retResponse = NULL;
					return RH_ERR_RC_STOPPED;
				}

				STATUS err = rclient->SendRequest(request, retResponse);

				return err;
			}
		}
	}
}

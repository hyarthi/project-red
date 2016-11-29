#pragma once

#include "logger.hpp"

namespace red {
	namespace hooks {
		namespace log {
			// globals
			Logger * gLog = (Logger *)NULL;

			Logger::Logger() {
				WORD wd;

				filename = LOG_FILENAME;
				char * folder = LOG_FOLDER;
				wd = OSGetDataDirectory(filepath);
				strcat(filepath, folder);
				strcat(filepath, "\\");
				strcat(filepath, filename);
			}

			Logger::~Logger() {
			}

			void Logger::LogLine(char * pattern, ...) {
				if (this->flog) {
					va_list args;
					va_start(args, pattern);
					vfprintf(this->flog, pattern, args);
					va_end(args);
					if (ferror(this->flog)) {
						this->CloseLogFile();
					}
				}
			}

			void Logger::OpenLogFile(int mode) {
				char * mod;
				switch (mode) {
				case LOGGER_OPEN_WRITE:
					mod = "w+";
					break;
				case LOGGER_OPEN_APPEND:
					mod = "a+";
					break;
				default:
					return;
				}
				flog = fopen(filepath, mod);
			}

			void Logger::OpenLogFile(char * mode) {
				flog = fopen(filepath, mode);
			}

			void Logger::CloseLogFile() {
				fclose(flog);
				flog = (FILE *)0;
			}

			void Logger::FlushNow() {
				fflush(flog);
			}
		}
	}
}
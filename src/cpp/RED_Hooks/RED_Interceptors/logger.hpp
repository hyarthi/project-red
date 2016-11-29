#pragma once

#ifndef RED_LOGGER
#define RED_LOGGER

#include "stdafx.h"

#define LOGGER_OPEN_WRITE 1
#define LOGGER_OPEN_APPEND 2

namespace red {
	namespace hooks {
		namespace log {
			class Logger {
			private:
				FILE * flog = (FILE *)0;
				char * filename;
				char filepath[MAXPATH + 1];
			public:
				Logger();
				~Logger();
				void LogLine(char * pattern, ...);
				void OpenLogFile(int mode);
				void OpenLogFile(char * mode);
				void CloseLogFile();
				void FlushNow();
			};

			extern Logger * gLog;
		}
	}
}
#endif

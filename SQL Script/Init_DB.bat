@echo off
REM init_DB.bat - create the myweibo DB and tables

REM Usage:
REM init_DB.bat [options]

REM options may be connection parameters if you need to specify them:
REM init_DB.bat -p -u root

if not "%1" == "" goto LOAD
  @echo Usage: init_DB.bat [options]
  goto DONE

:LOAD
mysql -e "source Init_DB.sql" %*
:DONE
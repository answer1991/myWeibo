@echo off
REM Init_All_Tables.bat - create myweibo tables

REM Usage:
REM Init_All_Tables.bat [options] db_name

REM options may be connection parameters if you need to specify them:
REM Init_All_Tables.bat -p -u sampadm db_name

if not "%1" == "" goto LOAD
  @echo Usage: Init_All_Tables.bat [options] db_name
  goto DONE

:LOAD
mysql -e "source Init_All_Tables.sql" %*
:DONE
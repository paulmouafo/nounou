@ECHO OFF
SETLOCAL
CHCP 1252 >NUL
CD /D "%~dp0"


SET ANCIEN_NOM=contacts


SET JAVA_HOME=C:\dev22\eclipse-p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955\jre
SET ANT_HOME=C:\dev22\utils\ant
SET MAVEN_HOME=C:\dev22\utils\maven

PATH %JAVA_HOME%\bin;%PATH%
PATH %ANT_HOME%\bin;%PATH%
PATH %MAVEN_HOME%\bin;%PATH%

SET FULLPATH_ROOT=%~dp0
IF "%FULLPATH_ROOT:~-1,1%"=="\" (
  SET FULLPATH_ROOT=%FULLPATH_ROOT:~-0,-1%
)
CALL :set-name NOUVEAU_NOM "%FULLPATH_ROOT%"

CALL ANT -Dnew.name=%ANCIEN_NOM% -Dnew.name=%NOUVEAU_NOM% -f renommer-projet.xml

CALL MVN clean install eclipse:eclipse

ENDLOCAL
ECHO. & PAUSE
GOTO :EOF


:set-fullpath-scriptdir
SET _FULLPATH=%~dp0
IF "%_FULLPATH:~-1,1%"=="\" (
  IF NOT "%_FULLPATH:~-2,1%"==":" SET _FULLPATH=%_FULLPATH:~-0,-1%
)
SET %~1=%_FULLPATH%
GOTO :EOF


:set-name
SET %~1=%~n2
GOTO :EOF

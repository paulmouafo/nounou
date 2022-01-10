CHCP 65001 >NUL
PROMPT $G

REM Variables d'environnement communes
REM aux differents scripts

SET JAVA_HOME=C:\dev22\eclipse-p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955\jre
SET IJ_HOME=C:\dev22\utils\ij

SET CLASSPATH_JDBC=
FOR /R "%IJ_HOME%\drivers" %%f in ( *.jar ) DO (
  CALL SET NAME_FILE_WITHOUT_DERBY=%%~nf
  CALL SET NAME_FILE_WITHOUT_DERBY=%%NAME_FILE_WITHOUT_DERBY:derby=%%
  CALL :classpath-jdbc-append "%%NAME_FILE_WITHOUT_DERBY%%" "%%f"
)

SET DERBY_OPTS=-Dfile.encoding=UTF-8

GOTO :EOF


:classpath-jdbc-append
IF "%~1"=="%~n2" (
  SET CLASSPATH_JDBC=%CLASSPATH_JDBC%;%2
) 	  
GOTO :EOF


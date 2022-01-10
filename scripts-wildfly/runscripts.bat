@ECHO OFF
SETLOCAL
CHCP 65001 >NUL
CD /D "%~dp0"
PROMPT $G

SET JAVA_HOME=C:\dev22\eclipse-p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_15.0.2.v20210201-0955\jre
SET WILDFLY_HOME=C:\dev22\wildfly-24
SET WILDFLY_URL=http://localhost:8931
SET NOPAUSE=ON

:MENU
ECHO.
ECHO Actions :
ECHO.
ECHO     1. Supprime Gestion de la Sécurité
ECHO     2. Supprime DataSource
ECHO     3. Supprime JDBC Driver
ECHO.
ECHO     4. Ajoute   JDBC Driver
ECHO     5. Ajoute   DataSource
ECHO     6. Ajoute   Gestion de la sécurité
ECHO.
ECHO     0. Quitter
ECHO.
SET CHOIX=
SET /P CHOIX=Votre choix : 

FOR %%p IN (%CHOIX%) DO CALL :executer_action %%p
IF "%CHOIX%" == "" GOTO FIN
IF "%CHOIX%" == "0" GOTO FIN
GOTO MENU

:FIN
ENDLOCAL
rem PAUSE
GOTO :EOF


:executer_action
SET SCRIPT=
IF /I [%1]==[1]  SET SCRIPT=1-remove-securtity.cli
IF /I [%1]==[2]  SET SCRIPT=2-remove-datasource.cli
IF /I [%1]==[3]  SET SCRIPT=3-remove-jdbc-driver.cli
IF /I [%1]==[4]  SET SCRIPT=4-add-jdbc-driver.cli
IF /I [%1]==[5]  SET SCRIPT=5-add-datasource.cli
IF /I [%1]==[6]  SET SCRIPT=6-add-security.cli
IF NOT [%SCRIPT%]==[] (
rem   CALL "%WILDFLY_HOME%\bin\jboss-cli.bat" --connect --controller=remote+%WILDFLY_URL% --file="%~dp0%SCRIPT%"
  CALL "%WILDFLY_HOME%\bin\jboss-cli.bat" --connect --controller=remote+%WILDFLY_URL% --file="%SCRIPT%"
  ECHO,
)
GOTO :EOF


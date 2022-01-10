@ECHO OFF
IF  "%1"=="" goto :usage
SETLOCAL
CALL "%~dp0\_config.bat"

TITLE %~nx0 - %1

SET FUULPATH_FILE_PROPERTIES=%~dp0\properties\%1.properties
SET CLASSPATH=%CLASSPATH_JDBC%

CALL "%IJ_HOME%\bin\ij.bat"  -p "%FUULPATH_FILE_PROPERTIES%"  %2 

IF NOT %ERRORLEVEL% == 0 (
  ECHO. & PAUSE
) ELSE (
  IF NOT [%2]==[] (
    ECHO. & ECHO Traitement terminé. & ECHO.
    PAUSE
  )
)
ENDLOCAL

GOTO :EOF

:usage
ECHO.
ECHo Usage : %~nx0 ^<nom_serveur^>
ECHO. & PAUSE

@echo off
REM Text Editor Runner Batch File
REM This script sets up the Java environment and runs the Text Editor application

echo.
echo ================================
echo   Text Editor - Starting...
echo ================================
echo.

REM Set Java Home
set JAVA_HOME=E:\jdk-25\jdk-25.0.2

REM Build the classpath with all required JAR files
set CLASSPATH=.\bin\log4j-api-2.20.0.jar;.\bin\log4j-core-2.20.0.jar;.\bin\mariadb-java-client-3.2.0.jar;.\bin\AlKhalilMorphoSys2.jar;.\bin\AlKhalilDiacritizer.jar;.\bin\Pos_tagger.jar;.\bin;.\resource

REM Run the application
echo Running application with Java 25...
"%JAVA_HOME%\bin\java.exe" -cp %CLASSPATH% Driver

REM Keep window open if there's an error
if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Application failed to start
    echo Press any key to close this window...
    pause
)

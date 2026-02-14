@echo off
REM Text Editor Compiler Batch File
REM This script compiles all Java source files

echo.
echo ================================
echo   Text Editor - Compiling...
echo ================================
echo.

REM Set Java Home
set JAVA_HOME=E:\jdk-25\jdk-25.0.2

REM Build the classpath with all required JAR files
set CLASSPATH=.\bin\log4j-api-2.20.0.jar;.\bin\log4j-core-2.20.0.jar;.\bin\mariadb-java-client-3.2.0.jar;.\bin\AlKhalilMorphoSys2.jar;.\bin\AlKhalilDiacritizer.jar;.\bin\Pos_tagger.jar;.\bin;.\resource

REM Compile all Java source files
echo Compiling all Java source files...
"%JAVA_HOME%\bin\javac.exe" -d bin -cp %CLASSPATH% src\*.java src\bll\*.java src\dal\*.java src\dto\*.java src\pl\*.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo SUCCESS: Compilation completed!
    echo.
    echo To run the application, execute run.bat
    echo.
) else (
    echo.
    echo ERROR: Compilation failed. Check the errors above.
    echo.
)

pause

@echo off
setlocal

set BASE_DIR=%~dp0
set WRAPPER_JAR=%BASE_DIR%.mvn\wrapper\maven-wrapper.jar
set WRAPPER_PROPERTIES=%BASE_DIR%.mvn\wrapper\maven-wrapper.properties

for /f "tokens=1,* delims==" %%A in ('findstr "wrapperUrl" "%WRAPPER_PROPERTIES%"') do set WRAPPER_URL=%%B

if not exist "%WRAPPER_JAR%" (
  echo Downloading Maven Wrapper from: %WRAPPER_URL%
  powershell -Command "Invoke-WebRequest -Uri '%WRAPPER_URL%' -OutFile '%WRAPPER_JAR%'"
)

if "%JAVA_HOME%"=="" (
  set JAVA_CMD=java
) else (
  set JAVA_CMD=%JAVA_HOME%\bin\java
)

"%JAVA_CMD%" -classpath "%WRAPPER_JAR%" "-Dmaven.multiModuleProjectDirectory=%BASE_DIR%" org.apache.maven.wrapper.MavenWrapperMain %*

endlocal

@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ganttproject startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and GANTTPROJECT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="--add-exports" "javafx.controls/com.sun.javafx.scene.control.behavior=ALL-UNNAMED" "--add-exports" "javafx.base/com.sun.javafx=ALL-UNNAMED" "--add-exports" "javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED" "--add-exports" "javafx.controls/com.sun.javafx.scene.control.skin=ALL-UNNAMED" "--add-exports" "javafx.controls/com.sun.javafx.scene.control.skin.resources=ALL-UNNAMED" "--add-exports" "javafx.controls/com.sun.javafx.scene.control.inputmap=ALL-UNNAMED" "--add-exports" "javafx.graphics/com.sun.javafx.scene.traversal=ALL-UNNAMED" "--add-exports" "javafx.graphics/com.sun.javafx.scene=ALL-UNNAMED" "--add-exports" "javafx.graphics/com.sun.javafx.tk=ALL-UNNAMED" "--add-exports" "javafx.graphics/com.sun.javafx.util=ALL-UNNAMED" "--add-opens" "java.desktop/sun.swing=ALL-UNNAMED" "--add-opens" "java.desktop/sun.awt.X11=ALL-UNNAMED" "-Dorg.jooq.no-logo=true"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\ganttproject-22.11.13-SNAPSHOT.jar;%APP_HOME%\lib\eclipsito.jar;%APP_HOME%\lib\resources;%APP_HOME%\lib\biz.ganttproject.core-22.11.13-SNAPSHOT.jar;%APP_HOME%\lib\kotlinx-serialization-json-jvm-1.4.0.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.6.4.jar;%APP_HOME%\lib\kotlinx-coroutines-javafx-1.6.4.jar;%APP_HOME%\lib\kotlinx-serialization-core-jvm-1.4.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.7.20.jar;%APP_HOME%\lib\javafx-fxml-17-linux.jar;%APP_HOME%\lib\javafx-controls-17-linux.jar;%APP_HOME%\lib\javafx-controls-17.jar;%APP_HOME%\lib\javafx-swing-17-linux.jar;%APP_HOME%\lib\javafx-graphics-17-linux.jar;%APP_HOME%\lib\javafx-graphics-17.jar;%APP_HOME%\lib\javafx-base-17-linux.jar;%APP_HOME%\lib\javafx-base-17.jar;%APP_HOME%\lib\h2-2.1.214.jar;%APP_HOME%\lib\jooq-3.16.4.jar;%APP_HOME%\lib\biz.ganttproject.desktop.jar;%APP_HOME%\lib\commons-csv.jar;%APP_HOME%\lib\commons-net-ftpclient-3.0.1.jar;%APP_HOME%\lib\ganttproject-jxbusycomponent-1.2.2.jar;%APP_HOME%\lib\mdfx-0.2.0-SNAPSHOT.jar;%APP_HOME%\lib\milton-api-2.7.4.4.jar;%APP_HOME%\lib\milton-client-2.7.4.4-bs.jar;%APP_HOME%\lib\org.bouncycastle.openpgp-1.67-with-deps.jar;%APP_HOME%\lib\swingx-1.6.4.jar;%APP_HOME%\lib\biz.ganttproject.app.localization-22.11.13-SNAPSHOT.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.7.20.jar;%APP_HOME%\lib\kotlin-reflect-1.7.20.jar;%APP_HOME%\lib\kotlin-stdlib-1.7.20.jar;%APP_HOME%\lib\r2dbc-spi-0.9.0.RELEASE.jar;%APP_HOME%\lib\jakarta.xml.bind-api-3.0.0.jar;%APP_HOME%\lib\guava-31.1-jre.jar;%APP_HOME%\lib\jackson-databind-2.13.4.jar;%APP_HOME%\lib\jackson-core-2.13.4.jar;%APP_HOME%\lib\jackson-annotations-2.13.4.jar;%APP_HOME%\lib\jackson-dataformat-xml-2.13.4.jar;%APP_HOME%\lib\retry4j-0.15.0.jar;%APP_HOME%\lib\slf4j-jdk14-2.0.3.jar;%APP_HOME%\lib\slf4j-api-2.0.3.jar;%APP_HOME%\lib\httpmime-4.5.13.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\poi-5.2.3.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\commons-io-2.11.0.jar;%APP_HOME%\lib\concurrentlinkedhashmap-lru-1.4.2.jar;%APP_HOME%\lib\jgoodies-looks-2.7.0.jar;%APP_HOME%\lib\jgoodies-common-1.8.1.jar;%APP_HOME%\lib\okhttp-3.14.9.jar;%APP_HOME%\lib\fontawesomefx-fontawesome-4.7.0-9.1.2.jar;%APP_HOME%\lib\fontawesomefx-materialicons-2.2.0-9.1.2.jar;%APP_HOME%\lib\fontawesomefx-commons-9.1.2.jar;%APP_HOME%\lib\balloontip-1.2.4.1.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\controlsfx-11.1.2.jar;%APP_HOME%\lib\nanohttpd-2.3.1.jar;%APP_HOME%\lib\jdom-1.1.3.jar;%APP_HOME%\lib\jxlayer-3.0.4.jar;%APP_HOME%\lib\flexmark-ext-gfm-strikethrough-0.64.0.jar;%APP_HOME%\lib\flexmark-ext-tables-0.64.0.jar;%APP_HOME%\lib\flexmark-ext-attributes-0.64.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.7.20.jar;%APP_HOME%\lib\flexmark-util-0.64.0.jar;%APP_HOME%\lib\flexmark-0.64.0.jar;%APP_HOME%\lib\flexmark-util-format-0.64.0.jar;%APP_HOME%\lib\flexmark-util-ast-0.64.0.jar;%APP_HOME%\lib\flexmark-util-builder-0.64.0.jar;%APP_HOME%\lib\flexmark-util-dependency-0.64.0.jar;%APP_HOME%\lib\flexmark-util-html-0.64.0.jar;%APP_HOME%\lib\flexmark-util-options-0.64.0.jar;%APP_HOME%\lib\flexmark-util-sequence-0.64.0.jar;%APP_HOME%\lib\flexmark-util-collection-0.64.0.jar;%APP_HOME%\lib\flexmark-util-data-0.64.0.jar;%APP_HOME%\lib\flexmark-util-misc-0.64.0.jar;%APP_HOME%\lib\flexmark-util-visitor-0.64.0.jar;%APP_HOME%\lib\annotations-15.0.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\jakarta.activation-2.0.0.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.12.0.jar;%APP_HOME%\lib\error_prone_annotations-2.11.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\woodstox-core-6.3.1.jar;%APP_HOME%\lib\stax2-api-4.2.1.jar;%APP_HOME%\lib\okio-1.17.2.jar;%APP_HOME%\lib\httpcore-4.4.13.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-math3-3.6.1.jar;%APP_HOME%\lib\SparseBitSet-1.2.jar;%APP_HOME%\lib\log4j-api-2.18.0.jar


@rem Execute ganttproject
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GANTTPROJECT_OPTS%  -classpath "%CLASSPATH%" net.sourceforge.ganttproject.AppKt %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable GANTTPROJECT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%GANTTPROJECT_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

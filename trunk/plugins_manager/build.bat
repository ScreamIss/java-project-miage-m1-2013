set PLUGINS_DIR=build\plugins
set DEST_DIR=Plugins-acceptor
rmdir /s /q %DEST_DIR%
mkdir %DEST_DIR%

echo Copy common data 
COPY build\run.bat %DEST_DIR%\run.bat 
COPY build\log4j.properties %DEST_DIR%\log4j.properties 
XCOPY /EIC libs %DEST_DIR%\libs /S

echo Build accceptor
call ant -buildfile .\build\acceptor\build.xml -Ddest.dir=%DEST_DIR%

echo Build plugins
call ant -buildfile .\%PLUGINS_DIR%\build.xml -Ddest.dir=%DEST_DIR% -propertyfile .\%PLUGINS_DIR%\dummy.build.properties 
call ant -buildfile .\%PLUGINS_DIR%\build.xml -Ddest.dir=%DEST_DIR% -propertyfile .\%PLUGINS_DIR%\spreadsheet.build.properties
call ant -buildfile .\%PLUGINS_DIR%\build.xml -Ddest.dir=%DEST_DIR% -propertyfile .\%PLUGINS_DIR%\chart.build.properties 



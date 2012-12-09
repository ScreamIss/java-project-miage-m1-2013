#!/bin/bash

PLUGINS_DIR=build/plugins
DEST_DIR=Plugins-acceptor
rm -r ${DEST_DIR}
mkdir ${DEST_DIR}

echo Copy common data
cp build/run.sh ${DEST_DIR}/run.sh
cp build/log4j.properties ${DEST_DIR}/log4j.properties
cp -r libs ${DEST_DIR}/libs

echo Build accceptor
ant -buildfile ./build/acceptor/build.xml -Ddest.dir=${DEST_DIR}

echo Build plugins
ant -buildfile ./${PLUGINS_DIR}/build.xml -Ddest.dir=${DEST_DIR} -propertyfile ./${PLUGINS_DIR}/dummy.build.properties 
ant -buildfile ./${PLUGINS_DIR}/build.xml -Ddest.dir=${DEST_DIR} -propertyfile ./${PLUGINS_DIR}/spreadsheet.build.properties 
ant -buildfile ./${PLUGINS_DIR}/build.xml -Ddest.dir=${DEST_DIR} -propertyfile ./${PLUGINS_DIR}/chart.build.properties 

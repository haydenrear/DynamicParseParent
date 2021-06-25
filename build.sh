#!/bin/bash

cd DynamicParseStarter
mvn clean install -DskipTests=true
cd ../DynamicParseBoot
mvn clean install -DskipTests=true
cd ../
mvn clean install -DskipTests=true

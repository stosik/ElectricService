#!/bin/bash

cd ..
./gradlew clean
./gradlew bootJar
./gradlew docker

cd ..
docker-compose up -d

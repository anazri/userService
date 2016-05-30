#!/bin/bash
echo "start mongo database"

docker run --name mongodb -p 27017:27017 -d mongo   

echo "mongo started"
rm -rf build
mkdir build

cp ../target/userService-0.0.1-SNAPSHOT.jar build
echo "userService jar copied to build dir"
cd build
docker build -t userservice ../

docker run --name userService -d -p 8080:8080 -e SPRING_DATA_MONGODB_URI='mongodb://172.17.0.1:27017/users' userservice
docker logs userService
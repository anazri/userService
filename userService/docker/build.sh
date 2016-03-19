echo "start mongo database"
DOCKER_HOST=tcp://192.168.99.100:2376
DOCKER_MACHINE_NAME=default
DOCKER_TLS_VERIFY=1
DOCKER_CERT_PATH=/Users/[username]/.docker/machine/machines/default
docker run -P -d --name mongodb mongo 
cp ../target/userService-0.0.1-SNAPSHOT.jar .
docker build -t devoxx/userService .

docker run -d -p 8080:8080 -e SPRING_DATA_MONGODB_URI=mongodb://192.168.59.103/users --name devoxx/userService devoxx/userService
docker logs devoxx/userService

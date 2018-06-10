# ElectricService

## Example of Hexagonal architecture for electric service.

## Prerequisites
Each module has it's own "entry point" which is only exposed to the outside being public as Facade.

# Modules

This is the list of our modules with their responsibilities 

user
- getLoggedUser

items
- add comment
- list items
- report malfunction

### Run
##### Manual (local) 
```bash
# start frontend
ng serve (angular app from root dir)
# start backend (redis running in docker container required or installed locally)
./gradlew bootRun (from root dir)
```
##### Docker
You can also build Docker images and run all via `Docker Compose`
```bash
# build redis image and backend image and will start docker-compose
# electric-backend/docker-setup

./build-images.sh
```
> Access REST API at http://localhost:8080

> Front API http://localhost:4200

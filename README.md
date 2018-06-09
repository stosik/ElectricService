# ElectricService

## Example of Hexagonal architecture for electric service.

# Modules

This is the list of our modules with their responsibilities 

user
- getLoggedUser

items
- add comment
- list
- report malfunction

### Test
```bash
gradle test
```

### Run
##### Manual (local) 
```bash
# start 
ng serve (angular app from root dir)
./gradlew bootRun (from root dir)
```
##### Docker
You can also build Docker images and run all via `Docker Compose`
```bash
# build frontend image and backend image
./build-images.sh

# start containers in the background
docker-compose up -d

```
> Access REST API at http://localhost:8080

> Front API http://localhost:4200

# grpcImageSearch

## Server Git Bash Commands:

### 1. Protoc command:

- python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. image_search.proto

### 2. Build Container and Create a Volume:

- docker build -t image-search-server .

- docker volume create database_volume

### 3. Run Docker Container and Mount the Volume:

- docker run -d -p 50051:50051 -v database_volume:/app/volume image-search-server

### 4. Copy data from the database folder into the Volume. (Only needs to be done once for the first time)

- docker cp database/. [Put the ID of the server container here, no brakets]:/app/volume

### Client Git Bash Commands:

### 1. Protoc command:

- protoc --java_out=src/main/java --grpc_out=src/main/java src/main/java/image_search.proto

### 2. Clean and install Maven Project:

- mvn clean

- mvn install

### 3. Run the Client Maven Project

- mvn exec:java -Dexec.mainClass="ImageSearchClient"


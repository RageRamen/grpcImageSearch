# Before you run:

- Apache Maven, protoc, and protoc-gen-grpc must be downloaded and setup as the environment variables. For Windows, I use the "edit the system environment variable" to add the paths to each of the bin directories of the Apache Maven, protoc, and protoc-gen-grpc. Also docker commands are required but that should already be installed when docker desktop is installed.
- gRPC and gRPC tools should be installed using python -m pip install grpcio and python -m pip install grpcio-tools from the Python Quick Start Guide. 
- Note: Windows and Git Bash was used for this project. Also the Dockerfile for the client java does not work, so the containerization of the client was unable to be complete.

## Run Server Git Bash Commands:

### 1. Protoc command:

- $ python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. image_search.proto

### 2. Build Container and Create a Volume:

- $ docker build -t image-search-server .

- $ docker volume create database_volume

### 3. Run Docker Container and Mount the Volume to the Container:

- $ docker run -d -p 50051:50051 -v database_volume:/app/volume image-search-server

### 4. Copy data from the database folder into the Volume. (Only needs to be done once for the first time since the Volume is empty when first created)

- $ docker cp database/. [Put the ID of the server container here, no brakets]:/app/volume

# Now the server should be running in docker and the volume has the contents linked to the /app/volume directory. 

### Run Client Git Bash Commands:

### 1. Protoc command:

- $ protoc --java_out=src/main/java --grpc_out=src/main/java src/main/java/image_search.proto

### 2. Clean and install Maven Project:

- $ mvn clean install

### 3. Run the Client Maven Project

- $ mvn exec:java -Dexec.mainClass="ImageSearchClient"

### 4. Searching the keywords on the GUI and Test Cases

- You can see a gui pop up and you can use the search bar. There are 5 test cases meaning that there are 5 keywords: ramen, rice, egg, cake, pokemon. When you search and enter for any of these keywords, you should notice that the "result.jpg" image gets created/updated with a random image based on the keyword. Opening the result.jpg will show the sent image. The result.jpg keeps the same name to avoid confusion when multiple images are downloaded. So if you keep pressing entering and checking the result.jpg, the image will change with the randomly sent image data.
- Remember, each keyword has a corresponding directory that contains 3 images based on the keyword like the ramen keyword has 3 images called: ramen_drawn, ramen_real, and ramen_instant. So searhing the ramen keyword will sent one of these 3 images. Same thing applies to the other keywords and their directory of images.

## Unusual Behaviors of the Code
- The odd thing is that even if you put a non keyword, it still updates the image but just with empty data. So you shouldn't be able to open it. Oddly this issue happened when I switched from using local database directory to using the volume instead. Still odd and it might just be because of docker volume acting odd.
- Note: The database folder is there for you to copy the images into Volume and the Volume is mounted to the /app/volume directory with it's own copy of the images. So when the server looks for an image, it uses the Create Volume's images and not the locally stored database folder. Just here for clarification.

## Before you run:

- The Maven, protoc, and protoc-gen-grpc must be downloaded and setup as the environment variables. For windows, I use the "edit the system environment variable"
- Windows and git bash was used for this project.

## Run Server Git Bash Commands:

### 1. Protoc command:

- $ python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. image_search.proto

### 2. Build Container and Create a Volume:

- $ docker build -t image-search-server .

- $ docker volume create database_volume

### 3. Run Docker Container and Mount the Volume:

- $ docker run -d -p 50051:50051 -v database_volume:/app/volume image-search-server

### 4. Copy data from the database folder into the Volume. (Only needs to be done once for the first time)

- $ docker cp database/. [Put the ID of the server container here, no brakets]:/app/volume

### Run Client Git Bash Commands:

### 1. Protoc command:

- $ protoc --java_out=src/main/java --grpc_out=src/main/java src/main/java/image_search.proto

### 2. Clean and install Maven Project:

- $ mvn clean install

### 3. Run the Client Maven Project

- $ mvn exec:java -Dexec.mainClass="ImageSearchClient"

### 4. Test Cases

- You can see a gui pop up and you can use the search bar. There are 5 test cases meaning that there are 5 keywords: ramen, rice, egg, cake, pokemon. When you search and enter for any of these keywords, you should notice that the "result.jpg" image gets created/updated with a random image based on the keyword. Opening the result.jpg will show the sent image.
- The odd thing is that even if you put a non keyword, it still updates the image but just with unusable data. So you shouldn't be able to open it. Oddly this issue happens when I switched from using local database directory to using the volume instead.
- Note: The database folder is there for you to copy the images into Volume and the Volume is mounted to the volume directory with it's images. So when the server looks for an image, it uses the Create Volume's images and not the database folder. Just here for clarification.

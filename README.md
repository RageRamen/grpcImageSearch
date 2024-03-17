# grpcImageSearch

Create Volume:

docker volume create dataset_volume

docker cp dataset/. [Put the ID of the image-search-server]c:/app/volume

docker run -d -p 50051:50051 -v my_dataset_volume:/app/volume image-search-server



Server Git Bash Commands:

Run the protoc command:
python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. image_search.proto

Build the docker container:
docker build -t image-search-server .

Run the docker container:
docker run -d -p 50051:50051 image-search-server

Client Git Bash Commands:

mvn clean

mvn install

protoc --java_out=src/main/java --grpc_out=src/main/java src/main/java/image_search.proto

mvn exec:java -Dexec.mainClass="ImageSearchClient"


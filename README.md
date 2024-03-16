# grpcImageSearch

Server Git Bash Commands:

1. Run the protoc command:
python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. image_search.proto

2. Build the docker container:
docker build -t image-search-server .

3. Run the docker container:
docker run -d -p 50051:50051 image-search-server

Client Git Bash Commands:

mvn clean

mvn install

protoc --java_out=src/main/java --grpc_out=src/main/java src/main/java/image_search.proto

mvn exec:java -Dexec.mainClass="ImageSearchClient"


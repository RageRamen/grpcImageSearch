from concurrent import futures
import grpc
import random

import image_search_pb2
import image_search_pb2_grpc


class ImageSearchServicer(image_search_pb2_grpc.ImageSearchServicer):
    def SearchImage(self, request, context):
        keyword = request.keyword
        if keyword == "ramen":
            # If the keyword matches "ramen", load the image data from the file
            with open("dataset/ramen.jpg", "rb") as f:
                image_data = f.read()
        else:
            # If the keyword is not "ramen", return a default image data or handle the error as needed
            image_data = b'Default image data for unknown keyword'
        return image_search_pb2.ImageResponse(image_data=image_data)

def serve():
    port = "50051"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    image_search_pb2_grpc.add_ImageSearchServicer_to_server(ImageSearchServicer(), server)
    server.add_insecure_port('[::]:' + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()    
   

if __name__ == '__main__':
    serve()

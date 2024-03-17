from concurrent import futures
import grpc
import os
import random

import image_search_pb2
import image_search_pb2_grpc


class ImageSearchServicer(image_search_pb2_grpc.ImageSearchServicer):
    def SearchImage(self, request, context):
        keyword = request.keyword

        directory = f"volume/{keyword}/"

        if not os.path.isdir(directory):
            image_data = b'Keyword does not exist as a folder ' + bytes(directory, 'utf-8')
            image_name = ""
        else:
            directory_list = os.listdir(directory)
            #print(directory_list)

            image_name = random.choice(directory_list)
            dir_ranking_item = directory + image_name

            if os.path.isfile(dir_ranking_item):
                with open(dir_ranking_item, "rb") as f:
                    #print(dir_ranking_item)
                    image_data = f.read()
            else:
                image_data = b'Image data not present in directory ' + bytes(dir_ranking_item, 'utf-8')
                image_name = ""

        
        
        return image_search_pb2.ImageResponse(image_data=image_data, image_name=image_name)

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

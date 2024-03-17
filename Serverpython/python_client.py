import grpc
import image_search_pb2
import image_search_pb2_grpc
from PIL import Image
import io

def run():
    channel = grpc.insecure_channel('localhost:50051')
    stub = image_search_pb2_grpc.ImageSearchStub(channel)
    response = stub.SearchImage(image_search_pb2.SearchRequest(keyword='ramen'))
    image_data = response.image_data

    print("Client Running ")
    # print(image_data)
    image = Image.open(io.BytesIO(image_data))
    image.show()

if __name__ == '__main__':
    run()
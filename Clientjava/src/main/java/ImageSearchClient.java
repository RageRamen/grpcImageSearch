import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.FileOutputStream;
import java.io.IOException;

import image_search.ImageResponse;
import image_search.ImageSearchGrpc;
import image_search.SearchRequest;

public class ImageSearchClient {
    private final ManagedChannel channel;
    private final ImageSearchGrpc.ImageSearchBlockingStub blockingStub;

    public ImageSearchClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = ImageSearchGrpc.newBlockingStub(channel);
    }

    public void searchImage(String keyword) {
        SearchRequest request = SearchRequest.newBuilder().setKeyword(keyword).build();
        ImageResponse response = blockingStub.searchImage(request);

        try (FileOutputStream outputStream = new FileOutputStream("result.jpg")) {
            outputStream.write(response.getImageData().toByteArray());
            
            System.out.println("Image received and saved. " + response.getImageName());
            //System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ImageSearchClient client = new ImageSearchClient("localhost", 50051);
        try {
            client.searchImage("pokemon");
        } finally {
            client.shutdown();
        }
    }
}
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.FileOutputStream;
import java.io.IOException;

import image_search.ImageResponse;
import image_search.ImageSearchGrpc;
import image_search.SearchRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSearchClient {
    private final ManagedChannel channel;
    private final ImageSearchGrpc.ImageSearchBlockingStub blockingStub;

    private JLabel imageLabel;

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
            //if (!response.getImageName().isEmpty()) {
                //ImageIcon imageIcon = new ImageIcon(response.getImageData().toByteArray());
                //imageLabel.setIcon(imageIcon);
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ImageSearchClient client = new ImageSearchClient("localhost", 50051);
        //try {
        //    client.searchImage("pokemon");
        //} finally {
        //    client.shutdown();
        //}

        JFrame frame = new JFrame("Image Search Client: User Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField keywordField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JLabel imageLabel = new JLabel();

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = keywordField.getText();
                if (!keyword.isEmpty()) {
                    client.searchImage(keyword);
                }
            }
        });

        frame.add(new JLabel("Keyword:"));
        frame.add(keywordField);
        frame.add(searchButton);
        frame.add(imageLabel);

        frame.pack();
        frame.setVisible(true);
    }
}
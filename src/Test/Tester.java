package Test;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Tester extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox box = new VBox();
        ImageView imageView = new ImageView();

        box.getChildren().add(imageView);

        Button localLoadButton = new Button("Local load");
        Button externalLoadButton = new Button("URL Load");

        localLoadButton.setOnAction(e -> {
            Image i = new Image(this.getClass().getResource("char2Walk.gif").toExternalForm());

            System.out.println(i.getException());
            imageView.setImage(i);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);

        });

        externalLoadButton.setOnAction(e -> {
            String imageSource = "https://cdn.dribbble.com/users/550761/screenshots/1773241/untitled-5.gif";
            try {
                imageView.setImage(createImage(imageSource));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        FlowPane buttonPane = new FlowPane();
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().addAll(localLoadButton, externalLoadButton);

        box.getChildren().add(buttonPane);

        stage.setScene(new Scene(box, 500, 400));
        stage.show();
    }

    private Image createImage(String url) throws IOException {
        // You have to set an User-Agent in case you get HTTP Error 403
        // respond while you trying to get the Image from URL.
        URLConnection conn = new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", "Wget/1.13.4 (linux-gnu)");

        try (InputStream stream = conn.getInputStream()) {
            return new Image(stream);
        }
    }
}
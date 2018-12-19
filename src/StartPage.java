import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StartPage {
    public ImageView mainPoster;
    public Button start;
    public AnchorPane pane;
    public Scene scene;

    public StartPage(Stage main, Scene otherScene) {
        this.mainPoster = new ImageView
                (new Image(getClass().getResourceAsStream("Sources\\other\\fronttext.png")));
        this.mainPoster.setFitHeight(450);
        this.mainPoster.setFitWidth(1000);
        start=new Button("Почати гру");
        start.setPrefSize(100, 60);
        start.setStyle("-fx-background-color: #90f3ff; ");
        start.setOnAction(event -> {
            main.setScene(otherScene);
        });

        this.pane=new AnchorPane();
        this.pane.getChildren().addAll(mainPoster,start);
        AnchorPane.setLeftAnchor(start,450.0);
        AnchorPane.setTopAnchor(start,300.0);

        scene= new Scene(pane);
        }

}
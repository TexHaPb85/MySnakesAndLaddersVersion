import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SnakesAndLaddersApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainPanel mainPanel = new MainPanel(9);
        StartPage startPage = new StartPage(primaryStage,mainPanel.mainScene);


        try {
            Scene scene= startPage.scene;
            primaryStage.setTitle("Modern Snakes & Ladders version");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

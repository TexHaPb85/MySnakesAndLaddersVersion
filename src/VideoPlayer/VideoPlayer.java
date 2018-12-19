package VideoPlayer;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

import static javafx.geometry.Pos.BOTTOM_CENTER;
import static javafx.geometry.Pos.CENTER;

public class VideoPlayer {

    private MediaView mediaView;
    private Slider seekSlider;
    private Label time;
    private MediaPlayer mediaPlayer;
    private Boolean flag;

    public VideoPlayer() {
        seekSlider = new Slider();
        mediaView = new MediaView();
        time = new Label();
        time.setPrefWidth(100);
        flag=false;
    }

    public static MediaView playChar1Walk(){
        Media media = new Media("file:/C:/MySnakesAndLaddersVersion/src/Sources/char1/char1Walk.mp4");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();
        return mediaView;
    }

}

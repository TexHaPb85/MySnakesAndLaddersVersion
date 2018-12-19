import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MyRightControlPanel {

    public ImageView moveGif;
    public VBox vBox;
    public Slider slider;
    public GifPlayer gifPlayer;

    public MyRightControlPanel() {
        this.gifPlayer= new GifPlayer();
        this.moveGif=gifPlayer.playChar1Walk(300);
        this.slider=new Slider(200,700,350);
        slider.setOnMouseClicked(event -> {
            resizeGifPlayer();
        });
        this.vBox=new VBox();
        vBox.getChildren().addAll(moveGif,slider);

    }

    public void resizeGifPlayer(){
        this.moveGif=gifPlayer.playChar1Walk((int) slider.getValue());
        vBox.getChildren().clear();
        vBox.getChildren().addAll(moveGif,slider);
    }
}

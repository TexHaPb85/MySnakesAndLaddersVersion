
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GifPlayer {

    public ImageView playChar1Walk(int size){
        Image i = new Image(this.getClass().getResource("Sources\\char1\\char1Walk.gif").toExternalForm());
        ImageView imageView = new ImageView(i);
        System.out.println(i.getException());
        imageView.setImage(i);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return imageView;
    }
}

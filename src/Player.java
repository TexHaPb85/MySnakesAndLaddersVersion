import javafx.scene.image.ImageView;

public class Player {

    public ImageView img;
    public String name;
    public int hp;
    public int pos;
    public boolean isMoving;

    public Player(String name, int hp, ImageView imageView){
        this.img=imageView;
        this.name = name;
        this.hp = hp;
        this.pos = 1;
        this.isMoving = false;
    }


    public Player(int i, boolean b, ImageView secondPlayerIMG) {
        this.name="some player";
        this.hp = i;
        this.pos = 1;
        this.img=secondPlayerIMG;
        this.isMoving = b;
    }

    public void setImgSize(int size){
        img.setFitHeight(size);
        img.setFitWidth(size);
    }
}

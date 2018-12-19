import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import VideoPlayer.*;



public class MyLeftControlPanel {
    public int moveTurn;

    public Player player1;
    public Player player2;

    public Button firstPlayer;
    public Button secondPlayer;

    public VBox mainVBox;


    public MyLeftControlPanel(Player p1, Player p2) {

        this.moveTurn=1;
        this.player1 = p1;
        this.player2 = p2;
        setPlayerButtons();


        mainVBox=new VBox();
        mainVBox.setSpacing(5);
        mainVBox.getChildren().addAll(firstPlayer,secondPlayer);
    }



    public void setPlayerButtons(){
        ImageView firstPlayerIMG=new ImageView
                (new Image(getClass().getResourceAsStream("Sources\\char1\\char1AvatarGlass.png")));
        firstPlayerIMG.setFitHeight(150);
        firstPlayerIMG.setFitWidth(150);
        ImageView secondPlayerIMG=new ImageView
                (new Image(getClass().getResourceAsStream("Sources\\char2\\char2Avatar1.png")));
        secondPlayerIMG.setFitWidth(150);
        secondPlayerIMG.setFitHeight(150);
        firstPlayer=new Button(getPlayer1Info(1),firstPlayerIMG);
        secondPlayer= new Button(getPlayer1Info(2),secondPlayerIMG);

        if(moveTurn==1){
                firstPlayer.setStyle("-fx-background-color: #525252; " +
                                        "-fx-text-fill: aliceblue");

        }else{
                firstPlayer.setStyle("-fx-background-color: #959595;"+
                                        "-fx-text-fill: black");
        }


        if(moveTurn==2){
                secondPlayer.setStyle("-fx-background-color: #525252;"+
                        "-fx-text-fill: aliceblue");
        }else{
                secondPlayer.setStyle("-fx-background-color: #959595;"+
                        "-fx-text-fill: black");
        }
    }

    public void refrash(){
        setPlayerButtons();
        mainVBox.getChildren().clear();
        mainVBox.setSpacing(5);
        mainVBox.getChildren().addAll(firstPlayer,secondPlayer);
    }

    public String getPlayer1Info(int num){
        StringBuilder s = new StringBuilder("Player ");
        s.append(String.valueOf(num));
        if (num==1){
            s.append("\nHP: ").append(player1.hp).append("\nPos: ").append(player1.pos);
        }else if(num==2){
            s.append("\nHP: ").append(player2.hp).append("\nPos: ").append(player2.pos);
        }
        return s.toString();
    }
}

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import VideoPlayer.Util;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;


public class MyGridField {

    public Player player1;
    public Player player2;
    public GridPane field;
    public int[] teleports;
    public int[][] numsOfFields;
    public int scale;
    public int btnSize;
    public ImageView blueTeleport;
    public ImageView yellowTeleport;
    public ImageView twoChars;
    private Image blue;


    public MyGridField(int scale, Player p1, Player p2) {

        this.teleports=new int[scale];

        this.numsOfFields = new int[scale][scale];
        this.scale = scale;
        this.btnSize=75;
        this.player1=p1;
        this.player2=p2;
        player1.setImgSize(btnSize-btnSize/2);
        player2.setImgSize(btnSize-btnSize/2);
        setRandonTeleports();
        setTeleportImg();
        fillGriedField();

        setImgOnBtn(player1.pos,p1.img);
        //setImgOnBtn(2,player2.img);


    }

    public void setTeleportImg(){
       // try{
        this.blue=new Image(getClass().getResourceAsStream("Sources\\other\\blue.png"));
            this.blueTeleport=new ImageView
                    (new Image(getClass().getResourceAsStream("Sources\\other\\blue.png")));
            blueTeleport.setFitHeight(btnSize-btnSize/2);
            blueTeleport.setFitWidth(btnSize-btnSize/2);
            this.yellowTeleport=new ImageView
                    (new Image(getClass().getResourceAsStream("Sources\\other\\yellow.png")));
            blueTeleport.setFitWidth(btnSize-btnSize/2);
            blueTeleport.setFitHeight(btnSize-btnSize/2);
            this.twoChars=new ImageView
                    (new Image(getClass().getResourceAsStream("Sources\\other\\twochars.png")));
            twoChars.setFitHeight(btnSize-btnSize/2);
            twoChars.setFitWidth(btnSize-btnSize/2);
        System.out.println("Images set");
        /*}catch (Exception e){
            System.out.println(e+"\n54 Grid");
        }*/

    }

    public void refresh(){
        for (int i = 1; i < field.getChildren().size()-1; i++) {
            Button button = (Button)field.getChildren().get(i);
            if(i!=player1.pos || i!=player2.pos){
                button.setGraphic(null);
            }
        }
    }

    public void goFromTo(Player player, int to){

        for (int i = 0; i <to-player.pos ; i++) {
            setImgOnBtn(player.pos+i,player.img);
        }

        player.pos=to;
        if (player1.pos==player2.pos){
            setImgOnBtn(player1.pos,twoChars);
        }
    }


    public void setImgOnBtn(int buttonIndex, ImageView img){
        try {
            Button button = (Button)field.getChildren().get(buttonIndex);
            if (player1.pos==player2.pos){
                button.setGraphic(twoChars);
            }else {
                button.setGraphic(img);
            }

        }catch (Exception e) {
            System.out.println(e + e.getStackTrace().toString());
            System.out.println(field.getChildren().toString());
        }
    }
    public void teleportTo(Player player){
        int newPos=teleports[(int)(Math.random()*(teleports.length-1))];
        System.out.println("from "+player.pos+" to "+ newPos);
        player.pos=newPos;
        setImgOnBtn(newPos,player.img);

    }

    public void checkTeleport(){
        for (int i = 0; i < teleports.length; i++) {
            if (player1.pos==teleports[i]){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Гравець 1 потрапив у телепорт!");
                alert.setHeaderText("Ви втрапили в телепорт!!!");
                alert.setContentText("Пане, " + player1.name+" Ви втрапили в телепорт "+
                        "Ви можете довіритися долі втративши 5% свого здоров'я та телепортуватися в невідомому напрямку " +
                        "або спробувати вибратися із телепорту втративши 20% свого здоров'я!");
                ButtonType buttonTypeOne = new ButtonType("Телепортуватися(-5% HP)");
                ButtonType buttonTypeTwo = new ButtonType("Тікати від телепорту(-20% HP)");

                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeOne){
                    player1.hp-=5;
                    teleportTo(player1);
                } else if (result.get() == buttonTypeTwo) {
                    player1.hp-=20;
                    player1.pos+=1;
                }
            }else if (player2.pos==teleports[i]) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Гравець 2 потрапив у телепорт!");
                alert.setHeaderText("Ви втрапили в телепорт!!!");
                alert.setContentText("Пане," + player2.name+"Ви втрапили в телепорт"+
                        "Ви можете довіритися долі втративши 5% свого здоров'я та телепортуватися в невідомому напрямку" +
                        "або спробувати вибратися із телепорту втративши 20% свого здоров'я!");
                ButtonType buttonTypeOne = new ButtonType("Телепортуватися(-5% HP)");
                ButtonType buttonTypeTwo = new ButtonType("Тікати від телепорту(-20% HP)");

                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeOne){
                    player2.hp-=5;
                    teleportTo(player1);
                } else if (result.get() == buttonTypeTwo) {
                    player2.hp-=20;
                    player2.pos+=1;
                }
            }
        }
    }

    public void setRandonTeleports(){
        for (int i = 0; i <teleports.length ; i++) {
            teleports[i]= Util.intRandom(2,scale*scale-2);
        }
        System.out.println(getTeleportsPosition());
    }

    public String getTeleportsPosition(){
        StringBuilder s = new StringBuilder("Teleports:\n");
        for (int i = 0; i <teleports.length ; i++) {
            s.append(teleports[i]).append(", ");
        }
        return s.toString();
    }

    public void fillGriedField(){
        this.field=new GridPane();
        this.field.setGridLinesVisible(true);
        this.field.setVgap(2);
        this.field.setHgap(1);

        int numOfBtn=1;
        int reverse=-1;
        for (int i = 0; i <scale ; i++) {
            reverse*=-1;
            for (int j = 0; j <scale ; j++) {
                if(reverse>0){
                    Button b = buttonFactory(numOfBtn);
                    field.add(b,j,i);
                    numOfBtn++;
                }else {
                    Button b = buttonFactory(numOfBtn);
                    field.add(b,scale-j-1,i);
                    numOfBtn++;
                }
            }
        }
    }

    public Button buttonFactory(int numOfBtn){
        Button button = new Button();
        if(numOfBtn==1){
            button.setText(String.valueOf(numOfBtn)+"\nStart Here");
            button.setStyle("-fx-background-color: #fff125; ");

        }else if(numOfBtn==scale*scale){
            button.setText(String.valueOf(numOfBtn)+"\nFinish Here");
            button.setStyle("-fx-background-color: #fff125; ");
        }else {
            for (int i = 0; i < teleports.length; i++) {
                if (numOfBtn==teleports[i]){
                    ImageView imageView = new ImageView(blue);
                    imageView.setFitWidth(btnSize-btnSize/2.5);
                    imageView.setFitHeight(btnSize-btnSize/2.5);
                    button.setText("");
                    button.setGraphic(imageView);
                    /*button= new Button("",imageView);*/
                }else {
                    button.setText(String.valueOf(numOfBtn));
                }
            }
            button.setStyle("-fx-background-color: #ccff99; ");
        }
        button.setPrefSize(btnSize+5,btnSize+5);

        button.setOnAction(event -> {
            button.setStyle("-fx-background-color: #ff1100; ");
        });
        return button;
    }


}

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class MainPanel {

    public int size;
    public Scene mainScene;
    public MyRightControlPanel rightController;
    public MyLeftControlPanel leftController;
    public MyGridField mainFieldl;

    public HBox mainH;
    public Player p1;
    public Player p2;


    public Button nextStepBtn;
    public Button cube;

    public MainPanel (int size){
        cube= new Button("0");
        cube.setPrefSize(60,60);
        this.size=size;
        ImageView firstPlayerIMG=new ImageView
                (new Image(getClass().getResourceAsStream("Sources\\char1\\char1AvatarGlass.png")));
        firstPlayerIMG.setFitHeight(150);
        firstPlayerIMG.setFitWidth(150);
        ImageView secondPlayerIMG=new ImageView
                (new Image(getClass().getResourceAsStream("Sources\\char2\\char2Avatar1.png")));
        secondPlayerIMG.setFitWidth(150);
        secondPlayerIMG.setFitHeight(150);

        this.p1=new Player(100, true,firstPlayerIMG);
        this.p2=new Player(100, false,secondPlayerIMG);
        this.rightController= new MyRightControlPanel();
        this.leftController=new MyLeftControlPanel(p1,p2);
        this.mainFieldl=new MyGridField(this.size,p1,p2);
        setNextStepBtn();

        leftController.mainVBox.getChildren().addAll(cube,nextStepBtn);
        mainH=new HBox();
        mainH.getChildren().addAll(leftController.mainVBox, mainFieldl.field,rightController.vBox);
        mainScene=new Scene(mainH);
    }


    public void setNextStepBtn(){
        this.nextStepBtn = new Button("Make a move...");
        nextStepBtn.setPrefSize(120,75);
        nextStepBtn.setStyle("-fx-background-color: #525252;"+
                "-fx-text-fill: aliceblue");
        nextStepBtn.setOnAction(event -> {
            makeMove();
            leftController.setPlayerButtons();
           /* leftController.mainVBox.getChildren().clear();
            leftController.mainVBox.getChildren().addAll(leftController.firstPlayer,leftController.secondPlayer,
                    leftController.moveGif,nextStepBtn);*/

        });
    }




    public void checkWinner(){

        if(p1.pos>=size*size){
            p1.pos=size*size;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Перший гравець: "+p1.name+" переміг!!!");
            alert.setHeaderText("Перемога першого гравця!");
            alert.showAndWait();
        }else if (p2.pos>size*size) {
            p2.pos=size*size;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Другий гравець: "+p2.name + " переміг!!!");
            alert.setHeaderText("Перемога другого гравця!");
            alert.showAndWait();
        }
    }



    public void makeMove(){
        checkWinner();

        int stepNum = 1+(int)(Math.random()*5);
        cube.setText(String.valueOf(stepNum));
        //System.out.println("move turn"+leftController.moveTurn);
        if(leftController.moveTurn==1){
            p1.pos+=stepNum;
            p1.isMoving=false;
            p2.isMoving=true;
            System.out.println(p1.pos);
            mainFieldl.setImgOnBtn(p1.pos,p1.img);
            //mainFieldl.goFromTo(p1,p1.pos+stepNum);
            leftController.moveTurn=2;
        }else {
            p2.pos+=stepNum;
            p2.isMoving=false;
            p1.isMoving=true;
            System.out.println(p2.pos);
            mainFieldl.setImgOnBtn(p2.pos,p2.img);
            //mainFieldl.goFromTo(p2,p2.pos+stepNum);
            leftController.moveTurn=1;
        }
        //mainFieldl.refresh();
        leftController.refrash();
        mainFieldl.checkTeleport();
        leftController.mainVBox.getChildren().addAll(cube,nextStepBtn);
    }
}

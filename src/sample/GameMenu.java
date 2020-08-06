package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GameMenu {

    public static Pane pauseMenu = new Pane();
    public static Rectangle backGround = new Rectangle(0,0, Constants.WIDTH, Constants.HEIGHT);


    public static void setScene(){
        backGround.setOpacity(0.3);
        pauseMenu.getChildren().add(backGround);
    }


}

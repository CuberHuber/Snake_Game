package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GameMenu {

    public static Pane pauseMenu = new Pane();
    public static Rectangle backGround = new Rectangle(0,0, Constants.WIDTH, Constants.HEIGHT);
    public static Button Exit = new Button();

    public static void setLanguage(){

    }
    public static void setScene(){
        backGround.setOpacity(0.3);
        Exit.setLayoutX(200);
        Exit.setLayoutY(200);
        Exit.setPrefSize(200, 38);
        Exit.setOnMousePressed(event ->{
            System.out.println("Кнопка выхода");
            GameMenu.pauseMenu.setVisible(false);
            Scenes.stage.setScene(Scenes.sceneMenu);
            Scenes.stage.show();
        });
        pauseMenu.getChildren().add(backGround);
        pauseMenu.getChildren().add(Exit);
        //pauseMenu.setVisible(false);
    }


}

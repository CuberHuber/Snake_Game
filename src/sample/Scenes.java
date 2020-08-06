package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scenes {

    public static Stage stage;
    public static Scene sceneMenu;

    public static void setScenes(Stage stage, Scene rootMenu){
        Scenes.stage = stage;
        Scenes.sceneMenu = rootMenu;
    }
}

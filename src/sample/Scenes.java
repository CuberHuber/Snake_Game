package sample;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class Scenes {

    public static Stage stage;
    public static Parent rootMenu;

    public static void setScenes(Stage stage, Parent rootMenu){
        Scenes.stage = stage;
        Scenes.rootMenu = rootMenu;
    }

}

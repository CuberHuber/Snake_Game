package sample;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment  ;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Localization.sethLanguage(0); // Указание языка по-Умолчанию; Русский

        primaryStage.setTitle("Пошел нахуй");
        //MenuItem newGame = new MenuItem("Играть");
        //MenuItem Options = new MenuItem("Настройки");
        //MenuItem exitGame = new MenuItem("Выход");
        //SubMenu mainMenu = new SubMenu(
        //        newGame, Options, exitGame
        //);
        //MenuBox menuBox = new MenuBox(mainMenu);

        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        primaryStage.setScene(new Scene(root, Constants.WIDTH, Constants.HEIGHT));
        Scenes.setScenes(primaryStage, root);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }

        });
        primaryStage.show();
        System.out.println("Ok");
    }

    private static class MenuBox extends Pane {
        static SubMenu subMenu;
        public MenuBox (SubMenu subMenu){
            MenuBox.subMenu = subMenu;
            setVisible(false);
            Rectangle bg = new Rectangle(600, 450, Color.RED);
            bg.setOpacity(0.0);

        }
        public void setSubMenu(SubMenu subMenu){
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);
        }
    }

    public static class MenuItem extends StackPane {
        public MenuItem(String name){
            Rectangle bg = new Rectangle(200, 20, Color.WHITE);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 16));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
            FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
            setOnMouseEntered(event ->{
                st.setFromValue(Color.DARKGRAY);
                st.setToValue(Color.DARKGOLDENROD);
                st.setCycleCount(Animation.INDEFINITE);
                st.setAutoReverse(true);
                st.play();
            });
            setOnMouseExited(event ->{
                st.stop();
                bg.setFill(Color.WHITE);
            });

        }
    }

    public static class SubMenu extends VBox{
        public SubMenu(MenuItem...items){
            setSpacing(15);
            setTranslateY(220);
            setTranslateX(198);
            for (MenuItem item : items){
                getChildren().addAll(item);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
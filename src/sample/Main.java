package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Localization.sethLanguage(0); // Указание языка по-Умолчанию; Русский

        primaryStage.setTitle("Snake");


        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));

        Scene scene = new Scene(root, Constants.WIDTH, Constants.HEIGHT);
        primaryStage.setScene(scene);
        Scenes.setScenes(primaryStage, scene);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }

        });
        primaryStage.initStyle(StageStyle.TRANSPARENT);   // Убирает внешний вид окна Windows. Без элементов управления           !!  После завершение проекта раскомментить
        primaryStage.show();
        System.out.println("Ok");
    }

//    private static class MenuBox extends Pane {
//        static SubMenu subMenu;
//        public MenuBox (SubMenu subMenu){
//            MenuBox.subMenu = subMenu;
//            setVisible(false);
//            Rectangle bg = new Rectangle(600, 450, Color.RED);
//            bg.setOpacity(0.0);
//
//        }
//        public void setSubMenu(SubMenu subMenu){
//            getChildren().remove(MenuBox.subMenu);
//            MenuBox.subMenu = subMenu;
//            getChildren().add(MenuBox.subMenu);
//        }
//    }
//
//    public static class MenuItem extends StackPane {
//        public MenuItem(String name){
//            Rectangle bg = new Rectangle(200, 20, Color.WHITE);
//            bg.setOpacity(0.5);
//
//            Text text = new Text(name);
//            text.setFill(Color.WHITE);
//            text.setFont(Font.font("Arial", FontWeight.BOLD, 16));
//
//            setAlignment(Pos.CENTER);
//            getChildren().addAll(bg, text);
//            FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
//            setOnMouseEntered(event ->{
//                st.setFromValue(Color.DARKGRAY);
//                st.setToValue(Color.DARKGOLDENROD);
//                st.setCycleCount(Animation.INDEFINITE);
//                st.setAutoReverse(true);
//                st.play();
//            });
//            setOnMouseExited(event ->{
//                st.stop();
//                bg.setFill(Color.WHITE);
//            });
//
//        }
//    }
//
//    public static class SubMenu extends VBox{
//        public SubMenu(MenuItem...items){
//            setSpacing(15);
//            setTranslateY(220);
//            setTranslateX(198);
//            for (MenuItem item : items){
//                getChildren().addAll(item);
//            }
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }
}

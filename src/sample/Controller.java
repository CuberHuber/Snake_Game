package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;


public class Controller {

    public static int x = 0;
    public static int y = 0;

    @FXML
    private VBox MainMenuVBox;

    @FXML
    private Button StartGameButton;

    @FXML
    private Button SettingsGameButton;

    @FXML
    private Button ExitGameButton;

    @FXML
    private VBox SettingsMenuVbox;

    @FXML
    private Button MenuSettingsLangs;

    @FXML
    private Button MenuSettingsExit;

    @FXML
    private VBox SettingsLangsVBox;

    @FXML
    private Button ChangeLangsOkButton;
    @FXML
    private ToggleButton LangsId0;

    @FXML
    private ToggleGroup langs;

    @FXML
    private ToggleButton LangsId1;


    @FXML
    public void initialize(){

        // Локализация
        setTextLanguages();

        // Параметры VBoxs
        // Основное меню
        MainMenuVBox.setLayoutX(Constants.Menu.Menu_LayoutX);
        MainMenuVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
        MainMenuVBox.setVisible(true);
        // Меню настроек
        SettingsMenuVbox.setLayoutX(Constants.Menu.Menu_LayoutX);
        SettingsMenuVbox.setLayoutY(Constants.Menu.Menu_LayoutY);
        SettingsMenuVbox.setVisible(false);


        //// Главное МЕНЮ
        // Кнопка Играть в главном меню
        StartGameButton.setText(Localization.Menu.Main.Start[Localization.IndexLangs]);
        Constants.Menu.setAnimationButton(StartGameButton);
        StartGameButton.setOnMousePressed(event->{
            SnakeGame.start();
        });

        // Кнопка настроек
        SettingsGameButton.setText(Localization.Menu.Main.Settings[Localization.IndexLangs]);
        Constants.Menu.setAnimationButton(SettingsGameButton);
        SettingsGameButton.setOnMousePressed(event ->{
            SettingsMenuVbox.setVisible(true);
            MainMenuVBox.setVisible(false);
        });


        // Кнопка выхода
        ExitGameButton.setText(Localization.Menu.Main.Exit[Localization.IndexLangs]);
        Constants.Menu.setAnimationButton(ExitGameButton);
        ExitGameButton.setOnMousePressed(event ->{
            System.exit(0);
        });


        //// НАСТРОЙКИ
        // Кнопка выхода из настроек
        Constants.Menu.setAnimationButton(MenuSettingsExit);
        MenuSettingsExit.setOnMousePressed(event ->{
            SettingsMenuVbox.setVisible(false);
            MainMenuVBox.setVisible(true);
            SettingsLangsVBox.setVisible(false);
        });

        // Кнопка Смены Языка
        Constants.Menu.setAnimationButton(MenuSettingsLangs); // Настройка анимации
        MenuSettingsLangs.setOnMousePressed(event ->{
            SettingsLangsVBox.setVisible(true);
            SettingsLangsVBox.setLayoutX(Constants.Menu.Menu_LayoutX+Constants.Menu.Menu_Pref_Width + 5);
            SettingsLangsVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
            //langsId[Localization.IndexLangs].setSelected(true);
//            SettingsMenuVbox.setVisible(false);
        });

        //// ВЫБОР ЯЗЫКА
        SettingsLangsVBox.setVisible(false);
        // Кнопка Выхода из меню выбора языка
        Constants.Menu.setAnimationButton(ChangeLangsOkButton);

        ChangeLangsOkButton.setOnMousePressed(event->{
            setTextLanguages();
            SettingsLangsVBox.setVisible(false);
            SettingsMenuVbox.setVisible(true);
        });



        //
        if (Localization.IndexLangs == 0) {

        }
        LangsId0.setOnMousePressed(event ->{      /// 0 - РУС
            Localization.sethLanguage(0);
            setTextLanguages();
        });
        LangsId1.setOnMousePressed(event ->{      /// 1 - Eng
            Localization.sethLanguage(1);
            setTextLanguages();
        });
    }



    public void setTextLanguages(){
        // МЕНЮ

        StartGameButton.setText(Localization.Menu.Main.Start[Localization.IndexLangs]);

        SettingsGameButton.setText(Localization.Menu.Main.Settings[Localization.IndexLangs]);

        ExitGameButton.setText(Localization.Menu.Main.Exit[Localization.IndexLangs]);



        MenuSettingsLangs.setText(Localization.Menu.Settings.language[Localization.IndexLangs]);

        MenuSettingsExit.setText(Localization.Menu.Settings.Close[Localization.IndexLangs]);



        ChangeLangsOkButton.setText(Localization.Menu.Settings.languagesExit[Localization.IndexLangs]);
    }
}

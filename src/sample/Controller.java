package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


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
    private Button MenuSettingsDifficulty;

    @FXML
    private Button MenuSettingsMode;

    @FXML
    private Button MenuSettingsExit;

    @FXML
    private VBox SettingsLangsVBox;

    @FXML
    private ToggleButton LangsId0;

    @FXML
    private ToggleGroup langs;

    @FXML
    private ToggleButton LangsId1;

    @FXML
    private HBox MainMenuVersionHBox;

    @FXML
    private Text GameVersionText;

    @FXML
    private VBox SettingsDifficultyVBox;

    @FXML
    private ToggleButton DifficultyEasy;

    @FXML
    private ToggleButton DifficultyNormal;

    @FXML
    private ToggleButton DifficultyHard;

    @FXML
    private ToggleButton DifficultyImpossible;

    @FXML
    private ToggleGroup Difficulty;


    @FXML
    public void initialize(){

        // Локализация
        setTextLanguages();


        // Версия игры
        GameVersionText.setText(Localization.GameVersion[Localization.IndexLangs] + " " + Constants.PROGRAM_VERSION);

        // Параметры VBoxs
        // Основное меню
        MainMenuVBox.setLayoutX(Constants.Menu.Menu_LayoutX);
        MainMenuVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
        MainMenuVBox.setVisible(true);
        // Меню настроек
        SettingsMenuVbox.setLayoutX(Constants.Menu.Menu_LayoutX);
        SettingsMenuVbox.setLayoutY(Constants.Menu.Menu_LayoutY);
        SettingsMenuVbox.setVisible(false);
        SettingsDifficultyVBox.setVisible(false);


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
            SettingsDifficultyVBox.setVisible(false);
        });


            //// ВЫБОР СЛОЖНОСТИ
        SettingsDifficultyVBox.setVisible(false);
        /// Кнопка выбора сложности игры
        Constants.Menu.setAnimationButton(MenuSettingsDifficulty); // Настройка анимации

        MenuSettingsDifficulty.setOnMousePressed(event ->{
            SettingsDifficultyVBox.setVisible(true);
            SettingsLangsVBox.setVisible(false);
            SettingsDifficultyVBox.setLayoutX(Constants.Menu.Menu_LayoutX+Constants.Menu.Menu_Pref_Width + 5);
            SettingsDifficultyVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
            //SettingsMenuVbox.setVisible(true);
        });


            // Группа

            // Выход из выбора языка
//        Constants.Menu.setAnimationButton(ChangeDifficultyOkButton);
//        ChangeDifficultyOkButton.setOnMousePressed(event -> {
//            SettingsDifficultyVBox.setVisible(false);
//            SettingsMenuVbox.setVisible(true);
//        });

            // Переключение сложности
        if (Constants.GameMode.Difficulty.indexDifficulty == 0){

        }
        DifficultyEasy.setOnMousePressed(event ->{
             Constants.GameMode.Difficulty.indexDifficulty = 0;
             System.out.println("Включена легкая сложность");
        });
        DifficultyNormal.setOnMousePressed(event ->{
            Constants.GameMode.Difficulty.indexDifficulty = 1;
            System.out.println("Включена нормальная сложность");
        });
        DifficultyHard.setOnMousePressed(event ->{
            Constants.GameMode.Difficulty.indexDifficulty = 2;
            System.out.println("Включена сложная сложность");
        });
        DifficultyImpossible.setOnMousePressed(event ->{
            Constants.GameMode.Difficulty.indexDifficulty = 3;
            System.out.println("Включена невероятная сложность");
        });

        // Кнопка выбора режима игры
        Constants.Menu.setAnimationButton(MenuSettingsMode); // Настройка анимации


        // Кнопка Смены Языка
        Constants.Menu.setAnimationButton(MenuSettingsLangs); // Настройка анимации
        MenuSettingsLangs.setOnMousePressed(event ->{
            SettingsLangsVBox.setVisible(true);
            SettingsDifficultyVBox.setVisible(false);
            SettingsLangsVBox.setLayoutX(Constants.Menu.Menu_LayoutX+Constants.Menu.Menu_Pref_Width + 5);
            SettingsLangsVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
            //langsId[Localization.IndexLangs].setSelected(true);
//            SettingsMenuVbox.setVisible(false);
        });

        //// ВЫБОР ЯЗЫКА
        SettingsLangsVBox.setVisible(false);
        // Кнопка Выхода из меню выбора языка
//        Constants.Menu.setAnimationButton(ChangeLangsOkButton);
//
//        ChangeLangsOkButton.setOnMousePressed(event->{
//            setTextLanguages();
//            SettingsDifficultyVBox.setVisible(false);
//            SettingsLangsVBox.setVisible(false);
//            SettingsMenuVbox.setVisible(true);
//        });



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

        // главное меню
        StartGameButton.setText(Localization.Menu.Main.Start[Localization.IndexLangs]);

        SettingsGameButton.setText(Localization.Menu.Main.Settings[Localization.IndexLangs]);

        ExitGameButton.setText(Localization.Menu.Main.Exit[Localization.IndexLangs]);


        // Настройки
        MenuSettingsLangs.setText(Localization.Menu.Settings.language.language[Localization.IndexLangs]);


        MenuSettingsDifficulty.setText(Localization.Menu.Settings.Difficulty.Difficulty[Localization.IndexLangs]);
        DifficultyEasy.setText(Localization.Menu.Settings.Difficulty.Easy[Localization.IndexLangs]);
        DifficultyNormal.setText(Localization.Menu.Settings.Difficulty.Normal[Localization.IndexLangs]);
        DifficultyHard.setText(Localization.Menu.Settings.Difficulty.Hard[Localization.IndexLangs]);
        DifficultyImpossible.setText(Localization.Menu.Settings.Difficulty.Impossible[Localization.IndexLangs]);
//        ChangeDifficultyOkButton.setText(Localization.Menu.Settings.Difficulty.Exit[Localization.IndexLangs]);

        MenuSettingsMode.setText(Localization.Menu.Settings.Mode.mode[Localization.IndexLangs]);

        MenuSettingsExit.setText(Localization.Menu.Settings.Close[Localization.IndexLangs]);



//        ChangeLangsOkButton.setText(Localization.Menu.Settings.language.languagesExit[Localization.IndexLangs]);
    }

    public void setDifficulty() {

    }
    public void setMode() {

    }
}

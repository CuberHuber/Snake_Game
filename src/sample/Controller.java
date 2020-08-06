package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private ToggleGroup Difficulty;

    @FXML
    private ToggleButton DifficultyNormal;

    @FXML
    private ToggleButton DifficultyHard;

    @FXML
    private ToggleButton DifficultyImpossible;

    @FXML
    private Pane SettingsModePane;

    @FXML
    private CheckBox ModeIsWallsButton;

    @FXML
    private CheckBox ModeIsAccelButton;


    @FXML
    public void initialize(){

        // Локализация
        setTextLanguages();

        // Версия игры
        GameVersionText.setText(Localization.GameVersion[Localization.IndexLangs] + " " + Constants.PROGRAM_VERSION);



            //// ПАРАМЕТРЫ КОНТЕЙНЕРОВ ПОДМЕНЮ
        // Основное меню
        MainMenuVBox.setLayoutX(Constants.Menu.Menu_LayoutX);
        MainMenuVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
        MainMenuVBox.setVisible(true);
        // Меню настроек
        SettingsMenuVbox.setLayoutX(Constants.Menu.Menu_LayoutX);
        SettingsMenuVbox.setLayoutY(Constants.Menu.Menu_LayoutY);
        SettingsMenuVbox.setVisible(false);
        SettingsLangsVBox.setVisible(false);
        SettingsDifficultyVBox.setVisible(false);
        SettingsModePane.setVisible(false);



            //// ГЛАВНОЕ МЕНЮ
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
        /// Кнопка Смены Языка
        Constants.Menu.setAnimationButton(MenuSettingsLangs); // Настройка анимации
        MenuSettingsLangs.setOnMousePressed(event ->{
            // настройка подменюшек
            setLanguage(LangsId0, LangsId1, Localization.IndexLangs);
            // Начальная позиция
            SettingsLangsVBox.setLayoutX(Constants.Menu.Menu_LayoutX+Constants.Menu.Menu_Pref_Width + 5);
            SettingsLangsVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
            // отображение подменю
            SettingsLangsVBox.setVisible(true);
            // Скрытие подменюшек
            SettingsDifficultyVBox.setVisible(false);
            SettingsModePane.setVisible(false);
        });
        /// Кнопка выбора сложности игры
        Constants.Menu.setAnimationButton(MenuSettingsDifficulty); // Настройка анимации
        MenuSettingsDifficulty.setOnMousePressed(event ->{
            // настройка подменюшек
            setDifficulty(DifficultyEasy, DifficultyNormal, DifficultyHard, DifficultyImpossible, Constants.GameMode.Difficulty.indexDifficulty);
            // Начальная позиция
            SettingsDifficultyVBox.setLayoutX(Constants.Menu.Menu_LayoutX+Constants.Menu.Menu_Pref_Width + 5);
            SettingsDifficultyVBox.setLayoutY(Constants.Menu.Menu_LayoutY);
            // отображение подменю
            SettingsDifficultyVBox.setVisible(true);
            // Скрытие подменюшек
            SettingsLangsVBox.setVisible(false);
            SettingsModePane.setVisible(false);
        });
        /// Кнопка выбора режима игры
        Constants.Menu.setAnimationButton(MenuSettingsMode); // Настройка анимации
        MenuSettingsMode.setOnMousePressed(event ->{
            // настройка подменюшек
            setMode(ModeIsWallsButton, ModeIsAccelButton);
            // Начальная позиция
            SettingsModePane.setLayoutX(Constants.Menu.Menu_LayoutX+Constants.Menu.Menu_Pref_Width + 5);
            SettingsModePane.setLayoutY(Constants.Menu.Menu_LayoutY);
            // отображение подменю
            SettingsModePane.setVisible(true);
            // Скрытие подменюшек
            SettingsLangsVBox.setVisible(false);
            SettingsDifficultyVBox.setVisible(false);
        });


        /// Кнопка выхода из настроек
        Constants.Menu.setAnimationButton(MenuSettingsExit);
        MenuSettingsExit.setOnMousePressed(event ->{
            // отображение подменю
            MainMenuVBox.setVisible(true);
            // Скрытие подменюшек
            SettingsMenuVbox.setVisible(false);
            SettingsLangsVBox.setVisible(false);
            SettingsDifficultyVBox.setVisible(false);
            SettingsModePane.setVisible(false);
        });




            //// ВЫБОР ЯЗЫКА
        LangsId0.setOnMousePressed(event ->{      /// 0 - РУС
            Localization.sethLanguage(0);
            setLanguage(LangsId0, LangsId1, Localization.IndexLangs);
            setTextLanguages();
        });
        LangsId1.setOnMousePressed(event ->{      /// 1 - Eng
            Localization.sethLanguage(1);
            setLanguage(LangsId0, LangsId1, Localization.IndexLangs);
            setTextLanguages();
        });



            //// ВЫБОР СЛОЖНОСТИ
        // Переключение сложности
        DifficultyEasy.setOnMousePressed(event ->{
             Constants.GameMode.Difficulty.indexDifficulty = 0;
             setDifficulty(DifficultyEasy, DifficultyNormal, DifficultyHard, DifficultyImpossible, Constants.GameMode.Difficulty.indexDifficulty);
        });
        DifficultyNormal.setOnMousePressed(event ->{
            Constants.GameMode.Difficulty.indexDifficulty = 1;
            setDifficulty(DifficultyEasy, DifficultyNormal, DifficultyHard, DifficultyImpossible, Constants.GameMode.Difficulty.indexDifficulty);
        });
        DifficultyHard.setOnMousePressed(event ->{
            Constants.GameMode.Difficulty.indexDifficulty = 2;
            setDifficulty(DifficultyEasy, DifficultyNormal, DifficultyHard, DifficultyImpossible, Constants.GameMode.Difficulty.indexDifficulty);
        });
        DifficultyImpossible.setOnMousePressed(event ->{
            Constants.GameMode.Difficulty.indexDifficulty = 3;
            setDifficulty(DifficultyEasy, DifficultyNormal, DifficultyHard, DifficultyImpossible, Constants.GameMode.Difficulty.indexDifficulty);
        });


            //// РЕЖИМЫ ИГРЫ
        // переключение режима
        ModeIsWallsButton.setOnAction(event ->{
            Constants.GameMode.isWalls = ModeIsWallsButton.isSelected();
            setMode(ModeIsWallsButton, ModeIsAccelButton);
        });
        ModeIsAccelButton.setOnAction(event ->{
            Constants.GameMode.changeSpeed = ModeIsAccelButton.isSelected();
            setMode(ModeIsWallsButton, ModeIsAccelButton);
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


        MenuSettingsMode.setText(Localization.Menu.Settings.Mode.mode[Localization.IndexLangs]);

        MenuSettingsExit.setText(Localization.Menu.Settings.Close[Localization.IndexLangs]);
    }

    public void setLanguage(ToggleButton rus, ToggleButton eng, int b){
        rus.setStyle(Constants.GameMode.styleOff);
        rus.setTextFill(Constants.GameMode.fillOff);
        eng.setStyle(Constants.GameMode.styleOff);
        eng.setTextFill(Constants.GameMode.fillOff);
        switch (b){
            case 0:
                rus.setStyle(Constants.GameMode.styleOn);
                rus.setTextFill(Constants.GameMode.fillOn);
                break;
            case 1:
                eng.setStyle(Constants.GameMode.styleOn);
                eng.setTextFill(Constants.GameMode.fillOn);
                break;
        }
    }

    public void setDifficulty(ToggleButton tE, ToggleButton tN, ToggleButton tH, ToggleButton tI, int b) {
        tE.setStyle(Constants.GameMode.styleOff);
        tE.setTextFill(Constants.GameMode.fillOff);
        tN.setStyle(Constants.GameMode.styleOff);
        tN.setTextFill(Constants.GameMode.fillOff);
        tH.setStyle(Constants.GameMode.styleOff);
        tH.setTextFill(Constants.GameMode.fillOff);
        tI.setStyle(Constants.GameMode.styleOff);
        tI.setTextFill(Constants.GameMode.fillOff);
        switch(b){
            case 0:
                tE.setStyle(Constants.GameMode.styleOn);
                tE.setTextFill(Constants.GameMode.fillOn);
                break;
            case 1:
                tN.setStyle(Constants.GameMode.styleOn);
                tN.setTextFill(Constants.GameMode.fillOn);
                break;
            case 2:
                tH.setStyle(Constants.GameMode.styleOn);
                tH.setTextFill(Constants.GameMode.fillOn);
                break;
            case 3:
                tI.setStyle(Constants.GameMode.styleOn);
                tI.setTextFill(Constants.GameMode.fillOn);
                break;
        }
    }

    public void setMode(CheckBox chW, CheckBox chA) {
        chW.setSelected(Constants.GameMode.isWalls);
        chA.setSelected(Constants.GameMode.changeSpeed);
    }
}

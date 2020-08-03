package sample;

public class Localization {


    public static String[] language = {"Русский", "English"};
    public static int IndexLangs;   // Индекс языка
            //  Рус - 0 ;   Eng - 1 ;


    public static String[] Title = {"Змейка", "Snake"};
    public static class Menu{
        public static class Main {
            public static String[] Start = {"Играть", "Play"};
            public static String[] Settings = {"Настройки", "Settings"};
            public static String[] Exit = {"Выход", "Exit"};
        }
        public static class Settings{
            public static String[] language = {"Язык", "Language"};
            public static String[] languagesExit = {"Готово", "OK"};
            public static String[] Close = {"Закрыть", "Close"};
        }
    }

    public static class Game{
        public static String[] Score = {"Счет", "Score"};
        public static String[] GameOver = {"     ИГРА\nОКОНЧЕНА", "GAME OVER"};
        public static int[][] LayoutGameOver = {{70, 200}, {65, 210}};
    }



    public static void sethLanguage(int IndexLang){
        IndexLangs = IndexLang;
    }
}

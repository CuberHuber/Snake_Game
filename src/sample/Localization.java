package sample;

public class Localization {


    public static String[] language = {"Русский", "English"};
    public static int IndexLangs;   // Индекс языка
            //  Рус - 0 ;   Eng - 1 ;


    // Тексты окна
    public static String[] Title = {"Змейка", "Snake"};
    public static String[] GameVersion = {"версия:", "version:"};

    // Меню
    public static class Menu{
        public static class Main {
            public static String[] Start = {"Играть", "Play"};
            public static String[] Settings = {"Настройки", "Settings"};
            public static String[] Exit = {"Выход", "Exit"};
        }
        public static class Settings{
            public static class language {
                public static String[] language = {"Язык", "Language"};
                public static String[] languagesExit = {"Готово", "OK"};
            }
            public static class Difficulty {
                public static String[] Difficulty = {"Сложность", "Difficulty"};
                public static String[] Easy = {"Легко", "Easy"};
                public static String[] Normal = {"Нормально", "Normal"};
                public static String[] Hard = {"Сложно", "Hard"};
                public static String[] Impossible = {"Невозможно", "Impossible"};
                public static String[] Exit = {"Готово", "OK"};
            }
            public static class Mode {
                public static String[] mode = {"Режим игры", "Mode"};

            }
            public static String[] Close = {"Закрыть", "Close"};
        }
    }

    // Игра
    public static class Game{
        public static String[] Score = {"Счет", "Score"};
        public static String[] GameOver = {"     ИГРА\nОКОНЧЕНА", "GAME OVER"};
        public static int[][] LayoutGameOver = {{70, 200}, {65, 210}};
    }



    // Установка языка
    public static void sethLanguage(int IndexLang){
        IndexLangs = IndexLang;
    }
}

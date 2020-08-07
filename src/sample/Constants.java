package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Constants {

    // Версия игры
    public static final String PROGRAM_VERSION = "0.8.3 beta";    //         !!!  После каждого значительного именения, повышать версию



    // Размеры окна
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public static class Menu {
        public static final int Menu_LayoutX = 190;
        public static final int Menu_LayoutY = 195;
        public static final int Menu_Pref_Width = 220;
        public static final int Menu_Pref_Height = 38;
        public static final int Menu_Pref_Spacing = 16;


        public static void setAnimationButton(Button but){
            but.setOnMouseEntered(event -> {
                but.setStyle("-fx-background-color: #fdfdfd");
                but.setTextFill(Color.BLACK);
            });
            but.setOnMouseExited(event->{
                but.setStyle("-fx-background-color: #afafaf");
                but.setTextFill(Color.WHITE);

            });
        }
    }

        //  Режимы ИГРЫ
    public static class GameMode {

        public static class Difficulty{
            private static int easySpeed = 5;
            private static int middleSpeed = 8;
            private static int highSpeed = 11;
            private static int impossibleSpeed = 16;

            public static int[] speed = {easySpeed, middleSpeed, highSpeed, impossibleSpeed}; // Массив уровней / скоростей

            public static int indexDifficulty = 1; // Уровень средний по-умолчанию

        }

            // #e7c23e  золотой цвет

            // Изменени скорости после каждой съеденной еды
        public static boolean changeSpeed = true;

        // Наличие стен.   или телепортов по краям карты
            // По-умолчанию стен нет
        public static boolean isWalls = false;

        public static String styleOn = "-fx-background-color: #e7c23e;";
        public static Color fillOn = Color.BLACK;
        public static String styleOff = "-fx-background-color: #afafaf;";
        public static Color fillOff = Color.WHITE;
    }



        //// ПАРАМЕТРЫ ТАЙМЕРА ПЕРЕД НАЧАЛОМ ИГРЫ
    public static class BeginGameTimer{
        public static final int BEGIN_MAX_VALUE = 3;

        public static class Text{
            public static double size = 100;     // размер
            public static String font = "";
            public static Color colorT = Color.RED;
            public static int LayoutX = 175;
            public static int LayoutY = 250;
        }
    }

        ////   ИГРОВОЕ ПОЛЕ
    public static class Field {

        // Характеристики поля
        public static final int FIELD_WIDTH = 400; // Ширина игрового поля
        public static final int FIELD_HEIGHT = 400; // Высота игрового поля
        public static final int START_WIDTH = 100; // Отступ слева, для зоны с выводом информации
        public static final int START_HEIGHT = 40; // Отступ сверху, для зоны с выводом информации

        public static int EndFieldX = FIELD_WIDTH + START_WIDTH;
        public static int EndFieldY = FIELD_HEIGHT + START_HEIGHT;
        public static int width = 16; // ширина единицы поля. (Клетка)
        public static int height = 16; // высота единицы поля. (Клетка)
        public static int corner_size = 25; // сторона квадрата поля. количество клеток

        // Допилить выбор начальной скорости. аля уровень сложности       !!!!
        //public static int speed = GameMode.Complexity.speed[]; // скорость змейки. Таймер

        //

        // Еда
        public static int food_color = 0;// Цвет еды.          !!! Добавить функцию по рандомносу цвету еды
        public static int foodX = 0; // x координата еды
        public static int foodY = 0; // y координата еды


        // Движение и координаты
        public static List<Corner> snake = new ArrayList<>();// Список координат змейки
        public static Dir direction = Dir.right; // Объединение направления движения


        // Рандом
        public static Random rand = new Random(); // Рандом


        // Условие конца игры
        public static boolean gameOver = false; // Показатель конца игры


    }
    // Объединение
    public enum Dir {
        left, right, up, down
    }

    //
    public static class Corner {
        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}

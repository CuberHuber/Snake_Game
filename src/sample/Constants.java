package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Constants {
    // Размеры окна
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public static class Menu {
        public static final int Menu_LayoutX = 190;
        public static final int Menu_LayoutY = 195;
        public static final int Menu_Pref_Width = 220;

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
        public static int speed = 5; // скорость змейки. Таймер

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

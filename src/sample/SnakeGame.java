package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import static sample.Constants.Field.rand;

public class SnakeGame {



    public static GraphicsContext GameGraphCont;

    // Анимация
    protected static long lasttick = 40;
    protected static boolean endGameColor = false;


    public static void start(){
        newfood(); // Функция выбора положения еды на поле

        VBox root = new VBox();
        Canvas c = new Canvas(Constants.Field.FIELD_WIDTH, Constants.Field.EndFieldY);
//        c.setLayoutX(Constants.Field.START_WIDTH);
//        c.setLayoutY(Constants.Field.START_HEIGHT);
        GraphicsContext gc = c.getGraphicsContext2D();
        GameGraphCont = gc;
        root.getChildren().add(c);
        root.setLayoutX(Constants.Field.START_WIDTH);
        root.setLayoutY(Constants.Field.START_HEIGHT);


        AnimationTimer asd = new AnimationTimer() {
            long lasttick = 0;

            public void handle(long now) {
                if (lasttick == 0) {
                    lasttick = now;
                    tick(gc);
                    return;
                }
                if (now - lasttick > 1000000000 / Constants.Field.speed) {
                    lasttick = now;
                    tick(gc);
                }
            }
        };
        asd.start();
        Scene scene1 = new Scene(root, Constants.WIDTH, Constants.HEIGHT);

        // Control
        scene1.addEventFilter(KeyEvent.KEY_PRESSED, key ->{
            if (key.getCode() == KeyCode.UP && Constants.Field.direction != Constants.Dir.down){
                Constants.Field.direction = Constants.Dir.up;
            }
            if (key.getCode() == KeyCode.LEFT && Constants.Field.direction != Constants.Dir.right){
                Constants.Field.direction = Constants.Dir.left;
            }
            if (key.getCode() == KeyCode.DOWN && Constants.Field.direction != Constants.Dir.up){
                Constants.Field.direction = Constants.Dir.down;
            }
            if (key.getCode() == KeyCode.RIGHT && Constants.Field.direction != Constants.Dir.left){
                Constants.Field.direction = Constants.Dir.right;
            }
            if (key.getCode() == KeyCode.ENTER){
                asd.stop();
            }
            if (key.getCode() == KeyCode.ESCAPE){
                asd.start();
            }
        });
        // Add start snake parts
        Constants.Field.snake.add(new Constants.Corner(Constants.Field.corner_size /2, Constants.Field.corner_size /2 + Constants.Field.START_HEIGHT));
        Constants.Field.snake.add(new Constants.Corner(Constants.Field.corner_size / 2, Constants.Field.corner_size /2 + Constants.Field.START_HEIGHT));
        Constants.Field.snake.add(new Constants.Corner(Constants.Field.corner_size / 2, Constants.Field.corner_size /2 + Constants.Field.START_HEIGHT));

        // Create scene
        Scenes.stage.setScene(scene1);
        Scenes.stage.setTitle("Змея");
        Scenes.stage.show();
    }

    // food
    private static void newfood() {
        start: while (true) {
            Constants.Field.foodX = rand.nextInt(Constants.Field.corner_size);
            Constants.Field.foodY = rand.nextInt(Constants.Field.corner_size);

            for (Constants.Corner c : Constants.Field.snake) {
                if (c.x == Constants.Field.foodX && c.y == Constants.Field.foodY) {
                    continue start;
                }
            }
            Constants.Field.food_color = rand.nextInt(5);
            Constants.Field.speed++;
            break;

        }
    }

    // Animator for scene from endgame
    protected static AnimationTimer anim = new AnimationTimer(){
        @Override
        public void handle(long now){
            endGameScene(GameGraphCont);
        }
    };


    public static void endGameScene(GraphicsContext gc){

        if (lasttick > 0){
            if (endGameColor) {
                gc.setFill(Color.RED);
                gc.setFont(new Font("", 50));
                gc.fillText(Localization.Game.GameOver[Localization.IndexLangs], Localization.Game.LayoutGameOver[Localization.IndexLangs][0], Localization.Game.LayoutGameOver[Localization.IndexLangs][1]);
                endGameColor = false;
            }else {
                gc.setFill(Color.WHITE);
                gc.setFont(new Font("", 50));
                gc.fillText(Localization.Game.GameOver[Localization.IndexLangs], Localization.Game.LayoutGameOver[Localization.IndexLangs][0], Localization.Game.LayoutGameOver[Localization.IndexLangs][1]);
                endGameColor = true;
            }
            lasttick--;
        }
        else{
            anim.stop();
        }
    }

    public static void tick(GraphicsContext gc){

        // Условие конца игры
        if (Constants.Field.gameOver){
            anim.start();
            return;
        }


        // Изменение координат змейки
        for (int i = Constants.Field.snake.size() -1; i > 0; i--) {
            Constants.Field.snake.get(i).x = Constants.Field.snake.get(i - 1).x;
            Constants.Field.snake.get(i).y = Constants.Field.snake.get(i - 1).y;
        }

        // Передвижение головы змеи
        switch (Constants.Field.direction){
            case up:
                Constants.Field.snake.get(0).y--;

                break;
            case down:
                Constants.Field.snake.get(0).y++;

                break;
            case left:
                Constants.Field.snake.get(0).x--;

                break;
            case right:
                Constants.Field.snake.get(0).x++;

                break;
        }




        // eat food
        // Когда голова змеи ест еду, добовляется хвост змеи и вызывается функция отрисовки новой еды
        if (Constants.Field.foodX == Constants.Field.snake.get(0).x && Constants.Field.foodY == Constants.Field.snake.get(0).y){
            Constants.Field.snake.add(new Constants.Corner(-10, -10));
            newfood();
        }

        // self destroy ..  Условия уничтожения змеи
        for ( int i = 1; i < Constants.Field.snake.size(); i++){
            if (Constants.Field.snake.get(0).x == Constants.Field.snake.get(i).x && Constants.Field.snake.get(0).y == Constants.Field.snake.get(i).y){
                Constants.Field.gameOver = true;
            }
        }

        // fill
        // background
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, Constants.Field.FIELD_WIDTH, Constants.Field.FIELD_HEIGHT);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, Constants.Field.START_HEIGHT, Constants.Field.FIELD_WIDTH, Constants.Field.FIELD_HEIGHT);

        // score
        gc.setFill(Color.CHOCOLATE);
        gc.setFont(new Font("", 30));
        gc.fillText(Localization.Game.Score[Localization.IndexLangs]+ ": " + (Constants.Field.speed - 6), Constants.Field.START_WIDTH+10, 30);

        // eat
        gc.setFill(Color.PURPLE);
        gc.fillOval(Constants.Field.foodX * Constants.Field.width, Constants.Field.foodY * Constants.Field.height + Constants.Field.START_HEIGHT, Constants.Field.width, Constants.Field.height);

        // Snake

        // check collision
        // Если змея доходит до края, то появляется в другом конце карты
        if (Constants.Field.snake.get(0).y < 0){
            Constants.Field.snake.get(0).y = Constants.Field.corner_size-1;
        }
        if (Constants.Field.snake.get(0).y > Constants.Field.corner_size -1){
            Constants.Field.snake.get(0).y = 0;
        }
        if (Constants.Field.snake.get(0).x < 0){
            Constants.Field.snake.get(0).x = Constants.Field.corner_size-1;
        }
        if (Constants.Field.snake.get(0).x > Constants.Field.corner_size -1){
            Constants.Field.snake.get(0).x = 0;
        }
        for (Constants.Corner c: Constants.Field.snake){
            gc.setFill(Color.LIGHTGREEN);
            gc.fillRect(c.x * Constants.Field.width, c.y * Constants.Field.height + Constants.Field.START_HEIGHT, Constants.Field.width - 1, Constants.Field.height - 1);
            gc.setFill(Color.GREEN);
            gc.fillRect(c.x * Constants.Field.width, c.y * Constants.Field.height + Constants.Field.START_HEIGHT, Constants.Field.width - 2, Constants.Field.height - 2);
        }
    }
}
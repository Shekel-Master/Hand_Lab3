import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
 * @author : Dylan Hand
 * Date : 03/15/2024
 * 
 * Displays a circle that is black when mouse is clicked, white when released, and will 
 * move according to arrow keys
 */

public class Main extends Application
{
    @Override
    public void start (Stage primaryStage)
    {
        //Create UI
        Pane pane = new Pane();
        Circle circle = new Circle(100, 100, 50);
        pane.getChildren().add(circle);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        circle.setOnMousePressed(e->circle.setFill(Color.BLACK));
        circle.setOnMouseReleased(e->circle.setFill(Color.WHITE));

        circle.setFocusTraversable(true);

        circle.setOnKeyPressed(e-> { //lambda expression for moving the circle around using arrow keys
            switch (e.getCode()) {
                case DOWN:
                    circle.setCenterY(circle.getCenterY() + 2);
                    break;
                case UP:
                    circle.setCenterY(circle.getCenterY() - 2);
                    break;
                case LEFT:
                    circle.setCenterX(circle.getCenterX() - 2);
                    break;
                case RIGHT:
                    circle.setCenterX(circle.getCenterX() + 2);
                    break;
            }
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle ("Hand Lab 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    

}

// 6.3 Displays the canvas and pet image, handles mouse input, and resizes with the window.
package view;

import controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


 // Displays the canvas and pet image, handles mouse input, and resizes with the window.

public class PetView extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private Image petImage;

    @Override
    public void init() {
        controller = new PetController(this);
    }

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(600, 400);
        gc = canvas.getGraphicsContext2D();

        petImage = new Image(getClass().getResourceAsStream("/cat.png"));

        // Mouse events
        canvas.setOnMouseMoved(event -> controller.setTarget(event.getX(), event.getY()));
        canvas.setOnMouseExited(event -> controller.clearTarget());

        // Scene with resizable canvas
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 600, 400);

        // Resize canvas when window resizes
        scene.widthProperty().addListener((obs, oldVal, newVal) -> canvas.setWidth(newVal.doubleValue()));
        scene.heightProperty().addListener((obs, oldVal, newVal) -> canvas.setHeight(newVal.doubleValue()));

        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Stop background loop when app exits
        controller.stopLoop();
    }

    public void updateCanvas(double petX, double petY, double petSize) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(petImage,
                petX - petSize / 2, petY - petSize / 2,
                petSize, petSize);
    }

    public double getCanvasWidth() {
        return canvas.getWidth();
    }

    public double getCanvasHeight() {
        return canvas.getHeight();
    }
}

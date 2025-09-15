import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class a extends Application {
    @Override
    public void start(Stage stage) {
        Button btn = new Button("Hello JavaFX!");
        Scene scene = new Scene(btn, 300, 200);
        stage.setTitle("My First JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // 启动 JavaFX 应用
    }
}

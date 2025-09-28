package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


 //Main class to launch the Notebook application.
public class NotebookApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file created in SceneBuilder
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/notebook_view.fxml"));
        Parent root = loader.load();

        // Set up the stage (window)
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Notebook App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}

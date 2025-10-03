/* 6.4 Notebook Application
 Create a simple JavaFX application that allows users to create, view, and delete notes.
 Each note should have a title and content. Use a ListView to display the list of notes and a TextArea for the content.
 Implement functionality to add new notes, view existing notes, and delete notes.
*/

package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;  //FXMLLoader 的作用：把 FXML 文件 → 转换成 JavaFX 界面对象（Scene Graph） → 并自动连接 Controller。
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


 //Main class to launch the Notebook application.
public class NotebookApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file created in SceneBuilder 加载 UI 布局
        //这行代码会读取 notebook_view.fxml，根据里面的标签自动创建界面控件，并返回根节点 Parent。
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

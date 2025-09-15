package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {
        // UI components
        TextField wordField = new TextField();
        wordField.setPromptText("Enter a word");
        Button searchButton = new Button("Search");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        // Layout
        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.getChildren().addAll(new Label("Word:"), wordField, searchButton, resultArea);

        // Event handler: when button is clicked, search for the word
        searchButton.setOnAction(event -> {
            String word = wordField.getText();
            String meaning = controller.searchWord(word);
            resultArea.setText(meaning);
        });

        // Stage setup
        stage.setTitle("Virtual Dictionary");
        stage.setScene(new Scene(pane, 400, 250));
        stage.show();
    }
}

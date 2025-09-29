package view;

import controller.CurrencyController;
import entity.Currency;
import model.CurrencyModel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


 // JavaFX GUI for Currency Converter (database version).

public class CurrencyView extends Application {
    private CurrencyModel model;
    private CurrencyController controller;

    @Override
    public void init() {
        model = new CurrencyModel();
        controller = new CurrencyController();
    }

    @Override
    public void start(Stage stage) {
        // Input amount
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        // Output result
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // Currency choice boxes
        ChoiceBox<Currency> fromCurrency = new ChoiceBox<>();
        ChoiceBox<Currency> toCurrency = new ChoiceBox<>();
        fromCurrency.getItems().addAll(model.getCurrencies());
        toCurrency.getItems().addAll(model.getCurrencies());

        if (!fromCurrency.getItems().isEmpty()) {
            fromCurrency.setValue(fromCurrency.getItems().get(0));
        }
        if (toCurrency.getItems().size() > 1) {
            toCurrency.setValue(toCurrency.getItems().get(1));
        }

        // Convert button
        Button convertButton = new Button("Convert");

        // Instructions
        Label instructions = new Label("Enter amount, select source and target currencies, then click Convert.");

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(
                instructions,
                new Label("Amount:"),
                amountField,
                new Label("From Currency:"),
                fromCurrency,
                new Label("To Currency:"),
                toCurrency,
                convertButton,
                new Label("Result:"),
                resultField
        );

        // Event handling
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency from = fromCurrency.getValue();
                Currency to = toCurrency.getValue();
                double result = controller.convert(from, to, amount);

                if (result == -1) {
                    resultField.setText("Error: invalid conversion.");
                } else {
                    resultField.setText(String.format("%.2f", result));
                }
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input! Please enter a number.");
            }
        });

        // Scene
        Scene scene = new Scene(root, 350, 400);
        scene.getStylesheets().add("style.css");

        stage.setTitle("Currency Converter (DB)");
        stage.setScene(scene);
        stage.show();
    }

//    public static void main(String[] args) {launch(args);}
}


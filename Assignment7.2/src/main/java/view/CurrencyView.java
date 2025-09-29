package view;

import controller.CurrencyController;
import entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class CurrencyView extends Application {
    private final CurrencyController controller = new CurrencyController();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        Label fromLabel = new Label("From:");
        Label toLabel = new Label("To:");
        Label amountLabel = new Label("Amount:");
        Label resultLabel = new Label("Result:");

        ComboBox<String> fromCurrency = new ComboBox<>();
        ComboBox<String> toCurrency = new ComboBox<>();
        TextField amountField = new TextField();
        Button convertBtn = new Button("Convert");
        Label resultValue = new Label("---");

        // 填充下拉框（捕获数据库异常）
        try {
            List<Currency> currencies = controller.getModel().getCurrencies();
            for (Currency c : currencies) {
                fromCurrency.getItems().add(c.getAbbreviation());
                toCurrency.getItems().add(c.getAbbreviation());
            }
        } catch (SQLException e) {
            showError("Database Error", "Could not load currencies:\n" + e.getMessage());
        }

        // 按钮事件
        convertBtn.setOnAction(event -> {
            try {
                String from = fromCurrency.getValue();
                String to = toCurrency.getValue();
                double amount = Double.parseDouble(amountField.getText());
                double result = controller.convert(from, to, amount);
                resultValue.setText(String.format("%.2f", result));
            } catch (SQLException e) {
                showError("Database Error", "Conversion failed:\n" + e.getMessage());
            } catch (Exception e) {
                showError("Input Error", "Please enter valid numbers and select currencies.");
            }
        });

        grid.add(fromLabel, 0, 0);
        grid.add(fromCurrency, 1, 0);
        grid.add(toLabel, 0, 1);
        grid.add(toCurrency, 1, 1);
        grid.add(amountLabel, 0, 2);
        grid.add(amountField, 1, 2);
        grid.add(convertBtn, 0, 3);
        grid.add(resultLabel, 0, 4);
        grid.add(resultValue, 1, 4);

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package ui;

import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyUI extends Application {

    private final CurrencyDao dao = new CurrencyDao();

    private ComboBox<String> fromCurrency;  // 改成类变量
    private ComboBox<String> toCurrency;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter (JPA)");

        Label fromLabel = new Label("From:");
        Label toLabel = new Label("To:");
        Label amountLabel = new Label("Amount:");

        fromCurrency = new ComboBox<>();
        toCurrency = new ComboBox<>();
        TextField amountField = new TextField();
        Label resultLabel = new Label();

        // 第一次加载货币
        refreshCurrencyBoxes();

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            try {
                String from = fromCurrency.getValue();
                String to = toCurrency.getValue();
                double amount = Double.parseDouble(amountField.getText());

                Currency cFrom = dao.find(from);
                Currency cTo = dao.find(to);

                if (cFrom != null && cTo != null) {
                    double converted = amount * (cTo.getRate() / cFrom.getRate());
                    resultLabel.setText(String.format("%.2f %s", converted, to));
                } else {
                    resultLabel.setText("Currency not found!");
                }
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        Button addCurrencyButton = new Button("Add Currency");
        addCurrencyButton.setOnAction(e -> openAddCurrencyWindow(primaryStage));

        VBox root = new VBox(10, fromLabel, fromCurrency, toLabel, toCurrency,
                amountLabel, amountField, convertButton, resultLabel, addCurrencyButton);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }

    // 打开添加新货币窗口
    private void openAddCurrencyWindow(Stage parentStage) {
        Stage newStage = new Stage();
        newStage.setTitle("Add New Currency");

        TextField abbrField = new TextField();
        abbrField.setPromptText("Abbreviation (e.g., USD)");

        TextField nameField = new TextField();
        nameField.setPromptText("Name (e.g., US Dollar)");

        TextField rateField = new TextField();
        rateField.setPromptText("Rate");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                String abbr = abbrField.getText();
                String name = nameField.getText();
                double rate = Double.parseDouble(rateField.getText());

                // 改这里，调用 addCurrency()
                dao.addCurrency(new Currency(abbr, name, rate));

                // 刷新 UI 下拉框
                refreshCurrencyBoxes();

                newStage.close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Error: " + ex.getMessage()).showAndWait();
            }
        });

        VBox layout = new VBox(10, abbrField, nameField, rateField, saveButton);
        layout.setPadding(new Insets(10));

        newStage.setScene(new Scene(layout, 250, 200));
        newStage.initOwner(parentStage);
        newStage.showAndWait();
    }

    // 重新加载下拉框内容
    private void refreshCurrencyBoxes() {
        fromCurrency.getItems().clear();
        toCurrency.getItems().clear();

        List<Currency> currencies = dao.getAllCurrencies();
        for (Currency c : currencies) {
            fromCurrency.getItems().add(c.getAbbreviation());
            toCurrency.getItems().add(c.getAbbreviation());
        }
    }
}

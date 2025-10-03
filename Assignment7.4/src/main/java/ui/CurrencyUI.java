package ui;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.Currency;
import entity.Transaction;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * CurrencyUI
 * ------------------------
 * JavaFX 图形界面：实现货币转换和添加新货币。
 * 使用 JPA (CurrencyDao) 与数据库交互。
 */
public class CurrencyUI extends Application {

    // DAO 对象，用于操作数据库
    private final CurrencyDao dao = new CurrencyDao();

    // 下拉框作为类变量（方便在其他方法里刷新）
    private ComboBox<String> fromCurrency;
    private ComboBox<String> toCurrency;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter (JPA)");

        // --- 界面控件 ---
        Label fromLabel = new Label("From:");
        Label toLabel = new Label("To:");
        Label amountLabel = new Label("Amount:");

        fromCurrency = new ComboBox<>();
        toCurrency = new ComboBox<>();
        TextField amountField = new TextField();
        Label resultLabel = new Label();

        // 第一次启动时加载数据库里的货币到下拉框
        refreshCurrencyBoxes();

        // --- Convert 按钮 ---
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            try {
                String from = fromCurrency.getValue(); // 选择的源货币
                String to = toCurrency.getValue();     // 选择的目标货币
                double amount = Double.parseDouble(amountField.getText()); // 输入的金额

                // 从数据库获取对应的 Currency 对象
                Currency cFrom = dao.find(from);
                Currency cTo = dao.find(to);

                if (cFrom != null && cTo != null) {
                    // 计算：金额 * (目标汇率 / 源汇率)
                    double converted = amount * (cTo.getRateToUsd() / cFrom.getRateToUsd());
                    resultLabel.setText(String.format("%.2f %s", converted, to));

                    ////// 保存交易
                    Transaction tx = new Transaction(amount, converted, cFrom, cTo);
                    TransactionDao txDao = new TransactionDao();
                    txDao.addTransaction(tx);

                } else {
                    resultLabel.setText("Currency not found!");
                }
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        // --- Add Currency 按钮 ---
        Button addCurrencyButton = new Button("Add Currency");
        addCurrencyButton.setOnAction(e -> openAddCurrencyWindow(primaryStage));

        // --- 布局 ---
        VBox root = new VBox(10, fromLabel, fromCurrency,
                toLabel, toCurrency,
                amountLabel, amountField,
                convertButton, resultLabel,
                addCurrencyButton);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }

    /**
     * 打开一个新窗口，允许用户添加新的货币
     */
    private void openAddCurrencyWindow(Stage parentStage) {
        Stage newStage = new Stage();
        newStage.setTitle("Add New Currency");

        // 输入框：货币缩写、货币名称、汇率
        TextField abbrField = new TextField();
        abbrField.setPromptText("Abbreviation (e.g., USD)");

        TextField nameField = new TextField();
        nameField.setPromptText("Name (e.g., US Dollar)");

        TextField rateField = new TextField();
        rateField.setPromptText("Rate");

        // 保存按钮
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                String abbr = abbrField.getText();
                String name = nameField.getText();
                double rate = Double.parseDouble(rateField.getText());

                // 插入到数据库
                dao.addCurrency(new Currency(abbr, name, rate));

                // 立即刷新下拉框（让用户能马上看到新货币）
                refreshCurrencyBoxes();

                // 关闭窗口
                newStage.close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Error: " + ex.getMessage()).showAndWait();
            }
        });

        // 布局
        VBox layout = new VBox(10, abbrField, nameField, rateField, saveButton);
        layout.setPadding(new Insets(10));

        newStage.setScene(new Scene(layout, 250, 200));
        newStage.initOwner(parentStage);
        newStage.showAndWait();
    }

    /**
     * 刷新下拉框：从数据库读取最新的货币数据
     */
    private void refreshCurrencyBoxes() {
        // 先清空
        fromCurrency.getItems().clear();
        toCurrency.getItems().clear();

        // 查询数据库所有货币
        List<Currency> currencies = dao.getAllCurrencies();

        // 把缩写放到下拉框
        for (Currency c : currencies) {
            fromCurrency.getItems().add(c.getAbbreviation());
            toCurrency.getItems().add(c.getAbbreviation());
        }
    }
}

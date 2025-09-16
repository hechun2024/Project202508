package view;

import controller.CurrencyController;
import model.Currency;
import model.CurrencyModel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CurrencyView extends Application {
    private CurrencyModel model;          // 模型
    private CurrencyController controller; // 控制器

    @Override
    public void init() {
        model = new CurrencyModel();
        controller = new CurrencyController();
    }

    @Override
    public void start(Stage stage) {
        //  输入金额
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        // 输出结果
        TextField resultField = new TextField();
        resultField.setEditable(false);

        //  下拉框选择货币
        ChoiceBox<Currency> fromCurrency = new ChoiceBox<>();
        ChoiceBox<Currency> toCurrency = new ChoiceBox<>();
        fromCurrency.getItems().addAll(model.getCurrencies());
        toCurrency.getItems().addAll(model.getCurrencies());

        // 默认值
        fromCurrency.setValue(model.getCurrencies().get(0));
        toCurrency.setValue(model.getCurrencies().get(1));

        //  转换按钮
        Button convertButton = new Button("Convert");

        //  提示标签
        Label instructions = new Label("Enter amount, select source and target currencies, then click Convert.");

        // ====== 布局 ======
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

        // ====== 事件处理 ======
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency from = fromCurrency.getValue();
                Currency to = toCurrency.getValue();
                double result = controller.convert(from, to, amount);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input! Please enter a number.");
            }
        });

        // ====== 设置场景 ======
        Scene scene = new Scene(root, 350, 400);
        scene.getStylesheets().add("style.css"); // 应用CSS

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);  //把 args（命令行参数）传给 JavaFX 应用
    }
}

/*
也可以把接口的启动类单独放一个文件，代替上面的 main 方法
public class Main {
    public static void main(String[] args) {
        Application.launch(CurrencyView.class, args);
    }
}
*/

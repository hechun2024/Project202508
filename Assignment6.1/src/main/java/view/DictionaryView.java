package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.application.Platform; // 用来做 runLater
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
        // 初始化控制器
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {

        // ===== 创建界面控件 =====
        TextField wordField = new TextField();      // 输入单词
        wordField.setPromptText("Enter a word");    // 提示文字
        Button searchButton = new Button("Search"); // 搜索按钮
        TextArea resultArea = new TextArea();       // 显示结果的区域
        resultArea.setEditable(false);              // 不允许用户自己修改
        resultArea.setWrapText(true);               // 自动换行

        // ===== 布局 =====
        FlowPane pane = new FlowPane();   // 流式布局
        pane.setHgap(10);                 // 横向间距
        pane.setVgap(10);                 // 纵向间距
        // 把所有控件放到布局里面
        pane.getChildren().addAll(new Label("Word:"), wordField, searchButton, resultArea);

        // ===== 按钮点击事件 =====
        searchButton.setOnAction(event -> {
            String word = wordField.getText();              // 取输入框的内容
            String meaning = controller.searchWord(word);   // 调用控制器去查单词
            resultArea.setText(meaning);                    // 把结果显示出来
        });

        // ===== 设置窗口 =====
        stage.setTitle("Virtual Dictionary");   // 窗口标题
        stage.setScene(new Scene(pane, 400, 250)); // 窗口场景（布局 + 尺寸）
        stage.show();   // 显示窗口

        // ===== 解决 macOS 窗口只停在 Dock 的问题 =====
        Platform.runLater(() -> {
            stage.toFront();       // 把窗口放到最前
            stage.requestFocus();  // 请求焦点（方便直接输入）
        });
    }
}

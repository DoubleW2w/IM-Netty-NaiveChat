/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/1/21 2:55
 * @project: IM-Netty-NaiveChat
 */module naive.chat.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires cn.hutool.core;

    exports org.itstack.naive.chat.ui;
    opens org.itstack.naive.chat.ui to javafx.fxml;
}
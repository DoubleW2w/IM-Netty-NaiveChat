package com.doublew2w.naive.chat.ui;

import com.doublew2w.naive.chat.ui.view.Login;
import javafx.stage.Stage;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/8 23:54
 * @project: IM-Netty-NaiveChat
 */
public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Login login = new Login();
        login.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

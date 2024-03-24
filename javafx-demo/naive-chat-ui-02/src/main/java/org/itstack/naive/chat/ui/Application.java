package org.itstack.naive.chat.ui;

import org.itstack.naive.chat.ui.view.Login;
import javafx.stage.Stage;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/1/21 0:56
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

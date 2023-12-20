package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2023/12/20 16:13
 * @project: IM-Netty-NaiveChat
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Class<? extends Main> aClass = getClass();
        URL resource = aClass.getResource("../sample.fxml");
        assert resource != null;
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

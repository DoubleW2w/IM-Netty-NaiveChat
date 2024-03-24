package org.itstack.naive.chat.ui.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/1/21 0:57
 * @project: IM-Netty-NaiveChat
 */
public class Login extends Stage {
  private static final String RESOURCE_NAME = "/fxml/login/login.fxml";

  private Parent root;

  public Login() {
    try {
      root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(RESOURCE_NAME)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    setScene(scene);
    initStyle(StageStyle.TRANSPARENT);
    setResizable(false);
    this.getIcons()
        .add(
            new Image(
                Objects.requireNonNull(
                    getClass().getResourceAsStream("/fxml/login/img/system/logo.png"))));
  }
}

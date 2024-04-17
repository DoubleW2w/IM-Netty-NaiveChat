package com.doublew2w.naive.chat.ui.view.face;

import com.doublew2w.naive.chat.ui.view.UIObject;
import com.doublew2w.naive.chat.ui.view.chat.ChatInit;
import com.doublew2w.naive.chat.ui.view.chat.IChatEvent;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:30
 * @project: IM-Netty-NaiveChat
 */
public abstract class FaceInit extends UIObject {

    private static final String RESOURCE_NAME = "/fxml/face/face.fxml";

    public Pane rootPane;

    public ChatInit chatInit;
    public IChatEvent chatEvent;
    public IChatMethod chatMethod;

    FaceInit(final UIObject obj) {
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        // 模态窗口
        initModality(Modality.APPLICATION_MODAL);
        initOwner(obj);
        // 初始化页面&事件
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        rootPane = $("face", Pane.class);
    }

    public Parent root(){
        return super.root;
    }

}

package com.doublew2w.naive.chat.ui.view.face;


/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:30
 * @project: IM-Netty-NaiveChat
 */
public class FaceEventDefine {

    private FaceInit faceInit;

    public FaceEventDefine(FaceInit faceInit) {
        this.faceInit = faceInit;

        hideFace();
    }

    private void hideFace(){
        faceInit.root().setOnMouseExited(event -> {
            faceInit.hide();
        });
    }

}

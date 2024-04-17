package com.doublew2w.naive.chat.ui.view.face;


import com.doublew2w.naive.chat.ui.view.UIObject;
import com.doublew2w.naive.chat.ui.view.chat.ChatInit;
import com.doublew2w.naive.chat.ui.view.chat.IChatEvent;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:30
 * @project: IM-Netty-NaiveChat
 */
public class FaceController extends FaceInit implements IFaceMethod {

    private FaceView faceView;

    public FaceController(UIObject obj, ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        super(obj);
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;
    }

    @Override
    public void initView() {
        faceView = new FaceView(this);
    }

    @Override
    public void initEventDefine() {
        new FaceEventDefine(this);
    }

    @Override
    public void doShowFace(Double x, Double y) {
        setX(x + 230 * (1 - 0.618));  // 设置位置X
        setY(y - 160);                      // 设置位置Y
        show();                             // 展示窗口
    }

}

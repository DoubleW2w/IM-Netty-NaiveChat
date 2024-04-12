package com.doublew2w.naive.chat.ui.view;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * UI父类定义
 *
 * <p>抽取公用的方法和事件操作，共所有框体使用
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 22:04
 * @project: IM-Netty-NaiveChat
 */
public abstract class UIObject extends Stage {
  /** UI根元素 */
  protected Parent root;

  /** x偏移量 */
  private double xOffset;

  /** y偏移量 */
  private double yOffset;

  public <T> T $(String id, Class<T> clazz) {
    return (T) root.lookup("#" + id);
  }

  public void clearViewListSelectedAll(ListView<Pane>... listViews) {
    for (ListView<Pane> listView : listViews) {
      listView.getSelectionModel().clearSelection();
    }
  }

  /** 鼠标移动窗体事件 */
  public void move() {
    // 鼠标按下事件：记录窗体位置
    root.setOnMousePressed(
        event -> {
          xOffset = getX() - event.getScreenX();
          yOffset = getY() - event.getScreenY();
          root.setCursor(Cursor.CLOSED_HAND);
        });
    // 鼠标拖动：设置X、Y
    root.setOnMouseDragged(
        event -> {
          System.out.println("移动窗体");
          setX(event.getScreenX() + xOffset);
          setY(event.getScreenY() + yOffset);
        });
    // 鼠标释放：恢复默认鼠标样式
    root.setOnMouseReleased(
        event -> {
          root.setCursor(Cursor.DEFAULT);
        });
  }

  /** 初始化页面 */
  public abstract void initView();

  /** 初始化事件定义 */
  public abstract void initEventDefine();
}

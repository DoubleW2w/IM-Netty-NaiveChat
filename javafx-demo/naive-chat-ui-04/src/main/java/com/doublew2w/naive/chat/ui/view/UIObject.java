package com.doublew2w.naive.chat.ui.view;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
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

  /** 移动窗体 */
  public void move() {
    // 鼠标按压
    root.setOnMousePressed(
        event -> {
          xOffset = getX() - event.getScreenX();
          yOffset = getY() - event.getScreenY();
          root.setCursor(Cursor.CLOSED_HAND);
        });
    // 鼠标拖动
    root.setOnMouseDragged(
        event -> {
          System.out.println("移动窗体");
          setX(event.getScreenX() + xOffset);
          setY(event.getScreenY() + yOffset);
        });
    // 鼠标释放
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

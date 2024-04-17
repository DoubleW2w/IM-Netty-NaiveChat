package com.doublew2w.naive.chat.ui.view;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * UI父类定义
 *
 * <p>提供基础的初始化内容和接口，定义抽象方法
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:45
 * @project: IM-Netty-NaiveChat
 */
public abstract class UIObject extends Stage {
  protected Parent root;
  private double xOffset;
  private double yOffset;

  /**
   * 寻找根节点的id属性节点所属的对象
   *
   * @param id id
   * @param clazz 要转换的类
   * @return 对象的事例
   * @param <T> 具体类型
   */
  public <T> T $(String id, Class<T> clazz) {
    return (T) root.lookup("#" + id);
  }

  /** 窗体移动 */
  public void move() {
    root.setOnMousePressed(
        event -> {
          xOffset = getX() - event.getScreenX();
          yOffset = getY() - event.getScreenY();
          root.setCursor(Cursor.CLOSED_HAND);
        });
    root.setOnMouseDragged(
        event -> {
          setX(event.getScreenX() + xOffset);
          setY(event.getScreenY() + yOffset);
        });
    root.setOnMouseReleased(
        event -> {
          root.setCursor(Cursor.DEFAULT);
        });
  }

  /**
   * 清除列表的所有选中状态
   *
   * @param listViews 列表
   */
  public void clearViewListSelectedAll(ListView<Pane>... listViews) {
    for (ListView<Pane> listView : listViews) {
      listView.getSelectionModel().clearSelection();
    }
  }

  public double x() {
    return getX();
  }

  public double y() {
    return getY();
  }

  public double width() {
    return getWidth();
  }

  public double height() {
    return getHeight();
  }

  // 初始化页面
  public abstract void initView();

  // 初始化事件定义
  public abstract void initEventDefine();
}

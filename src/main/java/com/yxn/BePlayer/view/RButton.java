package com.yxn.BePlayer.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class RButton extends JButton {
    public RButton(String label) {
        super(label);
// 这些声明把按钮扩展为一个圆而不是一个椭圆。
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
//这个调用使JButton不画背景，而允许我们画一个圆的背景。
        setContentAreaFilled(false);
        this.setBackground(Color.decode("#fcb49e"));
        this.setBorderPainted(false);
    }

    // 画圆的背景和标签
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
// 你可以选一个高亮的颜色作为圆形按钮类的属性
            g.setColor(Color.decode("#f57da1"));
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
//这个调用会画一个标签和焦点矩形。
        super.paintComponent(g);
    }

    // 侦测点击事件
    Shape shape;

    public boolean contains(int x, int y) {
// 如果按钮改变大小，产生一个新的形状对象。
        if (shape == null ||
                !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}
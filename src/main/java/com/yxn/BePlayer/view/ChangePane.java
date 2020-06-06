package com.yxn.BePlayer.view;

import javax.swing.*;
import java.awt.*;

public class ChangePane extends JPanel {

    public ChangePane() {
        ToTalPane.getInstance();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        this.setPreferredSize(new Dimension(130, 600));//设置大小
        ToTalPane.getInstance().b1.setBounds(10, 130, 50, 50);
        ToTalPane.getInstance().b2.setBounds(10, 250, 50, 50);
        this.setBackground(new Color(60, 62, 64));
        this.add(ToTalPane.getInstance().b1);
        this.add(ToTalPane.getInstance().b2);
    }
}

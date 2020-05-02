package com.yxn.BePlayer.view;

import javax.swing.*;
import java.awt.*;

public class ChangePane extends JPanel {

    public ChangePane(){
        ToTalPane.getInstance();
        this.setLayout(new GridLayout(2, 1, 5, 5));
        this.add(ToTalPane.getInstance().b1);
        this.add(ToTalPane.getInstance().b2);
    }
}

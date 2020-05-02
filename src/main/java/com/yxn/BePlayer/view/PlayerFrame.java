package com.yxn.BePlayer.view;

import com.yxn.BePlayer.MediaPlayer.AudioMediaPlayer;
import com.yxn.BePlayer.MediaPlayer.VideoMediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PlayerFrame  extends JFrame {
    private static ChangePane changePane;
    public PlayerFrame(){

        changePane = new ChangePane();
        Container container = this.getContentPane();
        container.add(ToTalPane.getInstance(), BorderLayout.CENTER);
        container.add(changePane, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(new Dimension(1000, 600));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                VideoMediaPlayer.getInstance().release();
                AudioMediaPlayer.getInstance().release();
                System.exit(0);
            }
        });
        this.setVisible(true);
    }
}

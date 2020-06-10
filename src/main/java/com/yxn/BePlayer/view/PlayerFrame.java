package com.yxn.BePlayer.view;

import com.yxn.BePlayer.mediaPlayer.AudioMediaPlayer;
import com.yxn.BePlayer.mediaPlayer.VideoMediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PlayerFrame extends JFrame {
    private static ChangePane changePane;

    public PlayerFrame() {

        changePane = new ChangePane();
        Image image = new ImageIcon("src\\main\\java\\com\\yxn\\BePlayer\\image\\g4.jpg").getImage();
        Container container = new ImagePanel(image);
        this.setContentPane(container);
        container.setLayout(new BorderLayout());
        container.add(ToTalPane.getInstance(), BorderLayout.CENTER);
        container.add(changePane, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(new Dimension(1000, 600));
        this.setLocationRelativeTo(null);//屏幕居中显示
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

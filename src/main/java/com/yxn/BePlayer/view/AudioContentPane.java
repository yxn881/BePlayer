package com.yxn.BePlayer.view;

import javax.swing.*;
import java.awt.*;


public class AudioContentPane extends JPanel {
    private static AudioControlsPane audioControlsPane;
    private static AudioButtonsPane audioButtonsPane;

    public AudioContentPane() {
        audioControlsPane = new AudioControlsPane();
        audioButtonsPane = new AudioButtonsPane();
        Image image = new ImageIcon("src\\main\\java\\com\\yxn\\BePlayer\\image\\audiobackground.jpg").getImage();
        JPanel panel = new ImagePanel(image);
        this.setLayout(new BorderLayout());
        this.add(audioControlsPane, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(audioButtonsPane, BorderLayout.NORTH);
    }
}

package com.yxn.BePlayer.view;

import javax.swing.*;
import java.awt.*;


public class AudioContentPane extends JPanel {
    private static AudioControlsPane audioControlsPane;
    private static AudioButtonsPane audioButtonsPane;

    public AudioContentPane() {
        audioControlsPane = new AudioControlsPane();
        audioButtonsPane = new AudioButtonsPane();
        this.setLayout(new BorderLayout());
        this.add(audioControlsPane, BorderLayout.SOUTH);
        this.add(audioButtonsPane, BorderLayout.NORTH);
    }
}

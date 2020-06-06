package com.yxn.BePlayer.view;

import com.yxn.BePlayer.mediaPlayer.VideoMediaPlayer;

import javax.swing.*;
import java.awt.*;


public class VideoContentPane extends JPanel {
    private static VideoControlsPane videoControlsPane;
    private static VideoButtonsPane videoButtonsPane;

    public VideoContentPane() {
        videoControlsPane = new VideoControlsPane();
        videoButtonsPane = new VideoButtonsPane();
        this.setLayout(new BorderLayout());
        this.add(videoControlsPane, BorderLayout.SOUTH);
        this.add(VideoMediaPlayer.getInstance(), BorderLayout.CENTER);
        this.add(videoButtonsPane, BorderLayout.NORTH);
    }

}

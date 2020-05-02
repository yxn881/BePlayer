package com.yxn.BePlayer.view;

import com.yxn.BePlayer.MediaPlayer.AudioMediaPlayer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;


public class AudioButtonsPane extends JPanel {
    private static JButton openButton;
    private static JFileChooser chooser;
    private static JTextField pathField;

    public AudioButtonsPane() {
        openButton = new JButton();
        pathField = new JTextField("why");
        pathField.setColumns(50);
        openButton.setText("选择");
        this.setLayout(new FlowLayout());
        openButton.setFocusPainted(false);
        this.add(pathField);
        this.add(openButton);

// 选择音频文件，进行播放
        openButton.addActionListener((e) -> {
            chooser = new JFileChooser();
            FileNameExtensionFilter filter2 = new FileNameExtensionFilter("音频", "mp3", "wav", "flac");
            chooser.setFileFilter(filter2);
            int ret = chooser.showOpenDialog(this);
            if (ret == JFileChooser.APPROVE_OPTION) {
// 结果为：已经存在的一个文件
                File file2 = chooser.getSelectedFile();
                pathField.setText(file2.getAbsolutePath());

// 开始播放音频
                AudioMediaPlayer.getInstance().mediaPlayer().media().play(file2.getAbsolutePath());
            }
        });
    }

}

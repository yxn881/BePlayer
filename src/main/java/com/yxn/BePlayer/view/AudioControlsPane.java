package com.yxn.BePlayer.view;

import com.yxn.BePlayer.MediaPlayer.AudioMediaPlayer;
import com.yxn.BePlayer.components.MediaTime;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AudioControlsPane extends JPanel {
    private static JButton pauseButton, rewindButton, skipButton;
    private static JProgressBar progressBar;
    private static JSlider slider;
    private static JLabel label1, label2;
    private static MediaTime mediaTime;

    public AudioControlsPane() {
        label1 = new JLabel("00:00");
        label2 = new JLabel("00:00");
        mediaTime = new MediaTime();
        progressBar = new JProgressBar();
        this.add(label1);
        this.add(progressBar);
        this.add(label2);
        progressBar.setStringPainted(true);
        //添加声音控制块
        slider = new JSlider();
        slider.setValue(80);
        slider.setMaximum(100);
        this.add(slider);
        rewindButton = new JButton("<<");
        this.add(rewindButton);
        pauseButton = new JButton("Pause");
        this.add(pauseButton);
        skipButton = new JButton(">>");
        this.add(skipButton);

        AudioMediaPlayer.getInstance().mediaPlayer().events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void playing(MediaPlayer mediaPlayer) {

            }

            @Override
            public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
                System.out.println("positionChanged.. " + newPosition);
                progressBar.setValue((int) (100 * newPosition));
                mediaTime.timeCalculate(AudioMediaPlayer.getInstance().mediaPlayer().media().info().duration(), newPosition * AudioMediaPlayer.getInstance().mediaPlayer().media().info().duration());
                label1.setText(mediaTime.getMinitueCurrent() + ":" + mediaTime.getSecondCurrent());
                label2.setText(mediaTime.getMinitueTotal() + ":" + mediaTime.getSecondTotal());
            }

            @Override
            public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
                // TODO Auto-generated method stub
                super.timeChanged(mediaPlayer, newTime);
            }

            public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
                // TODO Auto-generated method stub
                super.lengthChanged(mediaPlayer, newLength);
            }


            @Override
            public void finished(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        showDefaultView();
                    }

                    private void showDefaultView() {
                        JOptionPane.showMessageDialog(
                                new JFrame(),
                                "Finished",
                                "Finished",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                });

            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
//                System.err.println("Error playing media");
//                System.exit(-1);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(
                                new JFrame(),
                                "Failed to play media",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                });
            }

        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AudioMediaPlayer.getInstance().mediaPlayer().controls().pause();
            }
        });

        rewindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AudioMediaPlayer.getInstance().mediaPlayer().controls().skipTime(-10000);
            }
        });

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AudioMediaPlayer.getInstance().mediaPlayer().controls().skipTime(10000);
            }
        });
        progressBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                jumpTo((float) x / progressBar.getWidth());

            }
        });
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setVol(slider.getValue());
            }
        });

    }

    // 实现音频点击进度条跳转的方法
    public static void jumpTo(float to) {
        AudioMediaPlayer.getInstance().mediaPlayer().controls().setTime((long) (to * AudioMediaPlayer.getInstance().mediaPlayer().media().info().duration()));
    }

    // 实现音频音量控制
    public static void setVol(int v) {
        AudioMediaPlayer.getInstance().mediaPlayer().audio().setVolume(v);
    }

}

package com.yxn.BePlayer.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToTalPane extends JPanel {
    private static AudioContentPane audioContentPane;
    private static VideoContentPane videoContentPane;
    public static JButton b1, b2;

    public ToTalPane() {
        audioContentPane = new AudioContentPane();
        videoContentPane = new VideoContentPane();
        //定义卡片布局对象
        CardLayout card = new CardLayout();
        this.setLayout(card);
        //定义字符数组，为卡片命名
        String cardName[] = {"0", "1"};
        b1 = new RButton("视频");
        b2 = new RButton2("音频");
        b1.setPreferredSize(new Dimension(120, 120));
        b1.setFont(new MyFont().getDefinedFont((float) 35.0));
        b2.setPreferredSize(new Dimension(80, 80));
        b2.setFont(new MyFont().getDefinedFont((float) 22.0));
        this.add(cardName[0], videoContentPane);
        this.add(cardName[1], audioContentPane);
        ToTalPane self = this;
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(self, cardName[0]);
                System.out.println("切换到视频");

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(self, cardName[1]);
                System.out.println("切换到音频");
            }
        });
    }

    public static ToTalPane getInstance() {
        return InnerClass.toTalPane;
    }

    public static class InnerClass {
        //在内部类中new出这个对象
        public static ToTalPane toTalPane = new ToTalPane();


    }
}

package com.yxn.BePlayer.MediaPlayer;

import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;

public class AudioMediaPlayer {

    public AudioMediaPlayer() {
    }

    public static AudioPlayerComponent getInstance() {
        return InnerClass.mediaPlayerComponent;
    }

    public static class InnerClass {
        //在内部类中new出这个对象
        public static AudioPlayerComponent mediaPlayerComponent = new AudioPlayerComponent();


    }
}

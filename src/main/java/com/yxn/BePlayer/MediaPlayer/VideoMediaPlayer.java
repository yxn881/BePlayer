package com.yxn.BePlayer.MediaPlayer;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VideoMediaPlayer {

    public VideoMediaPlayer() {
    }

    public static EmbeddedMediaPlayerComponent getInstance() {
        return InnerClass.mediaPlayerComponent;
    }

    public static class InnerClass {
        //在内部类中new出这个对象
        public static EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();


    }
}

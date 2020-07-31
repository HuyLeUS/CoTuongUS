package com.example.ctngus.TroChoi.AmThanh;

import android.media.MediaPlayer;

public class HieuUngAmThanh extends Thread {
     private MediaPlayer player;

     public HieuUngAmThanh(MediaPlayer player) {
          this.player = player;
     }

     @Override
     public void run() {
          this.player.start();
     }
}

package com.example.test1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {
        
        MediaPlayer player;
        
        @Override
        public IBinder onBind(Intent intent) {
                return null;
        }
        
        @Override
        public void onCreate() {
                Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
                
                player = MediaPlayer.create(this, R.raw.treck1);
                player.setLooping(true); // зацикливаем
        }

        @Override
        public void onDestroy() {
                Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
                player.stop();
        }
        
        @Override
        public void onStart(Intent intent, int startid) {
                Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
                player.start();
        }
        
        public void onPause() {
			player.pause();
		}
}
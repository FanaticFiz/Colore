package com.example.test1;

import java.io.IOException;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Toast;

public class ShortSounds extends Activity 
{
    
	  SoundPool mSoundPool;
	  AssetManager assets;
	  int Sound1,Sound2,Sound3,Sound4,Sound5,Sound6,Sound7,Sound8;
	    
	  @Override
	  protected void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	        
	    mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
	    assets = getAssets();

	    Sound1 = loadSound("Treck1.mp3");
	    
	  }

	  private int loadSound(String fileName) 
	  {
	    AssetFileDescriptor afd = null;
	    try 
	    {
	      afd = assets.openFd(fileName);
	    } catch (IOException e) 
	    		{
	    		e.printStackTrace();
	    		Toast.makeText(this, "Couldn't load file '" + fileName + "'", Toast.LENGTH_SHORT).show();
	    		return -1;
	    		}
	    return mSoundPool.load(afd, 1);
	  }
}
package com.example.test1;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends Activity {

	TextView textStartGame,textStartGame1,textStartGame2,textStartGame3,textStartGame4;
	private Animation menu_animation;
	private MediaPlayer mediaPlayer;
	private SoundPool soundPool;
	boolean loaded = false;
	public static int soundID1, soundID2, soundID3;
    public static float volume;
    
    public static final String APP_PREFERENCES = "mysettings";  		// ��� ����� ��������
    public static final String APP_PREFERENCES_COUNTER = "vol";		// �������
    SharedPreferences mSettings;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		
		
		// ****************************************************************************
		// *************************** �������� �� ������  ****************************
		// ��������� ������ ��������� � �����������
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		// ����� ����� ��� ������������ ������� ����������
		mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.treck1);
		mediaPlayer.start();
		//������� soundPool. ��� �������� �����
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        //������������� call-back �������, ������� ���������� ��
        //���������� �������� ����� � ������
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
                Log.e("Test", "sampleId="+sampleId+" status="+status);
            }
        });
        //��������� ����� � ������
        soundID1 = soundPool.load(this, R.raw.btn1, 1);
        soundID2 = soundPool.load(this, R.raw.btn2, 1);
        soundID3 = soundPool.load(this, R.raw.btn3, 1);
        
        // 	Getting the user sound settings
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume = actualVolume / maxVolume;
		// ****************************************************************************
		// ****************************************************************************
        
        
		
		
		// ��������� ������ ��������� �����
		final TextView textColoremaze = (TextView)findViewById(R.id.textView2);
		textColoremaze.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sketchRockwell-Bold.ttf"));
		
		textStartGame = (TextView)findViewById(R.id.start);
		textStartGame.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/trashco.ttf"));
		textStartGame1 = (TextView)findViewById(R.id.settings);
		textStartGame1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/trashco.ttf"));
		textStartGame2 = (TextView)findViewById(R.id.about);
		textStartGame2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/trashco.ttf"));
		textStartGame3 = (TextView)findViewById(R.id.exit);
		textStartGame3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sketchRockwell-Bold.ttf"));
		textStartGame4 = (TextView)findViewById(R.id.textView11);
				
		// ��������� ����
		textColoremaze.setShadowLayer(8f,4f,4f,0xFF000000);
		textStartGame.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame1.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame2.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame3.setShadowLayer(8f,4f,4f,0xFF000000);
		textStartGame4.setShadowLayer(8f,4f,4f,0xFF000000);
		
			
		
		// ���������� ���� �������� ��� ����
		menu_animation = AnimationUtils.loadAnimation(this, R.anim.menuanimation);
	}

	
	
	// ��� ����������, ��� ��������������� ����� �����������?
	// ��� ���� ���� ������ ������� ��������� ������ onCompletion. 
	public void onCompletion(MediaPlayer arg0) 
	{
        arg0.start(); //��������� ��������������� ������
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void OnClickPlay(View v) 
	{
		// ��������� ����
		textStartGame.startAnimation(menu_animation);
		soundPool.play(soundID1, volume, volume, 1, 0, 1f);		
		// ������ ���� � ���� ������ ���� ����
		Intent intentG = new Intent();
		intentG.setClass(MainActivity.this, Type.class);
		startActivity(intentG);
	}	
	public void OnClickSettings(View v) 
	{
		textStartGame1.startAnimation(menu_animation);
		soundPool.play(soundID2, volume, volume, 1, 0, 1f);
		
		Intent inten1 = new Intent();
		inten1.setClass(MainActivity.this, SettingsActivity.class);
		startActivity(inten1);
	}
	public void OnClickAbout(View v) 
	{
		textStartGame2.startAnimation(menu_animation);
		soundPool.play(soundID3, volume, volume, 1, 0, 1f);
		
		Intent inten2 = new Intent();
		inten2.setClass(MainActivity.this, AboutActivity.class);
		startActivity(inten2);
	};
	public void OnClickExit(View v) 
	{
		textStartGame3.startAnimation(menu_animation);
		soundPool.play(soundID1, volume, volume, 1, 0, 1f);
		
		soundPool.release();
		soundPool = null;
		finish();
	}	
	
		
	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();

		// ������ �� �����
		mediaPlayer.pause();
		volume++;
		Editor editor = mSettings.edit();
		editor.putFloat(APP_PREFERENCES_COUNTER, volume);
		editor.apply();
	}
	
	
	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();

		// �������� ������ �����
		mediaPlayer.start();
	    
		
		// ���� �� ������ ��� ����
		if (mSettings.contains(APP_PREFERENCES_COUNTER)) 
		{
			// �������� ����� �� ��������
			volume = mSettings.getFloat(APP_PREFERENCES_COUNTER, 0);
			textStartGame4.setText("= "+volume);
		}
		
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		// TODO Auto-generated method stub
	    if (mediaPlayer != null) 
	    {
	    	mediaPlayer.release();
	    	mediaPlayer = null;
	    }

	}
	
}

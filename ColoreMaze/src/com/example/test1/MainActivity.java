package com.example.test1;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends Activity {

	TextView textStartGame,textStartGame1,textStartGame2,textStartGame3,textStartGame4;
	private Animation menu_animation;
	private SoundPool soundPool;
	private Intent svc;
	boolean loaded = false;
	private static int soundID1;
	private static float volume;
    
    public static final String APP_PREFERENCES = "mysettings";  		// Имя файла настроек
    public static final String APP_PREFERENCES_COUNTER = "vol";		// Счетчик
    SharedPreferences mSettings;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

		
		// ****************************************************************************
		// *************************** работаем со звуком  ****************************
		// Стартуем сервис проигрования музыки.
		svc=  new Intent(this, MusicService.class);
		startService(svc);
		
		//Создаем soundPool. для коротких пуков
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID1 = soundPool.load(this, R.raw.btn2, 1);
        
        // Связываем кнопку громкости с приложением
     	this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // 	Getting the user sound settings
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume = actualVolume / maxVolume;
		// ****************************************************************************
		// ****************************************************************************
        
        
		
		
		// Установка шрифта текстовым полям
		final TextView textColoremaze = (TextView)findViewById(R.id.game_up_text);
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
				
		// Добавляем тени
		textColoremaze.setShadowLayer(8f,4f,4f,0xFF000000);
		textStartGame.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame1.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame2.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame3.setShadowLayer(8f,4f,4f,0xFF000000);
		textStartGame4.setShadowLayer(8f,4f,4f,0xFF000000);
		
			
		
		// подключаем файл анимации для меню
		menu_animation = AnimationUtils.loadAnimation(this, R.anim.menuanimation);
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
		// Анимируем меню
		textStartGame.startAnimation(menu_animation);
		soundPool.play(soundID1, volume, volume, 1, 0, 1f);		
		// отсюда идем в окно выбора типа игры
		Intent intentG = new Intent();
		intentG.setClass(MainActivity.this, Type.class);
		startActivity(intentG);
		// анимируем переход между активити
		overridePendingTransition(R.anim.activity_zoom_in, R.anim.activity_zoom_out);
	}	
	public void OnClickSettings(View v) 
	{
		textStartGame1.startAnimation(menu_animation);
		soundPool.play(soundID1, volume, volume, 1, 0, 1f);
		
		Intent inten1 = new Intent();
		inten1.setClass(MainActivity.this, SettingsActivity.class);
		startActivity(inten1);
		
		overridePendingTransition(R.anim.activity_zoom_in, R.anim.activity_zoom_out);
	}
	public void OnClickAbout(View v) 
	{
		textStartGame2.startAnimation(menu_animation);
		soundPool.play(soundID1, volume, volume, 1, 0, 1f);
		
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

		
		// если ли нужный нам ключ
		if (mSettings.contains(APP_PREFERENCES_COUNTER)) 
		{
			// Получаем число из настроек
			volume = mSettings.getFloat(APP_PREFERENCES_COUNTER, 0);
			textStartGame4.setText("= "+volume);
		}
		
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		// TODO Auto-generated method stub
		soundPool.release();
		soundPool = null;
		
		stopService(svc);
		finish();
	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		stopService(svc);
		finish();
		
	}
}

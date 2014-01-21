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

	TextView textStartGame1,textStartGame2,textStartGame3,textStartGame4;
	private Animation menu_animation;
	private SoundPool soundPool;
	boolean loaded = false;
	private static int soundID1;
	
	private static float	volume;
	private static int 		Sound_on_of,fontBG;
    public static final String APP_PREFERENCES = "mysettings";  				// Имя файла настроек
    public static final String APP_PREFERENCES_menu_volume 	= "volume";			// Громкость музыки
    public static final String APP_PREFERENCES_menu_sound	= "Sound_on_of";	// вкл/выкл звука
    public static final String APP_PREFERENCES_menu_fonBG	= "fontBG";			// фон выбранный по умолчанию 
    
    SharedPreferences mSettings;
      
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		
		
		// ****************************************************************************
		// *************************** работаем со звуком  ****************************
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
		
		textStartGame1 = (TextView)findViewById(R.id.settings);
		textStartGame1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sketchRockwell-Bold.ttf"));
		textStartGame2 = (TextView)findViewById(R.id.about);
		textStartGame2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sketchRockwell-Bold.ttf"));
		textStartGame3 = (TextView)findViewById(R.id.exit);
		textStartGame3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sketchRockwell-Bold.ttf"));
		textStartGame4 = (TextView)findViewById(R.id.textView11);
		
		/*
		// Добавляем тени
		textColoremaze.setShadowLayer(8f,4f,4f,0xFF000000);
		textStartGame.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame1.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame2.setShadowLayer(8f,8f,8f,0xFF000000);
		textStartGame3.setShadowLayer(8f,4f,4f,0xFF000000);
		textStartGame4.setShadowLayer(8f,4f,4f,0xFF000000);
		*/
			
		
		// подключаем файл анимации для меню
		menu_animation = AnimationUtils.loadAnimation(this, R.anim.menuanimation);
		
		//MyGetPreferences();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void onPlayClick(View v) 
	{
		
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

	
	
	public void MyGetPreferences() 
	{
		/*// если ли нужный нам ключ
		if (mSettings.contains(APP_PREFERENCES_menu_volume)) 
		{	volume = mSettings.getFloat(APP_PREFERENCES_menu_volume, 0);	}
		if (mSettings.contains(APP_PREFERENCES_menu_sound)) 
		{	volume = mSettings.getInt(APP_PREFERENCES_menu_sound, 0);	}
		if (mSettings.contains(APP_PREFERENCES_menu_fonBG)) 
		{	volume = mSettings.getInt(APP_PREFERENCES_menu_fonBG, 0);	}
		*/
		textStartGame4.setText(String.format("Громкость, Звук вкл/выкл, Тип фона: %d:%d:%d", volume, Sound_on_of, fontBG));
	}
	
	
	public void MySetPreferences() 
	{
		Editor editor = mSettings.edit();
		editor.putFloat(APP_PREFERENCES_menu_volume, 	volume		);
		editor.putFloat(APP_PREFERENCES_menu_sound, 	Sound_on_of	);
		editor.putFloat(APP_PREFERENCES_menu_fonBG, 	fontBG		);
		editor.apply();

	}
	
	
	
	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();

		volume++;
	}
	
	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
		
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		// TODO Auto-generated method stub
		soundPool.release();
		soundPool = null;
		
		finish();
	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		finish();
	}
}

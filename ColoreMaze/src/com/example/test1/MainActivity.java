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
	//private static int 		Sound_on_of,fontBG;
	
    public static final String APP_PREFERENCES = "mysettings";  				// Имя файла настроек
    
    public static final String APP_PREFERENCES_FirstRun 	= "FirstRun";		// признак первого запуска
    public static final String APP_PREFERENCES_menu_volume 	= "volume";			// Громкость музыки
    public static final String APP_PREFERENCES_menu_sound	= "Sound_on_of";	// вкл/выкл звука
    public static final String APP_PREFERENCES_menu_fonBG	= "fontBG";			// фон выбранный по умолчанию 
    
    SharedPreferences mSettings;
    Editor preferences_editor;      
    // Уровень 1 
	public static final String 	APP_PREFERENCES_moovs_of_type1		= 	"moovs_of_type1";		// Общее кол-во ходов 
	public static final String 	APP_PREFERENCES_levels_of_type1_1	= 	"levels_of_type1_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type1_2	= 	"levels_of_type1_2";		// второй
	public static final String 	APP_PREFERENCES_levels_of_type1_3	= 	"levels_of_type1_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_4	= 	"levels_of_type1_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_5	= 	"levels_of_type1_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_6	= 	"levels_of_type1_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_7	= 	"levels_of_type1_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_8	= 	"levels_of_type1_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_9	= 	"levels_of_type1_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_10	= 	"levels_of_type1_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_11	= 	"levels_of_type1_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_12	= 	"levels_of_type1_12";		// 

	// Уровень 2
	public static final String 	APP_PREFERENCES_moovs_of_type2		= 	"moovs_of_type2";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_1	= 	"levels_of_type2_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type2_2	= 	"levels_of_type2_2";		// второй
	public static final String 	APP_PREFERENCES_levels_of_type2_3	= 	"levels_of_type2_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_4	= 	"levels_of_type2_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_5	= 	"levels_of_type2_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_6	= 	"levels_of_type2_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_7	= 	"levels_of_type2_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_8	= 	"levels_of_type2_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_9	= 	"levels_of_type2_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_10	= 	"levels_of_type2_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_11	= 	"levels_of_type2_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_12	= 	"levels_of_type2_12";		// 
    	
	// Уровень 3
	public static final String 	APP_PREFERENCES_moovs_of_type3		= 	"moovs_of_type3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_1	= 	"levels_of_type3_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type3_2	= 	"levels_of_type3_2";		// второй
	public static final String 	APP_PREFERENCES_levels_of_type3_3	= 	"levels_of_type3_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_4	= 	"levels_of_type3_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_5	= 	"levels_of_type3_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_6	= 	"levels_of_type3_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_7	= 	"levels_of_type3_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_8	= 	"levels_of_type3_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_9	= 	"levels_of_type3_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_10	= 	"levels_of_type3_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_11	= 	"levels_of_type3_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_12	= 	"levels_of_type3_12";		// 

	// Уровень 4
	public static final String 	APP_PREFERENCES_moovs_of_type4		= 	"moovs_of_type4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_1	= 	"levels_of_type4_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type4_2	= 	"levels_of_type4_2";		// второй
	public static final String 	APP_PREFERENCES_levels_of_type4_3	= 	"levels_of_type4_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_4	= 	"levels_of_type4_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_5	= 	"levels_of_type4_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_6	= 	"levels_of_type4_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_7	= 	"levels_of_type4_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_8	= 	"levels_of_type4_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_9	= 	"levels_of_type4_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_10	= 	"levels_of_type4_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_11	= 	"levels_of_type4_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_12	= 	"levels_of_type4_12";		// 
	
	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Преференсес
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		PreferencesInit();
		
		
		
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

	
	
	public void PreferencesInit() 
	{
		// Если НЕ существует переменной FirstRun(да собственно как и любой другой) значит приложение еще не запускалось
		// проводим инициализацию всех переменных в начальное положение
		if (!mSettings.contains(APP_PREFERENCES_FirstRun)) 
		{ 
			preferences_editor = mSettings.edit();
			// Общие настройки
			preferences_editor.putInt(APP_PREFERENCES_FirstRun, 1);
			preferences_editor.putInt(APP_PREFERENCES_menu_fonBG, 		0);	// Фон поумолчанию
			preferences_editor.putInt(APP_PREFERENCES_menu_sound, 		1);	// Звуки нажатий включены
			preferences_editor.putInt(APP_PREFERENCES_menu_volume, 		1);	// музыка ВКЛ
			
			// Настройки игры
			preferences_editor.putInt(APP_PREFERENCES_moovs_of_type1, 	0);	// Общее кол-во ходов на легком (1) уровне игры
			preferences_editor.putInt(APP_PREFERENCES_moovs_of_type2, 	0);	// Общее кол-во ходов на среднем (2) уровне игры
			preferences_editor.putInt(APP_PREFERENCES_moovs_of_type3, 	0);	// Общее кол-во ходов на легком (3) уровне игры
			preferences_editor.putInt(APP_PREFERENCES_moovs_of_type4, 	0);	// Общее кол-во ходов на легком (4) уровне игры
			
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_1,	0);		//	Тип 1. Уровень 1
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_2,	0);		//	Тип 1. Уровень 2
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_3,	0);		//	Тип 1. Уровень 3
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_4,	0);		//	Тип 1. Уровень 4
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_5,	0);		//	Тип 1. Уровень 5
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_6,	0);		//	Тип 1. Уровень 6
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_7,	0);		//	Тип 1. Уровень 7
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_8,	0);		//	Тип 1. Уровень 8
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_9,	0);		//	Тип 1. Уровень 9
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_10,	0);		//	Тип 1. Уровень 10
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_11,	0);		//	Тип 1. Уровень 11
			preferences_editor.putInt(APP_PREFERENCES_levels_of_type1_12,	0);		//	Тип 1. Уровень 12
			
			preferences_editor.apply();
		}
		
	}
	
	
		
	
	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();

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

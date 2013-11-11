package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends Activity {

	TextView textStartGame,textStartGame1,textStartGame2,textStartGame3;
	Animation menu_animation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Установка шрифта текстовым полям
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
		final TextView textStartGame4 = (TextView)findViewById(R.id.textView11);
				
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
		// нимируем меню
		textStartGame.startAnimation(menu_animation);
		
		// отсюда идем в окно выбора типа игры
		Intent intentG = new Intent();
		intentG.setClass(MainActivity.this, Type.class);
		startActivity(intentG);
	}
	
	
	public void OnClickSettings(View v) 
	{
		textStartGame1.startAnimation(menu_animation);
		Intent inten1 = new Intent();
		inten1.setClass(MainActivity.this, SettingsActivity.class);
		startActivity(inten1);
	}
	
	public void OnClickAbout(View v) 
	{
		textStartGame2.startAnimation(menu_animation);
		Intent inten2 = new Intent();
		inten2.setClass(MainActivity.this, AboutActivity.class);
		startActivity(inten2);
	};
	
	public void OnClickExit(View v) 
	{
		textStartGame3.startAnimation(menu_animation);
		finish();
	}
	
}

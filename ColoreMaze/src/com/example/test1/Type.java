package com.example.test1;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Type extends Activity {

	private SoundPool soundPool;
	private static int soundID1;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_typeof_game);
		
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		// Загружаем звуки в память
		soundID1 = soundPool.load(this, R.raw.btn1, 1);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new gridAdapter_TypeImage(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,	int position, long id) {
				soundPool.play(soundID1, 1, 1, 1, 0, 1f);
				// Переходим к выбору уровней
				Intent intentG = new Intent();
				intentG.setClass(Type.this, Levels.class);
				intentG.putExtra("from_type_tolevels_tog", position);// передаём в левел какой тип игры выбран
				startActivity(intentG);

				switch (position) {
				case 0:	overridePendingTransition(R.anim.activity_slide_left_in,	R.anim.activity_slide_left_out);			break; // Активность уходит влево
				case 2:	overridePendingTransition(R.anim.activity_slide_right_in,	R.anim.activity_slide_right_out);			break; // Активность уходит вправо
				case 3:	overridePendingTransition(R.anim.activity_slide_up_in,		R.anim.activity_slide_up_out);				break; // Активность уходит вниз
				case 1:	overridePendingTransition(R.anim.activity_slide_down_in,	R.anim.activity_slide_down_out);			break; // Активность уходит вверх
				default:					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.typeof_game, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

		// Завершаем наше activity
		this.finish();

		overridePendingTransition(R.anim.activity_zoom_in,
				R.anim.activity_zoom_out);
	}

}

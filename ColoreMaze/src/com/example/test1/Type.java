package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Type extends Activity {

	private Animation 		animation_wrong_moovs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_typeof_game);
		
		// подключаем файл анимации
		animation_wrong_moovs = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);

		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new gridAdapter_TypeImage(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,	int position, long id) {
				
				if (position==0) {
					Intent intentG = new Intent();
					intentG.setClass(Type.this, Levels.class);
					intentG.putExtra("from_type_tolevels_tog", position);
					startActivity(intentG);

					switch (position) {
					case 0:	overridePendingTransition(R.anim.activity_slide_left_in,	R.anim.activity_slide_left_out);			break; // ���������� ������ �����
					case 2:	overridePendingTransition(R.anim.activity_slide_right_in,	R.anim.activity_slide_right_out);			break; // ���������� ������ ������
					case 3:	overridePendingTransition(R.anim.activity_slide_up_in,		R.anim.activity_slide_up_out);				break; // ���������� ������ ����
					case 1:	overridePendingTransition(R.anim.activity_slide_down_in,	R.anim.activity_slide_down_out);			break; // ���������� ������ �����
					default:					break;
					}
				}
				else 	{	parent.getChildAt(position).startAnimation(animation_wrong_moovs);	}
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

		this.finish();

		overridePendingTransition(R.anim.activity_zoom_in,
				R.anim.activity_zoom_out);
	}

}

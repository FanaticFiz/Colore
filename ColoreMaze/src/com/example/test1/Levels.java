package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class Levels extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_levels);
		
		GridView gridview = (GridView) findViewById(R.id.levelselect);
	    gridview.setAdapter(new gridAdapter_LevelsImage(this));
	    
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
	        {
	        	// Прыгаем в Игру
	        	Intent intentG = new Intent();
	    		intentG.setClass(Levels.this, game_gameActivity.class);
	    		startActivity(intentG);	        	
	        }
	    });			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.levels, menu);
		return true;
	}

}

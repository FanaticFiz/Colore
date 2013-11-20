package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Type extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_typeof_game);
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new gridAdapter_TypeImage(this));
	    	    	
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
	        {
	        	// Переходим к выбору уровней
	        	Intent intentG = new Intent();
	    		intentG.setClass(Type.this, Levels.class);
	    		startActivity(intentG);	        	
	        }
	    });
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.typeof_game, menu);
		return true;
	}

	

}

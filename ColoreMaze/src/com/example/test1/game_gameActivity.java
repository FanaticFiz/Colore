package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;


public class game_gameActivity extends Activity {

	//private TextView mSelectText;
	private GridView mGrid;
	private game_gridadapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		//********* Place for some test code * ***************
		//mSelectText = (TextView) findViewById(R.id.textView11);
		
		
		////**************************************************
		// ѕрив€зываемс€ к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(10);
        mGrid.setEnabled(true);
        mAdapter = new game_gridadapter(this, 10, 20);
        mGrid.setAdapter(mAdapter);
			
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

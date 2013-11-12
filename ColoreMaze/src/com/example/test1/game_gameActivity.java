package com.example.test1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;


public class game_gameActivity extends Activity {

	//private TextView mSelectText;
	private GridView mGrid;
	private gridadapter_Game mAdapter;
			
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		// Получаем массив из предыдущей активити 
		ArrayList<String> arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
				
		////**************************************************
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(10);
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel);
        mGrid.setAdapter(mAdapter);
	
        // Обработчик нажатий
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
                // Do  
            	//mAdapter.getItemId(position);
            	
            	TextView someText = (TextView)findViewById(R.id.textView1);
                someText.setText("ID: "+id+"  Position: "+position);
            	            	
                }
        	});
	}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

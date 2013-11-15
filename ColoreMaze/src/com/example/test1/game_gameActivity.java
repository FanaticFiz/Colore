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
	private int p,LastMoov;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		p=0;LastMoov=0;
		
		// �������� ������ �� ���������� �������� 
		ArrayList<String> arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
				
		////**************************************************
		// ������������� � ���� �� �����, ����������� ���� ��� �� ��������, ���������� ���� ����������� 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(10);
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel);
        mGrid.setAdapter(mAdapter);
	
        // ���������� �������
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
            		// 	Do
            		game_move(position, v);
        
            		//TextView someText = (TextView)findViewById(R.id.textView1);
                    //someText.setText("ID: "+id+"  Position: "+position);
                	
                }
        	});
	}

	
	//
	public void game_move(int position, View v) 
	{
	
		// ����� ������������ ������� �� �������...
		// ����� ������ ���������: 
		//
		//-----------------------------------------------------------------------------------------------
		// ���������� ������ ��������� �������, ��������� �� ��� ������ � ����������� ���������� ��������
		if (p==0)		{	p++;	
			//TextView someText = (TextView)findViewById(R.id.textView1);
			//someText.setText("Last moov is="+LastMoov+" Now you taped on"+position);
			mGrid.getChildAt(LastMoov).setScaleX((float) 1);
	    	mGrid.getChildAt(LastMoov).setScaleY((float) 1);
	    	LastMoov=position;
	    	mGrid.getChildAt(position).setScaleX((float) 0.7);
	    	mGrid.getChildAt(position).setScaleY((float) 0.7);	}
		else			{	p--;	
			//TextView someText = (TextView)findViewById(R.id.textView1);
			//someText.setText("Last moov is="+LastMoov+" Now you taped on"+position);
			mGrid.getChildAt(LastMoov).setScaleX((float) 1);
	    	mGrid.getChildAt(LastMoov).setScaleY((float) 1);
	    	LastMoov=position;
	    	mGrid.getChildAt(position).setScaleX((float) 0.7);
	    	mGrid.getChildAt(position).setScaleY((float) 0.7);	}
		//-----------------------------------------------------------------------------------------------
		
		// � ������� ������ � ����������� �� ����� ���������� ���� ������ ����� ������... 
		// ���� � ��� � ���� ������ ������������ ������� �� ���� ��������� � ������ �� ��� ���� ������ ����� ������� ���...
		//

		
	}
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

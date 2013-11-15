package com.example.test1;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class game_gameActivity extends Activity {

	//private TextView mSelectText;
	private GridView mGrid;
	private gridadapter_Game mAdapter;
	private int p,LastMoov;
	ArrayList<String> arrayfromlevel;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		p=0;LastMoov=0;
		
		// �������� ������ �� ���������� �������� 
		arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
				
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
            		game_move(parent, position, v);
        
            		//TextView someText = (TextView)findViewById(R.id.textView1);
                    //someText.setText("ID: "+id+"  Position: "+position);
                	
                }
        	});
	}

	
	//
	public void game_move(AdapterView<?> parent, int position, View v) 
	{
	
		// ����� ������������ ������� �� �������...
		// ����� ������ ���������: 
		// ����� �� ����� ���������� ����� ���� ������� ����������� � ��� ��� 
		// ����� ����� ������/������ �� ��������� ����
		//
		//-----------------------------------------------------------------------------------------------
		// ���������� ������ ��������� �������, ��������� �� ��� ������ � ����������� ���������� ��������
		if (p==0)		{	p++;	
			//TextView someText = (TextView)findViewById(R.id.textView1);
			//someText.setText("Last moov is="+LastMoov+" Now you taped on"+position);
			parent.getChildAt(LastMoov).setScaleX((float) 1);
			parent.getChildAt(LastMoov).setScaleY((float) 1);
	    	LastMoov=position;
	    	v.setScaleX((float) 0.7);
	    	v.setScaleY((float) 0.7);	}
		else			{	p--;	
			//TextView someText = (TextView)findViewById(R.id.textView1);
			//someText.setText("Last moov is="+LastMoov+" Now you taped on"+position);
			parent.getChildAt(LastMoov).setScaleX((float) 1);
	    	parent.getChildAt(LastMoov).setScaleY((float) 1);
	    	LastMoov=position;
	    	v.setScaleX((float) 0.7);
	    	v.setScaleY((float) 0.7);	}
		//-----------------------------------------------------------------------------------------------
		
	
		// �������� ��� ����� ������� �� �������� �� ��������� 
		// ����� ��������� ���� ��������
		// �������� � ������� ������� ��� �������� ������ �� ���� � ����
    	// � ����������� �� ����������� ������ ������ ������� �� �������� ����� � �������� .png
    	// �� ������ ������ 
    	// 	0	-	����� 
    	// 	1 	-	������
    	//	2	-	����������
    	// 	3	-	����� 
    	// 	4 	-	�������	
    	//	5	-	�������
    	// 	6	-	����� 
    	// 	7 	-	���������	
    	//	8	-	���������
    	// 	9	-	������� 
    	// 	10	-	����������	
    	//	11	-	������
    	// 	12	-	�������	
		String Name_of_file = arrayfromlevel.get(position);
		switch (Name_of_file) 
		{
		case "ball0":
			
			break;

		default:
			break;
		}
		
		
	}
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

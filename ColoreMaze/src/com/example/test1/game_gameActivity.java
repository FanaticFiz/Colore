package com.example.test1;

import java.util.ArrayList;

import android.R.integer;
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
	ArrayList<String> arrayfromlevel;
	private String ColorBall;
	
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
		
		String Name_of_file = arrayfromlevel.get(position).replaceAll("[^0-9]+", " ");
		Name_of_file = Name_of_file.trim();
		Integer ert = Integer.parseInt(Name_of_file);
		
		
		TextView someText = (TextView)findViewById(R.id.textView1);
		switch (ert) 
		{
		case 0:
			ColorBall = "�����";
			someText.setText("���� = "+ColorBall);
			break;
		case 1:
			ColorBall = "������";
			someText.setText("���� = "+ColorBall);
			break;
		case 2:
			ColorBall = "����������";
			someText.setText("���� = "+ColorBall);
			break;
		case 3:
			ColorBall = "�����";
			someText.setText("���� = "+ColorBall);
			break;
		case 4:
			ColorBall = "�������";
			someText.setText("���� = "+ColorBall);
			break;
		case 5:
			ColorBall = "�������";
			someText.setText("���� = "+ColorBall);
			break;
		case 6:
			ColorBall = "�����";
			someText.setText("���� = "+ColorBall);
			break;
		case 7:
			ColorBall = "���������";
			someText.setText("���� = "+ColorBall);
			break;
		case 8:
			ColorBall = "���������";
			someText.setText("���� = "+ColorBall);
			break;
		case 9:
			ColorBall = "�������";
			someText.setText("���� = "+ColorBall);
			break;
		case 10:
			ColorBall = "����������";
			someText.setText("���� = "+ColorBall);
			break;
		case 11:
			ColorBall = "������";
			someText.setText("���� = "+ColorBall);
			break;
		case 12:
			ColorBall = "�������";
			someText.setText("���� = "+ColorBall);
			break;
		default:
			ColorBall = "����� ��������� )))";
			someText.setText("���� = "+ColorBall);
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

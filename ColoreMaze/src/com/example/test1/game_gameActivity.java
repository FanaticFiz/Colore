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

	private GridView mGrid;
	private gridadapter_Game mAdapter;
	private int LastMoov;
	ArrayList<String> arrayfromlevel;	// ������ ���������� �� ���������� ���������� �������� �������� �������� ���� / ������-������ ��������� �����
	int[] array_legal_moovs;
	private String ColorBall;		
	TextView someText;    			//	���� ��� ������� �����
	boolean firstTouch = true;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		LastMoov=0;
		array_legal_moovs = new int[4];
		
		// �������� ������ �� ���������� �������� 
		arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
		
		//�������� �� ������� ��������� �� �����
		someText = (TextView)findViewById(R.id.textView1);
		someText.setText("������� ������! �������� ��� ������...");
		
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
                 	
            		// ����������� ������ �������
        			if (firstTouch) 
        			{
        				someText.setText("����: ������ �� ������� ���� � ������");
        				// 	��� ������ ������ ������� � ������� ������-��������� ����� 
        				// 	��������������� �� ��� � ���������� ��������� ��������� ����
        				for (int i=0; i<arrayfromlevel.size(); i++) 
        				{
        					if (arrayfromlevel.get(i)=="ball1") 
        					{
        						parent.getChildAt(i).setScaleX((float) 0.7);
        						parent.getChildAt(i).setScaleY((float) 0.7);
        						// ���������� ��������� ���� (�� ������ ���� �� ���� 4 ������������)
        						array_legal_moovs[0] = i-1;
        						array_legal_moovs[1] = i+1;
        						array_legal_moovs[2] = i-10;
        						array_legal_moovs[3] = i+10;	
        						// ������� �� ��� ������
        						Cheking_legal_moovs();
        						LastMoov = i;
        					}
        				}  
        				firstTouch = false;        				
        			}	else	
        				{	
        					game_move(parent, position, v);
        				}                	
                }
        	});
	}

	
	//
	public void game_move(AdapterView<?> parent, int position, View v) {

		if ((array_legal_moovs[0] == position)| (array_legal_moovs[1] == position)| (array_legal_moovs[2] == position)| (array_legal_moovs[3] == position)) 
		{

			// -----------------------------------------------------------------------------------------------
			// ��������� �� ��� ������ � ����������� ���������� ��������
			parent.getChildAt(LastMoov).setScaleX((float) 1);
			parent.getChildAt(LastMoov).setScaleY((float) 1);
			LastMoov = position;
			v.setScaleX((float) 0.7);
			v.setScaleY((float) 0.7);
			// -----------------------------------------------------------------------------------------------

			// �������� ��� ����� ������� �� �������� �� ���������
			// ����� ��������� ���� ��������
			// �������� � ������� ������� ��� �������� ������ �� ���� � ������
			//
			// �� ������ ������
			// 0 - ����� - �����
			// 1 - ������ - �����
			// 2 - ���������� - �����, ������
			// 3 - ����� - �����
			// 4 - ������� - �����, ������
			// 5 - ������� - ������, ����
			// 6 - ����� - ����, �����
			// 7 - ��������� - �����, ����
			// 8 - ��������� - ������
			// 9 - ������� - �����
			// 10 - ���������� - �����, ������, ����
			// 11 - ������ - �����, �����
			// 12 - ������� - �����, ����, �����
			// 13 - ����������!!! -
			// 14 - ������ - ����

			// ����������� ����� �� �������� �����
			Integer ert = NumberFromName(arrayfromlevel.get(position));

			switch (ert) {
			case 0:
				// �����
				ColorBall = "�����������, �� ��������!!!";
				someText.setText("���� = " + ColorBall);
				break;
			case 1:
				// �����
				ColorBall = "�������� �� ����� �����...";
				someText.setText("���� = " + ColorBall);
				// �� ��������� ������ �������� ��� �� ���� ������������, ������ ��� � ���� ������ ��������� ��������� ������ ���������
				// ����� �� � ������ ��������� ����� �������� ��� ��������, � ��� ������������� ���� �� ������� ���������
				// ���� ������������� � ������ �����... � ����� � �� ���� ������������ �����, ��������� ������ �� �� ���� ��� ����� �� ���������...
						
				array_legal_moovs[0] = position - 1; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
				array_legal_moovs[2] = position - 10;
				array_legal_moovs[3] = position + 10; 
				
				Cheking_legal_moovs();
				
				break;
			case 2:
				ColorBall = "����������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 1; 	// ������� � ������
				array_legal_moovs[1] = position + 1; 	// ���������� ������ ���� �������� ���.
				array_legal_moovs[2] = 10000;	 		// �������� ������� �������
				array_legal_moovs[3] = 10000;			// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 3:
				ColorBall = "�����";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 10; // ������� � ������
				array_legal_moovs[1] = 10000;	 // ���������� ������ ���� ��������
												// ���.
				array_legal_moovs[2] = 10000; 	// �������� ������� �������
				array_legal_moovs[3] = 10000; 	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 4:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 10; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 5:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 1; // ������� � ������
				array_legal_moovs[1] = position + 10; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 6:
				ColorBall = "�����";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 10; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 7:
				ColorBall = "���������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 10; // ������� � ������
				array_legal_moovs[1] = position + 10; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 8:
				ColorBall = "���������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 1; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
												// ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 9:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 1; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
												// ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 10:
				ColorBall = "����������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 10; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = position + 10; // �������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 11:
				ColorBall = "������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 10; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 12:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 10; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = position + 10; // �������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;
			case 13:
				ColorBall = "�� ����� ��� �����? )))";
				someText.setText("���� = " + ColorBall);

				break;
			case 14:
				ColorBall = "��������� ))";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 10; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
												// ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				break;

			default:
				ColorBall = "����� ��������� )))";
				someText.setText("���� = " + ColorBall);
				break;
			}

		} else {	someText.setText("���� ��� ����������..."); 	}

	}
	
	public Integer NumberFromName(String name) 
	{
		name = name.replaceAll("[^0-9]+", " "); // ������� ��� ������� ����� �����
		name = name.trim();						// ������� �������
		return Integer.parseInt(name);			// ���������� �����
	}
	
	
	// ������� ������� ������� ���� �� ������� ��������� �����, �� ��������� ����� ��������� ��� ����� ����� ������ � ������ �������������.
	// ��� �������� ������ ������ ����� ���������� ������� ��������� �����.
	// �.�. �� ��� ��������� ����� ���������� �� ��� ������������ ��������
	public void Cheking_legal_moovs()
	{
		for (int i = 0; i < array_legal_moovs.length; i++) 
		{
			// ������������ ��� ��������� ���� �� ���������� �� ������� ��������� �� ������� �������� �������
			if ( (array_legal_moovs[i] <= arrayfromlevel.size()) & (array_legal_moovs[i] >= 0) )	
			{									}			
			else 
			{	array_legal_moovs[i] = 10000;	} 
		}
	}
	
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

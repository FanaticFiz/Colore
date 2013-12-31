package com.example.test1;

import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class game_gameActivity extends Activity {

	private GridView 			mGrid;
	private Dialog				dialog_end_of_game;	
	private gridadapter_Game 	mAdapter;
	private int 				LastMoov,Moovs_counter;
	ArrayList<String> 			arrayfromlevel;			// ������ ���������� �� ���������� ���������� �������� �������� �������� ���� 
	int[] 						array_legal_moovs;		//  ������-������ ��������� �����
	private String 				ColorBall;		
	TextView 					someText,TimerField;    			//	���� ��� ������� �����
	boolean 					firstTouch = true;
	byte 						Sqrt_from_arraysize;
	long 						Start_Time,End_Time;
	String ss = System.getProperty("line.separator");
	int randomBG;
	
	// ������
	int seconds;
	private Timer timer    = null;
	private long startTime;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		
		// ������ � ����� ������ ������������� ���� � ������ ������� �� 30 ������ �� 0
		/*
		TimerField = (TextView)findViewById(R.id.textView2);		
		 new CountDownTimer(30000, 1000) 
		 {
		     public void onTick(long millisUntilFinished) 
		     {
		    	 TimerField.setText("seconds remaining: " + millisUntilFinished / 1000);
		     }
		     public void onFinish() 
		     {
		    	 TimerField.setText("done!");
		     }
		 }.start();
		*/
		 
		TimerField = (TextView)findViewById(R.id.textView1);
		class UpdateTimeTask extends TimerTask 
		{
		   public void run() 
		   {
		       /*
			   long millis = System.currentTimeMillis() - startTime;
		       int seconds = (int) (millis / 1000);
		       int minutes = seconds / 60;
		       seconds     = seconds % 60;
		       //TimerField.setText(String.format("%d:%02d", minutes, seconds));
		        * 
		        */
		       
			   seconds++;
			   TimerField.setText("� ����� �� ���� "+seconds);
		       
		       
		   }
		}
		
		startTime = System.currentTimeMillis();
		timer = new Timer();
		timer.schedule(new UpdateTimeTask(), 0, 1000);
		
		
		
		LastMoov=0;Moovs_counter=0;
		array_legal_moovs = new int[4];
		
		// �������� ������ �� ���������� �������� 
		arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
		Sqrt_from_arraysize = (byte) Math.sqrt(arrayfromlevel.size()); //�������� ������� �������� � �������

		RandomBackground();
		
			
		//�������� �� ������� ��������� �� �����
		someText = (TextView)findViewById(R.id.textView1);
		someText.setText("����: ������ �� ������� ���� � ������");
		
		/*// �������� ���������� ����, ������������ ��� ����������� ������ 
		dialog_end_of_game = new Dialog(game_gameActivity.this);
		dialog_end_of_game.setContentView(R.layout.dialog_end_levels);
		dialog_end_of_game.setTitle(R.string.Dialog_end_of_game_Title);
		dialog_end_of_game.setCancelable(false);
		*/
		
		
		
			
		////**************************************************
		// ������������� � ���� �� �����, ����������� ���� ��� �� ��������, ���������� ���� ����������� 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(Sqrt_from_arraysize);					// ������ ���-�� ������� � �����������
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel);
        mGrid.setAdapter(mAdapter);
        
                
        // ������� ��������� �����
        Find_Start_Point();     
         
        
        Start_Time = System.currentTimeMillis();
        
        // ���������� �������
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
                 	game_move(parent, position, v);
                 	someText.setText("BG="+randomBG+"  ���-�� �����: "+Moovs_counter);
        		}                	
             
        	});
        
	}

	
	// 	��� ������ ������ ������� � ������� ������-��������� ����� 
	// 	��������������� �� ��� � ���������� ��������� ��������� ����
	public void Find_Start_Point() 
	{
		for (int i=0; i<arrayfromlevel.size(); i++) 
		{
			if (arrayfromlevel.get(i)=="ball1") 
			{
				// ���������� ��������� ���� (�� ������ ���� �� ���� 4 ������������)
				array_legal_moovs[0] = i-1;
				array_legal_moovs[1] = i+1;
				array_legal_moovs[2] = i-Sqrt_from_arraysize;
				array_legal_moovs[3] = i+Sqrt_from_arraysize;	
				// 	������� �� ��� ������
				Cheking_legal_moovs();
				LastMoov = i;
			}
		}  
	}
	
	
	
	// ���������� �������� ��� ����...
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
				array_legal_moovs[0] = 10000; // ����� ����
				array_legal_moovs[1] = 10000; // ������ ������ ������
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = 10000;
				Moovs_counter++;
				
				End_Time = System.currentTimeMillis();
			
				ShowGameOver();
				
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
				array_legal_moovs[2] = position - Sqrt_from_arraysize;
				array_legal_moovs[3] = position + Sqrt_from_arraysize; 
				
				Cheking_legal_moovs();
				Moovs_counter++;
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
				Moovs_counter++;
				break;
			case 3:
				ColorBall = "�����";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = 10000;	 // ���������� ������ ���� ��������
												// ���.
				array_legal_moovs[2] = 10000; 	// �������� ������� �������
				array_legal_moovs[3] = 10000; 	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
				break;
			case 4:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
				break;
			case 5:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 1; // ������� � ������
				array_legal_moovs[1] = position + Sqrt_from_arraysize; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
				break;
			case 6:
				ColorBall = "�����";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
				break;
			case 7:
				ColorBall = "���������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = position + Sqrt_from_arraysize; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
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
				Moovs_counter++;
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
				Moovs_counter++;
				break;
			case 10:
				ColorBall = "����������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = position + Sqrt_from_arraysize; // �������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
				break;
			case 11:
				ColorBall = "������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
				break;
			case 12:
				ColorBall = "�������";
				someText.setText("���� = " + ColorBall);
				// ��������� �� ��� ���� ���������
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
														// �������� ���.
				array_legal_moovs[2] = position + Sqrt_from_arraysize; // �������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
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
				array_legal_moovs[0] = position + Sqrt_from_arraysize; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
												// ���.
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				Moovs_counter++;
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

	private void RandomBackground() 
	{
		LinearLayout LinLayout = (LinearLayout) findViewById(R.id.LinearLayout_of_Game);
		
				
		randomBG = (int) (Math.random()*26);
		String stringBG = "bgstyle"+randomBG;
		
		Resources mRes = this.getResources();
		Integer identifierID = mRes.getIdentifier(stringBG, "drawable", this.getPackageName());
		LinLayout.setBackgroundResource(identifierID);
	}
	
	
	private void ShowGameOver() {
		 
	    // ���������� ����
	    AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
	 
	    // ��������� � �����
	    alertbox.setTitle("�����������!");
	    
	    
	    int inTime = (int) ((End_Time - Start_Time)/1000);
	    
	    String TextToast = "���-�� �����: "+ Moovs_counter+ss+"�����: "+inTime;
	    alertbox.setMessage(TextToast);
	 
	    // ��������� ������ 
	    alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface arg0, int arg1) {
	        // ��������� ������� Activity
	        finish();
	      }
	    });
	    // ���������� ����
	    alertbox.show();
	  }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

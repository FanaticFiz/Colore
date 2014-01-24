package com.example.test1;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class game_gameActivity extends Activity {

	private Animation 			animation_wrong_moovs;
	private GridView 			mGrid;
	//private Dialog			dialog_end_of_game;
	private gridadapter_Game 	mAdapter;
	private int 				LastMoov,Moovs_counter,moovs_counter_all;
	ArrayList<String> 			arrayfromlevel;			// ������ ���������� �� ���������� ���������� �������� �������� �������� ���� 
	int[] 						array_legal_moovs;		//  ������-������ ��������� �����
	private String 				ColorBall,XMLgame_type;	// XMLgame_type - ����������� � XML ����� ������� ����	
	private TextView			someText,TimerField,MoovField;    			//	���� ��� ������� �����
	boolean 					firstTouch = true;
	int 						type_game_from,counter_col,number_of_level;
	long 						Start_Time,End_Time;
	int 						randomBG;
	ImageButton 				ImbuttonReset;
	                                           
	String ss = System.getProperty("line.separator"); // ������ �����������
	
	// Preferences
	SharedPreferences mSettings;
	Editor editor;
	public static final String 	APP_PREFERENCES = "mysettings";  							// ��� ����� ��������
	
	// ������� 1
	// ������ ������ �������� ��� ���������� �� ����������� ���� ������� ������� ����
	// ������ 24 ��������� �������� � ���� ���-�� ����� �� ������� ������ �� ������� �������...
	// ������ ������� ���� ����� ������� ��� 0 ������������� �������� ��� ������� ��� �������! (��� ����������� ��� ���� ������� ����� �������)
	// ��������� �������� ��� ����� ���-�� �����
	//private static int[] 		pref_type1_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,	0};
	public static final String 	APP_PREFERENCES_moovs_of_type1		= 	"moovs_of_type1";		// ����� ���-�� ����� 
	public static final String 	APP_PREFERENCES_levels_of_type1_1	= 	"levels_of_type1_1";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type1_2	= 	"levels_of_type1_2";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type1_3	= 	"levels_of_type1_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_4	= 	"levels_of_type1_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_5	= 	"levels_of_type1_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_6	= 	"levels_of_type1_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_7	= 	"levels_of_type1_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_8	= 	"levels_of_type1_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_9	= 	"levels_of_type1_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_10	= 	"levels_of_type1_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_11	= 	"levels_of_type1_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type1_12	= 	"levels_of_type1_12";		// 

	// ������� 2
	//private static int[] 		pref_type2_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0};
	public static final String 	APP_PREFERENCES_moovs_of_type2		= 	"moovs_of_type2";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_1	= 	"levels_of_type2_1";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type2_2	= 	"levels_of_type2_2";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type2_3	= 	"levels_of_type2_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_4	= 	"levels_of_type2_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_5	= 	"levels_of_type2_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_6	= 	"levels_of_type2_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_7	= 	"levels_of_type2_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_8	= 	"levels_of_type2_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_9	= 	"levels_of_type2_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_10	= 	"levels_of_type2_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_11	= 	"levels_of_type2_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_12	= 	"levels_of_type2_12";		// 
    	
	// ������� 3
	//private static int[] 		pref_type3_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0};
	public static final String 	APP_PREFERENCES_moovs_of_type3		= 	"moovs_of_type3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_1	= 	"levels_of_type3_1";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type3_2	= 	"levels_of_type3_2";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type3_3	= 	"levels_of_type3_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_4	= 	"levels_of_type3_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_5	= 	"levels_of_type3_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_6	= 	"levels_of_type3_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_7	= 	"levels_of_type3_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_8	= 	"levels_of_type3_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_9	= 	"levels_of_type3_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_10	= 	"levels_of_type3_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_11	= 	"levels_of_type3_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_12	= 	"levels_of_type3_12";		// 

	// ������� 4
	public static final String 	APP_PREFERENCES_moovs_of_type4		= 	"moovs_of_type4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_1	= 	"levels_of_type4_1";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type4_2	= 	"levels_of_type4_2";		// ������
	public static final String 	APP_PREFERENCES_levels_of_type4_3	= 	"levels_of_type4_3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_4	= 	"levels_of_type4_4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_5	= 	"levels_of_type4_5";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_6	= 	"levels_of_type4_6";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_7	= 	"levels_of_type4_7";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_8	= 	"levels_of_type4_8";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_9	= 	"levels_of_type4_9";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_10	= 	"levels_of_type4_10";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_11	= 	"levels_of_type4_11";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_12	= 	"levels_of_type4_12";		// 
	
	// ������
	private int seconds,minutes,hours;
	private Timer timer    = null;
	private long startTime;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		 
		
		//	
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		
		if (mSettings.contains(APP_PREFERENCES_moovs_of_type1)) 
		{	
			moovs_counter_all = mSettings.getInt(APP_PREFERENCES_moovs_of_type1, 0);	
		}
		
		
		// ------------------------------------------------------------------------------------------------		
		// ---------------------- ������� ������ � ������� � ��������� ���� ��������� ---------------------
		// ------------------------------------------------------------------------------------------------
		
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

		final Handler handlerUI = new Handler();
		TimerField = (TextView)findViewById(R.id.game_up_text1);
		
		class UpdateTimeTask extends TimerTask 
		{
		   public void run() 
		   {
			   long millis = System.currentTimeMillis() - startTime;
		       seconds 	= 	(int) (millis / 1000);
		       minutes 	= 	seconds / 60;
		       hours	=	minutes	/ 60;
		       
		       minutes	=	minutes % 60;
		       seconds  = 	seconds % 60;
		       
		       // ������ ���������� � ��������� UI(user interf.) ������ �� ������� ������.
		       // ������� ���������� handler 
		       handlerUI.post(new Runnable()	{
		       public void run()    			{
		    	    if (hours>0)  	{	TimerField.setText(String.format("%d:%02d:%02d", hours, minutes, seconds));	} 
		    	    else 			{	TimerField.setText(String.format("%d:%02d", minutes, seconds));	} 
		    	   								}
		       									});       
		   }
		}
		
		startTime = System.currentTimeMillis();
		timer = new Timer();
		timer.schedule(new UpdateTimeTask(), 0, 1000);

		// ------------------------------------------------------------------------------------------------		
		// ------------------------------------------------------------------------------------------------
		// ------------------------------------------------------------------------------------------------
		
		// ���������� ���� ��������
		animation_wrong_moovs = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
	
		
		LastMoov=0;
		array_legal_moovs = new int[4];
		
		// �������� ������ �� ���������� ��������. ������� ������ � ���-�� ����� � �������� � ������� ���� 
		arrayfromlevel 	=	getIntent().getExtras().getStringArrayList("FromLeveltogame");
		counter_col		=	getIntent().getExtras().getInt("from_level_to_game_col");
		type_game_from	=	getIntent().getExtras().getInt("from_level_to_game_type");
		number_of_level =	1 + getIntent().getExtras().getInt("from_level_to_game_number_of_level");
		XMLgame_type	=	getIntent().getExtras().getString("from_level_to_game_XMLgame_type");
		
		
		RandomBackground();
		
			
		//�������� �� ������� ��������� �� �����
		MoovField = (TextView)findViewById(R.id.game_up_text2);
		MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
		
		someText = (TextView)findViewById(R.id.game_down_text);
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
        mGrid.setNumColumns(counter_col);					// ������ ���-�� ������� � �����������
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel,XMLgame_type);
        mGrid.setAdapter(mAdapter);
        
                
        // ������� ��������� �����
        Find_Start_Point();     
         
        
        Start_Time = System.currentTimeMillis();
        
        
        
        // ���������� �������
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
                 	if (NumberFromName(arrayfromlevel.get(position))==13) 
                 	{						}
                 	else 	{
                 		
                 		someText.setText("����� ���� = "+randomBG);
                 		MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
                 		
                 		game_move(parent, position, v);
                 			}
        		}                	             
        	});     
      
	}

	   
    public void onResetClick(View v)
    {
    	
    	//mSettings.
    	
    	startTime = System.currentTimeMillis();
    	hours=0;minutes=0;seconds=0;
    	Moovs_counter=0;
    	MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
    	TimerField.setText(String.format("%d:%02d", minutes, seconds));
    	
    	mGrid.setAdapter(mAdapter);
    	
    	Find_Start_Point();
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
				array_legal_moovs[2] = i-counter_col;
				array_legal_moovs[3] = i+counter_col;	
				// 	������� �� ��� ������
				Cheking_legal_moovs();
				LastMoov = i;
			}
		}  
	}
	
	
	
	// ���������� �������� ��� ����...
	public void game_move(AdapterView<?> parent, int position, View v) 
	{
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

			//	�.�. ���� �� ���� ������ ������ �� ������� ��������� ���... �.�. �� ��� ��� ����� ������� ������� ����� � �� � ������ ��������� �����
			Moovs_counter++;
			
			
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
				// �������� ������
				timer.cancel();
				
				moovs_counter_all = moovs_counter_all + Moovs_counter;
									
				// ����� � �����������
				//������� ��� ����, ������� � ��������� ���-�� �����
				MySetPreferences(type_game_from, number_of_level,Moovs_counter);
				
				// ������ ����� ��������� ������
				array_legal_moovs[0] = 10000; // ����� ����
				array_legal_moovs[1] = 10000; // ������ ������ ������
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = 10000;
				
				// ���������� ���� ���������
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
				array_legal_moovs[2] = position - counter_col;
				array_legal_moovs[3] = position + counter_col; 
				
				Cheking_legal_moovs();
			
				break;
			case 2:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 1; 	// ������� � ������
				array_legal_moovs[1] = position + 1; 	// ���������� ������ ���� �������� ���.
				array_legal_moovs[2] = 10000;	 		// �������� ������� �������
				array_legal_moovs[3] = 10000;			// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 3:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - counter_col; // ������� � ������
				array_legal_moovs[1] = 10000;	 // ���������� ������ ���� ��������
				array_legal_moovs[2] = 10000; 	// �������� ������� �������
				array_legal_moovs[3] = 10000; 	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 4:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - counter_col; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 5:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 1; // ������� � ������
				array_legal_moovs[1] = position + counter_col; // ���������� ������ ����
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 6:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + counter_col; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 7:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - counter_col; // ������� � ������
				array_legal_moovs[1] = position + counter_col; // ���������� ������ ����
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 8:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + 1; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 9:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - 1; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 10:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - counter_col; // ������� � ������
				array_legal_moovs[1] = position + 1; // ���������� ������ ����
				array_legal_moovs[2] = position + counter_col; // �������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 11:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - counter_col; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ����
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 12:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position - counter_col; // ������� � ������
				array_legal_moovs[1] = position - 1; // ���������� ������ ���� �������� ���.										
				array_legal_moovs[2] = position + counter_col; // �������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;
			case 13:
				// ���� ������ �� ������� �� ������ �������, ��� �� ������ 13 ����������� � Cheking_legal_moovs
				break;
			case 14:
				// ���������� ���� ����� �����, ������� � ������
				array_legal_moovs[0] = position + counter_col; // ������� � ������
				array_legal_moovs[1] = 10000; // ���������� ������ ���� ��������
				array_legal_moovs[2] = 10000; // �������� ������� �������
				array_legal_moovs[3] = 10000;	// ����������� � 10000
				Cheking_legal_moovs();
				
				break;

			default:
				ColorBall = "����� ��������� )))";
				someText.setText("���� = " + ColorBall);
				break;
			}

		} 
		else 
		{	
			parent.getChildAt(position).startAnimation(animation_wrong_moovs);   
			someText.setText("���� ��� ����������..."); 	
		}

	}
	
	
	
	
	public void MySetPreferences(int type, int level, int mooves) 
	{
		editor = mSettings.edit();
		switch (type) 
		{
		case 0:
			// ����� ����� ���-�� �����
			editor.putInt(APP_PREFERENCES_moovs_of_type1,moovs_counter_all);
			// ����� � ���������� �������� ������ ���-�� ����� �� ������� ������  
			switch (level-1)		{
				case 0:	editor.putInt(APP_PREFERENCES_levels_of_type1_1,	mooves);	break;
				case 1:	editor.putInt(APP_PREFERENCES_levels_of_type1_2,	mooves);	break;
				case 2:	editor.putInt(APP_PREFERENCES_levels_of_type1_3,	mooves);	break;
				case 3:	editor.putInt(APP_PREFERENCES_levels_of_type1_4,	mooves);	break;
				case 4:	editor.putInt(APP_PREFERENCES_levels_of_type1_5,	mooves);	break;
				case 5:	editor.putInt(APP_PREFERENCES_levels_of_type1_6,	mooves);	break;
				case 6:	editor.putInt(APP_PREFERENCES_levels_of_type1_7,	mooves);	break;
				case 7:	editor.putInt(APP_PREFERENCES_levels_of_type1_8,	mooves);	break;
				case 8:	editor.putInt(APP_PREFERENCES_levels_of_type1_9,	mooves);	break;
				case 9:	editor.putInt(APP_PREFERENCES_levels_of_type1_10,	mooves);	break;
				case 10:editor.putInt(APP_PREFERENCES_levels_of_type1_11,	mooves);	break;
				case 11:editor.putInt(APP_PREFERENCES_levels_of_type1_12,	mooves);	break;
				default:	break;	}
		break;

		case 1:	
			editor.putInt(APP_PREFERENCES_moovs_of_type2,moovs_counter_all);
			switch (level-1)		{
				case 0:	editor.putInt(APP_PREFERENCES_levels_of_type2_1,	mooves);	break;
				case 1:	editor.putInt(APP_PREFERENCES_levels_of_type2_2,	mooves);	break;
				case 2:	editor.putInt(APP_PREFERENCES_levels_of_type2_3,	mooves);	break;
				case 3:	editor.putInt(APP_PREFERENCES_levels_of_type2_4,	mooves);	break;
				case 4:	editor.putInt(APP_PREFERENCES_levels_of_type2_5,	mooves);	break;
				case 5:	editor.putInt(APP_PREFERENCES_levels_of_type2_6,	mooves);	break;
				case 6:	editor.putInt(APP_PREFERENCES_levels_of_type2_7,	mooves);	break;
				case 7:	editor.putInt(APP_PREFERENCES_levels_of_type2_8,	mooves);	break;
				case 8:	editor.putInt(APP_PREFERENCES_levels_of_type2_9,	mooves);	break;
				case 9:	editor.putInt(APP_PREFERENCES_levels_of_type2_10,	mooves);	break;
				case 10:editor.putInt(APP_PREFERENCES_levels_of_type2_11,	mooves);	break;
				case 11:editor.putInt(APP_PREFERENCES_levels_of_type2_12,	mooves);	break;
				default:	break;	}
		break;

		case 2:	
			editor.putInt(APP_PREFERENCES_moovs_of_type3,moovs_counter_all);
			switch (level-1)		{
				case 0:	editor.putInt(APP_PREFERENCES_levels_of_type3_1,	mooves);	break;
				case 1:	editor.putInt(APP_PREFERENCES_levels_of_type3_2,	mooves);	break;
				case 2:	editor.putInt(APP_PREFERENCES_levels_of_type3_3,	mooves);	break;
				case 3:	editor.putInt(APP_PREFERENCES_levels_of_type3_4,	mooves);	break;
				case 4:	editor.putInt(APP_PREFERENCES_levels_of_type3_5,	mooves);	break;
				case 5:	editor.putInt(APP_PREFERENCES_levels_of_type3_6,	mooves);	break;
				case 6:	editor.putInt(APP_PREFERENCES_levels_of_type3_7,	mooves);	break;
				case 7:	editor.putInt(APP_PREFERENCES_levels_of_type3_8,	mooves);	break;
				case 8:	editor.putInt(APP_PREFERENCES_levels_of_type3_9,	mooves);	break;
				case 9:	editor.putInt(APP_PREFERENCES_levels_of_type3_10,	mooves);	break;
				case 10:editor.putInt(APP_PREFERENCES_levels_of_type3_11,	mooves);	break;
				case 11:editor.putInt(APP_PREFERENCES_levels_of_type3_12,	mooves);	break;
				default:	break;	}
		break;

		case 3:	
			editor.putInt(APP_PREFERENCES_moovs_of_type4,moovs_counter_all);
			switch (level-1)		{
				case 0:	editor.putInt(APP_PREFERENCES_levels_of_type4_1,	mooves);	break;
				case 1:	editor.putInt(APP_PREFERENCES_levels_of_type4_2,	mooves);	break;
				case 2:	editor.putInt(APP_PREFERENCES_levels_of_type4_3,	mooves);	break;
				case 3:	editor.putInt(APP_PREFERENCES_levels_of_type4_4,	mooves);	break;
				case 4:	editor.putInt(APP_PREFERENCES_levels_of_type4_5,	mooves);	break;
				case 5:	editor.putInt(APP_PREFERENCES_levels_of_type4_6,	mooves);	break;
				case 6:	editor.putInt(APP_PREFERENCES_levels_of_type4_7,	mooves);	break;
				case 7:	editor.putInt(APP_PREFERENCES_levels_of_type4_8,	mooves);	break;
				case 8:	editor.putInt(APP_PREFERENCES_levels_of_type4_9,	mooves);	break;
				case 9:	editor.putInt(APP_PREFERENCES_levels_of_type4_10,	mooves);	break;
				case 10:editor.putInt(APP_PREFERENCES_levels_of_type4_11,	mooves);	break;
				case 11:editor.putInt(APP_PREFERENCES_levels_of_type4_12,	mooves);	break;
				default:	break;	}
		break;

		default:
			break;
		}

		editor.apply();
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
	        
	    String TextToast = "���-�� �����: "+ Moovs_counter+ss+"�����: "+minutes+":"+seconds;
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);
		
		switch (type_game_from) 	{
		case 0:	overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);	break; 	// ���������� ������ �����
		case 2:	overridePendingTransition(R.anim.activity_slide_left_in, R.anim.activity_slide_left_out);	break;	// ���������� ������ ������	
		case 3:	overridePendingTransition(R.anim.activity_slide_down_in, R.anim.activity_slide_down_out);		break;	// ���������� ������ ����
		case 1:	overridePendingTransition(R.anim.activity_slide_up_in, R.anim.activity_slide_up_out);	break;	// ���������� ������ �����
		default:			break;
							}    		 
	}

}

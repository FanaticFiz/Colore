package com.example.test1;

import java.util.ArrayList;
import java.util.Collections;
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
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;


public class game_gameActivity extends Activity {

	private Animation			animation_wrong_moovs;
	private GridView			mGrid;
	private gridadapter_Game	mAdapter;
	private int					LastMoov, Moovs_counter, moovs_counter_all;
	ArrayList<String>			arrayfromlevel;										// массивпереданныйизпредыдущейактивностисодержитописаниеигровогополя
	ArrayList<Integer>			array_all_moovs;									// массиввсехсделаныхходов...пригодится))
	int[]						array_legal_moovs;									// массив-списокдоступныхходов
	private String				ColorBall;											// XMLgame_type-прописанныйвXMLфайлевариантигры
	int							Kvest_from_XMLFile;
	private TextView			someText, TimerField, MoovField;					// поледлязаметоквнизу
	boolean						firstTouch							= true;
	int							type_game_from, counter_col, number_of_level;
	long						Start_Time, End_Time;
	int							randomBG;
	Boolean						Priznak_kvesta;
	ImageButton					ImbuttonReset;
	                                           
	String ss = System.getProperty("line.separator"); // строка разделитель
	
	// Preferences
	SharedPreferences mSettings;
	Editor editor;
	public static final String 	APP_PREFERENCES = "mysettings";  							// Имя файла настроек
	
	// Уровень 1
	// Данный массив содержит всю информацию по прохождению всех уровней первого типа
	// первые 24 параметра содержат в себе кол-ов ходов за которое каждый из уровней пройден...
	// Причем наличие люой цифры большей чем 0 автоматически означает что уровень был пройден! (это справедливо для всех уровней кроме первого)
	// последний параметр это общее кол-во ходов
	//private static int[] 		pref_type1_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,	0};
	public static final String 	APP_PREFERENCES_moovs_of_type1		= 	"moovs_of_type1";		// Общее кол-во ходов 
	public static final String 	APP_PREFERENCES_levels_of_type1_1	= 	"levels_of_type1_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type1_2	= 	"levels_of_type1_2";		// второй
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

	// Уровень 2
	//private static int[] 		pref_type2_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0};
	public static final String 	APP_PREFERENCES_moovs_of_type2		= 	"moovs_of_type2";		// 
	public static final String 	APP_PREFERENCES_levels_of_type2_1	= 	"levels_of_type2_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type2_2	= 	"levels_of_type2_2";		// второй
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
    	
	// Уровень 3
	//private static int[] 		pref_type3_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0};
	public static final String 	APP_PREFERENCES_moovs_of_type3		= 	"moovs_of_type3";		// 
	public static final String 	APP_PREFERENCES_levels_of_type3_1	= 	"levels_of_type3_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type3_2	= 	"levels_of_type3_2";		// второй
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

	// Уровень 4
	public static final String 	APP_PREFERENCES_moovs_of_type4		= 	"moovs_of_type4";		// 
	public static final String 	APP_PREFERENCES_levels_of_type4_1	= 	"levels_of_type4_1";		// Первый
	public static final String 	APP_PREFERENCES_levels_of_type4_2	= 	"levels_of_type4_2";		// второй
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
	
	// Таймер
	private int seconds,minutes,hours;
	private Timer timer    = null;
	private long startTime;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		 
		
		array_all_moovs = new ArrayList<Integer>();
		//	
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		
		if (mSettings.contains(APP_PREFERENCES_moovs_of_type1)) 
		{	
			moovs_counter_all = mSettings.getInt(APP_PREFERENCES_moovs_of_type1, 0);	
		}
		
		
		// ------------------------------------------------------------------------------------------------		
		// ---------------------- аботает таймер и выводит в текстовое поле результат ---------------------
		// ------------------------------------------------------------------------------------------------
		
		// Пример с гугла таймер отсчитывающий вниз в данном примере от 30 секунд до 0
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
		       
		       // Нельзя обращаться к элементам UI(user interf.) потока из другого потока.
		       // Поэтому пользуемся handler 
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
		
		// подключаем файл анимации
		animation_wrong_moovs = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
	
		
		LastMoov=0;
		array_legal_moovs = new int[4];
		
		// Получаем данные из предыдущей активити. Игровой массив и кол-во строк и столбцов в игровом поле 
		arrayfromlevel 	=	getIntent().getExtras().getStringArrayList("FromLeveltogame");
		counter_col		=	getIntent().getExtras().getInt("from_level_to_game_col");
		type_game_from	=	getIntent().getExtras().getInt("from_level_to_game_type");
		number_of_level =	1 + getIntent().getExtras().getInt("from_level_to_game_number_of_level");
		Kvest_from_XMLFile	=	Integer.parseInt(getIntent().getExtras().getString("from_level_to_game_XMLgame_type"));
		
		
//		Надоел рандомный фон... закоментирую пока...
//		RandomBackground();
		
			
		//Свяжемся со строкой текстовой на форме
		MoovField = (TextView)findViewById(R.id.game_up_text2);
		MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
		
		someText = (TextView)findViewById(R.id.game_down_text);
		someText.setText("Цель: пройти от черного поля к белому");
		
		/*// Описываю диалоговое окно, появляющееся при прохождении уровня 
		dialog_end_of_game = new Dialog(game_gameActivity.this);
		dialog_end_of_game.setContentView(R.layout.dialog_end_levels);
		dialog_end_of_game.setTitle(R.string.Dialog_end_of_game_Title);
		dialog_end_of_game.setCancelable(false);
		*/
			
			
		////**************************************************	
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(counter_col);					// Задаем кол-во колонок в отображении
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel,Kvest_from_XMLFile);
        mGrid.setAdapter(mAdapter);
        
                
        // Находим стартовую точку
        Find_Start_Point();     
         
        
        Start_Time = System.currentTimeMillis();
        
        
        
        // Обработчик нажатий
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
                 	if (NumberFromName(arrayfromlevel.get(position))==13) 
                 	{						}
                 	else 	{
                   			game_move(parent, position, v);
                 		
                 			someText.setText("Номер фона = "+randomBG);
                 			MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
               
                 			}
        		}                	             
        	});     
      
	}

	   
    public void onResetClick(View v)
    {
    	
    	MyRestart_Level();
    	
    }
    
    private void MyRestart_Level() 
    {
    	
    	startTime = System.currentTimeMillis();
    	
    	hours=0;minutes=0;seconds=0;
    	array_all_moovs.clear();
    	Moovs_counter=0;
    	MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
    	TimerField.setText(String.format("%d:%02d", minutes, seconds));
    	
    	mGrid.setAdapter(mAdapter);
    	
    	Find_Start_Point();
		
	}
    
    
	// 	При старте уровня находим в массиве черную-стартовую точку 
	// 	позиционируемся на ней и определяем следующие доступные ходы
	public void Find_Start_Point() 
	{
		for (int i=0; i<arrayfromlevel.size(); i++) 
		{
			if (arrayfromlevel.get(i)=="ball1") 
			{
				// определяем доступные ходы (со старта идем во всех 4 направлениях)
				array_legal_moovs[0] = i-1;
				array_legal_moovs[1] = i+1;
				array_legal_moovs[2] = i-counter_col;
				array_legal_moovs[3] = i+counter_col;	
				// 	Убираем те что нельзя
				Cheking_legal_moovs();
				LastMoov = i;
			}
		}  
	}
	
	
	
	// Определяем дейсвтия при ходе...
	public void game_move(AdapterView<?> parent, int position, View v) 
	{
		
		if ((array_legal_moovs[0] == position) || (array_legal_moovs[1] == position) || (array_legal_moovs[2] == position) || (array_legal_moovs[3] == position)) 
		{			
			// -----------------------------------------------------------------------------------------------
			// уменьшаем то что нажали и увеличиваем предыдущую картинку
			parent.getChildAt(LastMoov).setScaleX((float) 1);
			parent.getChildAt(LastMoov).setScaleY((float) 1);
			LastMoov = position;
			v.setScaleX((float) 0.7);
			v.setScaleY((float) 0.7);
			// -----------------------------------------------------------------------------------------------

			//	Т.е. если мы сюда попали значит мы сделали легальный ход... т.е. мы уже тут можем считать счетчик ходов а не в каждом отдельном кайсе
			Moovs_counter++;
			
			
			// получаем имя файла ресурса по которому мы определим
			// какие следующие ходы возможны
			// например с красной позиции ход возможен только на верх и вправо
			//
			// На данный момент
			// 0 - белый - Финиш
			// 1 - Черный - Старт
			// 2 - Коричневый - влево, вправо
			// 3 - Серый - вверх
			// 4 - красный - вверх, вправо
			// 5 - зеленый - вправо, вниз
			// 6 - синий - вниз, влево
			// 7 - Оранжевый - вверх, вниз
			// 8 - Салатовый - вправо
			// 9 - Голубой - влево
			// 10 - Фиолетовый - вверх, вправо, вниз
			// 11 - Желтый - влево, вверх
			// 12 - Розовый - вверх, вниз, влево
			// 13 - Прозрачный!!! -
			// 14 - Лосось - вниз

			// выдергиваем число из названия файла
			Integer ert = NumberFromName(arrayfromlevel.get(position));			
			switch (ert) {
			case 0:
				// Финиш	
				
				moovs_counter_all = moovs_counter_all + Moovs_counter;
				
				// Пишем в преференсес
				//передаю тип игры, уровень и сделанное кол-во ходов
				MySetPreferences(type_game_from, number_of_level,Moovs_counter);
				
				// Массив ходов заполняем фигней
				array_legal_moovs[0] = 10000; // Конец игры
				array_legal_moovs[1] = 10000; // Ходить никуда нельзя
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = 10000;
				
				
				// Проверка на выполнение задания поставленного на данном уровне
				switch (number_of_level)	
				{
				case 8:	if (Test_to_MoovKvest(Moovs_counter,Kvest_from_XMLFile)) 	{	timer.cancel();	ShowGameOver();	}
						else 														{	MyRestart_Level();				}
						break;
				default:	timer.cancel(); ShowGameOver();	break;
				}
				
				break;
			case 1:
				// Старт
				ColorBall = "Пройдите до белой точки...";
				someText.setText("Цвет = " + ColorBall);
				// Со стартовой клетки возможен ход во всех неправлениях, потому что я буду менять положение стартовой клетки постоянно
				// Сдесь мы в массив возможных ходов добвляем все варианты, а уже невозможность хода за пределы лабиринат
				// надо осуществляеть в другом месте... А МОЖЕТ и не надо осуществлять вовсе, поскольку нажать на те поля все равно не получится...
						
				array_legal_moovs[0] = position - 1; // заносим в массив
				array_legal_moovs[1] = position + 1; // координаты клеток куда
				array_legal_moovs[2] = position - counter_col;
				array_legal_moovs[3] = position + counter_col; 
				
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				
				break;
			case 2:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 1; 	// заносим в массив
				array_legal_moovs[1] = position + 1; 	// координаты клеток куда доступен ход.
				array_legal_moovs[2] = 10000;	 		// ненужный элемент массива
				array_legal_moovs[3] = 10000;			// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 3:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - counter_col; // заносим в массив
				array_legal_moovs[1] = 10000;	 // координаты клеток куда доступен
				array_legal_moovs[2] = 10000; 	// ненужный элемент массива
				array_legal_moovs[3] = 10000; 	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 4:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - counter_col; // заносим в массив
				array_legal_moovs[1] = position + 1; // координаты клеток куда
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 5:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + 1; // заносим в массив
				array_legal_moovs[1] = position + counter_col; // координаты клеток куда
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 6:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + counter_col; // заносим в массив
				array_legal_moovs[1] = position - 1; // координаты клеток куда
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 7:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - counter_col; // заносим в массив
				array_legal_moovs[1] = position + counter_col; // координаты клеток куда
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 8:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + 1; // заносим в массив
				array_legal_moovs[1] = 10000; // координаты клеток куда доступен
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 9:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 1; // заносим в массив
				array_legal_moovs[1] = 10000; // координаты клеток куда доступен
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 10:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - counter_col; // заносим в массив
				array_legal_moovs[1] = position + 1; // координаты клеток куда
				array_legal_moovs[2] = position + counter_col; // ненужный элемент
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 11:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - counter_col; // заносим в массив
				array_legal_moovs[1] = position - 1; // координаты клеток куда
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 12:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - counter_col; // заносим в массив
				array_legal_moovs[1] = position - 1; // координаты клеток куда доступен ход.										
				array_legal_moovs[2] = position + counter_col; // ненужный элемент
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 13:
				// СЮда поидее мы никогда не должны попасть, ход по клетке 13 отсеивается в Cheking_legal_moovs
				break;
			case 14:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + counter_col; // заносим в массив
				array_legal_moovs[1] = 10000; // координаты клеток куда доступен
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;

			default:
				ColorBall = "Херня случилась )))";
				someText.setText("Цвет = " + ColorBall);
				break;
			}

		} 
		else 
		{	
			parent.getChildAt(position).startAnimation(animation_wrong_moovs);   
			someText.setText("Этот ход недопустим..."); 	
		}

	}
	
	
	
	
	public void MySetPreferences(int type, int level, int mooves) 
	{
		editor = mSettings.edit();
		switch (type) 
		{
		case 0:
			// пишем общее кол-во ходов
			editor.putInt(APP_PREFERENCES_moovs_of_type1,moovs_counter_all);
			// пишем в переменную текущего уровня кол-во ходов за которое прошел  
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
		name = name.replaceAll("[^0-9]+", " "); // Удаляем все символы кроме чисел
		name = name.trim();						// убираем пробелы
		return Integer.parseInt(name);			// возвращаем число
	}
	
	
	// функция которая убирает ходы из массива доступных ходов, на основании конца лабиринта или когда точки старта и финиши соприкасаются.
	// эту проверку делать всегда после заполнения массива доступных ходов.
	// т.е. из уже доступных ходов выкидывать те что противоречат правилам
	public void Cheking_legal_moovs()
	{
		for (int i = 0; i < array_legal_moovs.length; i++) 
		{
			// Просматривая все возможные ходы мы выкидываем те которые находятся за рамками игрового массива
			if ( (array_legal_moovs[i] <= arrayfromlevel.size()) & (array_legal_moovs[i] >= 0) )	
			{									}			
			else 
			{	array_legal_moovs[i] = 10000;	}
		
		}
	}

	/*
	private void RandomBackground() 
	{
		LinearLayout LinLayout = (LinearLayout) findViewById(R.id.LinearLayout_of_Game);
		
		randomBG = (int) (Math.random()*26);
		String stringBG = "bgstyle"+randomBG;
		
		Resources mRes = this.getResources();
		Integer identifierID = mRes.getIdentifier(stringBG, "drawable", this.getPackageName());
		LinLayout.setBackgroundResource(identifierID);
	}
	*/
	
	// Цель пройти лабиринт за строго определенное кол-во ходов
	// Есть массив который содержит эти ходы, нужно его весь перебрать и проверить нет ли одинаковых ходов, таковых быть не должно!	
	private boolean Test_to_MoovKvest(int kolvo_hodov, int kvest) 
	{
		// признак выполненного задания устанавливаем в false, и пытаемся его подтвердить
		if (kvest != kolvo_hodov)	{	return false;	}
		else 
		{	// Если кол-во ходов равное то проверяем на читерство!
			boolean local_bool = false;			
			// В массиве всех ходов ищем частоту вхождния каждого элемента, если она больше 1 бьем тревогу!
			for (int i = 0; i < array_all_moovs.size(); i++) 
			{
				if (Collections.frequency(array_all_moovs, array_all_moovs.get(i))	>	1) 
				{	local_bool = true;	break; }
			}	
			if (local_bool) { 	return false;	}
			else 			{	return true;	}
		}
	}
	
	
	
	private void ShowGameOver() {
		 
	    // Диалоговое окно
	    AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
	 
	    // Заголовок и текст
	    alertbox.setTitle("Поздравляем!");
	        
	    String TextToast = "Кол-во ходов: "+ Moovs_counter+ss+"Время: "+minutes+":"+seconds;
	    alertbox.setMessage(TextToast);
	 
	    // Добавляем кнопку 
	    alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface arg0, int arg1) {
	        // закрываем текущюю Activity
	        finish();
	      }
	    });
	    // показываем окно
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
		Log.d("onBack", "нажали стрелку назад");
		// Останавливаем таймер
		timer.cancel();
		overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);
		
		switch (type_game_from) 	{
		case 0:	overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);	break; 	// Активность уходит влево
		case 2:	overridePendingTransition(R.anim.activity_slide_left_in, R.anim.activity_slide_left_out);	break;	// Активность уходит вправо	
		case 3:	overridePendingTransition(R.anim.activity_slide_down_in, R.anim.activity_slide_down_out);		break;	// Активность уходит вниз
		case 1:	overridePendingTransition(R.anim.activity_slide_up_in, R.anim.activity_slide_up_out);	break;	// Активность уходит вверх
		default:			break;
							}    		 
	}

}

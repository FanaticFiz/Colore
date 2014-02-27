package com.example.test1;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class game_gameActivity extends Activity {

	private	XmlVidKvest			myXML;
	private	String	 			vid,kvest;
	private Animation			animation_wrong_moovs;
	private GridView			mGrid;
	private grdAd_Game_t1		mAdapter_t1;
	private grdAd_Game_t2		mAdapter_t2;
	private grdAd_Game_color1	mAdapter_t3;
	private int					EndPoint, LastMoov=0, Moovs_counter, moovs_counter_all;
	ArrayList<String>			arrayfromlevel;										// массивпереданныйизпредыдущейактивностисодержитописаниеигровогополя
	ArrayList<Integer>			array_all_moovs;									// массиввсехсделаныхходов...пригодится))
	public int[]				array_legal_moovs;									// массив-списокдоступныхходов
	private String				ColorBall;											// XMLgame_type-прописанныйвXMLфайлевариантигры
	private TextView			someText, TimerField, MoovField;					// поледлязаметоквнизу
	boolean						firstTouch							= true;
	int							type_game_from, counter_col, number_of_level;
	long						Start_Time, End_Time;
	int							randomBG;
	Boolean						Priznak_kvesta;
	ImageButton					ImbuttonReset;
	Dialog 						cDial_Messges,cDial_GamaeOver,cDial_EndLevel;
	
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
		
		myXML = new XmlVidKvest();
		array_all_moovs = new ArrayList<Integer>();
		
		// Мои диалоги
		cDial_Messges = new Dialog(this,R.style.NoTitleDialog);
		cDial_Messges.setContentView(R.layout.dialog_messages);
		
		cDial_GamaeOver = new Dialog(this,R.style.NoTitleDialog);
		cDial_GamaeOver.setContentView(R.layout.dialog_game_over);

		cDial_EndLevel = new Dialog(this,R.style.NoTitleDialog);
		cDial_EndLevel.setContentView(R.layout.dialog_end_levels);

		
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		if (mSettings.contains(APP_PREFERENCES_moovs_of_type1))	{
			moovs_counter_all = mSettings.getInt(APP_PREFERENCES_moovs_of_type1, 0);	
		}

		
		
		
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
		
		// подключаем файл анимации
		animation_wrong_moovs 	= 	AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
		
		// Порядок присвоения в этом массиве ходов строг: сначала вверх потом по часово стрелке: право, низ лево.
		// это из-за того что я не сделал массив уровня двухмерным...
		array_legal_moovs = new int[4];
		
		// Получаем данные из предыдущей активити. Игровой массив и кол-во строк и столбцов в игровом поле 
		arrayfromlevel 	=	getIntent().getExtras().getStringArrayList("FromLeveltogame");
		counter_col		=	getIntent().getExtras().getInt("from_level_to_game_col");
		type_game_from	=	getIntent().getExtras().getInt("from_level_to_game_type");
		number_of_level =	1 + getIntent().getExtras().getInt("from_level_to_game_number_of_level");
		// получаем два параметра определяющие вид игры и задание на уровень
		vid		=	getIntent().getExtras().getString("from_level_to_game_XMLgame_vid");
		kvest	=	getIntent().getExtras().getString("from_level_to_game_XMLgame_kvest");
		// передаем оба параметра обьекту
		myXML.setVid(vid);
		myXML.setKvest(kvest);
		// Покажем пользователю задание на текущий уровень
		if (myXML.getKvest() == 0) {		}
		else {	StartMessadge(myXML.getKvest());		}
		
		//Свяжемся со строкой текстовой на форме
		MoovField = (TextView)findViewById(R.id.game_up_text2);
		MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
		
		someText = (TextView)findViewById(R.id.game_down_text);
		someText.setText("Цель: пройти от черного поля к белому");

		// Находим стартовую точку
        Find_Start_Point();     
		
		////**************************************************	
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(counter_col);					// Задаем кол-во колонок в отображении
        mGrid.setEnabled(true);
        switch (myXML.getVid()) {
		case 1:		mAdapter_t1 = new grdAd_Game_t1(this, arrayfromlevel, array_legal_moovs, LastMoov, EndPoint);
					mGrid.setAdapter(mAdapter_t1);			break;
		case 2:		mAdapter_t2 = new grdAd_Game_t2(this, arrayfromlevel, array_legal_moovs, LastMoov, EndPoint);
					mGrid.setAdapter(mAdapter_t2);			break;
		case 3:		mAdapter_t3 = new grdAd_Game_color1(this, arrayfromlevel, array_legal_moovs, LastMoov, EndPoint);
					mGrid.setAdapter(mAdapter_t3);			break;
		default:											break;
		}
        Start_Time = System.currentTimeMillis();
        
        
        // ----------------------   Обработчик нажатий	----------------------
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)  	{
              	if (NumberFromName(arrayfromlevel.get(position))==13)	{ 	}
              	else{
               		game_move(parent, position, v); 		// Делаем ход
               		// Перерисовываем поле
                    switch (myXML.getVid()) {
            			case 1:	mAdapter_t1.BuilderField(arrayfromlevel,array_legal_moovs, LastMoov, EndPoint);	break;
            			case 2:	mAdapter_t2.BuilderField(arrayfromlevel,array_legal_moovs, LastMoov, EndPoint);	break;
            			case 3:	mAdapter_t3.BuilderField(arrayfromlevel,array_legal_moovs, LastMoov, EndPoint);	break;
            			default:											break;
            		}
               		MoovField.setText(String.format("Level:%02d  %03d", number_of_level, Moovs_counter));
               		}
        	}                	             
        });     
        // ------------------------------------------------------------------
      
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

    	Find_Start_Point();
    	
    	switch (myXML.getVid()) {
		case 1:	mAdapter_t1.BuilderField(arrayfromlevel,array_legal_moovs, LastMoov, EndPoint); break;
		case 2:	mAdapter_t2.BuilderField(arrayfromlevel,array_legal_moovs, LastMoov, EndPoint); break;
		case 3:	mAdapter_t3.BuilderField(arrayfromlevel,array_legal_moovs, LastMoov, EndPoint); break;
		default:	break;
		}
    			
	}
    
    
	// 	При старте уровня находим в массиве черную-стартовую точку 
	// 	позиционируемся на ней и определяем следующие доступные ходы
	public void Find_Start_Point() 
	{
		for (int i=0; i<arrayfromlevel.size(); i++) 
		{
			if ( Integer.parseInt(arrayfromlevel.get(i)) == 1 ) 
			{
				// определяем доступные ходы (со старта идем во всех 4 направлениях)
				array_legal_moovs[0] = i-counter_col;
				array_legal_moovs[1] = i+1;
				array_legal_moovs[2] = i+counter_col;
				array_legal_moovs[3] = i-1;	
				LastMoov = i;
			}
			else if (Integer.parseInt(arrayfromlevel.get(i)) == 0) {
				EndPoint = i;
			}
		}  
		// 	Убираем те что нельзя
		Cheking_legal_moovs();
	}
	
	
	
	// Определяем дейсвтия при ходе...
	public void game_move(AdapterView<?> parent, int position, View v) 
	{
		// Будем делать ход только если нажали на разрешенное поле
		if ((array_legal_moovs[0] == position) || (array_legal_moovs[1] == position) || (array_legal_moovs[2] == position) || (array_legal_moovs[3] == position)) 
		{			
			//	Т.е. если мы сюда попали значит мы сделали легальный ход... т.е. мы уже тут можем считать счетчик ходов а не в каждом отдельном кайсе
			Moovs_counter++;
			
			// Последний ход это тот на котором только что нажали...
			LastMoov = position;
			
			// какие следующие ходы возможны
			// например с красной позиции ход возможен только на верх и вправо
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
			case 0:		// Финиш
				moovs_counter_all = moovs_counter_all + Moovs_counter;
				
				// Пишем в преференсес
				//передаю тип игры, уровень и сделанное кол-во ходов
				MySetPreferences(type_game_from, number_of_level,Moovs_counter);
				
				// Массив ходов заполняем фигней
				array_legal_moovs[0] = 10000; // Конец игры
				array_legal_moovs[1] = 10000; // Ходить никуда нельзя
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = 10000;
				
				// Проверка на выполнение задания поставленного на уровне	
				if (myXML.kvest_TEST(myXML.getKvest(), Moovs_counter, array_all_moovs)){	
					timer.cancel();	ShowGameEnd();							}
				else	{			ShowGameOver();							}
				
				break;
			case 1:
				// Старт
				ColorBall = "Пройдите до белой точки...";
				someText.setText("Цвет = " + ColorBall);
				// Со стартовой клетки возможен ход во всех неправлениях, потому что я буду менять положение стартовой клетки постоянно
				// Сдесь мы в массив возможных ходов добвляем все варианты, а уже невозможность хода за пределы лабиринат
				// надо осуществляеть в другом месте... А МОЖЕТ и не надо осуществлять вовсе, поскольку нажать на те поля все равно не получится...
				array_legal_moovs[0] = position-counter_col;	// Строго в такой последовательности! ВВЕРХ 
				array_legal_moovs[1] = position+1;				// ВПРАВО
				array_legal_moovs[2] = position+counter_col;	// ВНИЗ
				array_legal_moovs[3] = position-1;				// ВЛЕВО
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				
				break;
			case 2:
				array_legal_moovs[0] = 10000;
				array_legal_moovs[1] = position+1;
				array_legal_moovs[2] = 10000;	 
				array_legal_moovs[3] = position-1;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 3:
				array_legal_moovs[0] = position - counter_col;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 4:
				array_legal_moovs[0] = position - counter_col;
				array_legal_moovs[1] = position+1;
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 5:
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = 10000;
				array_legal_moovs[1] = position + 1;
				array_legal_moovs[2] = position + counter_col;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 6:
				array_legal_moovs[0] = 10000;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = position + counter_col;
				array_legal_moovs[3] = position - 1;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 7:
				array_legal_moovs[0] = position - counter_col;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = position + counter_col;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 8:
				array_legal_moovs[0] = 10000;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = position + 1;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 9:
				array_legal_moovs[0] = 10000;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = position - 1;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 10:
				array_legal_moovs[0] = position - counter_col;
				array_legal_moovs[1] = position + 1;
				array_legal_moovs[2] = position + counter_col;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 11:
				array_legal_moovs[0] = position - counter_col;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = 10000;
				array_legal_moovs[3] = position - 1;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 12:
				array_legal_moovs[0] = position - counter_col;
				array_legal_moovs[1] = 10000;										
				array_legal_moovs[2] = position + counter_col;
				array_legal_moovs[3] = position - 1;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;
			case 13:
				// СЮда поидее мы никогда не должны попасть, ход по клетке 13 отсеивается в Cheking_legal_moovs
				break;
			case 14:
				array_legal_moovs[0] = 10000;
				array_legal_moovs[1] = 10000;
				array_legal_moovs[2] = position + counter_col;
				array_legal_moovs[3] = 10000;
				Cheking_legal_moovs();
				array_all_moovs.add(position);
				break;

			default:
				ColorBall = "Херня случилась )))";
				someText.setText("Цвет = " + ColorBall);
				break;
			}
		} 
		else	{	
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
			if ( (array_legal_moovs[i] <= arrayfromlevel.size()) && (array_legal_moovs[i] >= 0) )	
			{									}			
			else 
			{	array_legal_moovs[i] = 10000;	}
		}
		// Я выстроил заполнение массива array_legal_moovs таким образом чтобы на 3 всегда был -1 элемент
		// НО ПОПРЕЖНЕМУ НЕТ ЗАЩИТЫ ОТ РАСПОЛОЖЕНИЯ СТАРТОВОГО ПОЛЯ СПРАВА МАССИВА !!!
		// защиту от этого незнаю как придумать пока... 
		// просто нельзя ставить начало справа скраю, получается...
		if (mySuperFitcha()) {
			array_legal_moovs[3] = 10000;
		}
	}

	// А есть ли остаток?	
	public boolean mySuperFitcha()	{
		if (LastMoov % counter_col == 0) 	{	return true;	}
		else 								{	return false;	}
	}
	

	private void ShowGameOver() {
		cDial_GamaeOver.setCancelable(false);
		cDial_GamaeOver.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		cDial_GamaeOver.getWindow().getAttributes().windowAnimations = R.anim.old_typeofgamepopin;
		ImageButton imb_dial = (ImageButton) cDial_GamaeOver.findViewById(R.id.imageButton1);
		imb_dial.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)	{
				cDial_GamaeOver.dismiss();
				MyRestart_Level();
			}
		});		
		cDial_GamaeOver.show();
	}
	
	private void ShowGameEnd() {
		cDial_EndLevel.setCancelable(false);
		cDial_EndLevel.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		cDial_EndLevel.getWindow().getAttributes().windowAnimations = R.anim.old_typeofgamepopin;
		TextView textMove = (TextView) cDial_EndLevel.findViewById(R.id.game_up_text);
		TextView textTime = (TextView) cDial_EndLevel.findViewById(R.id.textView3);
		
		textMove.setText(String.format("Ходов: %02d", Moovs_counter));
		textTime.setText(String.format("Время: %d:%02d", minutes, seconds));
		
		ImageButton imb_dial = (ImageButton) cDial_EndLevel.findViewById(R.id.imageButton1);
		imb_dial.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)	{
				cDial_EndLevel.dismiss();
				finish();
			}
		});		
		cDial_EndLevel.show();
	}
	
	
	public void StartMessadge(int kl)
	{
		cDial_Messges.setCancelable(false);
		cDial_Messges.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		cDial_Messges.getWindow().getAttributes().windowAnimations = R.anim.old_typeofgamepopin;
		TextView text = (TextView) cDial_Messges.findViewById(R.id.textView1);

		if (kl == 0) {
		}else {
			if (kl > 0) {
				text.setText("На прохождение уровня дано: "+kl+" секунд.");
			}else {
				text.setText("Пройди этот уровень за: "+Math.abs(kl)+" ходов.");
			}
		}
		
		ImageButton imb_dial = (ImageButton) cDial_Messges.findViewById(R.id.imageButton1);
		imb_dial.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)	{
				cDial_Messges.dismiss();
				startTime = System.currentTimeMillis();
			}
		});		
		cDial_Messges.show();
	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
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

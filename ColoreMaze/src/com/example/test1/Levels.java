package com.example.test1;


import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Levels extends Activity {
	
	private Animation 			animation_wrong_moovs;
	ArrayList<String> 		list 		= 	new ArrayList<String>();
	private 	SoundPool 	soundPool;
	private 	static int 	soundID1;
	private		int			counter_col;	// кол-во столбцов	
	private		int			type_of_game;	// пполучаем типа игры которую выбрали в Type.class]
	private		String		XMLgame_type="0";	// Типа усложнения игры из файла
	
	// Preferences
	SharedPreferences mSettings;
	public static final String 	APP_PREFERENCES = "mysettings";  							// Имя файла настроек	
	// массив заполненный из преференсес
	private static int[] 		pref_type_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,	0};

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
	//private static int[] 		pref_type4_AllAboutLevels 			=	{1,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0,0,	0,0,0,0};
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
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_levels);
			
		
		
		//
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

		
		// подключаем файл анимации
		animation_wrong_moovs = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
			
		
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		//Загружаем звуки в память
        soundID1 = soundPool.load(this, R.raw.btn1, 1);

		// получаем тип выбранной игры...
		type_of_game =	getIntent().getExtras().getInt("from_type_tolevels_tog");
        
		
		MyGetPreferences(type_of_game);
		
		// передаём в класс грид: контекст, тип выбранный в предыдущей активности и массив из преферансес
		GridView gridview = (GridView) findViewById(R.id.levelselect);
	    gridview.setAdapter(new gridAdapter_LevelsImage(this, type_of_game, pref_type_AllAboutLevels));
	       
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
	        {
	        	// Идем играть только если уровень открыт
	        	int position_for_array = position-1;
	        	if (pref_type_AllAboutLevels[position_for_array] > 0) 
	        	{
     		        	
	        		soundPool.play(soundID1, 1, 1, 1, 0, 1f);
	        		ChoiseLevel(type_of_game, position);
	        		// 	Прыгаем в Игру
	        		Intent intentG = new Intent();
	        		intentG.setClass(Levels.this, game_gameActivity.class);
	        		intentG.putExtra("FromLeveltogame", list);
	        		intentG.putExtra("from_level_to_game_col",  counter_col);	
	        		intentG.putExtra("from_level_to_game_number_of_level",  position);		// Передаю номер уровня для отображения оного			
	        		intentG.putExtra("from_level_to_game_type", type_of_game); 				// использую для анимации между активити
	        		intentG.putExtra("from_level_to_game_XMLgame_type",  XMLgame_type);		// Передаем тип игры из XML файла
	        		startActivity(intentG);
	    		
	        		switch (type_of_game) 	{
	        		case 0:	overridePendingTransition(R.anim.activity_slide_left_in, R.anim.activity_slide_left_out);	break; 	// Активность уходит влево
	        		case 2:	overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);	break;	// Активность уходит вправо	
	        		case 3:	overridePendingTransition(R.anim.activity_slide_up_in, R.anim.activity_slide_up_out);		break;	// Активность уходит вниз
	        		case 1:	overridePendingTransition(R.anim.activity_slide_down_in, R.anim.activity_slide_down_out);	break;	// Активность уходит вверх
	        		default:			break;
	        								}
	        	}
	        	else 
	        	{
	        		parent.getChildAt(position).startAnimation(animation_wrong_moovs);
				}
	        }
	    });			
	}

	
	
	public void MyGetPreferences(int type) 
	{
		switch (type) 
		{
		case 0:	
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_1))	{	pref_type_AllAboutLevels[0] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_1, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_2))	{	pref_type_AllAboutLevels[1] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_2, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_3))	{	pref_type_AllAboutLevels[2] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_3, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_4))	{	pref_type_AllAboutLevels[3] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_4, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_5))	{	pref_type_AllAboutLevels[4] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_5, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_6))	{	pref_type_AllAboutLevels[5] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_6, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_7))	{	pref_type_AllAboutLevels[6] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_7, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_8))	{	pref_type_AllAboutLevels[7] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_8, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_9))	{	pref_type_AllAboutLevels[8] = mSettings.getInt(APP_PREFERENCES_levels_of_type1_9, 0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_10))	{	pref_type_AllAboutLevels[9]	= mSettings.getInt(APP_PREFERENCES_levels_of_type1_10,0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_11))	{	pref_type_AllAboutLevels[10]= mSettings.getInt(APP_PREFERENCES_levels_of_type1_11,0);	}
			if (mSettings.contains(APP_PREFERENCES_levels_of_type1_12))	{	pref_type_AllAboutLevels[11]= mSettings.getInt(APP_PREFERENCES_levels_of_type1_12,0);	}
		break;

		case 1:	
		break;

		case 2:	
		break;

		case 3:	
		break;

		default:
			break;
		}
	}
	
	
	
	// Определяем какой файл xml подгрузить в зависимости от выбора уровня...
	public void ChoiseLevel(int type, int NP) 
	{
		String String_of_type;
		switch (type) 	{
		case 0:	String_of_type = "type1_";	break;
		case 1:	String_of_type = "type2_";	break;
		case 2:	String_of_type = "type3_";	break;
		case 3:	String_of_type = "type4_";	break;
		default:String_of_type = "type1_";	break;
						}
		
		String StringNP;
		int i;
		switch (NP) {
		case 0:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);
			break;
			
		case 1:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);		
			break;

		case 2:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 3:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 4:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 5:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 6:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 7:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 8:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 9:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 10:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 11:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		case 12:
			i = NP+1;
			StringNP = String_of_type+"level"+i;
			ParserXML(StringNP);			
			break;

		default:
			break;
		}
	}
	
	
	private void ParserXML(String Name_of_XML_file) 
	{
		 // ------------------- Достаем из XML уровень -------------------------
	    // и загоняем в массив list
		
		// Получаем ID нужного файла исполльзуя название файла
	    int XMLFileID = getResources().getIdentifier(Name_of_XML_file,"xml",getPackageName());
		list.clear();
		
        try 
        {
        XmlPullParser parser = getResources().getXml(XMLFileID);

        	while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) 
        	{
        		if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("game-type"))
        		{
        			for (int i = 0; i < parser.getAttributeCount(); i++)
        			{
        				XMLgame_type = parser.getAttributeValue(i);
        			}
        		}
        		
        		if (parser.getEventType() == XmlPullParser.START_TAG
                    && parser.getName().equals("array-list")) 
        		{
        			for (int i = 0; i < parser.getAttributeCount(); i++)
        			{
        				list.add(parser.getAttributeValue(i));
        			}
        			counter_col = parser.getAttributeCount();
        		}
        		
        	parser.next();
        	}
        }
        
        catch (Throwable t) 
        {
            Toast.makeText(this,"Ошибка при загрузке XML-документа: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
	    // ------------------- Достаем из XML уровень -------------------------    
	    
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.levels, menu);
		return true;
	}

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		// Завершаем наше activity
        this.finish(); 
		
		switch (type_of_game) 	{
		case 0:	overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);	break; 	// Активность уходит влево
		case 2:	overridePendingTransition(R.anim.activity_slide_left_in, R.anim.activity_slide_left_out);	break;	// Активность уходит вправо	
		case 3:	overridePendingTransition(R.anim.activity_slide_down_in, R.anim.activity_slide_down_out);		break;	// Активность уходит вниз
		case 1:	overridePendingTransition(R.anim.activity_slide_up_in, R.anim.activity_slide_up_out);	break;	// Активность уходит вверх
		default:			break;
							}    		 
	}
}

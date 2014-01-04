package com.example.test1;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Levels extends Activity {
	
	ArrayList<String> 		list 		= 	new ArrayList<String>();
	private 	SoundPool 	soundPool;
	private 	static int 	soundID1;
	private		int			counter_col;	// кол-во столбцов	
	private		int			type_of_game;	// пполучаем типа игры которую выбрали в Type.class
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_levels);
			
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		//Загружаем звуки в память
        soundID1 = soundPool.load(this, R.raw.btn1, 1);

		// получаем тип выбранной игры...
		type_of_game =	getIntent().getExtras().getInt("from_type_tolevels_tog");
        
		GridView gridview = (GridView) findViewById(R.id.levelselect);
	    gridview.setAdapter(new gridAdapter_LevelsImage(this, type_of_game));
	       
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
	        {
	        	
	        	soundPool.play(soundID1, 1, 1, 1, 0, 1f);
	        	ChoiseLevel(type_of_game, position);
	        	// Прыгаем в Игру
	        	Intent intentG = new Intent();
	    		intentG.setClass(Levels.this, game_gameActivity.class);
	    		intentG.putExtra("FromLeveltogame", list);
	    		intentG.putExtra("from_level_to_game_col",  counter_col);
	    		intentG.putExtra("from_level_to_game_type", type_of_game);
	    		startActivity(intentG);
	    		
	    		switch (type_of_game) 	{
				case 0:	overridePendingTransition(R.anim.activity_slide_left_in, R.anim.activity_slide_left_out);	break; 	// Активность уходит влево
				case 2:	overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_right_out);	break;	// Активность уходит вправо	
				case 3:	overridePendingTransition(R.anim.activity_slide_up_in, R.anim.activity_slide_up_out);		break;	// Активность уходит вниз
				case 1:	overridePendingTransition(R.anim.activity_slide_down_in, R.anim.activity_slide_down_out);	break;	// Активность уходит вверх
				default:			break;
									}    		
	        }
	    });			
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

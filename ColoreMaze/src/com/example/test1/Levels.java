package com.example.test1;

import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_levels);
		
		GridView gridview = (GridView) findViewById(R.id.levelselect);
	    gridview.setAdapter(new gridAdapter_LevelsImage(this));
	    
	    
	    // ------------------- Достаем из XML уровень -------------------------
	    ArrayList<String> list = new ArrayList<String>();
        
        try {
            XmlPullParser parser = getResources().getXml(R.xml.contacts);

            while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("array-list")) 
                {
                    list.add(parser.getAttributeValue(0));
                    list.add(parser.getAttributeValue(1));
                    list.add(parser.getAttributeValue(2));
                    list.add(parser.getAttributeValue(3));
                }
                parser.next();
            }
        }
        catch (Throwable t) {
            Toast.makeText(this,"Ошибка при загрузке XML-документа: " + t.toString(), 4000).show();
        }
	    // ------------------- Достаем из XML уровень -------------------------
        	    
	    
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
	        {
	        	// Прыгаем в Игру
	        	Intent intentG = new Intent();
	    		intentG.setClass(Levels.this, game_gameActivity.class);
	    		startActivity(intentG);	        	
	        }
	    });			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.levels, menu);
		return true;
	}

}

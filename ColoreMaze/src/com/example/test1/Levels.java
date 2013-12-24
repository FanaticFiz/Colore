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
	
	ArrayList<String> list = new ArrayList<String>();
	private SoundPool soundPool;
	private static int soundID1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_levels);
				
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		//��������� ����� � ������
        soundID1 = soundPool.load(this, R.raw.btn1, 1);
        
		GridView gridview = (GridView) findViewById(R.id.levelselect);
	    gridview.setAdapter(new gridAdapter_LevelsImage(this));
	       
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
	        {
	        	soundPool.play(soundID1, 1, 1, 1, 0, 1f);
	        	ChoiseLevel(position);
	        	// ������� � ����
	        	Intent intentG = new Intent();
	    		intentG.setClass(Levels.this, game_gameActivity.class);
	    		intentG.putExtra("FromLeveltogame", list);
	    		startActivity(intentG);
	    		
	    		
	        }
	    });			
	}

	
	// ���������� ����� ���� xml ���������� � ����������� �� ������ ������...
	public void ChoiseLevel(int NP) 
	{
		String StringNP;
		int i;
		switch (NP) {
		case 0:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);
			break;
			
		case 1:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);		
			break;

		case 2:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 3:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 4:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 5:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 6:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 7:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 8:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 9:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 10:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 11:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		case 12:
			i = NP+1;
			StringNP = "level"+i;
			ParserXML(StringNP);			
			break;

		default:
			break;
		}
	}
	
	
	private void ParserXML(String Name_of_XML_file) 
	{
		 // ------------------- ������� �� XML ������� -------------------------
	    // � �������� � ������ list
		
		// �������� ID ������� ����� ���������� �������� �����
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
        		}
        	parser.next();
        	}
        }
        
        catch (Throwable t) 
        {
            Toast.makeText(this,"������ ��� �������� XML-���������: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
	    // ------------------- ������� �� XML ������� -------------------------    
	    
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.levels, menu);
		return true;
	}

}

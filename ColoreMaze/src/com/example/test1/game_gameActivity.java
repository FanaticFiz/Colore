package com.example.test1;

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
	private game_gridadapter mAdapter;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
	
		//String FileXML = getIntent().getStringExtra("FileXML");
		
		 // Работаем над парсингос файла XML в котором хранится инфа об уровне 
		// Типа Получаем из предыдущего активити номер xml файла
		/*ArrayList<String> list = new ArrayList<String>();
		
		XmlPullParser parser = getResources().getXml(R.xml.level1);
		// 
		parser.getName().equals("arrey-info");
		
		
		try {
			while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
			    if (parser.getEventType() == XmlPullParser.START_TAG
			            && parser.getName().equals("arrey-info")) 
			    {
			    	// Пишем в массив
			        list.add(parser.getAttributeValue(0));
			    }
			    parser.next();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		////**************************************************
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(10);
        mGrid.setEnabled(true);
        mAdapter = new game_gridadapter(this, 10, 10);
        mGrid.setAdapter(mAdapter);
	
        // Обработчик нажатий
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
                // Do  
            	//mAdapter.getItemId(position);
            	
            	TextView someText = (TextView)findViewById(R.id.textView1);
                someText.setText("ID: "+id+"  Position: "+position);
            	            	
                }
        	});
	}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

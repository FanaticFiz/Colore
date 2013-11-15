package com.example.test1;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class game_gameActivity extends Activity {

	//private TextView mSelectText;
	private GridView mGrid;
	private gridadapter_Game mAdapter;
	private int p,LastMoov;
	ArrayList<String> arrayfromlevel;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		p=0;LastMoov=0;
		
		// Получаем массив из предыдущей активити 
		arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
				
		////**************************************************
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(10);
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel);
        mGrid.setAdapter(mAdapter);
	
        // Обработчик нажатий
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        	{
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
            		// 	Do
            		game_move(parent, position, v);
        
            		//TextView someText = (TextView)findViewById(R.id.textView1);
                    //someText.setText("ID: "+id+"  Position: "+position);
                	
                }
        	});
	}

	
	//
	public void game_move(AdapterView<?> parent, int position, View v) 
	{
	
		// здесь обрабатываем нажатие на элемент...
		// нужно делать следующее: 
		// сдесь же нужно определять конец игры который заключается в том что 
		// игрок сумел нажать/встать на последнее поле
		//
		//-----------------------------------------------------------------------------------------------
		// запоминаем только последнее нажатие, уменьшаем то что нажали и увеличиваем предыдущую картинку
		if (p==0)		{	p++;	
			//TextView someText = (TextView)findViewById(R.id.textView1);
			//someText.setText("Last moov is="+LastMoov+" Now you taped on"+position);
			parent.getChildAt(LastMoov).setScaleX((float) 1);
			parent.getChildAt(LastMoov).setScaleY((float) 1);
	    	LastMoov=position;
	    	v.setScaleX((float) 0.7);
	    	v.setScaleY((float) 0.7);	}
		else			{	p--;	
			//TextView someText = (TextView)findViewById(R.id.textView1);
			//someText.setText("Last moov is="+LastMoov+" Now you taped on"+position);
			parent.getChildAt(LastMoov).setScaleX((float) 1);
	    	parent.getChildAt(LastMoov).setScaleY((float) 1);
	    	LastMoov=position;
	    	v.setScaleX((float) 0.7);
	    	v.setScaleY((float) 0.7);	}
		//-----------------------------------------------------------------------------------------------
		
	
		// получаем имя файла ресурса по которому мы определим 
		// какие следующие ходы возможны
		// например с красной позиции ход возможен только на верх и вниз
    	// в зависимости от содержимого меняем ячейку массива на название файла с рисунком .png
    	// На данный момент 
    	// 	0	-	белый 
    	// 	1 	-	Черный
    	//	2	-	Коричневый
    	// 	3	-	Серый 
    	// 	4 	-	красный	
    	//	5	-	зеленый
    	// 	6	-	синий 
    	// 	7 	-	Оранжевый	
    	//	8	-	Салатовый
    	// 	9	-	Голубой 
    	// 	10	-	Фиолетовый	
    	//	11	-	Желтый
    	// 	12	-	Розовый	
		String Name_of_file = arrayfromlevel.get(position);
		switch (Name_of_file) 
		{
		case "ball0":
			
			break;

		default:
			break;
		}
		
		
	}
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

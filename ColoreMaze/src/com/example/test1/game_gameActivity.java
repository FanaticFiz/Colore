package com.example.test1;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class game_gameActivity extends Activity {

	private GridView mGrid;
	private gridadapter_Game mAdapter;
	private int p,LastMoov;
	ArrayList<String> arrayfromlevel, array_legal_moovs;	// массив переданный из предыдущей активности содержит описание игрового поля / массив-список доступных ходов
	private String ColorBall;		
	TextView someText;    			//	поле для заметок внизу
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		p=0;LastMoov=0;
		
		// Получаем массив из предыдущей активити 
		arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
		
		//Свяжемся со строкой текстовой на форме
		someText = (TextView)findViewById(R.id.textView1);
		
		////**************************************************
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(10);
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this, arrayfromlevel);
        mGrid.setAdapter(mAdapter);

/*	
        // Установим игрока на начальную позицию - Черную клетку!
        for (int i=0; i< arrayfromlevel.size(); i++) 
        {
        	NumberFromName(arrayfromlevel.get(position));
        	
		}
*/        

        
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
		// например с красной позиции ход возможен только на верх и вправо
    	// 
    	// На данный момент 
    	// 	0	-	белый 			-	Финиш
    	// 	1 	-	Черный			- 	Старт
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
		//	13	-	Прозрачный!!!
		//	14	-	Лосось
		
		// выдергиваем число из названия файла
		Integer ert = NumberFromName(arrayfromlevel.get(position));
		switch (ert) 
		{
		case 0:
			// Финиш
			ColorBall = "Поздравляем, Вы выиграли!!!";
			someText.setText("Цвет = "+ColorBall);				
			break;
		case 1:
			// Старт
			ColorBall = "Пройдите до белой точки...";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 2:
			
			ColorBall = "коричневый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 3:
			ColorBall = "серый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 4:
			ColorBall = "красный";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 5:
			ColorBall = "зеленый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 6:
			ColorBall = "синий";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 7:
			ColorBall = "Оранжевый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 8:
			ColorBall = "Салатовый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 9:
			ColorBall = "Голубой";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 10:
			ColorBall = "Фиолетовый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 11:
			ColorBall = "Желтый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 12:
			ColorBall = "Розовый";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 13:
			ColorBall = "Ты зачем тут нажал? )))";
			someText.setText("Цвет = "+ColorBall);
			break;
		case 14:
			ColorBall = "лососевый ))";
			someText.setText("Цвет = "+ColorBall);
			break;			

		default:
			ColorBall = "Херня случилась )))";
			someText.setText("Цвет = "+ColorBall);
			break;
		}
		
		
	}
		
	
	public Integer NumberFromName(String name) 
	{
		name = name.replaceAll("[^0-9]+", " "); // Удаляем все символы кроме чисел
		name = name.trim();						// убираем пробелы
		return Integer.parseInt(name);			// возвращаем число
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

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
	private int LastMoov;
	ArrayList<String> arrayfromlevel;	// массив переданный из предыдущей активности содержит описание игрового поля / массив-список доступных ходов
	int[] array_legal_moovs;
	private String ColorBall;		
	TextView someText;    			//	поле для заметок внизу
	boolean firstTouch = true;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		LastMoov=0;
		array_legal_moovs = new int[4];
		
		// Получаем массив из предыдущей активити 
		arrayfromlevel =  getIntent().getExtras().getStringArrayList("FromLeveltogame");
		
		//Свяжемся со строкой текстовой на форме
		someText = (TextView)findViewById(R.id.textView1);
		someText.setText("Давайте начнем! Жмякните где нибуть...");
		
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
                 	
            		// обрабатываю первое касание
        			if (firstTouch) 
        			{
        				someText.setText("Цель: пройти от черного поля к белому");
        				// 	При старте уровня находим в массиве черную-стартовую точку 
        				// 	позиционируемся на ней и определяем следующие доступные ходы
        				for (int i=0; i<arrayfromlevel.size(); i++) 
        				{
        					if (arrayfromlevel.get(i)=="ball1") 
        					{
        						parent.getChildAt(i).setScaleX((float) 0.7);
        						parent.getChildAt(i).setScaleY((float) 0.7);
        						// определяем доступные ходы (со старта идем во всех 4 направлениях)
        						array_legal_moovs[0] = i-1;
        						array_legal_moovs[1] = i+1;
        						array_legal_moovs[2] = i-10;
        						array_legal_moovs[3] = i+10;	
        						// Убираем те что нельзя
        						Cheking_legal_moovs();
        						LastMoov = i;
        					}
        				}  
        				firstTouch = false;        				
        			}	else	
        				{	
        					game_move(parent, position, v);
        				}                	
                }
        	});
	}

	
	//
	public void game_move(AdapterView<?> parent, int position, View v) {

		if ((array_legal_moovs[0] == position)| (array_legal_moovs[1] == position)| (array_legal_moovs[2] == position)| (array_legal_moovs[3] == position)) 
		{

			// -----------------------------------------------------------------------------------------------
			// уменьшаем то что нажали и увеличиваем предыдущую картинку
			parent.getChildAt(LastMoov).setScaleX((float) 1);
			parent.getChildAt(LastMoov).setScaleY((float) 1);
			LastMoov = position;
			v.setScaleX((float) 0.7);
			v.setScaleY((float) 0.7);
			// -----------------------------------------------------------------------------------------------

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
				ColorBall = "Поздравляем, Вы выиграли!!!";
				someText.setText("Цвет = " + ColorBall);
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
				array_legal_moovs[2] = position - 10;
				array_legal_moovs[3] = position + 10; 
				
				Cheking_legal_moovs();
				
				break;
			case 2:
				ColorBall = "коричневый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 1; 	// заносим в массив
				array_legal_moovs[1] = position + 1; 	// координаты клеток куда доступен ход.
				array_legal_moovs[2] = 10000;	 		// ненужный элемент массива
				array_legal_moovs[3] = 10000;			// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 3:
				ColorBall = "серый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 10; // заносим в массив
				array_legal_moovs[1] = 10000;	 // координаты клеток куда доступен
												// ход.
				array_legal_moovs[2] = 10000; 	// ненужный элемент массива
				array_legal_moovs[3] = 10000; 	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 4:
				ColorBall = "красный";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 10; // заносим в массив
				array_legal_moovs[1] = position + 1; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 5:
				ColorBall = "зеленый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + 1; // заносим в массив
				array_legal_moovs[1] = position + 10; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 6:
				ColorBall = "синий";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + 10; // заносим в массив
				array_legal_moovs[1] = position - 1; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 7:
				ColorBall = "Оранжевый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 10; // заносим в массив
				array_legal_moovs[1] = position + 10; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 8:
				ColorBall = "Салатовый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + 1; // заносим в массив
				array_legal_moovs[1] = 10000; // координаты клеток куда доступен
												// ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 9:
				ColorBall = "Голубой";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 1; // заносим в массив
				array_legal_moovs[1] = 10000; // координаты клеток куда доступен
												// ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 10:
				ColorBall = "Фиолетовый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 10; // заносим в массив
				array_legal_moovs[1] = position + 1; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = position + 10; // ненужный элемент
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 11:
				ColorBall = "Желтый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 10; // заносим в массив
				array_legal_moovs[1] = position - 1; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 12:
				ColorBall = "Розовый";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position - 10; // заносим в массив
				array_legal_moovs[1] = position - 1; // координаты клеток куда
														// доступен ход.
				array_legal_moovs[2] = position + 10; // ненужный элемент
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;
			case 13:
				ColorBall = "Ты зачем тут нажал? )))";
				someText.setText("Цвет = " + ColorBall);

				break;
			case 14:
				ColorBall = "лососевый ))";
				someText.setText("Цвет = " + ColorBall);
				// Уменьшаем то что было увеличено
				// Legal_Moovs_Small_Picture(parent, array_legal_moovs);
				// Определяем куда можно пойти, заносим в массив
				array_legal_moovs[0] = position + 10; // заносим в массив
				array_legal_moovs[1] = 10000; // координаты клеток куда доступен
												// ход.
				array_legal_moovs[2] = 10000; // ненужный элемент массива
				array_legal_moovs[3] = 10000;	// проставляем в 10000
				Cheking_legal_moovs();
				break;

			default:
				ColorBall = "Херня случилась )))";
				someText.setText("Цвет = " + ColorBall);
				break;
			}

		} else {	someText.setText("Этот ход недопустим..."); 	}

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
	
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


}

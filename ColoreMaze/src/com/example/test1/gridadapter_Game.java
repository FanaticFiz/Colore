package com.example.test1;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridadapter_Game extends BaseAdapter 
{
	private Context 			mContext;
	private ArrayList<String> 	arrayPicture; 	// массив картинок
	private Resources 			mRes; 		   	// Ресурсы приложени
	private int[] 				legal_moovs;	// Массив доступных ходов
	private int 				SizeArray, LastMoov, EndPoint;
	private int 				colvo=0;
	
	public gridadapter_Game(Context context, ArrayList<String> _arrayfromXML, int xMLgame_type, int[] _array_legal_moovs, int _LastMoov, int _EndPoint) 
	{
		mContext = context;
	    // Получаем все ресурсы приложения
	    mRes = mContext.getResources();
	 
	    // Метод заполняющий массив arrayPicture
	    BuilderField(_arrayfromXML, _array_legal_moovs, _LastMoov, _EndPoint);
	    
	}

	public void BuilderField(ArrayList<String> _arrayfromXML, int[] _array_legal_moovs, int _LastMoov, int _EndPoint)
	{
		arrayPicture	=	(ArrayList<String>) _arrayfromXML.clone();
		legal_moovs 	= 	_array_legal_moovs;
		LastMoov		=	_LastMoov;	
		EndPoint		=	_EndPoint;
				
		SizeArray = arrayPicture.size();
		
		makePictArray();
		notifyDataSetChanged();
	}
	
	private void makePictArray() 
	{  	
	    // добавляем
	    for (int i = 0; i<SizeArray; i++)
	    {
	    	int j = Integer.parseInt(arrayPicture.get(i));
	    	// j это содержимае i ячейки массива
	    	switch (j) 
	    	{
	    	// в зависимости от содержимого меняем ячейку массива на название файла с рисунком .png
	    	// На данный момент 
	    	// 	0	-	белый 			-	Финиш
	    	// 	1 	-	Черный			-	Старт
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
	    	//	14 	-	лососевый )) 
	    	//		
	    	
			case 0:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball0");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}
				break;
				
			case 1:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball1");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;
				
			case 2:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball2");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;
				
			case 3:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball3");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}

				break;

			case 4:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball4");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}

				break;
				
			case 5:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball5");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;

			case 6:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball6");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;
				
			case 7:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball7");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;

			case 8:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball8");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}

				break;
				
			case 9:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball9");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}

				break;


			case 10:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball10");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;

			case 11:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball11");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}

				break;

				
			case 12:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball12");		
				}
				else {
					arrayPicture.set(i, "ball15");
				}

				break;

			case 14:
				if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
					arrayPicture.set(i, "ball14");		
				}	
				else {
					arrayPicture.set(i, "ball15");
				}

				break;
			/*
			case 0:
				arrayPicture.set(i, "ball92");
				break;
				
			case 1:
				// черное стартовое поле
				arrayPicture.set(i, "ball92");
				break;
				
			case 2:
				arrayPicture.set(i, "ball52");	
				break;
				
			case 3:
				arrayPicture.set(i, "ball92");	
				break;

			case 4:
				arrayPicture.set(i, "ball52");	
				break;
				
			case 5:
				arrayPicture.set(i, "ball52");	
				break;

			case 6:
				arrayPicture.set(i, "ball52");	
				break;
				
			case 7:
				arrayPicture.set(i, "ball52");	
				break;

			case 8:
				arrayPicture.set(i, "ball92");	
				break;
				
			case 9:
				arrayPicture.set(i, "ball92");	
				break;

			case 10:
				arrayPicture.set(i, "ball92");	
				break;

			case 11:
				arrayPicture.set(i, "ball92");	
				break;
				
			case 12:
				arrayPicture.set(i, "ball92");	
				break;
			case 14:
				arrayPicture.set(i, "ball92");	
				break;
				*/
				
			default:
				arrayPicture.set(i, "ball13");
				break;
			}
	    }
	}
	
	
	@Override
	public 	int 	getCount()				{	return arrayPicture.size();	}
	@Override
	public 	Object 	getItem(int position) 	{	return null;				}
	@Override
	public 	long 	getItemId(int position)	{	return 0;					}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		SquareImageView view; // для вывода картинки

		if (convertView == null)
			view = new SquareImageView(mContext);
		else
			view = (SquareImageView) convertView;

		// Получаем идентификатор ресурса для картинки,
	    // которая находится в векторе arrayPicture на позиции position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
		
		// место последнего хода уменьшаем
		if (position == LastMoov)
		{
			Log.d("some", "qweqweqweqwwwwwwwwwwwwwwww");
			view.setScaleX((float) 0.7);
			view.setScaleY((float) 0.7);
		}
		return view;
	}
}

package com.example.test1;

import java.util.ArrayList;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class grdAd_Game_color1 extends BaseAdapter 
{
	private Context 			mContext;
	private ArrayList<String> 	arrayPicture; 	
	private Resources 			mRes; 		   	
	private int 				LastMoov;

	// Конструктор
	public grdAd_Game_color1(Context context, ArrayList<String> _arrayfromXML, int xMLgame_type, int[] _array_legal_moovs, int _LastMoov, int _EndPoint) 
	{
		mContext = context;
	    mRes = mContext.getResources();
	    // Метод заполняющий массив arrayPicture
	    BuilderField(_arrayfromXML, _array_legal_moovs, _LastMoov, _EndPoint);
	}

	public void BuilderField(ArrayList<String> _arrayfromXML, int[] _array_legal_moovs, int _LastMoov, int _EndPoint)
	{
		arrayPicture	=	(ArrayList<String>) _arrayfromXML.clone();
		LastMoov		=	_LastMoov;	

		makePictArray();
		notifyDataSetChanged();
	}

	private void makePictArray() 
	{  	
	    // добавляем
	    for (int i = 0; i<arrayPicture.size(); i++)
	    {
	    	int j = Integer.parseInt(arrayPicture.get(i));
	    	switch (j)	// j это содержимае i ячейки массива 
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
			case 0:		arrayPicture.set(i, "color0");	break;
			case 1:		arrayPicture.set(i, "color1");	break;
			case 2:		arrayPicture.set(i, "color2");	break;
			case 3:		arrayPicture.set(i, "color3");	break;
			case 4:		arrayPicture.set(i, "color4");	break;
			case 5:		arrayPicture.set(i, "color5");	break;
			case 6:		arrayPicture.set(i, "color6");	break;
			case 7:		arrayPicture.set(i, "color7");	break;
			case 8:	 	arrayPicture.set(i, "color8");	break;
			case 9:		arrayPicture.set(i, "color9");	break;
			case 10:	arrayPicture.set(i, "color10");	break;
			case 11:	arrayPicture.set(i, "color11");	break;
			case 12:	arrayPicture.set(i, "color12");	break;
			case 14:	arrayPicture.set(i, "color14");	break;
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
		SquareImageView view; 
		if (convertView == null)	{	
			view = new SquareImageView(mContext);
			view.setPadding(2, 2, 2, 2);
		}
		else						view = (SquareImageView) convertView;
		// Получаем идентификатор ресурса для картинки, которая находится в векторе arrayPicture на позиции position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
		// место последнего хода уменьшаем. Остальное ставим на место
		if (position == LastMoov)	{	view.setScaleX((float) 0.7);	view.setScaleY((float) 0.7);	}
		else 						{	view.setScaleX((float) 1);	view.setScaleY((float) 1);	}
		return view;
	}
}
package com.example.test1;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class gridadapter_Game extends BaseAdapter 
{
	private Context mContext;
	
	private ArrayList<String> arrayPicture; // массив картинок
	private Resources mRes; 		   		// –есурсы приложени
	private int SizeArray;
	
	public gridadapter_Game(Context context, ArrayList<String> arrayfromXML) 
	{
		mContext = context;
				
		arrayPicture = arrayfromXML;
		SizeArray = arrayPicture.size();
		
	    // ѕолучаем все ресурсы приложени€
	    mRes = mContext.getResources();
	 
	    // ћетод заполн€ющий массив arrayPicture
	    makePictArray();
	    
	}

	
	private void makePictArray() 
	{  	   
	    // добавл€ем
	    for (int i = 0; i<SizeArray; i++)
	    {
	    	int j = Integer.parseInt(arrayPicture.get(i));
	    	// j это содержимае i €чейки массива
	    	switch (j) 
	    	{
	    	// в зависимости от содержимого мен€ем €чейку массива на название файла с рисунком .png
			case 0:
				arrayPicture.set(i, "ball0");
				break;
				
			case 1:
				arrayPicture.set(i, "ball10");	
				break;
				
			case 2:
				arrayPicture.set(i, "ball20");	
				break;
				
			case 3:
				arrayPicture.set(i, "ball30");	
				break;

			case 4:
				arrayPicture.set(i, "ball40");	
				break;
				
			case 5:
				arrayPicture.set(i, "ball50");	
				break;

			case 6:
				arrayPicture.set(i, "ball60");	
				break;
				
			case 7:
				arrayPicture.set(i, "ball70");	
				break;

			case 8:
				arrayPicture.set(i, "ball80");	
				break;
				
			case 9:
				arrayPicture.set(i, "ball90");	
				break;

			default:
				arrayPicture.set(i, "ball1");
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
		ImageView view; // дл€ вывода картинки

		if (convertView == null)
			view = new ImageView(mContext);
		else
			view = (ImageView) convertView;


		// ѕолучаем идентификатор ресурса дл€ картинки,
	    // котора€ находитс€ в векторе arrayPicture на позиции position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
		
		return view;
	}
}

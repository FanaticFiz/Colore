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
	private Integer mCols, mRows;

	private ArrayList<String> arrayPicture; // массив картинок
	//private String PictureCollection; 		// Префикс набора картинок
	private Resources mRes; 		   		// Ресурсы приложени
	private int SizeArray;
	
	public gridadapter_Game(Context context, ArrayList<String> arrayfromXML) 
	{
		mContext = context;
				
		arrayPicture = arrayfromXML;
		SizeArray = arrayPicture.size();
		// Пока определяем префикс так, позже он будет браться из настроек
	    //PictureCollection = "ball";
	    // Получаем все ресурсы приложения
	    mRes = mContext.getResources();
	 
	    // Метод заполняющий массив arrayPicture
	    makePictArray();
	    
	}

	
	private void makePictArray () 
	{  	   
	    // добавляем
	    for (int i = 0; i<SizeArray; i++)
	    {
	    	int j = Integer.parseInt(arrayPicture.get(i));
	    	// j это содержимае i ячейки массива
	    	j++;
	    	j--;
	    	switch (j) 
	    	{
	    	// в зависимости от содержимого меняем ячейку массива на название файла с рисунком .png
			case 0:
				arrayPicture.set(j, "ball0.png");	
				break;
				
			case 1:
				arrayPicture.set(j, "ball10.png");	
				break;
				
			case 2:
				arrayPicture.set(j, "ball20.png");	
				break;
				
			case 3:
				arrayPicture.set(j, "ball30.png");	
				break;

			case 4:
				arrayPicture.set(j, "ball40.png");	
				break;
				
			case 5:
				arrayPicture.set(j, "ball50.png");	
				break;

			case 6:
				arrayPicture.set(j, "ball60.png");	
				break;
				
			case 7:
				arrayPicture.set(j, "ball70.png");	
				break;

			case 8:
				arrayPicture.set(j, "ball80.png");	
				break;
				
			case 9:
				arrayPicture.set(j, "ball90.png");	
				break;

			default:
				arrayPicture.set(j, "ball1.png");
				break;
			}
	    }
	}
	
	
	@Override
	public int getCount() 
	{
		return mCols * mRows;
	}

	
	@Override
	public Object getItem(int position) 
	{
		return null;
	}

	
	@Override
	public long getItemId(int position) 
	{
		return 0;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView view; // для вывода картинки

		if (convertView == null)
			view = new ImageView(mContext);
		else
			view = (ImageView) convertView;

		// Получаем идентификатор ресурса для картинки,
	    // которая находится в векторе arrayPicture на позиции position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);

		return view;
	}
}

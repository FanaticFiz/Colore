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
	private String PictureCollection; 		// Префикс набора картинок
	private Resources mRes; 		   		// Ресурсы приложени
	
	
	public gridadapter_Game(Context context, int cols, int rows) 
	{
		mContext = context;
		mCols = cols;
		mRows = rows;
		
		arrayPicture = new ArrayList<String>();
		// Пока определяем префикс так, позже он будет браться из настроек
	    PictureCollection = "ball";
	    // Получаем все ресурсы приложения
	    mRes = mContext.getResources();
	 
	    // Метод заполняющий массив arrayPicture
	    makePictArray();
	    
	}

	
	private void makePictArray () 
	{
	    // очищаем вектор
	    arrayPicture.clear();
	    
	    
	    // добавляем
	    for (int i = 0; i < ((mCols * mRows)); i++)
	    {
	    	arrayPicture.add (PictureCollection + Integer.toString(i));
	    }
	    
	    
	    // добавляем пока в ручную, потом думаю из XML файла. 
	    // Каждый уровень это отдельный массив
	   /*arrayPicture.add(0,"Ball1.png");arrayPicture.add(1,"Ball1.png");arrayPicture.add(2,"Ball1.png");arrayPicture.add(3,"Ball1.png");arrayPicture.add(4,"Ball1.png");arrayPicture.add(5,"Ball1.png");arrayPicture.add(6,"Ball1.png");arrayPicture.add(7,"Ball1.png");arrayPicture.add(8,"Ball1.png");arrayPicture.add(9,"Ball1.png");
	    arrayPicture.add(10,"Ball11.png");arrayPicture.add(11,"Ball11.png");arrayPicture.add(12,"Ball11.png");arrayPicture.add(13,"Ball11.png");arrayPicture.add(14,"Ball11.png");arrayPicture.add(15,"Ball11.png");arrayPicture.add(16,"Ball11.png");arrayPicture.add(17,"Ball11.png");arrayPicture.add(18,"Ball11.png");arrayPicture.add(19,"Ball11.png");
	    arrayPicture.add(20,"1.png");arrayPicture.add(21,"1.png");arrayPicture.add(22,"1.png");arrayPicture.add(23,"1.png");arrayPicture.add(24,"1.png");arrayPicture.add(25,"1.png");arrayPicture.add(26,"1.png");arrayPicture.add(27,"1.png");arrayPicture.add(28,"1.png");arrayPicture.add(29,"1.png");
	    arrayPicture.add(30,"1.png");arrayPicture.add(31,"1.png");arrayPicture.add(32,"1.png");arrayPicture.add(33,"1.png");arrayPicture.add(34,"1.png");arrayPicture.add(35,"1.png");arrayPicture.add(36,"1.png");arrayPicture.add(37,"1.png");arrayPicture.add(38,"1.png");arrayPicture.add(39,"1.png");
	    arrayPicture.add(40,"1.png");arrayPicture.add(41,"1.png");arrayPicture.add(42,"1.png");arrayPicture.add(43,"1.png");arrayPicture.add(44,"1.png");arrayPicture.add(45,"1.png");arrayPicture.add(46,"1.png");arrayPicture.add(47,"1.png");arrayPicture.add(48,"1.png");arrayPicture.add(49,"1.png");
	    arrayPicture.add(50,"1.png");arrayPicture.add(51,"1.png");arrayPicture.add(52,"1.png");arrayPicture.add(53,"1.png");arrayPicture.add(54,"1.png");arrayPicture.add(55,"1.png");arrayPicture.add(56,"1.png");arrayPicture.add(57,"1.png");arrayPicture.add(58,"1.png");arrayPicture.add(59,"1.png");
	    arrayPicture.add(60,"1.png");arrayPicture.add(61,"1.png");arrayPicture.add(62,"1.png");arrayPicture.add(63,"1.png");arrayPicture.add(64,"1.png");arrayPicture.add(65,"1.png");arrayPicture.add(66,"1.png");arrayPicture.add(67,"1.png");arrayPicture.add(68,"1.png");arrayPicture.add(69,"1.png");
	    arrayPicture.add(70,"1.png");arrayPicture.add(71,"1.png");arrayPicture.add(72,"1.png");arrayPicture.add(73,"1.png");arrayPicture.add(74,"1.png");arrayPicture.add(75,"1.png");arrayPicture.add(76,"1.png");arrayPicture.add(77,"1.png");arrayPicture.add(78,"1.png");arrayPicture.add(79,"1.png");
	    arrayPicture.add(80,"1.png");arrayPicture.add(81,"1.png");arrayPicture.add(82,"1.png");arrayPicture.add(83,"1.png");arrayPicture.add(84,"1.png");arrayPicture.add(85,"1.png");arrayPicture.add(86,"1.png");arrayPicture.add(87,"1.png");arrayPicture.add(88,"1.png");arrayPicture.add(89,"1.png");
	    arrayPicture.add(90,"1.png");arrayPicture.add(91,"1.png");arrayPicture.add(92,"1.png");arrayPicture.add(93,"1.png");arrayPicture.add(94,"1.png");arrayPicture.add(95,"1.png");arrayPicture.add(96,"1.png");arrayPicture.add(97,"1.png");arrayPicture.add(98,"1.png");arrayPicture.add(99,"1.png");	    
	    */
	    // перемешиваем
	    // Collections.shuffle(arrayPicture);
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
				
		//view.setImageResource(R.drawable.ball3);

		return view;
	}
}

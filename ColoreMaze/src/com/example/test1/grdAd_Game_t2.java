package com.example.test1;

import java.util.ArrayList;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class grdAd_Game_t2 extends BaseAdapter 
{
	private Context 			mContext;
	private ArrayList<String> 	arrayPicture; 		
	private Resources 			mRes; 		   		
	private int[] 				legal_moovs;		
	private int 				LastMoov, EndPoint;
	
	// Конструктор
	public grdAd_Game_t2(Context context, ArrayList<String> _arrayfromXML, int xMLgame_type, int[] _array_legal_moovs, int _LastMoov, int _EndPoint) 
	{
		mContext = context;
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
		
		makePictArray();
		notifyDataSetChanged();
	}
	
	private void makePictArray() 
	{  	
	    for (int i = 0; i<arrayPicture.size(); i++)
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
	    	//	15	-	контур	
	    	// Если полученный из массива номер есть в массиве доступных ходов то на эту ячейку возможен ход.
	    	// соответственно она появляется на поле, если же не совпадает то присваевается "ball15" - контур
			case 0:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball0");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 1:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball1");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 2:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball2");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 3:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball3");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 4:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball4");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 5:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball5");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 6:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball6");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 7:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball7");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 8:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball8");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 9:		if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball9");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 10:	if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball10");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 11:	if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball11");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 12:	if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball12");			}
						else {		arrayPicture.set(i, "ball15");			}
						break;
			case 14:	if ((legal_moovs[0] == i) || (legal_moovs[1] == i) || (legal_moovs[2] == i) || (legal_moovs[3] == i) || (LastMoov == i) || (EndPoint == i))	{
									arrayPicture.set(i, "ball14");			}	
						else {		arrayPicture.set(i, "ball15");			}
						break;
			default:	arrayPicture.set(i, "ball13");
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
		if (convertView == null)	view = new SquareImageView(mContext);
		else						view = (SquareImageView) convertView;
		// Получаем идентификатор ресурса для картинки, которая находится в векторе arrayPicture на позиции position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
		// место последнего хода уменьшаем. Остальное ставим на место
		if (position == LastMoov)	{	view.setScaleX((float) 0.7);	view.setScaleY((float) 0.7);	}
		else 						{	view.setScaleX((float) 1);		view.setScaleY((float) 1);		}
		return view;
	}
}

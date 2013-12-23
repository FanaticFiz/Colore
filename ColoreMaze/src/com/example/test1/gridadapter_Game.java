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
	private ArrayList<String> arrayPicture; // ������ ��������
	private Resources mRes; 		   		// ������� ���������
	private int SizeArray;
	
	public gridadapter_Game(Context context, ArrayList<String> arrayfromXML) 
	{
		mContext = context;
		arrayPicture = arrayfromXML;
		SizeArray = arrayPicture.size();
		
	    // �������� ��� ������� ����������
	    mRes = mContext.getResources();
	 
	    // ����� ����������� ������ arrayPicture
	    makePictArray();
	    
	}

	
	private void makePictArray() 
	{  	   
	    // ���������
	    for (int i = 0; i<SizeArray; i++)
	    {
	    	int j = Integer.parseInt(arrayPicture.get(i));
	    	// j ��� ���������� i ������ �������
	    	switch (j) 
	    	{
	    	// � ����������� �� ����������� ������ ������ ������� �� �������� ����� � �������� .png
	    	// �� ������ ������ 
	    	// 	0	-	����� 			-	�����
	    	// 	1 	-	������			-	�����
	    	//	2	-	����������
	    	// 	3	-	����� 
	    	// 	4 	-	�������	
	    	//	5	-	�������
	    	// 	6	-	����� 
	    	// 	7 	-	���������	
	    	//	8	-	���������
	    	// 	9	-	������� 
	    	// 	10	-	����������	
	    	//	11	-	������
	    	// 	12	-	�������	
	    	//	13	-	����������!!!
	    	//	14 	-	��������� )) 
	    	//		
	    	
			case 0:
				arrayPicture.set(i, "ball0");
				break;
				
			case 1:
				// ������ ��������� ����
				arrayPicture.set(i, "ball1");
				break;
				
			case 2:
				arrayPicture.set(i, "ball2");	
				break;
				
			case 3:
				arrayPicture.set(i, "ball3");	
				break;

			case 4:
				arrayPicture.set(i, "ball4");	
				break;
				
			case 5:
				arrayPicture.set(i, "ball5");	
				break;

			case 6:
				arrayPicture.set(i, "ball6");	
				break;
				
			case 7:
				arrayPicture.set(i, "ball7");	
				break;

			case 8:
				arrayPicture.set(i, "ball8");	
				break;
				
			case 9:
				arrayPicture.set(i, "ball9");	
				break;

			case 10:
				arrayPicture.set(i, "ball10");	
				break;

			case 11:
				arrayPicture.set(i, "ball11");	
				break;
				
			case 12:
				arrayPicture.set(i, "ball12");	
				break;
			case 14:
				arrayPicture.set(i, "ball14");	
				break;
			
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
		SquareImageView view; // ��� ������ ��������

		if (convertView == null)
			view = new SquareImageView(mContext);
		else
			view = (SquareImageView) convertView;

		// �������� ������������� ������� ��� ��������,
	    // ������� ��������� � ������� arrayPicture �� ������� position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
		//view.setPadding(4, 4, 4, 4);
		
		return view;
	}
}

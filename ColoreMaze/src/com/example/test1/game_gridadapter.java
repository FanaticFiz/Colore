package com.example.test1;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class game_gridadapter extends BaseAdapter 
{
	private Context mContext;
	private Integer mCols, mRows;

	private ArrayList<String> arrayPicture; // ������ ��������
	private String PictureCollection; 		// ������� ������ ��������
	private Resources mRes; 		   		// ������� ���������
	
	
	public game_gridadapter(Context context, int cols, int rows) 
	{
		mContext = context;
		mCols = cols;
		mRows = rows;
		
		arrayPicture = new ArrayList<String>();
		// ���� ���������� ������� ���, ����� �� ����� ������� �� ��������
	    PictureCollection = "ball";
	    // �������� ��� ������� ����������
	    mRes = mContext.getResources();
	 
	    // ����� ����������� ������ arrayPicture
	    makePictArray();
	    
	}

	
	private void makePictArray () 
	{
	    // ������� ������
	    arrayPicture.clear();
	    // ���������
	    for (int i = 0; i < ((mCols * mRows)); i++)
	    {
	      arrayPicture.add(PictureCollection + Integer.toString(i));
	    }
	    // ������������
	    Collections.shuffle(arrayPicture);
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
		ImageView view; // ��� ������ ��������

		if (convertView == null)
			view = new ImageView(mContext);
		else
			view = (ImageView) convertView;

		// �������� ������������� ������� ��� ��������,
	    // ������� ��������� � ������� arrayPicture �� ������� position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
				
		//view.setImageResource(R.drawable.ball3);

		return view;
	}
}

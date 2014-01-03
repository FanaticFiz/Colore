package com.example.test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridAdapter_LevelsImage extends BaseAdapter {
    private Context mContext;
    private int 	grid_type_of_game;		
    
    public gridAdapter_LevelsImage(Context c, int type_of_game_from_levels) 	
    { 
    	mContext = c;
    	grid_type_of_game = type_of_game_from_levels;
    }
    
    // ���� ������ ������ ���� �������� ���� ����� ���������� type_of_game � ����� ��� ����� ������ 
    // ��������������� ������� mThumbIds[] 
    // �� � ���� ������ ��� ������� ����� ���������� ������ ���, ������� �� ����� ������ ������ �� ��� ������.
    public int getCount() 						{ 	return mThumbIds1.length;   }
    public Object getItem(int position) 		{ 	return null;				}
    public long getItemId(int position) 		{ 	return 0;	   				}

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        SquareImageView imageView;
        if (convertView == null) 
        {  
        	// if it's not recycled, initialize some attributes
            imageView = new SquareImageView(mContext);                   
        } 
        else 
        {
            imageView = (SquareImageView) convertView;
        }
        
        // � ����������� �� ���������� ���� ���� ������������ ������ ������ � ������� ��� �����������
        switch (grid_type_of_game) {
		case 0:
			imageView.setImageResource(mThumbIds1[position]);	
			break;
		case 1:
			imageView.setImageResource(mThumbIds2[position]);	
			break;
		case 2:
			imageView.setImageResource(mThumbIds3[position]);	
			break;
		case 3:
			imageView.setImageResource(mThumbIds4[position]);	
			break;
		default:
			//imageView.setImageResource(mThumbIds1[position]);	
			break;
		}
            
        return imageView;
    }

    // ����� ��������� ������� � ������� ������������� ����������� ������� ��� ����������� ������� 
    // � �������� levels. �� ������ ������ � �������� 24 ������ �� ������ ��� ����.
    private Integer[] mThumbIds1 = {
            R.drawable.type1_level1, R.drawable.type1_level2, R.drawable.type1_level3, R.drawable.type1_level4,
            R.drawable.type1_level5, R.drawable.type1_level6, R.drawable.type1_level7, R.drawable.type1_level8,
            R.drawable.type1_level9, R.drawable.type1_level10,R.drawable.type1_level11,R.drawable.type1_level12,
    };
    
    private Integer[] mThumbIds2 = {
            R.drawable.type2_level1, R.drawable.type2_level2, R.drawable.type2_level3, R.drawable.type2_level4,
            R.drawable.type2_level5, R.drawable.type2_level6, R.drawable.type2_level7, R.drawable.type2_level8,
            R.drawable.type2_level9, R.drawable.type2_level10,R.drawable.type2_level11,R.drawable.type2_level12,
    };

    private Integer[] mThumbIds3 = {
            R.drawable.type3_level1, R.drawable.type3_level2, R.drawable.type3_level3, R.drawable.type3_level4,
            R.drawable.type3_level5, R.drawable.type3_level6, R.drawable.type3_level7, R.drawable.type3_level8,
            R.drawable.type3_level9, R.drawable.type3_level10,R.drawable.type3_level11,R.drawable.type3_level12,
    };

    private Integer[] mThumbIds4 = {
            R.drawable.type4_level1, R.drawable.type4_level2, R.drawable.type4_level3, R.drawable.type4_level4,
            R.drawable.type4_level5, R.drawable.type4_level6, R.drawable.type4_level7, R.drawable.type4_level8,
            R.drawable.type4_level9, R.drawable.type4_level10,R.drawable.type4_level11,R.drawable.type4_level12,
    };

}
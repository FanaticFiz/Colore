package com.example.test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridAdapter_LevelsImage extends BaseAdapter {
    private Context 		mContext;
    private int 			grid_type_of_game;
    private static int[] 	array_of_P;	
    private int 			ggggg;
    
	
 	
    public gridAdapter_LevelsImage(Context c, int type_of_game_from_levels, int[] pref_type_AllAboutLevels) 	
    { 
    	mContext = c;
    	grid_type_of_game = type_of_game_from_levels;
    	array_of_P = pref_type_AllAboutLevels;
    }
    
    // ���� ������ ������ ���� �������� ���� ����� ���������� type_of_game � ����� ��� ����� ������ 
    // ��������������� ������� mThumbIds[] 
    // �� � ���� ������ ��� ������� ����� ���������� ������ ���, ������� �� ����� ������ ������ �� ��� ������.
    public int getCount() 						{ 	return mThumbIds1.length-12;   }
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
        
        // ���� ��� � ����� ���� �������...
        // ������: ���������� ���� ����������� ������ ���� �������� �� ���������� ����� 1 � ������ ���� �������� ��������� 0
        // ��������� ��� ��� ���� ������������ ���� ��� ��� �������� �������� �������, �� ������ � getView � �������� ��� ����� �����...
        // ��������� � ����� � ������ ��� ������ �� ���� ������� � ������� "private Integer[] mThumbIds" �� � �������� ���������
        // �������� � ��� ������� ��������� �������� � ��� ������ 24 �������� ������� ���������� �������� ��������� ������ � ��� +24 ������� ���������� �������� ���������
        // � � ����������� �� �������� � ���������� ����� ���� 0,1,2... ��������, ���� �� ������� 0+24,1+24,2+24... ��������...
        // �������� ���� ��� ��� ����� � ����� ��� ������� � ���� ����� ������ ��������� ��� ��� �� ��������/�������������� ��� ��
        switch (position) 
        {
		case 0:	if (array_of_P[0] > 0) 	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 1:	if (array_of_P[1] > 0) 	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 2:	if (array_of_P[2] > 0) 	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 3:	if (array_of_P[3] > 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 4:	if (array_of_P[4] > 0) 	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 5:	if (array_of_P[5] > 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 6:	if (array_of_P[6] > 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 7:	if (array_of_P[7] > 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 8:	if (array_of_P[8] > 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 9:	if (array_of_P[9] > 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 10:if (array_of_P[10]> 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;
		case 11:if (array_of_P[11]> 0)	{  	ggggg = position + 12;	}
				else 					{	ggggg = position;		}
				break;

		default:
			ggggg = position;
			break;
		}
        
        
        // � ����������� �� ���������� ���� ���� ������������ ������ ������ � ������� ��� �����������
        switch (grid_type_of_game) {
		case 0:
			imageView.setImageResource(mThumbIds1[ggggg]);	
			break;
		case 1:
			imageView.setImageResource(mThumbIds2[ggggg]);	
			break;
		case 2:
			imageView.setImageResource(mThumbIds3[ggggg]);	
			break;
		case 3:
			imageView.setImageResource(mThumbIds4[ggggg]);	
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
    		
    		R.drawable.layer_of_levelsgrid1,	R.drawable.layer_of_levelsgrid2,	R.drawable.layer_of_levelsgrid3,	R.drawable.layer_of_levelsgrid4,
            R.drawable.layer_of_levelsgrid5,	R.drawable.layer_of_levelsgrid6,	R.drawable.layer_of_levelsgrid7,	R.drawable.layer_of_levelsgrid8,
            R.drawable.layer_of_levelsgrid9,	R.drawable.layer_of_levelsgrid10,	R.drawable.layer_of_levelsgrid11,	R.drawable.layer_of_levelsgrid12,
              
    		R.drawable.type1_level1,			R.drawable.type1_level2,			R.drawable.type1_level3,			R.drawable.type1_level4,
    		R.drawable.type1_level5,			R.drawable.type1_level6,			R.drawable.type1_level7,			R.drawable.type1_level8,
    		R.drawable.type1_level8,			R.drawable.type1_level10,			R.drawable.type1_level11,			R.drawable.type1_level12,          
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
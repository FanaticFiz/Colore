package com.example.test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridAdapter_LevelsImage extends BaseAdapter {
    private Context mContext;
    private int 	grid_type_of_game,preference_levels_compleate;		
    
    
    public gridAdapter_LevelsImage(Context c, int type_of_game_from_levels) 	
    { 
    	mContext = c;
    	grid_type_of_game = type_of_game_from_levels;
    }
    
    // этом методе поидее надо смотреть чему равна переменная type_of_game и тогда уже брать длинну 
    // соответсвующего массива mThumbIds[] 
    // НО у меня поидее эти массивы будут одинаковый длинны все, поэтому мы берем длинну одного из них только.
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
        
        // В зависимости от выбранного типа игры подгружается нужный массив с данными для отображения
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
   
    // Здесь обьявлены массивы в которых перечисляются графические ресурсы для отображения уровней 
    // в активити levels. На данный момент я планирую 24 уровня на каждый тип игры.
    private Integer[] mThumbIds1 = {
            R.drawable.layer_of_levelsgrid1,	R.drawable.layer_of_levelsgrid2,	R.drawable.layer_of_levelsgrid3,	R.drawable.layer_of_levelsgrid4,
            R.drawable.layer_of_levelsgrid5,	R.drawable.layer_of_levelsgrid6,	R.drawable.layer_of_levelsgrid7,	R.drawable.layer_of_levelsgrid8,
            R.drawable.layer_of_levelsgrid9,	R.drawable.layer_of_levelsgrid10,	R.drawable.layer_of_levelsgrid11,	R.drawable.layer_of_levelsgrid12,
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
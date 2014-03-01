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
    
    // этом методе поидее надо смотреть чему равна переменная type_of_game и тогда уже брать длинну 
    // соответсвующего массива mThumbIds[] 
    // НО у меня поидее эти массивы будут одинаковый длинны все, поэтому мы берем длинну одного из них только.
    public int getCount() 						{ 	return mThumbIds1.length-48;	}
    public Object getItem(int position) 		{ 	return null;					}
    public long getItemId(int position) 		{ 	return 0;	   					}

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
        
        // Итак что я хотел этим сказать...
        // Задача: показывать один графический ресурс если значение из преферанса равно 1 и другой если значение параметра 0
        // поскольку все это дело отображается один раз при открытии активити уровней, то именно в getView я придумал вот такую хрень...
        // поскольку я турок и незнаю как отойти от кода взятого в примере "private Integer[] mThumbIds" то я придумал следующее
        // добавить в эти массивы избточные значения в моём случае 24 елемента которые отображают закрытое состояние уровня и еще +24 которые отображают открытое состояние
        // и в зависимости от значения в преферансе брать либо 0,1,2... элементы, либо со сдвигом 0+24,1+24,2+24... элементы...
        // возможно даже что так лучше в плане что ненужно в коде потом менять состояния или как то рисовать/перерисовывать что то
        switch (position) 
        {
		case 0:	if (array_of_P[0]==0) 	{	ggggg = position+24;	}
				if (array_of_P[0]>0) 	{	ggggg = position+48;	}
				break;

		case 1:
			if 	(array_of_P[0]== 0) 					{  	ggggg = position;		}	// замочек
			if ((array_of_P[0] > 0)&(array_of_P[1]==0)) {  	ggggg = position + 24;	}	// чисто
			if  (array_of_P[1] > 0)						{	ggggg = position + 48;	}	// галочка			
			break;
		case 2:	
			if 	(array_of_P[1]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[1] > 0)&(array_of_P[2]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[2] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 3:				
			if 	(array_of_P[2]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[2] > 0)&(array_of_P[3]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[3] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 4:	
			if 	(array_of_P[3]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[3] > 0)&(array_of_P[4]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[4] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 5:	
			if 	(array_of_P[4]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[4] > 0)&(array_of_P[5]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[5] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 6:	
			if 	(array_of_P[5]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[5] > 0)&(array_of_P[6]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[6] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 7:	
			if 	(array_of_P[6]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[6] > 0)&(array_of_P[7]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[7] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 8:	
			if 	(array_of_P[7]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[7] > 0)&(array_of_P[8]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[8] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 9:	
			if 	(array_of_P[8]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[8] > 0)&(array_of_P[9]==0)) {  	ggggg = position + 24;	}
			if  (array_of_P[9] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 10:
			if 	(array_of_P[9]== 0) 					{  	ggggg = position;		}
			if ((array_of_P[9] > 0)&(array_of_P[10]==0)){  	ggggg = position + 24;	}
			if  (array_of_P[10]> 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 11:
			if 	(array_of_P[10]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[10] > 0)&(array_of_P[11]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[11] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 12:
			if 	(array_of_P[11]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[11] > 0)&(array_of_P[12]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[12] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 13:
			if 	(array_of_P[12]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[12] > 0)&(array_of_P[13]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[13] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 14:
			if 	(array_of_P[13]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[13] > 0)&(array_of_P[14]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[14] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 15:
			if 	(array_of_P[14]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[14] > 0)&(array_of_P[15]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[15] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 16:
			if 	(array_of_P[15]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[15] > 0)&(array_of_P[16]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[16] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 17:
			if 	(array_of_P[16]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[16] > 0)&(array_of_P[17]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[17] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 18:
			if 	(array_of_P[17]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[17] > 0)&(array_of_P[18]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[18] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 19:
			if 	(array_of_P[18]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[18] > 0)&(array_of_P[19]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[19] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 20:
			if 	(array_of_P[19]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[19] > 0)&(array_of_P[20]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[20] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 21:
			if 	(array_of_P[20]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[20] > 0)&(array_of_P[21]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[21] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 22:
			if 	(array_of_P[21]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[21] > 0)&(array_of_P[22]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[22] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		case 23:
			if 	(array_of_P[22]== 0) 						{  	ggggg = position;		}
			if ((array_of_P[22] > 0)&(array_of_P[23]==0)) 	{  	ggggg = position + 24;	}
			if  (array_of_P[23] > 0)						{	ggggg = position + 48;	}	// галочка				
			break;

		default:
			ggggg = position;
			break;
		}
        
        
        // В зависимости от выбранного типа игры подгружается нужный массив с данными для отображения
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
   
    // Здесь обьявлены массивы в которых перечисляются графические ресурсы для отображения уровней 
    // в активити levels. На данный момент я планирую 24 уровня на каждый тип игры.
    private Integer[] mThumbIds1 = {
    		
    		R.drawable.layer_of_levelsgrid1,	R.drawable.layer_of_levelsgrid2,	R.drawable.layer_of_levelsgrid3,	R.drawable.layer_of_levelsgrid4,		// замочек	
            R.drawable.layer_of_levelsgrid5,	R.drawable.layer_of_levelsgrid6,	R.drawable.layer_of_levelsgrid7,	R.drawable.layer_of_levelsgrid8,
            R.drawable.layer_of_levelsgrid9,	R.drawable.layer_of_levelsgrid10,	R.drawable.layer_of_levelsgrid11,	R.drawable.layer_of_levelsgrid12,
            R.drawable.layer_of_levelsgrid13,	R.drawable.layer_of_levelsgrid14,	R.drawable.layer_of_levelsgrid15,	R.drawable.layer_of_levelsgrid16,		// замочек	
            R.drawable.layer_of_levelsgrid17,	R.drawable.layer_of_levelsgrid18,	R.drawable.layer_of_levelsgrid19,	R.drawable.layer_of_levelsgrid20,
            R.drawable.layer_of_levelsgrid21,	R.drawable.layer_of_levelsgrid22,	R.drawable.layer_of_levelsgrid23,	R.drawable.layer_of_levelsgrid24,
            
              
    		R.drawable.type1_level1,			R.drawable.type1_level2,			R.drawable.type1_level3,			R.drawable.type1_level4,				// чисто
    		R.drawable.type1_level5,			R.drawable.type1_level6,			R.drawable.type1_level7,			R.drawable.type1_level8,
    		R.drawable.type1_level9,			R.drawable.type1_level10,			R.drawable.type1_level11,			R.drawable.type1_level12,
    		R.drawable.type1_level13,			R.drawable.type1_level14,			R.drawable.type1_level15,			R.drawable.type1_level16,				// чисто
    		R.drawable.type1_level17,			R.drawable.type1_level18,			R.drawable.type1_level19,			R.drawable.type1_level20,
    		R.drawable.type1_level21,			R.drawable.type1_level22,			R.drawable.type1_level23,			R.drawable.type1_level24,

    		
    		R.drawable.layer_of_levelsgrid1_ok,	R.drawable.layer_of_levelsgrid2_ok,	R.drawable.layer_of_levelsgrid3_ok,	R.drawable.layer_of_levelsgrid4_ok,		// галочка
            R.drawable.layer_of_levelsgrid5_ok,	R.drawable.layer_of_levelsgrid6_ok,	R.drawable.layer_of_levelsgrid7_ok,	R.drawable.layer_of_levelsgrid8_ok,
            R.drawable.layer_of_levelsgrid9_ok,	R.drawable.layer_of_levelsgrid10_ok,R.drawable.layer_of_levelsgrid11_ok,R.drawable.layer_of_levelsgrid12_ok,
    		R.drawable.layer_of_levelsgrid13_ok,R.drawable.layer_of_levelsgrid14_ok,R.drawable.layer_of_levelsgrid15_ok,R.drawable.layer_of_levelsgrid16_ok,	// галочка
            R.drawable.layer_of_levelsgrid17_ok,R.drawable.layer_of_levelsgrid18_ok,R.drawable.layer_of_levelsgrid19_ok,R.drawable.layer_of_levelsgrid20_ok,
            R.drawable.layer_of_levelsgrid21_ok,R.drawable.layer_of_levelsgrid22_ok,R.drawable.layer_of_levelsgrid23_ok,R.drawable.layer_of_levelsgrid24_ok,

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
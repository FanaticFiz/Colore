package com.example.test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class gridAdapter_LevelsImage extends BaseAdapter {
    private Context mContext;

    public gridAdapter_LevelsImage(Context c) 	{ mContext = c; 			}
    public int getCount() 						{ return mThumbIds.length; 	}
    public Object getItem(int position) 		{ return null;				}
    public long getItemId(int position) 		{ return 0;	   				}

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
                    
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Если хотим добавить элементов, то добавляем их сюда
    private Integer[] mThumbIds = {
            R.drawable.level1, R.drawable.level2,
            R.drawable.level3, R.drawable.level4,
            R.drawable.level5, R.drawable.level6,
            R.drawable.level7, R.drawable.level8,
            R.drawable.level9,
    };
}
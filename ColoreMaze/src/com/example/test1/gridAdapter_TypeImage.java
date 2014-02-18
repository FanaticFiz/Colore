package com.example.test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridAdapter_TypeImage extends BaseAdapter {
    private Context mContext;

    public gridAdapter_TypeImage(Context c) { mContext = c; 			}
    public int getCount() 					{ return mThumbIds.length; 	}
    public Object getItem(int position) 	{ return null;				}
    public long getItemId(int position) 	{ return 0;	   				}

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	SquareImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new SquareImageView(mContext);
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);            
        } else {
            imageView = (SquareImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // ���� ����� �������� ���������, �� ��������� �� ����
    private Integer[] mThumbIds = {
            R.drawable.rebenok2, 	R.drawable.type_soon2,
            R.drawable.type_soon3, 	R.drawable.type_soon4,
    };
}
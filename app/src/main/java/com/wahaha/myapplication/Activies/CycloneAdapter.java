package com.wahaha.myapplication.Activies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wahaha.myapplication.R;

public class CycloneAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIds = new int[]{R.drawable.stormone, R.drawable.stormtwo, R.drawable.stormthree, R.drawable.stormfour, R.drawable.stormfive,R.drawable.stormsix,R.drawable.stormseven,R.drawable.stormeight,R.drawable.stormnine,R.drawable.stormten,R.drawable.stormeleven,R.drawable.droughttwelve,R.drawable.stormthirteen,R.drawable.stormfourteen,R.drawable.stormfifteen,R.drawable.stormsixteen};

    CycloneAdapter(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;


    }
}

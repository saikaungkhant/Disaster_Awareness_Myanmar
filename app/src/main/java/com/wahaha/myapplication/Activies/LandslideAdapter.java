package com.wahaha.myapplication.Activies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wahaha.myapplication.R;

public class LandslideAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIds = new int[]{R.drawable.landslideone, R.drawable.landslidetwo, R.drawable.landslidethree, R.drawable.landslidefour, R.drawable.landslidefive,R.drawable.landslidesix,R.drawable.landslideseven,R.drawable.landslideeight,R.drawable.landslidenine,R.drawable.landslideten,R.drawable.landslideeleven,R.drawable.landslidetwelve,R.drawable.landslidethirteen,R.drawable.landslidefourteen,R.drawable.landslidefifteen,R.drawable.landslidesixteen,R.drawable.landslideseveteen,R.drawable.landslideeighteen,R.drawable.landslidenineteen,R.drawable.landslidetwenty};

    LandslideAdapter(Context context) {
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

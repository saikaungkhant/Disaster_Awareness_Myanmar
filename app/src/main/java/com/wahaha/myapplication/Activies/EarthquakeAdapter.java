package com.wahaha.myapplication.Activies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wahaha.myapplication.R;

public class EarthquakeAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImageIds = new int[]{R.drawable.earthone, R.drawable.earthtwo, R.drawable.earththree, R.drawable.earthfour, R.drawable.eqfive, R.drawable.eqsix, R.drawable.eqseven, R.drawable.eqeight, R.drawable.eqnine, R.drawable.eqten, R.drawable.eqeleven, R.drawable.eqtwelve, R.drawable.eqthirteen, R.drawable.eqfourteen, R.drawable.eqfifteen, R.drawable.stormsixteen, R.drawable.eqeighteen, R.drawable.eqnineteen, R.drawable.eqtwelve};

    EarthquakeAdapter(Context context) {
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

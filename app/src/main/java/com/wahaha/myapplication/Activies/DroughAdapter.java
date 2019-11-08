package com.wahaha.myapplication.Activies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wahaha.myapplication.R;

public class DroughAdapter extends PagerAdapter {private Context mContext;
    private int[] mImageIds = new int[]{R.drawable.droughtone, R.drawable.droughttwo, R.drawable.droughtthree, R.drawable.droughtfour, R.drawable.droughtfive,R.drawable.droughtsix,R.drawable.droughtseven,R.drawable.droughteight,R.drawable.droughtnine,R.drawable.droughtten,R.drawable.droughteleven,R.drawable.droughttwelve,R.drawable.droughtthirteen,R.drawable.droughtfourteen,R.drawable.droughtfifteen,R.drawable.droughtsixteen,R.drawable.droughtseveteen,R.drawable.droughteighteen};

    DroughAdapter(Context context) {
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

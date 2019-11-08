package com.wahaha.myapplication.Activies;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wahaha.myapplication.R;

import java.text.BreakIterator;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout itemLayout;
    TextView txtTitle, txtDate;

    public MyRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        txtDate = (TextView)itemView.findViewById(R.id.txtDate);
        itemLayout = (RelativeLayout)itemView.findViewById(R.id.itemLayout);
    }
}

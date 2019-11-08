package com.wahaha.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wahaha.myapplication.Donation;

import java.util.List;

/**
 * Created by HP on 23/6/2019.
 */
public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.DonationViewHolder>
{
    private Context context;
    private List<Donation> donationList;

    public DonationAdapter(Context context, List<Donation> donationList) {
        this.context = context;
        this.donationList = donationList;
    }

    @Override
    public DonationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.cardview,null);
        DonationViewHolder holder=new DonationViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DonationViewHolder holder, int position) {
        Donation donation=donationList.get(position);
        holder.txtTitle.setText(donation.getTitle());
        holder.txtAddress.setText(donation.getAddress());
        holder.txtphone.setText(donation.getPhone());

        holder.imageView.setImageDrawable(context.getResources().getDrawable(donation.getImage()));

        final String ph=holder.txtphone.getText().toString();
        // Log.i("This is Phone intent","TextPhone"+ph);


        holder.txtphone.setOnClickListener(new View.OnClickListener()
        {
            //ph=txtph.getText().toString();
            @Override
            public void onClick(View view)
            {
                Intent callintent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ph));
                Log.i("This is Phone intent","TextPhone"+ph);
                view.getContext().startActivity(callintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return donationList.size();
    }

    class DonationViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView txtTitle,txtphone,txtAddress;

        public DonationViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtAddress=itemView.findViewById(R.id.txtaddress);
            txtphone=itemView.findViewById(R.id.txtphone);
        }
    }
}

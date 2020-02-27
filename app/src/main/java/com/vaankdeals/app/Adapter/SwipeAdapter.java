package com.vaankdeals.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vaankdeals.app.Model.DealItem;
import com.vaankdeals.app.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class SwipeAdapter extends RecyclerView.Adapter <SwipeAdapter.DealViewHolder> {

    Context mContext;
    private List<Object> mDealList;

    public SwipeAdapter(Context mContext, List<Object> mDealList) {
        this.mContext = mContext;
        this.mDealList = mDealList;
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.deal_item, parent, false);
        return new DealViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {
        DealItem currentItem = (DealItem) mDealList.get(position);
        String mDealTitle = currentItem.getmDealTitle();
        String mDealIMage= currentItem.getmDealImage();

        holder.dealName.setText(mDealTitle);
        Glide.with(mContext).load(mDealIMage).into(holder.dealImage);

    }


    public class DealViewHolder extends RecyclerView.ViewHolder {
        TextView dealName;
        ImageView dealImage;

        public DealViewHolder(@NonNull View itemView) {
            super(itemView);

            dealImage = itemView.findViewById(R.id.dealimage);
            dealName =itemView.findViewById(R.id.dealtitle);

        }
    }

    @Override
    public int getItemCount() {
        return mDealList.size();
    }
}


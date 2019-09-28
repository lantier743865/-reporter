package com.lantier.trackdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lantier.trackdemo.ItemVH;
import com.lantier.trackdemo.R;
import com.lantier.trackdemo.bean.ItemBean;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemVH> {
    private static final String TAG = "ItemAdapter";
    private List<ItemBean> mList;

    public ItemAdapter(List<ItemBean> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track_main, parent, false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH holder, int position) {
        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

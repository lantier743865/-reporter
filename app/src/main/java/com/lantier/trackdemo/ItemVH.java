package com.lantier.trackdemo;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lantier.trackdemo.bean.ItemBean;


public class ItemVH extends RecyclerView.ViewHolder {
    private static final String TAG = "ItemVH";
    private TextView tv_item_name;
    private TextView tv_item_time;
    private TextView tv_item_upload;

    public ItemVH(@NonNull View itemView) {
        super(itemView);
        tv_item_name = itemView.findViewById(R.id.tv_item_name);
        tv_item_time = itemView.findViewById(R.id.tv_item_time);
        tv_item_upload = itemView.findViewById(R.id.tv_item_upload);
    }

    public void bindData(ItemBean itemBean) {
        tv_item_name.setText(itemBean.getName());
        tv_item_time.setText(itemView.getResources().getString(R.string.item_track_count,itemBean.getCount()));
        tv_item_upload.setText(itemView.getResources().getString(R.string.item_track_upload,itemBean.getCount()));
    }
}

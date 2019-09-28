package com.lantier.trackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;

import com.lantier.reporter.ItemViewReporterApi;
import com.lantier.reporter.ItemViewReporterFactory;
import com.lantier.reporter.OnExposureCallback;
import com.lantier.trackdemo.adapter.ItemAdapter;
import com.lantier.trackdemo.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerview;
    private List<ItemBean> mTotalList;
    private int testCount = 1000;
    private ItemAdapter mAdapter;
    private ItemViewReporterApi itemReporter;
    private SparseIntArray data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initReporter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemReporter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        itemReporter.release();
    }

    private void initReporter() {
        itemReporter = ItemViewReporterFactory.getItemReporter(mRecyclerview);
        data = itemReporter.getData();
        itemReporter.setOnExposureCallback(new OnExposureCallback() {
            @Override
            public void onExposure(List<Integer> exposePosition, List<View> exposeView) {
                for (int i = 0; i < exposePosition.size(); i++) {
                    Integer integer = exposePosition.get(i);
                    ItemBean itemBean = mTotalList.get(integer);
                    int count = data.get(integer);
                    itemBean.setCount(count);
                    final int finalI = integer;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.notifyItemChanged(finalI);
                        }
                    });

                }
            }
        });

    }

    private void initData() {
        if (mTotalList == null) {
            mTotalList = new ArrayList<>();
        }
        for (int i = 0; i < testCount; i++) {
            mTotalList.add(new ItemBean("item" + i,0,0));
        }
    }

    private void initView() {
        mRecyclerview = findViewById(R.id.recyclerview_main);
        mAdapter = new ItemAdapter(mTotalList);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(mAdapter);
    }
}

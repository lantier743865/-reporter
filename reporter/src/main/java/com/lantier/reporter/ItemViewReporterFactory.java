package com.lantier.reporter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *  RecyclerView Item曝光数据统计
 *  工厂类
 */
public class ItemViewReporterFactory {
    private ItemViewReporterFactory() {
    }


    public static ItemViewReporterApi getItemReporter(RecyclerView recyclerView) throws IllegalArgumentException {
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof LinearLayoutManager) {
            return new ItemViewReporterImpl(recyclerView);
        }
        throw new IllegalArgumentException("LayoutManager must be LinearLayoutManager");
    }
}

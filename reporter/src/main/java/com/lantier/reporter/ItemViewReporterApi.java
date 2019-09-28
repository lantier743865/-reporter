package com.lantier.reporter;

import android.util.SparseIntArray;

/**
 *
 * 调用接口
 * RecyclerView Item曝光数据统计
 * 数据获取分两种方式：
 * 1、通过getData获得当前总曝光量
 * 2、通过setOnExposureCallback监听每次曝光事件
 */
public interface ItemViewReporterApi {
    /**
     * 重置data曝光量
     */
    void reset();

    /**
     * 停止监听并且释放资源
     */
    void release();

    /**
     * 获得当前状态
     */
    boolean isReleased();

    /**
     * 得到曝光数据总集合
     */
    SparseIntArray getData();

    /**
     * 设置曝光回调
     */
    void setOnExposureCallback(OnExposureCallback exposureCallback);

    /**
     * 当RecyclerView所在页面获得焦点时统计一次曝光
     */
    void onResume();

    /**
     * @param interval 曝光时间间隔,单位ms
     */
    void setTouchInterval(long interval);

    /**
     * @param interval 曝光时间间隔，单位ms
     * @see #onResume()
     */
    void setResumeInterval(long interval);
}

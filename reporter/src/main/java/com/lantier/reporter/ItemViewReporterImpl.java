package com.lantier.reporter;

import android.util.SparseIntArray;

import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView Item曝光数据统计
 * 外部实现
 */
public class ItemViewReporterImpl extends ItemViewReporterBase {
    ItemViewReporterImpl(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    public void reset() {
        templateCheck();
        mHandler.removeCallbacksAndMessages(null);
        mReportData.clear();
        mOldFirstComPt = -1;
        mOldLastComPt = -1;
        mLastResumeTime = 0;
        mLastTouchTime = 0;
    }

    @Override
    public void release() {
        templateCheck();
        mIsRelease = true;
        mRecyclerView.removeOnScrollListener(mScrollListener);
        mHandler.getLooper().quit();
        mHandlerThread.quit();
        mReportData.clear();
        mExposureCallback = null;
        mRecyclerView = null;
    }

    @Override
    public boolean isReleased() {
        return mIsRelease;
    }

    @Override
    public SparseIntArray getData() {
        templateCheck();
        return mReportData;
    }

    @Override
    public void setOnExposureCallback(OnExposureCallback exposureCallback) {
        this.mExposureCallback = exposureCallback;
    }


    @Override
    public void onResume() {
        templateCheck();
        mLastResumeTime = templateTimeCtrl(mLastResumeTime, mIntervalResume, WHAT_RESUME);
    }

    @Override
    public void setResumeInterval(long interval) {
        templateCheck();
        this.mIntervalResume = interval;
    }

    @Override
    public void setTouchInterval(long interval) {
        templateCheck();
        this.mIntervalTouch = interval;
    }
}

package com.lantier.reporter;

import android.view.View;

import java.util.List;

/**
 *  曝光回调接口
 */
public interface OnExposureCallback {
    void onExposure(List<Integer> exposePosition, List<View> exposeView);
}

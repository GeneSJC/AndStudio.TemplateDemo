package com.demo.app4.util;

import android.view.MotionEvent;

/**
 * Ensures developers are aware of handling onMove() event
 * for any class that implements this interface
 */
public interface OnMoveHandler {

    void onMove(MotionEvent event);
}

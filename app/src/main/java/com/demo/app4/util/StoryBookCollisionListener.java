package com.demo.app4.util;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class StoryBookCollisionListener extends DragAndDropCollisionListener {

	public StoryBookCollisionListener(WindowManager windowManager, View targetImageView) {

		super(windowManager, targetImageView);
	}

	public void onMove(MotionEvent event) {

		boolean isCollision = isCollision();
		String msg = "isCollision : " + isCollision;
		Log.d("dbg", msg);
	}


}

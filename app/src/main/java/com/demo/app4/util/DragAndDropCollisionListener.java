package com.demo.app4.util;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.demo.app4.R;

public class DragAndDropCollisionListener extends DragAndDropListenerLogic {

	// For collision detection
	private View targetImageView;	// target to watch for intersect from dragItem

	public DragAndDropCollisionListener(Activity activity, View targetImageView) {

		super(activity);

		this.targetImageView = targetImageView;
	}

	public void onMove(MotionEvent event) {

		boolean isCollision = isCollision();
		String msg = "isCollision : " + isCollision;
		Log.d("dbg", msg);
	}

	private boolean isCollision () {

		boolean isCollision = false;

		Rect dragItem_viewRect = new Rect();
		dragItemImageView.getHitRect(dragItem_viewRect);

		Rect target_viewRect = new Rect();
		targetImageView.getHitRect(target_viewRect);

		if (Rect.intersects(dragItem_viewRect, target_viewRect)) {

			isCollision = true;
		}

		return isCollision;
	}

}

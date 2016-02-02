package com.demo.app4.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.demo.app4.R;
import com.demo.app4.util.DragAndDropCollisionListener;

public class DrawableDragDropActivity extends Activity
{
	DragAndDropCollisionListener dragAndDropCollisionLstnr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dragndrop_bluesky);

		this.dragAndDropCollisionLstnr = getSunInSkyCollisionListener();
	}

	private DragAndDropCollisionListener getSunInSkyCollisionListener() {

		WindowManager windowManager = getWindowManager();

		int id_containerViewGroup = R.id.my_sky_layout;
		int id_dragItemImageView  = R.id.sun;

		ViewGroup dragAreaViewGroup = (ViewGroup) findViewById(id_containerViewGroup);

		View dragItemImgView = findViewById(id_dragItemImageView);
		View targetImageView = findViewById(R.id.target);

		DragAndDropCollisionListener dragAndDropCollisionLstnr =
				new DragAndDropCollisionListener(windowManager, targetImageView);

		dragAndDropCollisionLstnr.setDragDrop(dragAreaViewGroup, dragItemImgView);

		return dragAndDropCollisionLstnr;
	}
}

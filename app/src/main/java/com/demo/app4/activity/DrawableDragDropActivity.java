package com.demo.app4.activity;

import android.app.Activity;
import android.os.Bundle;

import com.demo.app4.R;
import com.demo.app4.util.DragAndDropCollisionListener;
import com.demo.app4.util.DragAndDropTemplate;

public class DrawableDragDropActivity extends Activity
{
	DragAndDropCollisionListener dragAndDropCollisionLstnr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dragndrop_bluesky);

		dragAndDropCollisionLstnr = DragAndDropTemplate.getSunInSkyCollisionListener(this);
	}

}

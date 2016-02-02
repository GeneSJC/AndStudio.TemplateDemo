package com.demo.app4.activity;

import android.app.Activity;
import android.os.Bundle;

import com.demo.app4.R;
import com.demo.app4.util.DragAndDropCollisionListener;

public class DrawableDragDropActivity extends Activity
{
	DragAndDropCollisionListener dragAndDropCollisionListener;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dragndrop_bluesky);

		int id_containerViewGroup = R.id.my_sky_layout;
		int id_dragItemImageView  = R.id.sun;
		int id_targetView  		  = R.id.target;

		dragAndDropCollisionListener =
				new DragAndDropCollisionListener(this, id_targetView);

		dragAndDropCollisionListener
				.setDragDrop(id_containerViewGroup,
							 id_dragItemImageView);
	}
}

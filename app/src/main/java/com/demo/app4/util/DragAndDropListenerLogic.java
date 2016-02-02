package com.demo.app4.util;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

abstract public class DragAndDropListenerLogic implements OnMoveHandler {

	private WindowManager windowManager;

	// DragAndDrop vars
	private View selected_item = null;
	private int offset_x = 0;
	private int offset_y = 0;

	// item being dragged
	protected View dragItemImageView;

	public DragAndDropListenerLogic(WindowManager windowManager) {

		super();
		this.windowManager = windowManager;
	}

	/**
	 * Must set dragItem and the parent ViewGroup
	 *
	 * @param dragAreaViewGroup that contains the item to drag
	 * @param dragItemImageView item to drag
	 */
	public void setDragDrop(ViewGroup dragAreaViewGroup, View dragItemImageView) {

		this.dragItemImageView = dragItemImageView;

		setDragDropViewGroup(dragAreaViewGroup);

		setDragItemActionDownListener();
	}

	/**
	 * Adds to instance member dragItem an ACTION_DOWN listener
	 *
	 */
	private void setDragItemActionDownListener()
	{
		dragItemImageView.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View dragItemView, MotionEvent event) {

				switch (event.getActionMasked()) {

					case MotionEvent.ACTION_DOWN:

						offset_x = (int) event.getX();
						offset_y = (int) event.getY();
						selected_item = dragItemView;

						break;

					default:
						break;
				}

				return false;
			}
		});
	}

	/**
	 * Instantiates instance drag area view group
	 * and adds to it an ACTION_MOVE listener
	 *
	 * @param vg
	 */
	private void setDragDropViewGroup(ViewGroup vg) {

		vg.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getActionMasked()) {

					case MotionEvent.ACTION_MOVE:

						// Calculate new position for item being moved
						RelativeLayout.LayoutParams lp = getPositionLayoutParams(event);
						selected_item.setLayoutParams(lp);

						// Any final logic to run after move is complete
						onMove(event);

						break;

					default:
						break;
				}
				return true;
			}
		});
	}

	/**
	 * Calculate new position for item being moved
	 *
	 * @param event input for determining update position
	 * @return
	 */
	private RelativeLayout.LayoutParams getPositionLayoutParams(MotionEvent event) {

		int dragItem_leftMargin_X = (int) event.getX() - offset_x;
		int dragItem_topMargin_Y = (int) event.getY() - offset_y;

		int w = windowManager.getDefaultDisplay().getWidth() - 100;
		int h = windowManager.getDefaultDisplay().getHeight() - 100;

		if (dragItem_leftMargin_X > w)
			dragItem_leftMargin_X = w;

		if (dragItem_topMargin_Y > h)
			dragItem_topMargin_Y = h;

		RelativeLayout.LayoutParams dragItemLayoutParams = new RelativeLayout.LayoutParams(
				new ViewGroup.MarginLayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT));

		dragItemLayoutParams.setMargins(
				dragItem_leftMargin_X,
				dragItem_topMargin_Y,
				0, 0);

		return dragItemLayoutParams;
	}

}

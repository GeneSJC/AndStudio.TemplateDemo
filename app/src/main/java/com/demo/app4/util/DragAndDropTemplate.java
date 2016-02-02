package com.demo.app4.util;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.demo.app4.R;

public class DragAndDropTemplate {

    public final static int ID__SKY_CONTAINER_VIEWGROUP = R.id.my_sky_layout;
    public final static int ID__SUN_DRAG_ITEM_IMAGEVIEW = R.id.sun;

    public static DragAndDropCollisionListener getSunInSkyCollisionListener(Activity activity) {

        DragAndDropInput dndInput = getDragAndDropInput(activity);

        return DragAndDropTemplate.getSunInSkyCollisionListener(dndInput);
    }

    public static DragAndDropInput getDragAndDropInput(Activity activity) {

        DragAndDropInput dndInput = new DragAndDropInput();

        dndInput.windowManager      = activity.getWindowManager();
        dndInput.dragAreaViewGroup  = (ViewGroup) activity.findViewById(ID__SKY_CONTAINER_VIEWGROUP);
        dndInput.dragItemImgView    = activity.findViewById(ID__SUN_DRAG_ITEM_IMAGEVIEW);
        dndInput.targetImageView    = activity.findViewById(R.id.target);

        return dndInput;
    }

    public static DragAndDropInput getDragAndDropInput(View fragmentRootView, Fragment fragment) {

        DragAndDropInput dndInput = new DragAndDropInput();

        dndInput.windowManager      = fragment.getActivity().getWindowManager();
        dndInput.dragAreaViewGroup  = (ViewGroup) fragmentRootView.findViewById(ID__SKY_CONTAINER_VIEWGROUP);
        dndInput.dragItemImgView    = fragmentRootView.findViewById(ID__SUN_DRAG_ITEM_IMAGEVIEW);
        dndInput.targetImageView    = fragmentRootView.findViewById(R.id.target);

        return dndInput;
    }

    public static DragAndDropCollisionListener getSunInSkyCollisionListener(DragAndDropInput dndInput) {

        DragAndDropCollisionListener dragAndDropCollisionLstnr =
                new DragAndDropCollisionListener(dndInput.windowManager, dndInput.targetImageView);

        dragAndDropCollisionLstnr.setDragDrop(dndInput.dragAreaViewGroup, dndInput.dragItemImgView);

        return dragAndDropCollisionLstnr;
    }
}

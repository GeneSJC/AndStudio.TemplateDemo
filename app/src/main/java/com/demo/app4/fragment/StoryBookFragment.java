package com.demo.app4.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.app4.R;
import com.demo.app4.util.DragAndDropInput;
import com.demo.app4.util.DragAndDropTemplate;
import com.demo.app4.util.StoryBookCollisionListener;
import com.demo.app4.util.Util;

/**
 * A placeholder fragment containing a simple view.
 */
public class StoryBookFragment extends Fragment {

    private static int CUR_STORYBOOK_PAGE = 0;

    private StoryBookCollisionListener storybookCollisionLstnr;

    public StoryBookFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static StoryBookFragment newInstance() {

        StoryBookFragment fragment = new StoryBookFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        CUR_STORYBOOK_PAGE++;

        if (CUR_STORYBOOK_PAGE == 1) {

            View rootView = getStoryBookDragDropPageView(inflater, container);
            return rootView;
        }

        View rootView = inflater.inflate(R.layout.fragment_storybook_page_2, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText("Add Story Book Page " + CUR_STORYBOOK_PAGE + " Here");

        Util.myToast(rootView, "Now on page: " + CUR_STORYBOOK_PAGE);

        return rootView;
    }

    public View getStoryBookDragDropPageView(LayoutInflater inflater, ViewGroup container) {

        View rootView = inflater.inflate(R.layout.activity_dragndrop_bluesky, container, false);

        //    if (storybookCollisionLstnr == null) {
        //    }
        // reset every time we get the view
        DragAndDropInput dndInput = DragAndDropTemplate.getDragAndDropInput(rootView, this);

        storybookCollisionLstnr = new StoryBookCollisionListener(getActivity(), dndInput.targetImageView);

        storybookCollisionLstnr.setDragDrop(dndInput.dragAreaViewGroup, dndInput.dragItemImgView);
        //    getActivity().setTitle("Story Book Page");

        return rootView;
    }
}

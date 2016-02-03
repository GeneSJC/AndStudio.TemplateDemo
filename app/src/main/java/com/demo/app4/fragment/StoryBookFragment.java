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

/**
 * A placeholder fragment containing a simple view.
 */
public class StoryBookFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private StoryBookCollisionListener storybookCollisionLstnr;

    private int sectionNumber;

    public StoryBookFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static StoryBookFragment newInstance(int sectionNumber) {

        StoryBookFragment fragment = new StoryBookFragment();

        fragment.sectionNumber = sectionNumber;

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        if (this.sectionNumber == 2) {

            View rootView = getDndView(inflater, container);
            return rootView;
        }

        View rootView = inflater.inflate(R.layout.fragment_tabbed_action_bar, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    public View getDndView(LayoutInflater inflater, ViewGroup container) {

        View rootView = inflater.inflate(R.layout.activity_dragndrop_bluesky, container, false);

        //    if (storybookCollisionLstnr == null) {
        //    }

        // reset every time we get the view
        DragAndDropInput dndInput = DragAndDropTemplate.getDragAndDropInput(rootView, this);

        storybookCollisionLstnr = new StoryBookCollisionListener(getActivity(), dndInput.targetImageView);

        storybookCollisionLstnr.setDragDrop(dndInput.dragAreaViewGroup, dndInput.dragItemImgView);

        //    storybookCollisionLstnr.setViewPager(mViewPager, this.sectionNumber);
        //    storybookCollisionLstnr.setActivity(getActivity());
        //
        //    getActivity().setTitle("Story Book Page");

        return rootView;
    }
}

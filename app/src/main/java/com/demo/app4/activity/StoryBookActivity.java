package com.demo.app4.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.demo.app4.R;
import com.demo.app4.fragment.StoryBookFragment;


public class StoryBookActivity extends AppCompatActivity {

    private static StoryBookActivity SELF_STATIC_REF;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storybook);

        StoryBookActivity.SELF_STATIC_REF = this;

        goToNextPage();

        showInstructionsDialog();
    }

    private void showInstructionsDialog() {

        String msg = "";

        msg += "Once upon a time there was a big bright sun in the blue sky. \n\n";
        msg += "The Barn House (the orange square) below wanted to enjoy the sun's warmth. \n\n";
        msg += "Can you find the sun and bring it over to the barn? \n\n";
        msg += "Touch the sun and drag to the orange square, to advance to next page.";

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Interactive Story Book Demo - Page 1");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK, Let's Start",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

        alertDialog.show();
    }

    public static void goToNextPage() {

        Fragment fragment = StoryBookFragment.newInstance();

        StoryBookActivity.SELF_STATIC_REF.updateFragment(fragment);
    }

    protected void updateFragment(Fragment fragment)
    {
        //    FragmentManager     fm          = getSupportFragmentManager();
        //    FragmentTransaction transaction = fm.beginTransaction();
        //    transaction.replace(R.id.fragment_container, fragment);
        //    transaction.commit();

        replaceFragmentWithAnimation(fragment, "some tag");
    }

    public void replaceFragmentWithAnimation(Fragment fragment, String tag){

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
}

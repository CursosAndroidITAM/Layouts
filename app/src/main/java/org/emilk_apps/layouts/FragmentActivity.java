package org.emilk_apps.layouts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.emilk_apps.layouts.fragments.FirstFragment;
import org.emilk_apps.layouts.fragments.SecondFragment;

import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity
implements FirstFragment.OnFragmentAButtonClickListener
{


    private static final String FRAGMENT_2 = "fragment_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fT = fragmentManager.beginTransaction();
        fT.add(R.id.fragment_container, new SecondFragment(), FRAGMENT_2);
        fT.commit();

        FirstFragment fragmentA = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_A);
/*

        fragmentA.setOnFragmentAButtonClickListener(new FirstFragment.OnFragmentAButtonClickListener() {
            @Override
            public void onClick() {
                changeFragment();
            }
        });
*/

    }

    private void changeFragment() {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_2);
        if (secondFragment!=null){
            secondFragment.switchImage();
        }
    }

    @Override
    public void onClick() {
        changeFragment();
    }
}

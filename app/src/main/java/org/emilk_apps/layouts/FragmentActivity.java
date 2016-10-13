package org.emilk_apps.layouts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.emilk_apps.layouts.fragments.ListViewFragment;

import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity
{


    private static final String FRAGMENT_LV = "fragment_lv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fT = fragmentManager.beginTransaction();
        fT.add(R.id.fragment_container, new ListViewFragment(), FRAGMENT_LV);
        fT.commit();


    }

}

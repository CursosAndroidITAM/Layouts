package org.emilk_apps.layouts.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.emilk_apps.layouts.R;
import org.emilk_apps.service.eventbus.FragmentEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    @BindView(R.id.second_fragment_image)
    ImageView secondFragmentImage;
    @BindView(R.id.second_fragment_text)
    TextView secondFragmentText;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    public void switchImage() {
        secondFragmentImage.setVisibility(secondFragmentImage.isShown() ? View.GONE : View.VISIBLE);
    }

    @Subscribe
    public void onEvent(FragmentEvent event) {
        secondFragmentText.setText(event.getHola());
    };


}

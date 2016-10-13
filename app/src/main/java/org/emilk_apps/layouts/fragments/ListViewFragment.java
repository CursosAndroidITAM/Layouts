package org.emilk_apps.layouts.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.emilk_apps.layouts.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {


    @BindView(R.id.list_view)
    ListView listView;
    private ArrayAdapter<String> stringArrayAdapter;

    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        ButterKnife.bind(this, view);
        loadAdapter();
        loadListView();
        return view;
    }

    private void loadAdapter() {
        stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getStringList());
    }

    private List<String> getStringList() {
        return new ArrayList<>(Arrays.asList("Este","es", "una", "lista", "genérica"));
    }


    private void loadListView() {
        listView.setAdapter(stringArrayAdapter);
    }


}

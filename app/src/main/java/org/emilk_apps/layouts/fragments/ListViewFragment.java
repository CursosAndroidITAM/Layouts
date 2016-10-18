package org.emilk_apps.layouts.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.emilk_apps.layouts.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {


    private static final String ARRAYLIST = "array_list";
    @BindView(R.id.list_view)
    ListView listView;
    private ArrayAdapter<String> stringArrayAdapter;
    private ArrayList<String> list = new ArrayList<>();

    public ListViewFragment() {
        // Required empty public constructor
    }

    public static ListViewFragment newInstance(ArrayList<String> list) {

        Bundle args = new Bundle();
        args.putStringArrayList(ARRAYLIST, list);
        ListViewFragment fragment = new ListViewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = getArguments().getStringArrayList(ARRAYLIST);

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
        stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
    }


    private void loadListView() {
        listView.setAdapter(stringArrayAdapter);
    }


}

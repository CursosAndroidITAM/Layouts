package org.emilk_apps.layouts.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.emilk_apps.layouts.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 */
public class FirstFragment extends Fragment {


    @BindView(R.id.fragment_first_button)
    Button fragmentFirstButton;


    /**
     * Public interface that will allow us to communicate the click event to the main activity
     *
     */
    public interface OnFragmentAButtonClickListener {
        void onClick();
    }

    /**
     * We define the interface as a private field that will fire the onClick event if it's not null
     */
    private OnFragmentAButtonClickListener mListener;

    /**
     * There are two options to instantiate our private interface mListener so it's no longer null
     * OPTION 1:
     * We define a method (setOnFragmentAButtonClickListener) that will allow us to instantiate it.
     *
     */
    public void setOnFragmentAButtonClickListener(OnFragmentAButtonClickListener listener){
       mListener = listener;
    }


    /**
     *  OPTION 2:
     * We override the onAttach method from the fragment's life cycle so we can instantiate the
     * mListener when this fragment attaches to a context. We need the try/catch block in case we
     * forget to implement the interface in our activity
     *
     *  {@link org.emilk_apps.layouts.FragmentActivity} FragmentActivity should implement the
     *  interface for this method to work
     *
     */
   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
             try {
        mListener = (OnFragmentAButtonClickListener) context;
         } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }*/


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        fragmentFirstButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       sendClick();
                                                   }
                                               }

        );

        return view;
    }

    private void sendClick() {
        if (mListener != null) {
            mListener.onClick();
        }
    }


}

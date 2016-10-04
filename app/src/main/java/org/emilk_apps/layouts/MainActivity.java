package org.emilk_apps.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String MAINACTIVITY = "mainActivity";
    @BindView(R.id.activity_tv)
    TextView activityTv;
    @BindView(R.id.activity_button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R    .layout.activity_main);
        ButterKnife.bind(this);
        activityTv.setText("Este ya no es un Hola Mundo");
        button.setText("Algo más");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondActivity();
            }
        });

    }

    private void showSecondActivity() {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("EXTRA", "dato extra");
        startActivity(i);

    }

    private void showOtherActivity() {
        Intent i = new Intent(this, OtherActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MAINACTIVITY, "On Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MAINACTIVITY, "On Stop");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(MAINACTIVITY, "On PostResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MAINACTIVITY, "On Destroy");

    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MAINACTIVITY, "On Pause");
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MAINACTIVITY, "On Resume");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_button){
            showSecondActivity();
        }
    }
}

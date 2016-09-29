package org.emilk_apps.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String stringOne = getIntent().getExtras().getString("EXTRA");
        TextView textView = (TextView) findViewById(R.id.second_activity_tV);
        textView.setText(stringOne);

    }
}

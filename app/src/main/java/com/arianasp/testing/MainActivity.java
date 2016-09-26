package com.arianasp.testing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ariana on 9/27/2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdiActivity.startThisActivity(MainActivity.this);
    }
}

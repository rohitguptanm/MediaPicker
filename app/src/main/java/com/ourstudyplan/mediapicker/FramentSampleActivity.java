package com.ourstudyplan.mediapicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FramentSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_sample);

//        SampleFragment sampleFragment = (SampleFragment) getSupportFragmentManager().findFragmentById(R.id.sample_fragment);
    }
}

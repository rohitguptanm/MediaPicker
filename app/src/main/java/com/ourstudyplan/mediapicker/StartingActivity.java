package com.ourstudyplan.mediapicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }

    public void openMainActiivty(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void openSamepleFragmentActiivty(View view) {
        Intent intent = new Intent(this,FramentSampleActivity.class);
        startActivity(intent);
    }
}

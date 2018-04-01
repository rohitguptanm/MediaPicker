package com.ourstudyplan.mediapicker;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity implements MediaUtils.GetImg {

    ImageView mImageView;
    MediaUtils mMediaUtils;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image_view);
        // initialize MediaUtils
        mMediaUtils = new MediaUtils(this);
    }

    public void selectImg(View view) {
        // select image button clicked
        mMediaUtils.openImageDialog();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mMediaUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mMediaUtils.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void imgdata(String imgPath) {
        Log.d(TAG, "imgdata: " + imgPath);
        Picasso.get().load(new File(imgPath)).into(mImageView);
    }
}

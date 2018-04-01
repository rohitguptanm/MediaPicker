package com.ourstudyplan.mediapicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Lalit Vasan on 2/1/2018.
 */

public class SampleFragment extends Fragment implements MediaUtils.GetImg, View.OnClickListener {

    ImageView mImageView;
    MediaUtils mMediaUtils;
    private String TAG = SampleFragment.class.getSimpleName();
    Button mBtnSelectImg;

   /* public static SampleFragment getInstance(int id) {
        PhotosFragment homeFragment = new PhotosFragment();

        Bundle args = new Bundle();
        args.putInt("id", id);
        homeFragment.setArguments(args);

        return homeFragment;
    }*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sample, container, false);

        mImageView = view.findViewById(R.id.image_view);
        mBtnSelectImg = view.findViewById(R.id.btn_select_img);
        // initialize MediaUtils
        mMediaUtils = new MediaUtils(this);

        mBtnSelectImg.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mMediaUtils.openImageDialog();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mMediaUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mMediaUtils.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void imgdata(String imgPath) {
        Log.d(TAG, "imgdata: " + imgPath);
        Picasso.get().load(new File(imgPath)).into(mImageView);
    }


}

package com.app.my_video_gallery_app;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


public class All_Img_Fragment extends Fragment {

    //    private static final int SELECT_VIDEO = 100;
    private static final int TAKE_Video = 1000;
    private static final int PERMISSION_REQUEST_CODE = 1001;
    VideoView videoView;
    Button LoadVid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_all__img_, container, false);
        videoView = view.findViewById(R.id.videoView);
        LoadVid = view.findViewById(R.id.LoadVid);
        LoadVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("video/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Video"), TAKE_Video);
            }

        });


        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_Video) {
            Uri mVideoURI = data.getData();
            videoView.setVideoURI(mVideoURI);


            videoView.start();
        }
    }
}




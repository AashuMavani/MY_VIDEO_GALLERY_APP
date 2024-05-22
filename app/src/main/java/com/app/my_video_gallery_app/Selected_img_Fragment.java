package com.app.my_video_gallery_app;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class Selected_img_Fragment extends Fragment {


    Button button;
    VideoView videoView;
    private static final int SELECT_VIDEO = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_selected_img_, container, false);
        button=view.findViewById(R.id.button);
        videoView=view.findViewById(R.id.videoView1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent();
                intent.setType("video/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Video"), SELECT_VIDEO);

            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_VIDEO) {
            Uri mVideoURI = data.getData();
            videoView.setVideoURI(mVideoURI);



            videoView.start();

        }
    }
}

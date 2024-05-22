package com.app.my_video_gallery_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        Viewpager_Adapter adapter = new Viewpager_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
    }
}
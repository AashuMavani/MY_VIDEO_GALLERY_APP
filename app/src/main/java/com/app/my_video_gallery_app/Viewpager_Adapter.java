package com.app.my_video_gallery_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Viewpager_Adapter extends FragmentPagerAdapter {
    public Viewpager_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new All_Img_Fragment();
        }else {
            return new Selected_img_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "All_Img_Fragment";
        }else {
            return "Selected_img_Fragment";
        }


    }
}

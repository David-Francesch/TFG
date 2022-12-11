package com.example.tfg;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Profile extends AppCompatActivity {

    ViewPager viewPager;

    int[] profileImages = {R.drawable.spotifylogo, R.drawable.googlelogo, R.drawable.soundcloudlogo};
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(Profile.this, profileImages);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
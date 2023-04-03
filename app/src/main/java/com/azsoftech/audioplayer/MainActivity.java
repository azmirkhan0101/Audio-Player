package com.azsoftech.audioplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView iv_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        iv_search = findViewById(R.id.iv_search);

        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PlayerControlActivity.class));
                overridePendingTransition( R.anim.slide_in_up,R.anim.slide_out_up );
            }
        });

        ViewPagerAudioPlayerAdapter viewPagerAudioPlayerAdapter = new ViewPagerAudioPlayerAdapter(getSupportFragmentManager());
        viewPager.setAdapter( viewPagerAudioPlayerAdapter );

        tabLayout.setupWithViewPager( viewPager );




    }
    //ONCREATE END


}
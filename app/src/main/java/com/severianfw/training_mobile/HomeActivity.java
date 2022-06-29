package com.severianfw.training_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.severianfw.training_mobile.view.MainActivity;

public class HomeActivity extends AppCompatActivity {

    Button logout;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.btn_logout);

        logout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
        });

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        setViewPager2(viewPager2);

        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();
    }

    private void setViewPager2(ViewPager2 viewPager2){
        if(pageAdapter == null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new ProfileFragment(), "Profile");
            pageAdapter.addFragment(new UploadFragment(), "Upload");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}
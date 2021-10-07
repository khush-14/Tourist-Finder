package com.example.touristfinderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

import android.accounts.Account;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.FrameStats;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity<ButtonView> extends AppCompatActivity   {
    Button btn;
    private static final String TAG = "MainActivity";
    BottomNavigationView bottomNavigationView;
//    FragmentContainer fragment;

    offers offer_obj = new offers();
    Trips trip_obj = new Trips();
    homepage homepage_obj = new homepage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigatin_view);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){

                switch(item.getItemId()){
                    case R.id.homepage: {

                        Log.i(TAG, "onNavigationItemSelected: "+item.getItemId()+" "+R.id.homepage);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new homepage()).commit();
                        return true;
                    }case R.id.trip:{
                        Log.i(TAG, "onNavigationItemSelected: "+item.getItemId()+" "+R.id.trip);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Trips()).commit();
                        return true;
                    }case R.id.offers:{
                        Log.i(TAG, "onNavigationItemSelected: "+item.getItemId()+" "+R.id.offers);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new offers()).commit();
                        return true;
                    }
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.homepage);


    }
}



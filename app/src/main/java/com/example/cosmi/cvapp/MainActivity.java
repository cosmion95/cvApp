package com.example.cosmi.cvapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new AboutFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){

            case R.id.navigation_about:
                fragment = new AboutFragment();
                break;
            case R.id.navigation_projects:
                fragment = new ProjectsFragment();
                break;
            case R.id.navigation_skills:
                fragment = new SkillsFragment();
                break;
            case R.id.navigation_education:
                fragment = new EducationFragment();
                break;
            case R.id.navigation_experience:
                fragment = new ExperienceFragment();
                break;

        }


        return loadFragment(fragment);
    }
}

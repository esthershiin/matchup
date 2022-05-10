package com.example.matchup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_image);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav10);
        navBar.setSelectedItemId(R.id.profile);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.create:
                // go to 'Create' screen
                intent = new Intent(this, CreateGameActivity.class);
                startActivity(intent);
                return false;
            case R.id.home:
                // go to 'Home' screen
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return false;
            case R.id.messages:
                // go to 'Messages' screen
                intent = new Intent(this, MessagesActivity.class);
                startActivity(intent);
                return false;
            case R.id.profile:
                // stay on 'Profile' screen
                return false;
            default:
                return false;
        }
    }
}
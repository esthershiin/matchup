package com.example.matchup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MapPopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_pop_up);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav2);
        navBar.setSelectedItemId(R.id.home);
    }

    // Bottom Navigation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.create:
                // go to 'Create' screen
                intent = new Intent(MapPopUpActivity.this, CreateGameActivity.class);
                startActivity(intent);
                return false;
            case R.id.home:
                // stay on 'Home' screen
                return false;
            case R.id.messages:
                // go to 'Messages' screen
                intent = new Intent(MapPopUpActivity.this, MessagesActivity.class);
                startActivity(intent);
                return false;
            case R.id.profile:
                intent = new Intent(this, ProfileImageActivity.class);
                startActivity(intent);
                return false;
            default:
                return false;
        }
    }
}
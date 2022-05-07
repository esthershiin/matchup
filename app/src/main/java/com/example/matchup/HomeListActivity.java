package com.example.matchup;
import com.example.matchup.adapter.ItemAdapter;
import com.example.matchup.data.Datasource;
import com.example.matchup.model.Game;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav3);
        navBar.setSelectedItemId(R.id.home);

        Intent intent = getIntent();
        Datasource myDatasource = (Datasource) intent.getSerializableExtra(MainActivity.EXTRA_DATASOURCE);
        ArrayList<Game> myDataset = myDatasource.loadAllGames();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new ItemAdapter(myDataset, this));
        recyclerView.setHasFixedSize(true);
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
                intent = new Intent(HomeListActivity.this, CreateGameActivity.class);
                startActivity(intent);
                return false;
            case R.id.home:
                // stay on 'Home' screen
                return false;
            case R.id.messages:
                // go to 'Messages' screen
                intent = new Intent(HomeListActivity.this, MessagesActivity.class);
                startActivity(intent);
                return false;
            case R.id.profile:
                intent = new Intent(HomeListActivity.this, ProfileImageActivity.class);
                startActivity(intent);
                return false;
            default:
                return false;
        }
    }

    public void switchToMapView(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
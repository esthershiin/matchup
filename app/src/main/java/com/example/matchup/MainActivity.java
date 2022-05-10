package com.example.matchup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matchup.adapter.ItemAdapter;
import com.example.matchup.data.Datasource;
import com.example.matchup.model.Game;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_DATASOURCE = "com.example.MatchUp.DATASOURCE";

    ImageView basketballButton;
    ImageView soccerButton;
    ImageView tennisButton;
    ImageView volleyballButton;
    ImageView clear;
    ImageView soccerPin1;
    ImageView soccerDetailed1;
    ImageView map;
    TextView discover;
    TextView joined;
    RecyclerView recyclerView;
    Context context;
    boolean selected;
    boolean showJoined;
    Datasource myDatasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav1);
        navBar.setSelectedItemId(R.id.home);

        context = this;
        selected = false;
        showJoined = false;
        if (myDatasource == null) {
            myDatasource = new Datasource();
            myDatasource.initializeGames();
        }
        Intent intent = getIntent();
        if (intent != null) {
            boolean isCreate = intent.getBooleanExtra(CreateGameActivity.EXTRA_CREATE, false);
            if (isCreate) {
                Game newGame = (Game) intent.getSerializableExtra(CreateGameActivity.EXTRA_GAME);
                myDatasource.addGame(newGame);
            }
        }

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setAdapter(new ItemAdapter(myDatasource.loadAllGames(), this));
        recyclerView.setHasFixedSize(true);

        basketballButton = findViewById(R.id.basketballButton);
        soccerButton = findViewById(R.id.soccerButton);
        tennisButton = findViewById(R.id.tennisButton);
        volleyballButton = findViewById(R.id.volleyballButton);
        clear = findViewById(R.id.clear);

        discover = findViewById(R.id.discover);
        joined = findViewById(R.id.joined);

        soccerPin1 = findViewById(R.id.soccer_pin1);
        soccerDetailed1 = findViewById(R.id.soccer_detailed1);
        map = findViewById(R.id.map);

        basketballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games = myDatasource.loadBasketBallGames(showJoined);
                basketballButton.setImageResource(R.drawable.basketball_selected);
                soccerButton.setImageResource(R.drawable.soccer_filter);
                tennisButton.setImageResource(R.drawable.tennis_filter);
                volleyballButton.setImageResource(R.drawable.vball_filter);
                soccerButton.setImageResource(R.drawable.soccer_filter);
                soccerPin1.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);
            }
        });

        volleyballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games = myDatasource.loadVolleyBallGames(showJoined);
                soccerButton.setImageResource(R.drawable.soccer_filter);
                basketballButton.setImageResource(R.drawable.bball_filter);
                tennisButton.setImageResource(R.drawable.tennis_filter);
                volleyballButton.setImageResource(R.drawable.vball_selected);
                soccerPin1.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);
            }
        });

        soccerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games = myDatasource.loadSoccerGames(showJoined);
                soccerButton.setImageResource(R.drawable.soccer_selected);
                basketballButton.setImageResource(R.drawable.bball_filter);
                tennisButton.setImageResource(R.drawable.tennis_filter);
                volleyballButton.setImageResource(R.drawable.vball_filter);
                soccerPin1.setVisibility(View.VISIBLE);
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);
            }
        });

        tennisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games = myDatasource.loadTennisGames(showJoined);
                soccerButton.setImageResource(R.drawable.soccer_filter);
                basketballButton.setImageResource(R.drawable.bball_filter);
                tennisButton.setImageResource(R.drawable.tennis_selected);
                volleyballButton.setImageResource(R.drawable.vball_filter);
                soccerPin1.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games;
                if (showJoined) {
                    games = myDatasource.loadJoinedGames();
                } else {
                    games = myDatasource.loadDiscoverGames();
                }
                basketballButton.setImageResource(R.drawable.bball_filter);
                soccerButton.setImageResource(R.drawable.soccer_filter);
                tennisButton.setImageResource(R.drawable.tennis_filter);
                volleyballButton.setImageResource(R.drawable.vball_filter);
                soccerButton.setImageResource(R.drawable.soccer_filter);
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);
                soccerPin1.setVisibility(View.VISIBLE);
            }
        });

        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games = myDatasource.loadDiscoverGames();
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);

                discover.setTextColor(Color.parseColor("#54CED6"));
                joined.setTextColor(Color.parseColor("#2E2C2C"));
                showJoined = false;
            }
        });

        joined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = findViewById(R.id.recyclerView2);
                ArrayList<Game> games = myDatasource.loadJoinedGames();
                recyclerView.setAdapter(new ItemAdapter(games, context));
                recyclerView.setHasFixedSize(true);

                discover.setTextColor(Color.parseColor("#2E2C2C"));
                joined.setTextColor(Color.parseColor("#54CED6"));
                showJoined = true;
            }
        });

        soccerPin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soccerDetailed1.setVisibility(View.VISIBLE);
                soccerPin1.setImageResource(R.drawable.soccerpin_selected);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soccerDetailed1.setVisibility(View.INVISIBLE);
                soccerPin1.setImageResource(R.drawable.soccer_pin);
            }
        });
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
                intent = new Intent(MainActivity.this, CreateGameActivity.class);
                startActivity(intent);
                return false;
            case R.id.home:
                // stay on 'Home' screen
                return false;
            case R.id.messages:
                // go to 'Messages' screen
                intent = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(intent);
                return false;
            case R.id.profile:
                intent = new Intent(MainActivity.this, ProfileImageActivity.class);
                startActivity(intent);
                return false;
            default:
                return false;
        }
    }

    public void switchToListView(View view) {
        Intent intent = new Intent(this, HomeListActivity.class);
        intent.putExtra(EXTRA_DATASOURCE, myDatasource);
        startActivity(intent);
    }

    public void clearScreen(View view) {
        soccerButton.setImageResource(R.drawable.soccer_filter);
        basketballButton.setImageResource(R.drawable.bball_filter);
        tennisButton.setImageResource(R.drawable.tennis_filter);
        volleyballButton.setImageResource(R.drawable.vball_filter);
        soccerPin1.setVisibility(View.INVISIBLE);
    }

}
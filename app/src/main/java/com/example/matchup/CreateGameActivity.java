package com.example.matchup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matchup.model.Game;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;

public class CreateGameActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String skill = "beginner";
    public static final String EXTRA_GAME = "com.example.MatchUp.GAME";
    public static final String EXTRA_CREATE = "com.example.MatchUp.CREATE";

    public ImageView basketball;
    public ImageView tennis;
    public ImageView soccer;
    public ImageView volleyball;

    public String type = "soccer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav4);
        navBar.setSelectedItemId(R.id.create);

        // instantiate the spinner object for the dropdown menu for skill level for create game
        Spinner spinnerSkillLevel = findViewById(R.id.spinnerSkillLevel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.skillLevels, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerSkillLevel.setAdapter(adapter);

        basketball = findViewById(R.id.basketballChipType);
        volleyball = findViewById(R.id.volleyballChipType);
        tennis = findViewById(R.id.tennisChipType);
        soccer = findViewById(R.id.soccerChipType);

        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketball.setImageResource(R.drawable.basketball_selected);
                soccer.setImageResource(R.drawable.soccer_filter);
                tennis.setImageResource(R.drawable.tennis_filter);
                volleyball.setImageResource(R.drawable.vball_filter);
                type = "basketball";

            }
        });

        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketball.setImageResource(R.drawable.bball_filter);
                soccer.setImageResource(R.drawable.soccer_filter);
                tennis.setImageResource(R.drawable.tennis_filter);
                volleyball.setImageResource(R.drawable.vball_selected);
                type = "volleyball";

            }
        });

        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketball.setImageResource(R.drawable.bball_filter);
                soccer.setImageResource(R.drawable.soccer_filter);
                tennis.setImageResource(R.drawable.tennis_selected);
                volleyball.setImageResource(R.drawable.vball_filter);
                type = "tennis";

            }
        });

        soccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketball.setImageResource(R.drawable.bball_filter);
                soccer.setImageResource(R.drawable.soccer_selected);
                tennis.setImageResource(R.drawable.tennis_filter);
                volleyball.setImageResource(R.drawable.vball_filter);
                type = "soccer";

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
                // stay on 'Create' screen
                return false;
            case R.id.home:
                // go to 'Home' screen
                intent = new Intent(CreateGameActivity.this, MainActivity.class);
                startActivity(intent);
                return false;
            case R.id.messages:
                // go to 'Messages' screen
                intent = new Intent(CreateGameActivity.this, MessagesActivity.class);
                startActivity(intent);
                return false;
            default:
                return false;
        }
    }

    public void createGame(View view) {
        // add new game to dataset
        EditText nameText = (EditText) findViewById(R.id.editGameName);
        String name = nameText.getText().toString();

        EditText dateText = (EditText) findViewById(R.id.editTextDate3);
        String date = dateText.getText().toString();

        EditText timeText = (EditText) findViewById(R.id.editTextTime);
        String time = timeText.getText().toString();

        EditText locationText = (EditText) findViewById(R.id.editLocation);
        String location = locationText.getText().toString();

        EditText playersText = (EditText) findViewById(R.id.editTextNumberSigned);
        String playersString = playersText.getText().toString();
        int players = 0;
        if (!playersString.equals("")) {
            players = Integer.parseInt(playersText.getText().toString());
        }

        EditText descriptionText = (EditText) findViewById(R.id.editTextTextMultiLine);
        String description = descriptionText.getText().toString();

        Game game = new Game(type, name, "jwong2 (You)", skill, 0.2, location, date,
                1, time, players, description, true);

        // navigate back to games map view with new game
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_GAME, game);
        intent.putExtra(EXTRA_CREATE, true);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        skill = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
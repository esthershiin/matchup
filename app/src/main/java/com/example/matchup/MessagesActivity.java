package com.example.matchup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MessagesActivity extends AppCompatActivity {

    View darleneMessageView;
    View openNewMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav5);
        navBar.setSelectedItemId(R.id.messages);

        darleneMessageView =  findViewById(R.id.darlene_view);
        openNewMessageView =  findViewById(R.id.new_message_button);

        darleneMessageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagesActivity.this, darleneMessageActivity.class);
                startActivity(intent);
            }
        });

        openNewMessageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagesActivity.this, newMessageActivity.class);
                startActivity(intent);
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
                // stay on 'Messages' screen
                return false;
            case R.id.profile:
                intent = new Intent(this, ProfileImageActivity.class);
                startActivity(intent);
                return false;
            default:
                return false;
        }
    }

//    public void openDarleneMessageActivity(View view){
//        Intent intent = new Intent(this, darleneMessageActivity.class);
//        System.out.println("Start");
//        startActivity(intent);
//        System.out.println("Started");
//    }
//
//    public void openNewMessageActivity(View view) {
//        Intent intent = new Intent(this, newMessageActivity.class);
//        startActivity(intent);
//    }
}
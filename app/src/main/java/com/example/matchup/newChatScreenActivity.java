package com.example.matchup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class newChatScreenActivity extends AppCompatActivity {

    private TextView friend_name;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chat_screen);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav6);
        navBar.setSelectedItemId(R.id.messages);

        friend_name = (TextView) findViewById(R.id.title);
        message = (TextView) findViewById(R.id.user_msg1);

        Intent intent = getIntent();
        String name_str = intent.getStringExtra("friend_name");
        friend_name.setText(name_str);
        String msg_str = intent.getStringExtra("message");
        message.setText(msg_str);
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

}
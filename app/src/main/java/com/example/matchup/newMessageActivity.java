package com.example.matchup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class newMessageActivity extends AppCompatActivity {

    private EditText friend_name;
    private EditText message;
    private Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView navBar = findViewById(R.id.bottomnav7);
        navBar.setSelectedItemId(R.id.messages);

        friend_name = (EditText) findViewById(R.id.friend_name_field);
        message = (EditText) findViewById(R.id.message_field);
        send_button = (Button) findViewById(R.id.send_button);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friend_name = (EditText) findViewById(R.id.friend_name_field);
                message = (EditText) findViewById(R.id.message_field);
                send_button = (Button) findViewById(R.id.send_button);

                Toast.makeText(getApplicationContext(), "message sent", Toast.LENGTH_SHORT).show();
                String friend_name_string = friend_name.getText().toString();

                String message_string = message.getText().toString();

                System.out.println(message_string);
                Intent intent = new Intent(getApplicationContext(), newChatScreenActivity.class);
                intent.putExtra("friend_name", friend_name_string);
                intent.putExtra("message", message_string);
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
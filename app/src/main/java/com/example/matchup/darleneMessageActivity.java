package com.example.matchup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class darleneMessageActivity extends AppCompatActivity {

    private EditText message;
    private Button send_button;
    private int msg_count;
    private TextView user_text1;
    private TextView user_text2;
    private View user_text_view1;
    private View user_text_view2;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darlene_message);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        System.out.println("made it to darlene message activity");
        BottomNavigationView navBar = findViewById(R.id.bottomnav4);
        navBar.setSelectedItemId(R.id.messages);

        message = (EditText) findViewById(R.id.chat_field);
        send_button = (Button) findViewById(R.id.send_button);
        user_text1 = (TextView) findViewById(R.id.user_msg1);
        user_text2 = (TextView) findViewById(R.id.user_msg2);
        user_text_view1 = (View) findViewById(R.id.user_msg_view1);
        user_text_view2 = (View) findViewById(R.id.user_msg_view2);
        back_button = (Button) findViewById(R.id.back_button);
        msg_count = 0;

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message_content = message.getText().toString();
                message.getText().clear();
                if (!message_content.equals("")) {
                    msg_count += 1;
                }

                if (msg_count == 1) {
                    user_text1.setText(message_content);
                    user_text1.setVisibility(View.VISIBLE);
                    user_text_view1.setVisibility(View.VISIBLE);
                }
                if (msg_count == 2) {
                    user_text2.setText(message_content);
                    user_text2.setVisibility(View.VISIBLE);
                    user_text_view2.setVisibility(View.VISIBLE);
                }
                if (msg_count > 2) {
                    Toast.makeText(getApplicationContext(), "this is the max number of msgs you can send for now, sorry", Toast.LENGTH_LONG).show();
                }
                if (msg_count == 0) {
                    Toast.makeText(getApplicationContext(), "write something", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MessagesActivity.class);
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
            default:
                return false;
        }
    }
}
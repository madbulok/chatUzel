package com.app.jedai.uzelchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText message = (EditText) findViewById(R.id.msgText);
        Button btnSay = (Button) findViewById(R.id.sayBtn);
        ListView listMsg = (ListView) findViewById(R.id.messages);

        Firebase.setAndroidContext(this);
        final Firebase ref = new Firebase("https://luminous-heat-2488.firebaseio.com/chat");

        btnSay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatMessage chat = new ChatMessage("artem", message.getText().toString());
                ref.push().setValue(chat);
                message.setText("");
            }
        });
    }
}

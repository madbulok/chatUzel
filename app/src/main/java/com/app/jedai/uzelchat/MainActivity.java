package com.app.jedai.uzelchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText messageTxt = (EditText) findViewById(R.id.msgText);
        Button sendBtn = (Button) findViewById(R.id.sayBtn);
        ListView messageLst = (ListView) findViewById(R.id.messagess);

        Firebase.setAndroidContext(this);
        final Firebase ref = new Firebase("https://luminous-heat-2488.firebaseio.com/chat");

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatMessage chat = new ChatMessage("artem", messageTxt.getText().toString());
                ref.push().setValue(chat);
                messageTxt.setText("");
            }
        });
        Query recent = ref.limitToLast(10);
        FirebaseListAdapter<ChatMessage> adapter = new FirebaseListAdapter<ChatMessage>(
                this, ChatMessage.class, android.R.layout.two_line_list_item, recent
        ) {
            @Override
            protected void populateView(View view, ChatMessage chat, int i) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(chat.getName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(chat.getMessage());
            }
        };

        messageLst.setAdapter(adapter);

    }
}

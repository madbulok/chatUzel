package com.app.jedai.uzelchat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 21.06.16.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        final EditText text = (EditText) findViewById(R.id.nameUser);
        Button btnLogin = (Button) findViewById(R.id.ok);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                if (text.getText().toString().isEmpty()){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                    dialog.setTitle("Ошибка!");
                    dialog.setMessage("Имя не может быть пустым!");
                    dialog.create();
                } else{
                    intent.putExtra("name", text.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}

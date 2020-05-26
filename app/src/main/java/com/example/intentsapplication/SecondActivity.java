package com.example.intentsapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle receivedMessage = getIntent().getExtras();

        if (receivedMessage == null)
            return;

        String messageReceived = receivedMessage.getString("passing message");

        TextView secondText = findViewById(R.id.editText);
        secondText.setText(messageReceived);
    }

}

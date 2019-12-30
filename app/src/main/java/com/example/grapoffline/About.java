package com.example.grapoffline;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class About extends AppCompatActivity implements View.OnClickListener {
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.about);
        b1 = (Button) findViewById(R.id.easter_egg);
        b1.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.easter_egg) {
            Intent intent_easter_egg = new Intent(About.this, Easter_egg.class);
            startActivity(intent_easter_egg);
        }
    }
}
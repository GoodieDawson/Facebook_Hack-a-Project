package com.careerpathfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userActivity extends AppCompatActivity {

   // Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        /*but = findViewById(R.id.login);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

                startActivity(intent);
            }
        });*/
    }

    public void Next(View view) {

        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void Forward(View view) {
        Intent j = new Intent(this, SignupActivity.class);
        startActivity(j);
    }
}
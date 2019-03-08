package com.example.android.postify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ImageView home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeintent = new Intent(Payment.this, MainActivity.class);
                startActivity(homeintent);
            }
        });

        ImageView nowplaying = (ImageView) findViewById(R.id.nowplaying);
        nowplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowplayingintent = new Intent(Payment.this, NowPlaying.class);
                startActivity(nowplayingintent);
            }
        });

        ImageView library = (ImageView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryintent = new Intent(Payment.this, Library.class);
                startActivity(libraryintent);
            }
        });
    }
}
package com.example.android.postify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ImageView home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeintent = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(homeintent);
            }
        });

        ImageView library = (ImageView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryintent = new Intent(NowPlaying.this, Library.class);
                startActivity(libraryintent);
            }
        });

        ImageView payment = (ImageView) findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentinent = new Intent(NowPlaying.this, Payment.class);
                startActivity(paymentinent);
            }
        });
    }
}
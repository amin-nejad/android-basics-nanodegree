package com.example.android.postify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(getResources().getString(R.string.home));

        ImageView library = (ImageView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryintent = new Intent(MainActivity.this, Library.class);
                startActivity(libraryintent);
            }
        });

        ImageView nowplaying = (ImageView) findViewById(R.id.nowplaying);
        nowplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowplayingintent = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(nowplayingintent);
            }
        });

        ImageView payment = (ImageView) findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentinent = new Intent(MainActivity.this, Payment.class);
                startActivity(paymentinent);
            }
        });
    }
}
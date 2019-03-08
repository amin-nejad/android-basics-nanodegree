package com.example.aanej.inventorymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.animation_view);

        button = findViewById(R.id.button);
        //button.setText(getString(R.string.home));
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!lottieAnimationView.isAnimating()) {
            lottieAnimationView.playAnimation();
        }
    }

    public void animate(View v) {
        Intent intent = new Intent(this, HomeActivity.class);

        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
            startActivity(intent);
        } else {
            startActivity(intent);
        }
    }
}
/*

        button = findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void animate(View v) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
*/
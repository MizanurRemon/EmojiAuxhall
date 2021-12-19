package com.example.auxhall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton keyboardButton;
    LinearLayout mainLayout, hideKeyBoardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyboardButton = findViewById(R.id.floating_action_button);
        mainLayout = findViewById(R.id.mainLayoutID);
        hideKeyBoardButton = findViewById(R.id.hideKeyBoardButtonID);

        keyboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_up);
                mainLayout.startAnimation(bottomUp);
                keyboardButton.setVisibility(View.GONE);
                mainLayout.setVisibility(View.VISIBLE);
            }
        });

        hideKeyBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_down);
                mainLayout.startAnimation(bottomUp);
                keyboardButton.setVisibility(View.VISIBLE);
                mainLayout.setVisibility(View.GONE);
            }
        });
    }
}
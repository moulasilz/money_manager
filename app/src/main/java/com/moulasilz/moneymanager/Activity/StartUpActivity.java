package com.moulasilz.moneymanager.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.moulasilz.moneymanager.R;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }else {
            View logoView = findViewById(R.id.StartUp_Logo);
            overridePendingTransition(R.anim.anim_intent_in, R.anim.anim_intent_out);
            logoView.setVisibility(View.VISIBLE);
            logoView.startAnimation(AnimationUtils.loadAnimation(StartUpActivity.this, R.anim.anim_fade_in));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }, 5000);
        }
    }

    private void mapping(){

    }

    private void initComponents() {

    }

}
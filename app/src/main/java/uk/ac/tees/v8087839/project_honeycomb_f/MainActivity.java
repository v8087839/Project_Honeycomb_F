package uk.ac.tees.v8087839.project_honeycomb_f;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static final int SplashTimeOut = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(MainActivity.this , HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }, SplashTimeOut);
    }
}
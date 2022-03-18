package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button SignUpButton;
    Button LogInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SignUpButton = findViewById(R.id.SignUp);
        LogInButton = findViewById(R.id.LogIn);


        SignUpButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUp.class)));

        LogInButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LogIn.class)));
    }
}
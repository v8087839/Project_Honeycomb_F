package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button SignUpButton;
    Button LogInButton;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Pre-registered Comment out to test
        //if(fAuth.getCurrentUser() != null)
        //{
        //    startActivity(new Intent(getApplicationContext(), MainMenu.class));
        //    finish();
        //}

        SignUpButton = findViewById(R.id.SignUp);
        LogInButton = findViewById(R.id.LogIn);


        SignUpButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUp.class)));

        LogInButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LogIn.class)));
    }
}
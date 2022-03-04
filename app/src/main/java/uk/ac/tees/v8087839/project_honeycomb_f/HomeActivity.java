package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    Button SignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SignUpButton = findViewById(R.id.SignUp);
        SignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

    }
    public void openNewActivity(){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}

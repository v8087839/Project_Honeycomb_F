package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText mFirstName, mSurname, mEmail, mPassword1, mPassword2;
    Button mSignUp;
    TextView mLogIn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirstName = findViewById(R.id.FirstNameType);
        mSurname = findViewById(R.id.LastNameType);
        mEmail = findViewById(R.id.EmailType);
        mPassword1 = findViewById(R.id.Password1Type);
        mPassword2 = findViewById(R.id.Password2Type);
        mSignUp = findViewById(R.id.SignUpButton);
        mLogIn = findViewById(R.id.HaveAnAccount);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        //Pre-registered Comment out to test
        //if(fAuth.getCurrentUser() != null) {
        //    startActivity(new Intent(getApplicationContext(), BasicMenu.class));
        //    finish();
        //}

        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LogIn.class));
            }
        });

        //On sign up button click
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password1 = mPassword1.getText().toString().trim();
                String password2 = mPassword2.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email Address can't be blank");
                    return;
                }
                if (TextUtils.isEmpty(password1)) {
                    mPassword1.setError("Password can't be blank");
                    return;
                }
                if (TextUtils.isEmpty(password2)) {
                    mPassword2.setError("Password can't be blank");
                    return;
                }
                if(password1.length() < 6) {
                    mPassword1.setError("Password must 6 or more characters");
                    return;
                }
                if (!(password1.equals(password2))) {
                    mPassword2.setError("Passwords must match");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Register User
                fAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), BasicMenu.class));
                        }
                        else {
                            Toast.makeText(SignUp.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        }
    }

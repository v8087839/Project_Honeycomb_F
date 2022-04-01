package uk.ac.tees.v8087839.project_honeycomb_f;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class MainMenu extends AppCompatActivity {

    Button editProfile;
    Button Feedback;
    Button Bugs;
    Button Settings;
    Button SignOut;
    Button Timetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        SignOut = findViewById(R.id.SignOut);
        editProfile = findViewById(R.id.editProfile);
        Feedback = findViewById(R.id.Feedback);
        Bugs = findViewById(R.id.Bugs);
        Settings = findViewById(R.id.Settings);
        Timetable = findViewById(R.id.TimetableButton);

        //Settings access
        Settings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
        });

        //Edit profile access
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Edit_Profile.class));
            }
        });

        //Feedback access
        Feedback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), Feedback.class));
            }
        });

        //Report bugs access
        Bugs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), ReportBugs.class));
            }
        });


        //LogOut method (When this is attached to a button the pre-registered if statement in SignUp class can also be active)

        SignOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

        Timetable.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), Timetable.class));
            }
        });
    }
}
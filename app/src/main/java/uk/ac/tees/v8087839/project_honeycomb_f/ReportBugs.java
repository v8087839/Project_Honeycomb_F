package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ReportBugs extends AppCompatActivity
{

    //Initialising UI Elements
    Button BugsSend;
    Button BugsCancel;
    TextView BugsDevice;
    TextView BugsPage;
    TextView BugsExplanation;
    //final FirebaseDatabase ReportedBugs = FirebaseDatabase.getInstance();
    //DatabaseReference RBref = ReportedBugs.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_bugs);

        //Assigning Variables to UI Elements
        BugsSend = findViewById(R.id.SendBugs);
        BugsCancel = findViewById(R.id.CancelBugs);
        BugsDevice = findViewById(R.id.DeviceBox);
        BugsPage = findViewById(R.id.PageBox);
        BugsExplanation = findViewById(R.id.ExplanationBox);

        //Creating Strings for storing
        String Device = BugsDevice.getText().toString();
        String Page = BugsPage.getText().toString();
        String Explanation = BugsExplanation.getText().toString();

        //Send button
        BugsSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Attempt to implement data being saved
                //Map<String, String> BugsDeviceM = new HashMap<>();
                //BugsDeviceM.put("Device: ", Device);
                //RBref.setValue(BugsDeviceM);
                //Map<String, String> BugsPageM = new HashMap<>();
                //BugsPageM.put("Page: ", Page);
                //RBref.setValue(BugsPageM);
                //Map<String, String> BugsExM = new HashMap<>();
                //BugsExM.put("Explanation: ", Explanation);
                //RBref.setValue(BugsExM);
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });

        //Cancel button
        BugsCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });
    }
}
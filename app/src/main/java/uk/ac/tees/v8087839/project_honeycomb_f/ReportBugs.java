package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReportBugs extends AppCompatActivity
{

    //Initialising UI Elements
    Button BugsSend;
    Button BugsCancel;
    TextView BugsDevice;
    TextView BugsPage;
    TextView BugsExplanation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_bugs);

        //Assigning Variables to UI Elements
        BugsSend.findViewById(R.id.SendBugs);
        BugsCancel.findViewById(R.id.CancelBugs);
        BugsDevice.findViewById(R.id.DeviceBox);
        BugsPage.findViewById(R.id.PageBox);
        BugsExplanation.findViewById(R.id.ExplanationBox);

        //Send button
        BugsSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

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
package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Feedback extends AppCompatActivity
{
    //Initialising UI Elements
    Button Send;
    Button Cancel;
    TextView FeedbackHead;
    TextView FeedbackBody;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //Assigning Variables to their respective UI elements
        Send = findViewById(R.id.Send);
        Cancel = findViewById(R.id.Cancel);
        FeedbackHead = findViewById(R.id.FeedbackHead);
        FeedbackBody = findViewById(R.id.FeedbackBody);

        Send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });
    }


}
package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Edit_Profile extends AppCompatActivity {

    TextView displayName, firstName, lastName, email, Dob, Phone;
    FirebaseAuth FAuth;
    FirebaseFirestore FStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Phone = findViewById(R.id.PhoneProfile);
        Dob = findViewById(R.id.Dob);
        email = findViewById(R.id.emailProfile);
        lastName = findViewById(R.id.LastNameProfile);
        firstName = findViewById(R.id.firstNameProfile);
        displayName = findViewById(R.id.DiaplayName);

        FAuth = FirebaseAuth.getInstance();
        FStore = FirebaseFirestore.getInstance();
        userId = FAuth.getCurrentUser().getUid();

        DocumentReference documentReference = FStore.collection("user").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Phone.setText(value.getString("phone"));
                firstName.setText(value.getString("fName"));
                lastName.setText(value.getString("lName"));
                email.setText(value.getString("email"));
                displayName.setText(value.getString("DName"));
                Dob.setText(value.getString("DOB"));
            }
        });

    }
}
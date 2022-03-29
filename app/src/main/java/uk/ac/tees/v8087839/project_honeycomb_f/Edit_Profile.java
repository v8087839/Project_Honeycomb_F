package uk.ac.tees.v8087839.project_honeycomb_f;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class Edit_Profile extends AppCompatActivity {

    TextView displayName, firstName, lastName, email, Dob, Phone, verifyText, verifyButton;
    Button saveButton, backButton;
    FirebaseAuth FAuth;
    FirebaseFirestore FStore;
    String userId;
    ImageView ProfileImage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Phone = findViewById(R.id.PhoneProfile);
        Dob = findViewById(R.id.Dob);
        email = findViewById(R.id.emailProfile);
        lastName = findViewById(R.id.LastNameProfile);
        firstName = findViewById(R.id.firstNameProfile);
        displayName = findViewById(R.id.DisplayName);
        ProfileImage = findViewById(R.id.imageView5);

        verifyText = findViewById(R.id.VerifyText);
        verifyButton = findViewById(R.id.VerifyButton);

        saveButton = findViewById(R.id.SaveButton);
        backButton = findViewById(R.id.BackButton);

        FAuth = FirebaseAuth.getInstance();
        FStore = FirebaseFirestore.getInstance();
        userId = FAuth.getCurrentUser().getUid();
        FirebaseUser user = FAuth.getCurrentUser();
        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference ProfileReference = storageReference.child("Users/"+userId+"/Profile.jpg");
        ProfileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(ProfileImage);
            }
        });

        if(!user.isEmailVerified()){
          verifyText.setVisibility(View.VISIBLE);
          verifyButton.setVisibility(View.VISIBLE);

          verifyButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  user.sendEmailVerification();
                  Toast.makeText(view.getContext(), "Verification Email Sent", Toast.LENGTH_SHORT).show();
              }
          });





        }

        DocumentReference documentReference = FStore.collection("user").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                assert value != null;
                Phone.setText(value.getString("phone"));
                firstName.setText(value.getString("fName"));
                lastName.setText(value.getString("lName"));
                email.setText(value.getString("email"));
                displayName.setText(value.getString("DName"));
                Dob.setText(value.getString("DOB"));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String mphone = Phone.getText().toString();
                    String mdob = Dob.getText().toString();
                    String memail = email.getText().toString();
                    String mLname = lastName.getText().toString();
                    String mFname = firstName.getText().toString();
                    String mDname = displayName.getText().toString();
                    userId = FAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = FStore.collection("user").document(userId);
                    //Map<String, Object> user;
                    documentReference.update("fName", mFname);
                    documentReference.update("lName", mLname);
                    documentReference.update("email", memail);
                    documentReference.update("Phone", mphone);
                    documentReference.update("DName", mDname);
                    documentReference.update("DOB", mdob);

                    Toast.makeText(Edit_Profile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(getApplicationContext(), MainMenu.class));
                }
           });

        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open gallery

                Intent OpenGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(OpenGalleryIntent, 1000);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                //ProfileImage.setImageURI(imageUri);
                UploadImageToFirebase(imageUri);
            }
        }
    }
    private void UploadImageToFirebase(Uri image){
        StorageReference fileRef = storageReference.child("Users/"+userId+"/Profile.jpg");
        fileRef.putFile(image).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(ProfileImage);
                    }
                });
            }
        });



    }


}
package com.fidohealth.fido;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SurveyActivity extends AppCompatActivity {
    Button submitButton;
    EditText editTextHeight, editTextWeight, editTextName;
    Spinner conditi;
    TextView textViewProfile;
    String[] conditio = new String[]{"Depression", "Seizures", "ADHD"};

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        submitButton = findViewById(R.id.buttonSubmitSurvey);
        editTextHeight = findViewById(R.id.Height);
        editTextWeight = findViewById(R.id.Weight);
        textViewProfile = findViewById(R.id.Profile);
        conditi = findViewById(R.id.Condit);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(SurveyActivity.this, android.R.layout.simple_list_item_1, conditio);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditi.setAdapter(adapt);
        textViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SurveyActivity.this, CreateAccountActivity.class));
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double h = Double.parseDouble(editTextHeight.getText().toString().trim());
                double w = Double.parseDouble(editTextWeight.getText().toString().trim());
                String name = editTextName.getText().toString().trim();
                String c = conditi.getSelectedItem().toString();

                UserInfo userInfo = new UserInfo(name, c, w, h);

                FirebaseUser user = firebaseAuth.getCurrentUser();

                databaseReference.child(user.getUid()).setValue(userInfo);
            }
        });
    }
}

package com.fidohealth.fido;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class SurveyActivity extends AppCompatActivity{
    Button submitButton;
    EditText editTextHeight, editTextWeight, editTextName;
    ScrollView condition;
    Spinner conditi;
    TextView textViewProfile;
    String[] conditio=new String[]{"Depression","Seizures","ADHD"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        submitButton = findViewById(R.id.buttonSubmitSurvey);
        editTextHeight = findViewById(R.id.Height);
        editTextWeight = findViewById(R.id.Weight);
        textViewProfile = findViewById(R.id.Profile);
        condition = findViewById(R.id.Conditions);
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
            }
        });
    }
}

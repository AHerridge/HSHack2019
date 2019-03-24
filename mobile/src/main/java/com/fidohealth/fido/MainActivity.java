package com.fidohealth.fido;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.veryhappy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(1);
            }
        });

        findViewById(R.id.happy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(.5);
            }
        });

        findViewById(R.id.neutral).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(0);
            }
        });

        findViewById(R.id.sad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(-.5);
            }
        });

        findViewById(R.id.verysad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(-1);
            }
        });
    }

    private void submit(double mood) {
        User user = UserDao.getById("Alex");
        user.data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), mood));
//        for (DataSample dataSample : user.data)
//            System.err.println(Arrays.toString(dataSample.asArray()));
        finish();
    }

    @Override
    public void finish() {
        Intent intent = new Intent(this, PredictActivity.class);
        startActivity(intent);
    }
}

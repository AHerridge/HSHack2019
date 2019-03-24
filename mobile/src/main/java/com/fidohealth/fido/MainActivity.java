package com.fidohealth.fido;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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

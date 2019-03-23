package com.fidohealth.fido;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
        addNotification();

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
        user.data.add(new DataSample(1.0, 0.78, 0.2, 0.85, 0.25, mood));
    }

    private void createNotificationChannel() {
        CharSequence name = "Notifier2";
        String description = "Umm";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("SurveyNotifier", name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.veryhappy)
                        .setContentTitle("Mood Survey")
                        .setContentText("How do you feel?")
                        .setChannelId("SurveyNotifier");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}

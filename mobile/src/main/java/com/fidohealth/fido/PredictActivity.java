package com.fidohealth.fido;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PredictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);

        double temperature = Math.random();
        double humidity = Math.random();
        double volume = Math.random();
        double activity = Math.random();
        double weather = Math.random();
        double heartRate = Math.random();

        ((ImageView) findViewById(R.id.predictedEmotion)).setImageResource(UserDao.getById("Alex").getEmotion(temperature, humidity, volume, activity, weather));

        createNotificationChannel();
        addNotification();
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

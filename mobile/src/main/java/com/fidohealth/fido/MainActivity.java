package com.fidohealth.fido;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent surveyIntent = new Intent(this, SurveyBroadcastReceiver.class);
//        PendingIntent pendingSurveyIntent = PendingIntent.getBroadcast(this, 0, surveyIntent, 0);

        createNotificationChannel();
        addNotification();
//        Notification moodSurvey = new Notification.Builder(this, NotificationChannel.DEFAULT_CHANNEL_ID)
//                .setContentTitle("How do you feel?")
//                .setContentText("YO")
//                .setSmallIcon(R.drawable.face_1)
//                .addAction(R.drawable.face_1, "Good", pendingSurveyIntent)
//                .build();
//        NotificationManagerCompat.from(this).notify(1, moodSurvey);
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
                        .setSmallIcon(R.drawable.face_1)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification")
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

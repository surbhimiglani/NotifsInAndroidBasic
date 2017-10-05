package com.example.surbhimiglani.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    NotificationCompat.Builder notification;
    private final static int uniqueID=9009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

    }


    public void clickForNotif(View view){
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("ticker notification");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Title");
        notification.setContentText("Keep going bro");


        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);


        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }


}

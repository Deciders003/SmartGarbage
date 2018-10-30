package com.example.saravanan.tomtom.People;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.widget.Toast;

import com.example.saravanan.tomtom.MainActivity;
import com.example.saravanan.tomtom.R;


public class NotificationHelper extends ContextWrapper {
    private static final String channel_id="channel1id";
    private static final String channel_name="channel 1";
    private NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createchannels();
        }
    }


    @TargetApi(Build.VERSION_CODES.O)
    private void createchannels() {
        NotificationChannel channel=new NotificationChannel(channel_id,channel_name, NotificationManager.IMPORTANCE_DEFAULT);
channel.enableLights(true);
channel.enableVibration(true);
channel.setLightColor(Color.GREEN);
channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
    getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
       if(manager==null) {
           manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
       }
        return manager;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public Notification.Builder getNotification(String title, String body)
    {
        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
        Intent resultintent=new Intent(this, Alert.class);
        PendingIntent intent= PendingIntent.getActivity(this,1,resultintent, PendingIntent.FLAG_UPDATE_CURRENT);
        return new Notification.Builder(getApplicationContext(),channel_id)
                .setContentText(body)
                .setContentTitle(title)
               .setSmallIcon(R.drawable.smallkutty)
                .setAutoCancel(true)
                .setContentIntent(intent);


    }
}

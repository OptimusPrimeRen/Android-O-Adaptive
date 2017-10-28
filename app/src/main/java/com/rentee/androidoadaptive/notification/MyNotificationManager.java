package com.rentee.androidoadaptive.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Tian on 17/10/21.
 */

public class MyNotificationManager {
    public static final String TAG = "MyNotificationManager";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void initNotificationChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("a", "a"));

        NotificationChannel channel = new NotificationChannel("1",
                "Channel1", NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(true);
        channel.setLightColor(Color.GREEN);
        channel.setShowBadge(true);
        notificationManager.createNotificationChannel(channel);

        NotificationChannel channel2 = new NotificationChannel("2",
                "Channel2", NotificationManager.IMPORTANCE_DEFAULT);
        channel2.enableLights(true);
        channel2.setLightColor(Color.GREEN);
        channel2.setGroup("a");
        notificationManager.createNotificationChannel(channel2);
    }

    /**
     * 错误示例
     */
    public static void showNotificationWrong(Context context) {
        int notificationId = 0x1234;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, Integer.toString(notificationId));

        builder.setSmallIcon(android.R.drawable.stat_notify_chat);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void showChannel1Notification(Context context) {
        int notificationId = 0x1234;
        Notification.Builder builder = new Notification.Builder(context,"1");

        builder.setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentText("xxx");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void showChannel2Notification(Context context) {
        int notificationId = 0x1235;
        Notification.Builder builder = new Notification.Builder(context, "2");

        builder.setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentText("xxx")
                .setNumber(3)
                .setContentTitle("Title");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, builder.build());
    }

}
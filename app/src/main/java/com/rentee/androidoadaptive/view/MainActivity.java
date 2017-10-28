package com.rentee.androidoadaptive.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rentee.androidoadaptive.R;
import com.rentee.androidoadaptive.notification.MyNotificationManager;
import com.rentee.androidoadaptive.shortcut.MyShortcutManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Adaptive";

    private Button mBtnAddShortcut;
    private Button mBtnSendNotificationChannel1;
    private Button mBtnSendNotificationChannel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyNotificationManager.initNotificationChannel(this);
        initView();
    }

    private void initView() {
        mBtnAddShortcut = findViewById(R.id.btn_add_shortcut);
        mBtnAddShortcut.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                MyShortcutManager.addShortCut(getApplicationContext());
            }
        });

        mBtnSendNotificationChannel1 = findViewById(R.id.btn_send_notification_channel1);
        mBtnSendNotificationChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyNotificationManager.showChannel1Notification(getApplicationContext());
            }
        });

        mBtnSendNotificationChannel2 = findViewById(R.id.btn_send_notification_channel2);
        mBtnSendNotificationChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyNotificationManager.showChannel2Notification(getApplicationContext());
            }
        });
    }
}

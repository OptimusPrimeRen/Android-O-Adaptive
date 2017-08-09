package com.rentee.androidoadaptive.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rentee.androidoadaptive.R;
import com.rentee.androidoadaptive.shortcut.MyShortcutManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Adaptive";

    private Button mBtnAddShortcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnAddShortcut = (Button) findViewById(R.id.btn_add_shortcut);
        mBtnAddShortcut.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                MyShortcutManager.addShortCut(getApplicationContext());
            }
        });
    }
}

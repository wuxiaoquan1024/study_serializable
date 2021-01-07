package com.stduy.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.stduy.serializable.bean.Scumbag;
import com.stduy.serializable.bean.Wife;
import com.stduy.serializable.bean.Woman;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    SerialHelper serialHelper = new SerialHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.EthernetSettings")));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.serial:
//                serialHelper.serial(this, new Scumbag("vill", 2));
                serialHelper.serial(this, new Wife(2, "Big", 30));
                break;

            case R.id.deserial:
                Log.d(TAG, serialHelper.deserial(this).toString());
                break;
        }
    }
}
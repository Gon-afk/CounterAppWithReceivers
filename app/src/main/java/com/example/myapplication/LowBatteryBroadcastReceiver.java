package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

public class LowBatteryBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

       // Toast.makeText(context,"IM HERE ", Toast.LENGTH_SHORT).show();
        //int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL);
        //int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE);
        //float batlevel = level * 100 / (float)scale;
        //int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL) ;
        Toast.makeText(context,"You are getting low in Battery! - Current level: "+ getBatteryLevel(context),Toast.LENGTH_SHORT).show();
    }
    private int getBatteryLevel(Context context) {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int batlevel = -1;
        int scale = -1;
        if (batteryStatus != null) {
            batlevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        }

        float batteryPct = batlevel / (float) scale;
        return (int) (batteryPct * 100);
    }

}

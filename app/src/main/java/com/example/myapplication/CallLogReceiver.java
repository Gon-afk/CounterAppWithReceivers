package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallLogReceiver extends BroadcastReceiver {
    static boolean isRinging = false;
    String number = "";
    @Override
    public void onReceive(Context context, Intent intent) {
       // Toast.makeText(context, "Intent recieved: " + intent.getAction(), Toast.LENGTH_SHORT).show();

        String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (phoneState == null)
        {
            number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Toast.makeText(context, "Outgoing call: " + number,Toast.LENGTH_SHORT).show();
        }

        // If phone Ringing
        if (phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            isRinging = true;

            number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "Phone ringing: " + number,Toast.LENGTH_SHORT).show();
        }

    }
}

package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        int number = intent.getExtras().getInt("number");
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "Unknown intent action";

            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    toastMessage = "Headset plugged!";
                    break;
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    toastMessage = "Airplane mode modified!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received\nSquare of " + number + " = " + number * number;
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
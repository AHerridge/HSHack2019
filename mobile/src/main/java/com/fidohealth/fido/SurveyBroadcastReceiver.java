package com.fidohealth.fido;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SurveyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent instanceof SurveyIntent) {

        }
    }
}

package com.rahat.pharmsafebd.services.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.rahat.pharmsafebd.R;

public class NetworkChangeListener extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (Common.isConnectedToInternet(context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View layout_dialog = LayoutInflater.from(context).inflate(R.layout.check_internet_dialog, null);
            builder.setView(layout_dialog);

            Button retryButton = layout_dialog.findViewById(R.id.retry_button_id);

            AlertDialog dialog = builder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
            dialog.setCancelable(false);
            dialog.getWindow().setGravity(Gravity.CENTER);


            retryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    onReceive(context, intent);
                }
            });

        }
    }
}
















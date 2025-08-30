package com.ulp.trabajopractico1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvion extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean avionState = intent.getBooleanExtra("state", true);

        if(avionState){
            Toast.makeText(context, "Modo avion habilitado", Toast.LENGTH_SHORT).show();
            Intent llamada = new Intent(Intent.ACTION_DIAL);
            llamada.setData(Uri.parse("tel:2664553747"));
            llamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(llamada);
        }else{
            Toast.makeText(context, "Modo avion deshabilitado", Toast.LENGTH_SHORT).show();
        }

    }
}

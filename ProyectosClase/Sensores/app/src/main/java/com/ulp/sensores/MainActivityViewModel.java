package com.ulp.sensores;

import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mDatos;
    private SensorManager sensorManager;
    private List<Sensor> listaSensores;
    private ManejaSensores manejaSensores;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getmDAtos() {
        if(mDatos == null)
            mDatos = new MutableLiveData<>();

        return mDatos;
    }

    public void accederASensores()
    {
        SensorManager manager = (SensorManager)getApplication().getSystemService(Context.SENSOR_SERVICE);
        listaSensores = manager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder cadena = new StringBuilder();
        for(Sensor s:listaSensores){
            cadena.append(s.getName()+"\n");
        }

        mDatos.setValue(cadena.toString());

    }

    public void activarLecturas()
    {
            sensorManager = (SensorManager) getApplication().getSystemService(Context.SENSOR_SERVICE);
            listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
            manejaSensores = new ManejaSensores();
            sensorManager.registerListener(manejaSensores, listaSensores.get(0), SensorManager.SENSOR_DELAY_GAME);
    }

    public void desactivarLecturas(){
        sensorManager.unregisterListener(manejaSensores);
    }

    private class ManejaSensores implements SensorEventListener{

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            mDatos.setValue("x: " + x + "y: " + y + "z: " + z);
        }
    }

}

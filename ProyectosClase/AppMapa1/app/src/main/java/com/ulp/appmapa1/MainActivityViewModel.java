package com.ulp.appmapa1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivityViewModel extends AndroidViewModel {
    public MutableLiveData<MapaActual> mMapa;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<MapaActual> getmMapa() {
        if(mMapa == null)
                mMapa = new MutableLiveData<>();

        return mMapa;
    }

    public void cargarMapa(){
        MapaActual mapaActual = new MapaActual();
        mMapa.setValue(mapaActual);
    }

    public class MapaActual implements OnMapReadyCallback{
        LatLng sanLuis = new LatLng(-33.280576, -66.332482);
        LatLng ulp = new LatLng(-33.150720, -66.306864);
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            MarkerOptions marcadorSL = new MarkerOptions();
            marcadorSL.position(sanLuis);
            marcadorSL.title("San Luis");

            MarkerOptions marcadorULP = new MarkerOptions();
            marcadorULP.position(ulp);
            marcadorULP.title("ULP");

            googleMap.addMarker(marcadorSL);
            googleMap.addMarker(marcadorULP);
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            CameraPosition  cameraPosition = new CameraPosition
                .Builder()
                .target(sanLuis)
                .zoom(30)
                .bearing(45)
                .tilt(15).build();

            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            googleMap.animateCamera(cameraUpdate);


        }
    }
}

package com.ulp.ejemplomenu2.ui.home;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.ejemplomenu2.R;
import com.ulp.ejemplomenu2.modelo.PalabraModel;

import java.util.ArrayList;

public class ResultadoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<PalabraModel> mutablePalabra;

    public LiveData<PalabraModel> getMutablePalabra() {
        if(mutablePalabra == null)
            mutablePalabra = new MutableLiveData<>();

        return mutablePalabra;
    }

    public void buscarTraccion(Bundle bundle){

        String palabraBuscada = bundle.getString("palabra");

        ArrayList<PalabraModel> lista = new ArrayList<>();
        lista.add(new PalabraModel("casa", "house", R.drawable.casa));
        lista.add(new PalabraModel("gato", "cat", R.drawable.gato));
        lista.add(new PalabraModel("perro", "house", R.drawable.perro));
        lista.add(new PalabraModel("auto", "cat", R.drawable.auto));
        lista.add(new PalabraModel("arbol", "tree", R.drawable.arbol));

        boolean bandera = false;
        for(PalabraModel palabra : lista){
            if(palabra.getPalabraEspanol().equals(palabraBuscada)){
                mutablePalabra.setValue(palabra);
                bandera = true;
            }
        }

        if(!bandera){
            mutablePalabra.setValue(new PalabraModel("","Not Found", R.drawable.ic_menu_camera));
        }

    }
}

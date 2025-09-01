package com.ulp.trabajopractico2.ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ulp.trabajopractico2.Model.LibroModel;

public class DetallesActivityViewModel extends AndroidViewModel {
    MutableLiveData<LibroModel> muLibro;
    public DetallesActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<LibroModel> getMuLibro() {
        if(muLibro == null)
            muLibro = new MutableLiveData<>();

        return muLibro;
    }

    public void cargarDatos(Intent intent){
        LibroModel libro = intent.getSerializableExtra("libro", LibroModel.class);

        if(libro != null)
            muLibro.setValue(libro);
    }

}

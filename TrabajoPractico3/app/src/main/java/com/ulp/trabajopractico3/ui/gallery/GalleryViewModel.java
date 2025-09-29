package com.ulp.trabajopractico3.ui.gallery;

import static com.ulp.trabajopractico3.MainActivity.stock;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.trabajopractico3.model.ProductoModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GalleryViewModel extends ViewModel {
    private MutableLiveData<List<ProductoModel>> listaProductosMutable;

    public LiveData<List<ProductoModel>> getListaProductos() {
        if(listaProductosMutable == null){
            listaProductosMutable = new MutableLiveData<>();
            cargarProductos();
        }


        return listaProductosMutable;
    }


    public void cargarProductos (){
        //Creamos una copia para ordenarlos
        ArrayList<ProductoModel> productosOrdenados = new ArrayList<>(stock);

        productosOrdenados.sort((p1, p2) ->
                p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion())
        );

        listaProductosMutable.setValue(productosOrdenados);
    }
}
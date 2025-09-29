package com.ulp.trabajopractico3.ui.gallery;

import static com.ulp.trabajopractico3.MainActivity.stock;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.trabajopractico3.model.ProductoModel;

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
        listaProductosMutable.setValue(stock);
    }
}
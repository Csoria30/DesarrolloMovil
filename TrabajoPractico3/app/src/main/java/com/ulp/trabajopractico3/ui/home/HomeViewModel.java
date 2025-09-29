package com.ulp.trabajopractico3.ui.home;

import static com.ulp.trabajopractico3.MainActivity.stock;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.trabajopractico3.model.ProductoModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> msgeError, msgeCorrecto;
    private MutableLiveData<Boolean> limpiarCampos;

    public LiveData<String> getmError() {
        if( msgeError == null )
            msgeError = new MutableLiveData<>();

        return msgeError;
    }

    public LiveData<String> getmCorrecto() {
        if ( msgeCorrecto == null )
            msgeCorrecto = new MutableLiveData<>();

        return msgeCorrecto;
    }
    public LiveData<Boolean> getLimpiarCampos(){
        if(limpiarCampos == null)
            limpiarCampos = new MutableLiveData<>();

        return limpiarCampos;
    }

    public void cargarProducto(String codigo, String descripcion, String precio){
        if(codigo.isEmpty() || descripcion.isEmpty() || precio.isEmpty()){
            msgeError.setValue("Debe completar todos los campos");
            return;
        }


        //Cargando productos
        for(ProductoModel producto:stock){
            if(producto.getCodigo().equalsIgnoreCase(codigo)){
                msgeError.setValue("El código ya existe");
                return;
            }

        }

        ProductoModel productoNuevo = new ProductoModel(codigo, descripcion, Double.parseDouble(precio));
        stock.add(productoNuevo);
        msgeCorrecto.setValue("Se agregó correctamente");
        limpiarCampos.setValue(true);
    }
}
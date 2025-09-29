package com.ulp.trabajopractico3.ui.eliminar;

import static com.ulp.trabajopractico3.MainActivity.stock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.trabajopractico3.model.ProductoModel;

public class EliminarViewModel extends ViewModel {
    private MutableLiveData<String> msgeError;
    private MutableLiveData<ProductoModel> productoEncontrado;
    private MutableLiveData<String> campoCodigo;

    public LiveData<String> getMsgeError() {
        if(msgeError == null)
            msgeError = new MutableLiveData<>();
        return msgeError;
    }

    public LiveData<ProductoModel> getProductoEncontrado() {
        if(productoEncontrado == null)
            productoEncontrado = new MutableLiveData<>();
        return productoEncontrado;
    }

    public LiveData<String> getCampoCodigo() {
        if(campoCodigo == null)
            campoCodigo = new MutableLiveData<>();
        return campoCodigo;
    }

    public void buscarProducto(String codigo) {
        if(codigo.isEmpty()) {
            msgeError.setValue("Debe ingresar un codigo");
            return;
        }

        if(!codigo.matches("\\d+")) {
            msgeError.setValue("El codigo debe contener solo numeros");
            return;
        }

        // Buscar producto
        ProductoModel encontrado = null;

        for(ProductoModel producto : stock) {
            if(producto.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = producto;
                break;
            }
        }

        //Mensaje Error
        if(encontrado != null){
            productoEncontrado.setValue(encontrado);
            msgeError.setValue("Producto Encontrado");
        }else{
            msgeError.setValue("Producto no encontrado");
        }
    }
}
package com.ulp.trabajopractico3.ui.home;

import static com.ulp.trabajopractico3.MainActivity.stock;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.trabajopractico3.model.ProductoModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> msgeError, msgeCorrecto;
    private MutableLiveData<String> campoCodigo, campoDescripcion, campoPrecio;

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
    //Campos del formulario
    public LiveData<String> getCampoCodigo(){
        if(campoCodigo == null)
            campoCodigo = new MutableLiveData<>();

        return campoCodigo;
    }

    public LiveData<String> getCampoDescripcion(){
        if(campoDescripcion == null)
            campoDescripcion = new MutableLiveData<>();

        return campoDescripcion;
    }

    public LiveData<String> getCampoPrecio(){
        if(campoPrecio == null)
            campoPrecio = new MutableLiveData<>();

        return campoPrecio;
    }

    private void limpiarCampos(){
        campoCodigo.setValue("");
        campoDescripcion.setValue("");
        campoPrecio.setValue("");
    }

    public void cargarProducto(String codigo, String descripcion, String precio){
        if(codigo.isEmpty() || descripcion.isEmpty() || precio.isEmpty()){
            msgeError.setValue("Debe completar todos los campos");
            return;
        }

        //Valida que codigo solo tenga numeros
        if(!codigo.matches("\\d+")){
            msgeError.setValue("El código debe contener solo números");
            return;
        }

        // Valida numero valido, acepta solo decimales positivos
        if(!precio.matches("\\d+(\\.\\d+)?")){
            msgeError.setValue("El precio debe ser un número válido");
            return;
        }

        // Valida precio mayor a cero
        double precioValido = Double.parseDouble(precio);
        if(precioValido <= 0){
            msgeError.setValue("El precio debe ser mayor a 0");
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
        limpiarCampos();
    }
}
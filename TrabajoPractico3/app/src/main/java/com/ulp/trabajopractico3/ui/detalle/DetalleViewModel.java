package com.ulp.trabajopractico3.ui.detalle;

import static com.ulp.trabajopractico3.MainActivity.stock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetalleViewModel extends ViewModel {
    private MutableLiveData<String> msgeExito, msgeError;
    private MutableLiveData<Boolean> navegarAtras;
    private MutableLiveData<String> codigoProducto;
    private MutableLiveData<String> descripcionProducto;
    private MutableLiveData<String> precioProducto;

    //Mutables
    public LiveData<String> getMsgeExito() {
        if(msgeExito == null)
            msgeExito = new MutableLiveData<>();
        return msgeExito;
    }
    public LiveData<String> getMsgeError() {
        if(msgeError == null)
            msgeError = new MutableLiveData<>();
        return msgeError;
    }

    public LiveData<Boolean> getNavegarAtras() {
        if(navegarAtras == null)
            navegarAtras = new MutableLiveData<>();
        return navegarAtras;
    }

    public LiveData<String> getCodigoProducto() {
        if(codigoProducto == null)
            codigoProducto = new MutableLiveData<>();
        return codigoProducto;
    }

    public LiveData<String> getDescripcionProducto() {
        if(descripcionProducto == null)
            descripcionProducto = new MutableLiveData<>();
        return descripcionProducto;
    }

    public LiveData<String> getPrecioProducto() {
        if(precioProducto == null)
            precioProducto = new MutableLiveData<>();
        return precioProducto;
    }

    //Funciones
    public void cargarDatosProducto(String codigo, String descripcion, String precioString) {

        if(msgeError == null) msgeError = new MutableLiveData<>();
        if(navegarAtras == null) navegarAtras = new MutableLiveData<>();
        if(codigoProducto == null) codigoProducto = new MutableLiveData<>();
        if(descripcionProducto == null) descripcionProducto = new MutableLiveData<>();
        if(precioProducto == null) precioProducto = new MutableLiveData<>();


        if(codigo == null || descripcion == null || precioString == null) {
            msgeError.setValue("Error: Datos del producto incompletos");
            navegarAtras.setValue(true);
            return;
        }

        if(codigo.trim().isEmpty() || descripcion.trim().isEmpty() || precioString.trim().isEmpty()) {
            msgeError.setValue("Error: Datos del producto vacíos");
            navegarAtras.setValue(true);
            return;
        }

        // Perseo
        double precio;
        try {
            precio = Double.parseDouble(precioString.trim());
        } catch (NumberFormatException e) {
            msgeError.setValue("Error: El precio no es un número válido");
            navegarAtras.setValue(true);
            return;
        }

        if(precio <= 0) {
            msgeError.setValue("Error: El precio debe ser mayor a cero");
            navegarAtras.setValue(true);
            return;
        }

        // Camino feliz - Todo ok
        codigoProducto.setValue("Código: " + codigo);
        descripcionProducto.setValue("Descripción: " + descripcion);
        precioProducto.setValue("Precio: $" + String.format("%.2f", precio));
    }

    public void eliminarProducto(String codigo) {
        if(msgeExito == null) msgeExito = new MutableLiveData<>();
        if(navegarAtras == null) navegarAtras = new MutableLiveData<>();
        if(msgeError == null) msgeError = new MutableLiveData<>();

        if(codigo == null || codigo.isEmpty()) {
            msgeError.setValue("Error: No se puede eliminar, código inválido");
            return;
        }

        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                stock.remove(i);
                msgeExito.setValue("Producto eliminado correctamente");
                navegarAtras.setValue(true);
                return;
            }
        }

        msgeError.setValue("Error: Producto no encontrado para eliminar");
    }

    public void cancelarEliminacion() {
        if(navegarAtras == null) navegarAtras = new MutableLiveData<>();
        navegarAtras.setValue(true);
    }
}
package co.com.bancolombia.certificacion.app.models.transaccion;

import co.com.bancolombia.certificacion.app.models.productos.Producto;

public class Detalle {

    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

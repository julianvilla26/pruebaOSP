package co.com.bancolombia.certificacion.app.models.factoria.producto;

import co.com.bancolombia.certificacion.app.models.productos.Producto;

@FunctionalInterface
public interface InterfazProducto {

     Producto crarProducto(String numeroProducto, String tipoProducto);
}

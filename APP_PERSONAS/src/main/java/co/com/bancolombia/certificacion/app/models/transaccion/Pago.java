package co.com.bancolombia.certificacion.app.models.transaccion;

import co.com.bancolombia.certificacion.app.models.productos.Producto;

public class Pago {

    private Producto productoDebitar;
    private Producto productoAcretar;
    private String metodoDePago;
    private String otroValorAPagar;

    public Producto getProductoDebitar() {
        return productoDebitar;
    }

    public void setProductoDebitar(Producto productoDebitar) {
        this.productoDebitar = productoDebitar;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getOtroValorAPagar() {
        return otroValorAPagar;
    }

    public void setOtroValorAPagar(String otroValorAPagar) {
        this.otroValorAPagar = otroValorAPagar;
    }

    public Producto getProductoAcretar() {
        return productoAcretar;
    }

    public void setProductoAcretar(Producto productoAcretar) {
        this.productoAcretar = productoAcretar;
    }
}

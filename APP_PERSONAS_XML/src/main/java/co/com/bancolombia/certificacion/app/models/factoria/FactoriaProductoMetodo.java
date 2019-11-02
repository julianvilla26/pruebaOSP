package co.com.bancolombia.certificacion.app.models.factoria;


import co.com.bancolombia.certificacion.app.models.productos.Producto;

/**
 * The interface Producto fabrica method.
 */
public interface FactoriaProductoMetodo {

    /**
     * Create factoria factoria.
     *
     * @param numberProduct the number factoria
     * @param typeProduct   the type factoria
     * @return the factoria
     */
    Producto createProduct(String numberProduct, String typeProduct);

}

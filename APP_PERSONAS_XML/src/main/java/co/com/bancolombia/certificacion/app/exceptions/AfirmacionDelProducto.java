package co.com.bancolombia.certificacion.app.exceptions;


import co.com.bancolombia.certificacion.app.utilidades.constantes.ExcepcionesConstante;

import java.text.MessageFormat;


/**
 * The type Field factoria assertion.
 */
public class AfirmacionDelProducto extends AssertionError {


    /**
     * The constantes NO_FUNCIONA.
     */
    public static final String NO_FUNCIONA = "No fue posible encontar el producto o archivo";

    /**
     * Instantiates a new Field factoria assertion.
     *
     * @param itemID the item id
     */
    public AfirmacionDelProducto(String itemID) {
        super(MessageFormat.format(ExcepcionesConstante.PRODUCTO_NO_EXISTE, itemID));
    }


}

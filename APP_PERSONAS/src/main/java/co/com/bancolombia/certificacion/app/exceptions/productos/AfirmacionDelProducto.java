package co.com.bancolombia.certificacion.app.exceptions.productos;


import co.com.bancolombia.certificacion.app.utilidades.constantes.ExcepcionesConstante;

import java.text.MessageFormat;

public class AfirmacionDelProducto extends AssertionError {

    public static final String NO_FUNCIONA = "No fue posible encontar el producto o archivo";

    public AfirmacionDelProducto(String itemID) {
        super(MessageFormat.format(ExcepcionesConstante.PRODUCTO_NO_EXISTE, itemID));
    }


}

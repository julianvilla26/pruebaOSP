package co.com.bancolombia.certificacion.app.utilidades.constantes;

public class ExcepcionesConstante {

    public static final String PRODUCTO_NO_EXISTE = "Producto o archivo no existe";

    private ExcepcionesConstante() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_CONSTANTE);
    }

}

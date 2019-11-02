package co.com.bancolombia.certificacion.app.exceptions.consultas.saldos;

public class ProductosDeUsuarioNoSonCorrectosException extends AssertionError{
    public static final String MENSAJE_PRODUCTOS_MOSTRADOS_NO_SON_CORRECTOS = "Los productos que se han mostrado en la categoria seleccionada no son acordes a los que deberia tener el usuario";

    public ProductosDeUsuarioNoSonCorrectosException(String mensaje, Throwable causa){
        super(mensaje,causa);
    }
}
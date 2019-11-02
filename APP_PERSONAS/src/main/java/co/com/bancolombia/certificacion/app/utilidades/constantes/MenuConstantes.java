package co.com.bancolombia.certificacion.app.utilidades.constantes;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_CONSTANTE;

public class MenuConstantes {
    public static final String INICIO = "Inicio";
    public static final String MIS_PRODUCTOS = "Mis productos";
    public static final String BILLETERA = "Billetera";
    public static final String SOLICITAR_PRODUCTOS = "Solicitar productos";
    public static final String PERFIL = "Perfil";

    private MenuConstantes() {
        throw new IllegalStateException(CLASE_CONSTANTE);
    }
}
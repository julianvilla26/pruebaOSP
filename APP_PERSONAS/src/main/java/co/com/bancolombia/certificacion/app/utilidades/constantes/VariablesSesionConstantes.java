package co.com.bancolombia.certificacion.app.utilidades.constantes;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_CONSTANTE;

public class VariablesSesionConstantes {
    public static final String TIENE_PRODUCTOS = "tiene productos";
    public static final String NUMERO_CUENTA = "NUMERO DE CUENTA PRODUCTO";
    public static final String TIPO_CUENTA = "TIPO CUENTA";
    public static final String TIPO_DOCUMENTO = "TIPO DOCUMENTO";
    public static final String NUMERO_DOCUMENTO = "NUMERO DOCUMENTO";
    public static final String NOMBRE_BANCO = "NOMBRE BANCO";
    public static final String NOMBRE_PERSONALIZADO_CLAVE_DINAMICA = "Nombre personalizado";
    public static final String TIPO_CORREO_CLAVE_DINAMICA = "Tipo de correo";
    public static final String TIPO_CORREO_LABORAL = "Laboral";
    public static final String CORREO_CLAVE_DINAMICA = "Correo electrónico";
    public static final String NUMERO_CELULAR = "Número de celular";
    public static final String SERVICIO = "EMPRESA O SERVICIO";
    public static final String CHEQUE = "Rango de Cheques";
    public static final String TIPO_ORIGEN_VERIFICACION = "TIPO ORIGEN VERIFICACION";
    public static final String CUENTA_ORIGEN_VERIFICACION = "CUENTA ORIGEN VERIFICACION";
    public static final String CUENTA_DESTINO_VERIFICACION = "CUENTA DESTINO VERIFICACION";
    public static final String TIPO_DESTINO_VERIFICACION = "TIPO DESTINO VERIFICACION";
    public static final String VALOR_DESEMBOLSAR = "VALOR DESEMBOLSAR";
    public static final String RECARGAR_EPREPAGO = "RECARGAR EPREPAGO";
    public static final String DESCARGAR_EPREPAGO = "DESCARGAR EPREPAGO";

    private VariablesSesionConstantes() {
        throw new IllegalStateException(CLASE_CONSTANTE);
    }
}
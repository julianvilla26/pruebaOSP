package co.com.bancolombia.certificacion.app.utilidades.enumeradores;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.MenuConstantes.*;

public enum TipoTransaccionEnum {
    CONSULTAR_PRODUCTO(MIS_PRODUCTOS, "Consultar mis productos",""),
    TRANSFERIR_DINERO(MIS_PRODUCTOS, "Transferir dinero","Transferir dinero"),
    INSCRIBIR_PRODUCTOS(MIS_PRODUCTOS, "Inscribir productos",""),
    GENERAR_CODIGO_QR(MIS_PRODUCTOS, "Recibir dinero","Generar código QR"),
    PAGAR_TARJETAS_DE_CREDITO_NO_PROPIAS(MIS_PRODUCTOS, "Pagar tarjetas de crédito","Pagar tarjetas no propias"),
    PAGAR_CREDITOS(MIS_PRODUCTOS, "Pagar tarjetas de crédito","Pagar créditos"),
    PAGAR_TARJETAS_DE_CREDITO_PROPIAS(MIS_PRODUCTOS, "Pagar tarjetas de crédito","Pagar tarjetas propias"),
    REALIZAR_AVANCES_DESEMBOLSOS(MIS_PRODUCTOS, "Realizar avances y desembolsos",""),
    PROGRAMAR_PAGAR_FACTURAS(MIS_PRODUCTOS, "Pagar y administrar facturas","Programar y pagar facturas"),
    CONSULTAR_DETALLE_FACTURA(MIS_PRODUCTOS, "Pagar y administrar facturas","Programar y pagar facturas"),
    ELIMINAR_FACTURA(MIS_PRODUCTOS, "Pagar y administrar facturas","Programar y pagar facturas"),
    SOLICITAR_EPREPAGO(SOLICITAR_PRODUCTOS, "e-Prepago",""),
    PAGAR_FACTURA(MIS_PRODUCTOS, "Pagar y administrar facturas","Programar y pagar facturas"),
    INSCRIBIR_FACTURAS(MIS_PRODUCTOS, "Pagar y administrar facturas","Inscribir facturas"),
    VER_HISTORICO_PAGOS(MIS_PRODUCTOS, "Pagar y administrar facturas","Ver histórico de pagos"),
    CONSULTAR_PUNTOS_COLOMBIA(MIS_PRODUCTOS, "Consultar Puntos Colombia",""),
    DESEMBOLSAR_CREDIAGIL(MIS_PRODUCTOS, "Realizar avances y desembolsos","Desembolsar crediágil"),
    INVERSIONES(SOLICITAR_PRODUCTOS, "Inversiones",""),
    OPCION_BILLETERA(BILLETERA, "",""),
    ACTIVAR_EPREPAGO(SOLICITAR_PRODUCTOS, "e-Prepago",""),
    BLOQUEOS(PERFIL, "Bloqueos",""),
    GENERAR_CLAVE_DINAMICA(PERFIL, "Seguridad","Gestionar la clave dinámica"),
    GESTIONAR_CLAVE_DINAMICA(PERFIL, "Seguridad","Gestionar la clave dinámica"),
    BLOQUEAR_TARJETAS(PERFIL, "Bloqueos","Bloquear tarjetas definitivamente"),
    BLOQUEAR_CLAVE(PERFIL, "Bloqueos","Bloquear clave"),
    BLOQUEAR_TARJETAS_CLAVE(PERFIL, "Bloqueos","Bloquear tarjetas y clave"),
    BLOQUEAR_CLAVE_DINAMICA(PERFIL, "Bloqueos","Bloquear clave dinámica"),
    CONTRAORDENAR_CHEQUE(PERFIL, "Seguridad","Contraordenar cheques"),
    ACTUALIZAR_DATOS_SEGURIDAD(PERFIL, "Seguridad","Actualizar datos de seguridad"),
    RECARGAR_EPREPAGO(SOLICITAR_PRODUCTOS, "e-Prepago",""),
    DESCARGAR_EPREPAGO(SOLICITAR_PRODUCTOS, "e-Prepago",""),
    INACTIVAR_EPREPAGO(SOLICITAR_PRODUCTOS, "e-Prepago","");

    private String menu;
    private String subMenu;
    private String tercerNivel;

    TipoTransaccionEnum(String menu, String subMenu, String tercerNivel) {
        this.menu = menu;
        this.subMenu = subMenu;
        this.tercerNivel = tercerNivel;
    }

    public String getMenu() {
        return menu;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public String getTercerNivel() {
        return tercerNivel;
    }
}
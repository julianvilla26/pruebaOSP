package co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.GeneralLocator.LNK_SIGUIENTE_LOCATOR;
import static co.com.bancolombia.certificacion.app.userinterface.locators.administrarfacturas.ProgramarPagarFacturasLocator.*;
import static co.com.bancolombia.certificacion.app.userinterface.locators.registro.InscripcionClaveDinamicaLocator.CHK_TIPO_CORREO_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class ProgramarPagarFacturasPage {
    public static final Target OPT_FACTURA = Target.the("Seleccionar factura").locatedBy(dynamicElement(OPT_FACTURA_LOCATOR));
    public static final Target OPT_PROGRAMAR = Target.the("Seleccionar la opción programar").located(theElementBy(OPT_PROGRAMAR_LOCATOR));
    public static final Target OPT_MIS_PRODUCTOS = Target.the("Seleccionar la opción desde mis productos").located(theElementBy(OPT_MIS_PRODUCTOS_LOCATOR));
    public static final Target TXT_FECHA_INICIO_FIN = Target.the("Seleccionar fecha inicio y fecha fin").located(theElementBy(TXT_FECHA_INICIO_FIN_LOCATOR));
    public static final Target BTN_PROGRAMAR= Target.the("Botón programar").located(theElementBy(BTN_PROGRAMAR_LOCATOR));
    public static final Target OPT_CUENTA_PRODUCTO = Target.the("Seleccionar la cuenta a programar").locatedBy(dynamicElement(OPT_CUENTA_PRODUCTO_FACTURA_LOCATOR));
    public static final Target CHK_FECHA_VENCIMIENTO = Target.the("Seleccionar la opción de fecha vencimiento").locatedBy(dynamicElement(CHK_TIPO_CORREO_LOCATOR));
    public static final Target CHK_RANGO_FECHAS = Target.the("Seleccionar la opción de fecha vencimiento").located(theElementBy(CHK_RANGO_LOCATOR));
    public static final Target LST_INTENTOS_PAGO = Target.the("Seleccionar el número de intentos de pago").locatedBy(dynamicElement(LST_INTENTOS_PAGO_LOCATOR));
    public static final Target LST_INTENTOS_PAGO_PROGRAMAR = Target.the("Seleccionar el número de intentos para programar factura").locatedBy(dynamicElement(LST_INTENTOS_PAGO_PROGRAMAR_LOCATOR));
    public static final Target CHK_ACEPTO_TERMINOS = Target.the("Click en el check Acepto terminos y condiciones").located(theElementBy(CHK_ACEPTO_TERMINOS_PROGRAMAR_LOCATOR));
    public static final Target LST_RANGO_FECHA = Target.the("Seleccionar rago de fecha inicio y fecha fin").locatedBy(dynamicElement(LST_RANGO_FECHA_LOCATOR));
    public static final Target BTN_FLECHA_MES_SIGUIENTE = Target.the("flecha para seleeccionar mes próximo").located(theElementBy(LST_FLECHA_MES_SIGUIENTE_LOCATOR));
    public static final Target LBL_MES = Target.the("Label para visualizar mes").locatedBy(dynamicElement(LBL_MES_LOCATOR));
    public static final Target LBL_VALOR_MES = Target.the("Label para visualizar número del mes").locatedBy(dynamicElement(LBL_VALOR_MES_LOCATOR));
    public static final Target LST_NUMERO_INTENTOS = Target.the("Clic para seleccionar numero de intentos").located(theElementBy(LST_NUMERO_INTENTOS_LOCATOR));
    public static final Target LST_NUMERO_INTENTOS_PROGRAMAR = Target.the("Clic para seleccionar numero de intentos en programacion de factura").located(theElementBy(LST_NUMERO_INTENTOS_PROGRAMAR_LOCATOR));
    public static final Target BTN_CERRAR_NUMERO_INTENTOS = Target.the("Clic para cerrar numero de intentos").located(theElementBy(BTN_CERRAR_NUMERO_INTENTOS_LOCATOR));
    public static final Target BTN_SELECCIONAR= Target.the("Clic para seleccionar numero de intentos").located(theElementBy(BTN_SELECCIONAR_LOCATOR));
    public static final Target OPT_MODIFICAR_PROGRAMACION= Target.the("Clic para seleccionar la opción modificar programación").located(theElementBy(OPT_MODIFICAR_PROGRAMACION_LOCATOR));
    public static final Target OPT_ELIMINAR_FACTURA= Target.the("Clic para seleccionar la opción eliminar factura").located(theElementBy(OPT_ELIMINAR_FACTURA_LOCATOR));
    public static final Target OPT_VER_DETALLE_FACTURA= Target.the("Clic para seleccionar la opción ver detalle factura").located(theElementBy(OPT_VER_DETALLE_LOCATOR));
    public static final Target OPT_VER_HISTORICO_FACTURA= Target.the("Clic para seleccionar la opción historico factura").located(theElementBy(OPT_HISTORICO_LOCATOR));
    public static final Target LNK_CAMBIAR_PRODUCTO= Target.the("link para cambiar").located(theElementBy(LNK_CAMBIAR_PRODUCTO_LOCATOR));
    public static final Target LNK_CAMBIAR_PERIODICIDAD= Target.the("link para cambiar periodicidad").located(theElementBy(LNK_CAMBIAR_PERIODICIDAD_LOCATOR));
    public static final Target LNK_SIGUIENTE= Target.the("link para siguiente").located(theElementBy(LNK_SIGUIENTE_LOCATOR));
    public static final Target OPT_PAGAR_FACTURA= Target.the("Selecciona la opcion pagar factura").located(theElementBy(OPT_PAGAR_FACTURA_LOCATOR));
    public static final Target FOCO = Target.the("Clic en el foco").located(theElementBy(FOCO_LOCATOR));
    public static final Target BTN_MODIFICAR = Target.the("Clic en botón modificar").located(theElementBy(BTN_MODIFICAR_LOCATOR));
    public static final Target BTN_CONFIRMAR_ELIMINACION = Target.the("Clic en botón para confirmar la eliminación").located(theElementBy(BTN_CONFIRMAR_ELIMINACION_LOCATOR));
    public static final Target LBL_MENSAJE_MODIFICACION = Target.the("Mensaje modificación exitosa").located(theElementBy(LBL_MENSAJE_MODIFICACION_LOCATOR));
    public static final Target LBL_ELIMINACION_EXITOSA = Target.the("Mensaje eliminación exitosa").located(theElementBy(LBL_ELIMINACION_EXITOSA_LOCATOR));
    public static final Target LBL_COMPROBANTE_EXITOSA = Target.the("Comprobante eliminación ").located(theElementBy(LBL_COMPROBANTE_ELIMINACION_EXITOSA_LOCATOR));
    public static final Target LBL_ESTADO_HISTORICO_PAGO = Target.the("Label de verifica el estado del historico de pago").locatedBy(dynamicElement(LBL_ESTADO_HISTORICO_PAGO_LOCATOR));
    public static final Target LBL_FECHA_HISTORICO_PAGO = Target.the("Label de verifica la fecha del historico de pago").locatedBy(dynamicElement(LBL_FECHA_HISTORICO_PAGO_LOCATOR));
    public static final Target LBL_REFERENCIA_HISTORICO_PAGO = Target.the("Label de verifica la referencia del historico de pago").locatedBy(dynamicElement(LBL_REFERENCIA_HISTORICO_PAGO_LOCATOR));
    public static final Target LBL_VALOR_HISTORICO_PAGO = Target.the("Label de verifica el valor del historico de pago").locatedBy(dynamicElement(LBL_VALOR_HISTORICO_PAGO_LOCATOR));
    public static final Target LBL_CONTENEDOR_HISTORICO_PAGO = Target.the("Contenedor detalle historico de pago").locatedBy(dynamicElement(LBL_CONTENEDOR_HISTORICO_PAGO_LOCATOR));
    public static final Target OPT_PROGRAMADAS = Target.the("Opcion programadas").located(theElementBy(OPT_PROGRAMADAS_LOCATOR));
    public static final Target CHK_SELECCIONAR_TODAS_FACTURAS = Target.the("Pagar todas las facturas").located(theElementBy(CHK_ACEPTO_TERMINOS_PROGRAMAR_LOCATOR));
    public static final Target CHk_SELECCIONAR_FACTURA = Target.the("Selecciona facturas a pagar").locatedBy(dynamicElement(CHK_SELECCIONAR_FACTURA_LOCATOR));
    public static final Target LBL_PAGO_EXITOSO_FACTURA = Target.the("Pago de una factura sin mas facturas inscrita exito").located(theElementBy(LBL_PAGO_EXITOSO_FACTURA_LOCATOR));
    public static final Target LBL_NUEVO_SALDO_DISPONIBLE = Target.the("Label nuevo saldo disponible").located(theElementBy(LBL_NUEVO_SALDO_DISPONIBLE_LOCATOR));
    public static final Target LBL_VALOR_PAGADO = Target.the("Campo de texto valor pagado").locatedBy(dynamicElement(LBL_VALOR_PAGAR_LOCATOR));
    public static final Target LBL_PRODUCTO_PAGO = Target.the("Campo de producto debitado").locatedBy(dynamicElement(LBL_PRODUCTO_PAGO_LOCATOR));
    public static final Target TXT_VALOR = Target.the("Campo ingresar valor a pagar").located(theElementBy(TXT_VALOR_LOCATOR));
    public static final Target OPT_MODIFICAR_DESCRIPCION = Target.the("Selecciona la opcion modificar descrpcion").located(theElementBy(OPT_MODIFICAR_DESCRIPCION_LOCATOR));
    public static final Target TXT_DESCRIPCION_FACTURA = Target.the("Campo de texto para ingresar descrpcion").located(theElementBy(TXT_DESCRIPCION_LOCATOR));
    public static final Target TXT_FOCO_MODIFICAR_DESCRIPCION = Target.the("Foco modificar descripción").located(theElementBy(TXT_FOCO_MODIFICAR_DESCRIPCION_LOCATOR));
    public static final Target LBL_VERIFICACION_MODIFICACION_INSCRITA = Target.the("Label verificacion descrpción exitosa").locatedBy(dynamicElement(LBL_VERIFICACION_MODIFICACION_INSCRITA_LOCATOR));
    public static final Target TXT_MENSAJE_PROGRAMACION_EXITOSA = Target.the("Mensaje de programación exitosa").located(theElementBy(TXT_MENSAJE_PROGRAMACION_EXITOSA_LOCATOR));
    public static final Target TXT_MENSAJE_PAGO_EXITOSO = Target.the("Mensaje de pago exitoso").located(theElementBy(TXT_MENSAJE_PAGO_EXITOSO_LOCATOR));
    public static final Target TXT_PAGO_REDEBAN_EXITOSO = Target.the("Mensaje de pago redeban exitoso").located(theElementBy(TXT_PAGO_REDEBAN_EXITOSO_LOCATOR));

    private ProgramarPagarFacturasPage(){
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}
package co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.consultas.detalleproductos.DetalleProductosLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class DetalleProductosPage {
    public static final Target LBL_SALDO_DISPONIBLE_DETALLE = Target.the("Saldo disponible producto").located(theElementBy(LBL_SALDO_DISPONIBLE_DETALLE_LOCATOR));
    public static final Target LBL_SALDO_CANJE_DETALLE = Target.the("Saldo canje cuenta producto").located(theElementBy(LBL_SALDO_CANJE_DETALLE_LOCATOR));
    public static final Target LBL_SALDO_TOTAL_DETALLE = Target.the("Saldo total cuenta producto").located(theElementBy(LBL_SALDO_TOTAL_DETALLE_LOCATOR));
    public static final Target LBL_FECHA_PROXIMO_PAGO = Target.the("Verificacion de fecha proxima pago").located(theElementBy(LBL_FECHA_PROXIMO_PAGO_LOCATOR));
    public static final Target LBL_DEUDA_FECHA_PESOS = Target.the("Verificacion deuda fecha pesos").located(theElementBy(LBL_DEUDA_FECHA_PESOS_LOCATOR));
    public static final Target LBL_DEUDA_FECHA_DOLAR = Target.the("Verificacion deuda fecha dolar").located(theElementBy(LBL_DEUDA_FECHA_DOLAR_LOCATOR));
    public static final Target LBL_DISPONIBLE_AVACE_PESOS= Target.the("Verificacion deuda fecha dolar").located(theElementBy(LBL_DISPONIBLE_AVACE_PESOS_LOCATOR));
    public static final Target LBL_CAPITAL_VIGENTE= Target.the("Capital Vigente Credito").located(theElementBy(LBL_CAPITAL_VIGENTE_LOCATOR));
    public static final Target LBL_INTERES_CORRIENTES= Target.the("Intereses Corrientes").located(theElementBy(LBL_INTERES_CORRIENTES_LOCATOR));
    public static final Target LBL_SALDO_MORA = Target.the("Saldo Mora en Creditos").located(theElementBy(LBL_SALDO_MORA_LOCATOR));
    public static final Target LBL_INTERES_MORA= Target.the("Interes de Mora Creditos").located(theElementBy(LBL_INTERES_MORA_LOCATOR));
    public static final Target LBL_OTROS_CARGOS= Target.the("Otros cargos creditos").located(theElementBy(LBL_OTROS_CARGOS_LOCATOR));
    public static final Target LBL_FECHA_DESEMBOLSO= Target.the("fecha desembolso credito").located(theElementBy(LBL_FECHA_DESEMBOLSO_LOCATOR));
    public static final Target LBL_VALOR_DESEMBOLSO = Target.the("valor desembolso credito").located(theElementBy(LBL_VALOR_DESEMBOLSO_LOCATOR));
    public static final Target LBL_DEUDA_FECHA_CREDITO = Target.the("Deuda a la fecha del Credito").located(theElementBy(LBL_DEUDA_FECHA_CREDITO_LOCATOR));
    public static final Target LBL_CUPO_ASIGNADO = Target.the("Cupo asignado").located(theElementBy(LBL_CUPO_ASIGNADO_LOCATOR));
    public static final Target LBL_CUPO_UTILIZADO = Target.the("Cupo utilizado").located(theElementBy(LBL_CUPO_UTILIZADO_LOCATOR));
    public static final Target LBL_CUPO_EN_CANJE = Target.the("Cupo en canje").located(theElementBy(LBL_CUPO_EN_CANJE_LOCATOR));
    public static final Target LBL_DISPONIBLE_SOBRECUPO = Target.the("Disponible en sobrecupo").located(theElementBy(LBL_DISPONIBLE_SOBRECUPO_LOCATOR));
    public static final Target LBL_MAXIMO_DESEMBOLSAR = Target.the("Valor máximo a desembolsar").located(theElementBy(LBL_MAXIMO_DESEMBOLSAR_LOCATOR));
    public static final Target LBL_MINIMO_DESEMBOLSAR = Target.the("Valor mínimo a desembolsar").located(theElementBy(LBL_MINIMO_DESEMBOLSAR_LOCATOR));
    public static final Target LBL_CUPO_DISPONIBLE = Target.the("Cupo disponible").located(theElementBy(LBL_CUPO_DISPONIBLE_LOCATOR));
    public static final Target LBL_SALDO_DISPONIBLE_E_PREPAGO = Target.the("Saldo disponible eprepago").located(theElementBy(LBL_SALDO_DISPONIBLE_E_PREPAGO_LOCATOR));
    public static final Target LBL_FECHA_VENCIMIENTO = Target.the("Fecha de vencimiento").located(theElementBy(LBL_FECHA_VENCIMIENTO_LOCATOR));
    public static final Target LBL_CVC = Target.the("Código de seguridad").located(theElementBy(LBL_CVC_LOCATOR));
    public static final Target LBL_NUMERO_TARJETA = Target.the("Número de tarjeta").located(theElementBy(LBL_NUMERO_TARJETA_LOCATOR));

    private DetalleProductosPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}

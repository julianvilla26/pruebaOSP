package co.com.bancolombia.certificacion.app.userinterface.locators.consultas.detalleproductos;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class DetalleProductosLocator {
    public static final Locator LBL_SALDO_DISPONIBLE_DETALLE_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Saldo disponible']/../following-sibling::div/div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Saldo disponible']/../../following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_CANJE_DETALLE_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Saldo en canje']/../../following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Saldo en canje']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_TOTAL_DETALLE_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Saldo total']/../../following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Saldo total']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_FECHA_PROXIMO_PAGO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Fecha próximo pago']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Fecha próximo pago']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_DEUDA_FECHA_PESOS_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Deuda a la fecha en pesos']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Deuda a la fecha en pesos']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
public static final Locator LBL_DEUDA_FECHA_DOLAR_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Deuda a la fecha en dólares']/../following-sibling::div")
        .withIos("xpath$//XCUIElementTypeStaticText[@name='Deuda a la fecha en dólares']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
public static final Locator LBL_DISPONIBLE_AVACE_PESOS_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Disponible para avances en pesos']/../following-sibling::div")
        .withIos("xpath$//XCUIElementTypeStaticText[@name='Disponible para avances en pesos']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_CAPITAL_VIGENTE_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Capital Vigente']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Capital Vigente']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_INTERES_CORRIENTES_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Intereses corrientes']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Intereses corrientes']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_MORA_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Saldo en mora']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Saldo en mora']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_INTERES_MORA_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Saldo en mora']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Intereses de mora']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_OTROS_CARGOS_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Otros cargos']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Otros cargos']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_FECHA_DESEMBOLSO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Fecha de desembolso']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Fecha de desembolso']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_VALOR_DESEMBOLSO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Valor desembolsado']/../following-sibling::div")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Valor desembolsado']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_DEUDA_FECHA_CREDITO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Deuda a la fecha']/../following-sibling::div/div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Deuda a la fecha']/../../following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    public static final Locator LBL_CUPO_ASIGNADO_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Cupo asignado']]/following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Cupo asignado']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_CUPO_UTILIZADO_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Cupo utilizado']]/following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Cupo utilizado']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_CUPO_EN_CANJE_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Cupo en canje']]/following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Cupo en canje']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_DISPONIBLE_SOBRECUPO_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Disponible con sobrecupo']]/following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Disponible con sobrecupo']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_MAXIMO_DESEMBOLSAR_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Valor máximo a desembolsar']]/following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Valor máximo a desembolsar']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_MINIMO_DESEMBOLSAR_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Valor mínimo a desembolsar']]/following-sibling::div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Valor mínimo a desembolsar']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_CUPO_DISPONIBLE_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[text()='Cupo disponible']]/following-sibling::div/div/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Cupo disponible']/../../following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_DISPONIBLE_E_PREPAGO_LOCATOR = locator()
            .withAndroid("xpath$//label[./span[text()='Saldo disponible']]/following-sibling::div[1]/div/div[1]/span")
            .withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Saldo disponible']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_FECHA_VENCIMIENTO_LOCATOR = locator()
            .withAndroid("xpath$//span[contains(text(),'Fecha de vencimiento')]/../following-sibling::span")
            .withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Fecha de vencimiento']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_CVC_LOCATOR = locator()
            .withAndroid("xpath$//span[contains(text(),'Código de seguridad')]/../following-sibling::span")
            .withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[contains(@name,'Código de seguridad')]]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_NUMERO_TARJETA_LOCATOR = locator()
            .withAndroid("xpath$//div[./span[contains(text(),'Tarjeta')]]/following-sibling::div[1]/span")
            .withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[contains(@name,'Tarjeta')]]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");

    private DetalleProductosLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
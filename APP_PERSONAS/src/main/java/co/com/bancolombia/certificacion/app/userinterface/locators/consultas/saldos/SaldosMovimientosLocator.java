package co.com.bancolombia.certificacion.app.userinterface.locators.consultas.saldos;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class SaldosMovimientosLocator {
    public static final Locator OPT_CUENTA_PRODUCTO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='{0}']/../..//following-sibling::div//span[contains(text(),'{1}')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'{0}')]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[@name='{1}']");
    public static final Locator OPT_CUENTA_TAJETA_CREDITO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='{0}']/../../following-sibling::div//span[text()='{1}']").withIos("xpath$(//XCUIElementTypeStaticText[@name='{0}'])[1]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[@name='{1}']");
    public static final Locator OPT_CUENTA_EPREPAGO_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='{0}']/../../following-sibling::div//span[text()='{1}']")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[@name='{1}']");
    public static final Locator OPCION_SELECCIONAR_CATEGORIA_PRODUCTOS_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='{0}']")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator LBL_SIN_MOVIMIENTOS_LOCATOR = locator()
            .withAndroid("xpath$//span[contains(text(),'{0}')]")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator BTN_DETALLE_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//div[@id='Tabs']//span[text()='Detalle del producto']").withIos("xpath$//XCUIElementTypeStaticText[@name='Detalle del producto']");
    public static final Locator BTN_MOVIMIENTO_LOCATOR = locator().withAndroid("xpath$//div[@id='Tabs']//span[text()='Movimientos']").withIos("xpath$(//XCUIElementTypeStaticText[@name='Movimientos'])[1]");
    public static final Locator BTN_OCULTAR_BANNER_LOCATOR = locator().withAndroid("xpath$//android.view.View[@resource-id='b5-b1-Content']/android.view.View[2]/android.view.View").withIos("xpath$n");
    public static final Locator CONTENEDOR_INFORMACION_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//div[@id='l1-{0}-Screen_Account_Line']").withIos("xpath$(//XCUIElementTypeStaticText[@name='Cuenta'])[{0}]");
    public static final Locator LBL_TIPO_CUENTA_SALDOS_MOVIMIENTOS_LOCATOR = locator()
            .withAndroid("xpath$//div[@id='l1-{0}-AccountContentContainer']//div[1]//i/following-sibling::span")
            .withIos("xpath$(//XCUIElementTypeStaticText[@name='Cuenta'])[{0}]//../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_NUMERO_CUENTA_SALDOS_MOVIMIENTOS_LOCATOR = locator()
            .withAndroid("xpath$//div[@id='l1-{0}-AccountContentContainer']//div[2]//div[1]//span")
            .withIos("xpath$(//XCUIElementTypeStaticText[@name='Cuenta'])[{0}]//../following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_DISPONIBLE_SALDOS_MOVIMIENTOS_LOCATOR = locator()
            .withAndroid("xpath$//div[@id='l1-0-AccountContentContainer']//div[3]//span")
            .withIos("xpath$(//XCUIElementTypeStaticText[@name='Cuenta'])[{0}]//../following-sibling::XCUIElementTypeOther[3]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDOS_MOVIMIENTOS_LOCATOR = locator()
            .withAndroid("xpath$//*[contains(text(),'{0}')]/ancestor::div[@class='cardlist-item']//*[contains(text(),'{1}')]/ancestor::div[@class='cardlist-item']//div[@class='text-right']")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../following-sibling::XCUIElementTypeOther[1][.//XCUIElementTypeStaticText[@name='{1}']]/following-sibling:: XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_CUENTAS_LOCATOR = locator()
            .withAndroid("xpath$//*[contains(text(),'{0}')]/ancestor::div[@class='cardlist-item']//*[contains(text(),'{1}')]/ancestor::div[@class='cardlist-item']//div[@class='text-right']")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../following-sibling::XCUIElementTypeOther[1][.//XCUIElementTypeStaticText[@name='{1}']]/following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_CREDIAGIL_MOVIMIENTOS_LOCATOR = locator()
            .withAndroid("xpath$//span[text()='Crediágil']/../../following-sibling::div/div/div/div[3]/span")
            .withIos("xpath$//XCUIElementTypeStaticText[@name='Crediágil']/../following-sibling::XCUIElementTypeOther[3]/XCUIElementTypeStaticText");
    public static final Locator VER_MOVIMIENTOS_LOCATOR = locator().withAndroid("xpath$//div[@id='l1-{0}-ContentAccountElement']").withIos("xpath$(((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeImage/../following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]/../../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]");
    public static final Locator VER_MOVIMIENTOS_TARJETA_CREDITO_LOCATOR = locator().withAndroid("xpath$(//div[@class='datalist-col-2'])[{0}]").withIos("xpath$h(((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage)[2]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]");
    public static final Locator VER_MOVIMIENTOS_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//div[@id='l3-{0}-$b30']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Movimientos']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[7][./XCUIElementTypeImage]/following-sibling::XCUIElementTypeOther[{0}]/XCUIElementTypeStaticText");
    public static final Locator LBL_FECHA_MOVIMIENTO_CUENTAS_LOCATOR = locator().withAndroid("xpath$//div[@id='l1-{0}-ContentAccountElement']//div[@class='datalist-date']/span[1]").withIos("xpath$(((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeImage/../following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]/../..//XCUIElementTypeStaticText)[1]");
    public static final Locator LBL_DESCRIPCION_MOVIMIENTO_CUENTAS_LOCATOR = locator().withAndroid("xpath$//div[@id='l1-{0}-ContentAccountElement']//div//div[2]/span[1]").withIos("xpath$(((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeImage/../following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]/../../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]");
    public static final Locator LBL_SALDO_CUENTASLOCATOR = locator().withAndroid("xpath$//div[@id='l1-{0}-ContentAccountElement']//div[@class='datalist-date']/span[1]").withIos("xpath$((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeImage/../following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]");
    public static final Locator LBL_FECHA_MOVIMIENTO_TARJETA_CREDITO_LOCATOR = locator().withAndroid("xpath$(//div[@class='datalist-col-2'])[{0}]//div[@class='datalist-date']/span[1]").withIos("xpath$((((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage)[2]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]/../..//XCUIElementTypeStaticText)[1]");
    public static final Locator LBL_FECHA_MOVIMIENTO_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//div[@id='l3-{0}-$b30']/div/div/div/span[2]/preceding-sibling::span").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Movimientos']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[7][./XCUIElementTypeImage]/following-sibling::XCUIElementTypeOther[{0}]/XCUIElementTypeStaticText");
    public static final Locator LBL_DESCRIPCION_MOVIMIENTO_TARJETA_CREDITO_LOCATOR = locator().withAndroid("xpath$(//div[@class='datalist-col-2'])[{0}]//div[2]//span").withIos("xpath$((((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage)[2]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]/../../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]");
    public static final Locator LBL_DESCRIPCION_MOVIMIENTO_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//div[@id='l3-{0}-$b30']/div/div/div[2]/span").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Movimientos']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[7][./XCUIElementTypeImage]/following-sibling::XCUIElementTypeOther[{0}]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    public static final Locator LBL_SALDO_MOVIMIENTO_TARJETA_CREDITO_LOCATOR = locator().withAndroid("xpath$(//div[@class='datalist-col-2'])[{0}]//div[@class='datalist-date']/span[2]").withIos("xpath$(((//XCUIElementTypeStaticText[@name='Movimientos'])[1]/../following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage)[2]/../following-sibling::XCUIElementTypeOther//XCUIElementTypeOther/XCUIElementTypeStaticText)[{0}]");
    public static final Locator LBL_SALDO_MOVIMIENTO_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//div[@id='l3-{0}-$b30']/div/div/div/span[2]").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Movimientos']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[7][./XCUIElementTypeImage]/following-sibling::XCUIElementTypeOther[{0}]/XCUIElementTypeOther/XCUIElementTypeStaticText");

    private SaldosMovimientosLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
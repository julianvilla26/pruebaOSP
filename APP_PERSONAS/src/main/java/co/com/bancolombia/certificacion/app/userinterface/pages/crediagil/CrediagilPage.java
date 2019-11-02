package co.com.bancolombia.certificacion.app.userinterface.pages.crediagil;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.crediagil.CrediagilLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class CrediagilPage {
    public static final Target TXT_VALOR_DESEMBOLSAR = Target.the("Valor a desembolsar").located(theElementBy(TXT_VALOR_DESEMBOLSAR_LOCATOR));
    public static final Target FOCO = Target.the("Foco crediágil").located(theElementBy(FOCO_LOCATOR));
    public static final Target BTN_DESEMBOLSAR = Target.the("Botón desembolsar").located(theElementBy(BTN_DESEMBOLSAR_LOCATOR));
    public static final Target TXT_PRODUCTO_DESTINO = Target.the("Texto producto destino").located(theElementBy(TXT_PRODUCTO_DESTINO_LOCATOR));
    public static final Target TXT_VALOR_DESEMBOLSADOR = Target.the("Texto valor desembolsar").located(theElementBy(TXT_VALOR_DESEMBOLSADOR_LOCATOR));
    public static final Target TXT_DESEMBOLSO_EXITOSO = Target.the("Mensaje desembolso exitoso").located(theElementBy(TXT_DESEMBOLSO_EXITOSO_LOCATOR));
    public static final Target TXT_FUERA_RANGO = Target.the("Mensaje desembolso fuera de rango").located(theElementBy(TXT_FUERA_RANGO_LOCATOR));

    private CrediagilPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}

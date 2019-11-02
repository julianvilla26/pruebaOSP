package co.com.bancolombia.certificacion.app.questions.fabrica;

import co.com.bancolombia.certificacion.app.questions.basededatos.finacle.VerificoLaAperturaEnFinacle;
import net.serenitybdd.screenplay.Question;

public class FabricaBaseDeDatosFinacle {

    private FabricaBaseDeDatosFinacle() {
    }

    public static Question<Boolean> verificarLaAperturaDeInversionVirtualEnFinacle() {
        return new VerificoLaAperturaEnFinacle();
    }

}

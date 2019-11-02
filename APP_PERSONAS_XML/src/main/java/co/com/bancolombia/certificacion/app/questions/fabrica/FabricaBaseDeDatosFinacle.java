package co.com.bancolombia.certificacion.app.questions.fabrica;

import co.com.bancolombia.certificacion.app.questions.basededatos.finacle.VerificoLaAperturaEnFinacle;
import net.serenitybdd.screenplay.Question;

/**
 * The type Data base fabrica.
 */
public class FabricaBaseDeDatosFinacle {

    private FabricaBaseDeDatosFinacle() {
    }

    /**
     * Verify channel log question.
     *
     * @return the question
     */
    public static Question<Boolean> verificarLaAperturaDeInversionVirtualEnFinacle() {
        return new VerificoLaAperturaEnFinacle();
    }

}

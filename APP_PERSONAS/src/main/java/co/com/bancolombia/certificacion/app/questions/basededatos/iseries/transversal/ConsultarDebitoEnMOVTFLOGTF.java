package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.transversal;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.transversal.Transversales;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsultarDebitoEnMOVTFLOGTF implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarDebitoEnMOVTFLOGTF.class.getName());

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado = false;
        String registro = Transversales.verificarElDebitoEnMOVTFLOGTF(actor);
        if (registro != ""){
            resultado = true;
        }else {
            LOGGER.info("Sin registros en la consulta");
        }
        return resultado;
    }
}

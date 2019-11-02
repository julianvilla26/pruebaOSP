package co.com.bancolombia.certificacion.app.questions.basededatos.finacle;


import co.com.bancolombia.certificacion.app.integration.FachadaFinacle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * The type Channel log in data base.
 */
public class VerificoLaAperturaEnFinacle implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(VerificoLaAperturaEnFinacle.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultFinal = false;
        List<Map<String, Object>> registro;
        registro = FachadaFinacle.consultTitleClientFinacle();
        if (registro !=  null){
            resultFinal = true;
        }else{
            LOGGER.info("Sin registros en la consulta");
        }
        return resultFinal;
    }
}

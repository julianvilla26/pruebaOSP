package co.com.bancolombia.certificacion.app.questions.basededatos.iseries;

import co.com.bancolombia.certificacion.app.integration.FachadaIseries;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsultarDebitoEnSCIFFSALDO implements Question {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarDebitoEnSCIFFSALDO.class.getName());

    @Override
    public Object answeredBy(Actor actor) {
        boolean resultado = false;
        resultado = FachadaIseries.verificarElDebitoDeLaCuenta();
        if (resultado){
            resultado = true;
        }else {
            LOGGER.info("Sin registros en la consulta");
        }
        return resultado;
    }
}
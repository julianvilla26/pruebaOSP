package co.com.bancolombia.certificacion.app.questions.basededatos.iseries;

import co.com.bancolombia.certificacion.app.integration.FachadaIseries;
import co.com.bancolombia.certificacion.app.integration.FachadaMovimientos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class ConsultarRegistroEnCABFFPPAUT implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(FachadaIseries.class.getName());



    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result = false;
        try {
            result = FachadaMovimientos.verifyTheMovementsEprepago();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }
}

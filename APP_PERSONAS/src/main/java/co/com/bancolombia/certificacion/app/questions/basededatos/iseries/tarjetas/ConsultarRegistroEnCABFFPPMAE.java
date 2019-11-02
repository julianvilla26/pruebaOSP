package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.tarjetas;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.tarjetas.Eprepago;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class ConsultarRegistroEnCABFFPPMAE implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result = false;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        if(AdministradorConstante.CODIGO_TRN_ACTIVATION_EPREPAGO.equals(datosPrincipales.getCodigoTransaccion())){
            result = Eprepago.verificoEstadoDeLaActivacionDeLaEprepago(actor);
        }
        if(AdministradorConstante.CODIGO_TRN_INACTIVATION_EPREPAGO.equals(datosPrincipales.getCodigoTransaccion())){
            result = Eprepago.verificoEstadoDeLaInactivacionDeLaEprepago(actor);
        }
        return result;
    }
}

package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.transversal;

import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.enumeradores.ArchivosComunesIseries;
import co.com.bancolombia.certificacion.app.utilidades.enumeradores.ArchivosLogCanalIseries;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager.getFileName;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class VerificarLosArchivosDeIseries implements Question<Boolean> {

    private static final String LOGCANAL = "COMFFLGWWW";
    private final List<String> archivosIseries;

    public VerificarLosArchivosDeIseries(List<String> files) {
        this.archivosIseries = files;
    }


    public static VerificarLosArchivosDeIseries enApp(List<String> files) {
        return new VerificarLosArchivosDeIseries(files);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ConfiguracionTransaccion transaccion = actor.recall(MODELO_DATOS_TRANSACCION);
        boolean resultadoVerificacion = false;

        for (String file : archivosIseries) {
            String dato = getFileName(file);
            String codTrn = transaccion.getCodigoTransaccion();

            if (LOGCANAL.equals(dato)) {
                ArchivosLogCanalIseries laVerificacion = ArchivosLogCanalIseries.getSearchFile(dato + codTrn);
                theActorInTheSpotlight().should(seeThat(laVerificacion.delArchivo(), is(true)).orComplainWith(laVerificacion.getException(), laVerificacion.getMessage()));
                resultadoVerificacion = true;
            } else {
                ArchivosComunesIseries theVerification = ArchivosComunesIseries.getSearchFile(dato);
                theActorInTheSpotlight().should(seeThat(theVerification.delArchivo(), is(true)).orComplainWith(theVerification.getException(), theVerification.getMessage()));
                resultadoVerificacion = true;

            }
        }
        return resultadoVerificacion;
    }
}

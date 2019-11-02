package co.com.bancolombia.certificacion.app.questions.fabrica.autenticacion;

import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.autenticacion.ConsultarExistenciaCliente;
import net.serenitybdd.screenplay.Question;


public class FabricaAutenticacion {

    private FabricaAutenticacion() {
    }

    public static Question<Boolean> elArchivoEnIseriesWWWFFUSRSV() {
        return new ConsultarExistenciaCliente();
    }

}

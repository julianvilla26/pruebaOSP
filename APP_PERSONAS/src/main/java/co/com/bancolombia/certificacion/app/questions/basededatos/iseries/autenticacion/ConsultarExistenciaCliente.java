package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.autenticacion;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.autenticacion.Autenticacion;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.ConstantesIseries;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class ConsultarExistenciaCliente implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarExistenciaCliente.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultFinal = false;
        List<Map<String, Object>> registros;
        registros = Autenticacion.consultaDeExistenciaDelCliente(actor);
        ConfiguracionTransaccion transaccion = actor.recall(MODELO_DATOS_TRANSACCION);

        if (!registros.isEmpty()) {
            Boolean resultadoDato = true;
            resultadoDato = validarCampo(ConstantesIseries.DOCUMENTO, registros.get(0).get("cnnoss").toString().trim(), StringManager.formatoDocumento(transaccion.getUsuario().getNumeroDocumento()), resultadoDato);
            resultadoDato = validarCampo(ConstantesIseries.TIPODOCUMENTO, registros.get(0).get("cncdti").toString().trim(), transaccion.getUsuario().getTipoDocumento(), resultadoDato);
            resultadoDato = validarCampo(ConstantesIseries.ESTADOUSUARIO, registros.get(0).get("estado").toString().trim(), "A", resultadoDato);

            if (resultadoDato) {
                resultFinal = true;
            }
            Serenity.recordReportData().withTitle("Verificacion Back Autenticacion").andContents(Serenity.sessionVariableCalled("log"));
        } else {
            LOGGER.info("Sin registros en la consulta");
        }
        return resultFinal;
    }


}

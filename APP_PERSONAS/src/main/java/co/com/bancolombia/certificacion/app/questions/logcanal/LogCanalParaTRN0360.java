package co.com.bancolombia.certificacion.app.questions.logcanal;

import co.com.bancolombia.backend.utilidades.managers.DateManager;
import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.logcanal.LogCanal;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.ConstantesIseries;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.clearReport;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class LogCanalParaTRN0360 implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(LogCanalParaTRN0360.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        clearReport();
        Boolean resultFinal = false;
        List<Map<String, Object>> registroTrn0360;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        registroTrn0360 = LogCanal.consultaLogCanalTrama220230(actor);

        if (registroTrn0360 !=  null){
            String trama0220Trn0360 = registroTrn0360.get(0).toString().replace("datos=","");
            String trama0230Trn0360 = registroTrn0360.get(1).toString().replace("datos=","");
            Boolean resultadoEntradaTrn0360 = true;
            Boolean resultadoSalidaTrn0360 = true;

            resultadoEntradaTrn0360 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220Trn0360.substring(5,20), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoEntradaTrn0360);
            resultadoEntradaTrn0360 = validarCampo(ConstantesIseries.TRACE + AdministradorConstante.TRAMAINPUT, trama0220Trn0360.substring(301,313), datosPrincipales.getTrace(),resultadoEntradaTrn0360);
            resultadoEntradaTrn0360 = validarCampo(ConstantesIseries.CODIGOTRN + AdministradorConstante.TRAMAINPUT, trama0220Trn0360.substring(313,317), datosPrincipales.getCodigoTransaccion(),resultadoEntradaTrn0360);
            resultadoEntradaTrn0360 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220Trn0360.substring(317,332), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoEntradaTrn0360);
            resultadoEntradaTrn0360 = validarCampo(ConstantesIseries.TIPODOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220Trn0360.substring(332,333), datosPrincipales.getUsuario().getTipoDocumento(),resultadoEntradaTrn0360);
            resultadoEntradaTrn0360 = validarCampo(ConstantesIseries.FECHA + AdministradorConstante.TRAMAINPUT, trama0220Trn0360.substring(359,367), DateManager.obtenerFechaSistema("YYYYMMdd"),resultadoEntradaTrn0360);


            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(5,20), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoSalidaTrn0360);
            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.CODIGOERROR + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(69,72), datosPrincipales.getCodigoError(),resultadoSalidaTrn0360);
            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.TRACE + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(301,313), datosPrincipales.getTrace(),resultadoSalidaTrn0360);
            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.CODIGOTRN + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(313,317), datosPrincipales.getCodigoTransaccion(),resultadoSalidaTrn0360);
            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(317,332), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoSalidaTrn0360);
            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.TIPODOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(332,333), datosPrincipales.getUsuario().getTipoDocumento(),resultadoSalidaTrn0360);
            resultadoSalidaTrn0360 = validarCampo(ConstantesIseries.FECHA + AdministradorConstante.TRAMAOUTPUT, trama0230Trn0360.substring(349,357), DateManager.obtenerFechaSistema("YYYYMMdd"),resultadoSalidaTrn0360);

            if (resultadoEntradaTrn0360 && resultadoSalidaTrn0360){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("Resultado del LogCanal Trn0360").
                    andContents(Serenity.sessionVariableCalled("informes_serenity"));
        }else{
            LOGGER.info("Sin registros: Transaccion 0360 Detalle depositos");
        }
        return resultFinal;
    }
}

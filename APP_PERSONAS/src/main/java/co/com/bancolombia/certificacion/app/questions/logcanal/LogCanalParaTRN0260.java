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

public class LogCanalParaTRN0260 implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(LogCanalParaTRN0360.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        clearReport();
        Boolean resultFinal = false;
        List<Map<String, Object>> trama;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        trama = LogCanal.consultaLogCanalTrama220230(actor);

        if (trama !=  null){
            String trama0220 = trama.get(0).toString().replace("datos=","");
            String trama0230 = trama.get(1).toString().replace("datos=","");
            Boolean resultadoEntrada = true;
            Boolean resultadoSalida = true;

            resultadoEntrada = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220.substring(5,20), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoEntrada);
            resultadoEntrada = validarCampo(ConstantesIseries.TRACE + AdministradorConstante.TRAMAINPUT, trama0220.substring(301,313), datosPrincipales.getTrace(),resultadoEntrada);
            resultadoEntrada = validarCampo(ConstantesIseries.CODIGOTRN + AdministradorConstante.TRAMAINPUT, trama0220.substring(313,317), datosPrincipales.getCodigoTransaccion(),resultadoEntrada);
            resultadoEntrada = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220.substring(317,332), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoEntrada);
            resultadoEntrada = validarCampo(ConstantesIseries.TIPODOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220.substring(332,333), datosPrincipales.getUsuario().getTipoDocumento(),resultadoEntrada);
            resultadoEntrada = validarCampo(ConstantesIseries.FECHA + AdministradorConstante.TRAMAINPUT, trama0220.substring(359,367), DateManager.obtenerFechaSistema("YYYYMMdd"),resultadoEntrada);


            resultadoSalida = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(5,20), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoSalida);
            resultadoSalida = validarCampo(ConstantesIseries.CODIGOERROR + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(69,72), datosPrincipales.getCodigoError(),resultadoSalida);
            resultadoSalida = validarCampo(ConstantesIseries.TRACE + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(301,313), datosPrincipales.getTrace(),resultadoSalida);
            resultadoSalida = validarCampo(ConstantesIseries.CODIGOTRN + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(313,317), datosPrincipales.getCodigoTransaccion(),resultadoSalida);
            resultadoSalida = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(317,332), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoSalida);
            resultadoSalida = validarCampo(ConstantesIseries.TIPODOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(332,333), datosPrincipales.getUsuario().getTipoDocumento(),resultadoSalida);
            resultadoSalida = validarCampo(ConstantesIseries.FECHA + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(349,357), DateManager.obtenerFechaSistema("YYYYMMdd"),resultadoSalida);

            if (resultadoEntrada && resultadoSalida){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("ResultLogCanal").
                    andContents(Serenity.sessionVariableCalled("INFORMES_SERENITY"));
        }else{
            LOGGER.info("Valores de la trama input y output sin registros");
        }
        return resultFinal;
    }
}

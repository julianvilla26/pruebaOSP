package co.com.bancolombia.certificacion.app.questions.basededatos.logcanal;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.backend.utilidades.managers.DateManager;
import co.com.bancolombia.certificacion.app.integration.FachadaIseries;
import co.com.bancolombia.certificacion.app.utilidades.constantes.LogCanalConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.logcanal.UtilidadLogCanal.validarCampo;

/**
 * The type Channel log in data base.
 */
public class LogCanalParaTRN0326 implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(LogCanalParaTRN0326.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultFinal = false;
        List<Map<String, Object>> trama;
        ConfiguracionTransaccion configuracionTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();
        Usuario usuario = CargarEntidadUsuario.getUsuario();
        trama = FachadaIseries.consultChannelLogPlot220230();

        if (trama !=  null){
            String trama0220 = trama.get(0).toString().replace("datos=","");
            String trama0230 = trama.get(1).toString().replace("datos=","");
            Boolean resultInput = true;
            Boolean resultOutput = true;

            /**
             * This is the Input plot.
             */
            resultInput = validarCampo(LogCanalConstante.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220.substring(5,20), StringManager.formatoDocumento(usuario.getNumeroDocumento()),resultInput);
            resultInput = validarCampo(LogCanalConstante.TRACE + AdministradorConstante.TRAMAINPUT, trama0220.substring(301,313), configuracionTransaccion.getTrace(),resultInput);
            resultInput = validarCampo(LogCanalConstante.CODIGOTRN + AdministradorConstante.TRAMAINPUT, trama0220.substring(313,317), configuracionTransaccion.getCodigoTransaccion(),resultInput);
            resultInput = validarCampo(LogCanalConstante.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220.substring(317,332), StringManager.formatoDocumento(usuario.getNumeroDocumento()),resultInput);
            resultInput = validarCampo(LogCanalConstante.TIPODOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220.substring(332,333), usuario.getTipoDocumento(),resultInput);
            resultInput = validarCampo(LogCanalConstante.FECHA + AdministradorConstante.TRAMAINPUT, trama0220.substring(359,367), DateManager.obtenerFechaSistema("YYYYMMdd"),resultInput);

            /**
             * This is the Output plot.
             */
            resultOutput = validarCampo(LogCanalConstante.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(5,20), StringManager.formatoDocumento(usuario.getNumeroDocumento()),resultOutput);
            resultOutput = validarCampo(LogCanalConstante.CODIGOERROR + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(69,72), configuracionTransaccion.getCodigoError(),resultOutput);
            resultOutput = validarCampo(LogCanalConstante.TRACE + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(301,313), configuracionTransaccion.getTrace(),resultOutput);
            resultOutput = validarCampo(LogCanalConstante.CODIGOTRN + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(313,317), configuracionTransaccion.getCodigoTransaccion(),resultOutput);
            resultOutput = validarCampo(LogCanalConstante.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(317,332), StringManager.formatoDocumento(usuario.getNumeroDocumento()),resultOutput);
            resultOutput = validarCampo(LogCanalConstante.TIPODOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(332,333), usuario.getTipoDocumento(),resultOutput);
            resultOutput = validarCampo(LogCanalConstante.FECHA + AdministradorConstante.TRAMAOUTPUT, trama0230.substring(359,367), DateManager.obtenerFechaSistema("YYYYMMdd"),resultOutput);

            if (resultInput && resultOutput){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("ResultLogCanal").andContents(Serenity.sessionVariableCalled("log"));
        }else{
            LOGGER.info("Valores de la trama input y output sin registros");
        }
        return resultFinal;
    }

}

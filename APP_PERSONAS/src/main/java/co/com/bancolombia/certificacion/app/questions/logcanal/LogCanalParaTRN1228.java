package co.com.bancolombia.certificacion.app.questions.logcanal;

import co.com.bancolombia.backend.utilidades.managers.DateManager;
import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.logcanal.LogCanal;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
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
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO_SALDOS_MOVIMIENTOS;

public class LogCanalParaTRN1228 implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(LogCanalParaTRN1228.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        clearReport();
        Boolean resultFinal = false;
        List<Map<String, Object>> registroTrn1228;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        List<Producto> listaProductosEprepago = actor.recall(MODELO_PRODUCTO_SALDOS_MOVIMIENTOS);
        registroTrn1228 = LogCanal.consultaLogCanalTrama220230(actor);

        if (registroTrn1228 !=  null){
            String trama0220Trn1756 = registroTrn1228.get(0).toString().replace("datos=","");
            String trama0230Trn1756 = registroTrn1228.get(1).toString().replace("datos=","");
            Boolean resultadoEntradaTrn1228 = true;
            Boolean resultadoSalidaTrn1228 = true;

            resultadoEntradaTrn1228 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220Trn1756.substring(5,20), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoEntradaTrn1228);
            resultadoEntradaTrn1228 = validarCampo(ConstantesIseries.TRACE + AdministradorConstante.TRAMAINPUT, trama0220Trn1756.substring(301,313), datosPrincipales.getTrace(),resultadoEntradaTrn1228);
            resultadoEntradaTrn1228 = validarCampo(ConstantesIseries.CODIGOTRN + AdministradorConstante.TRAMAINPUT, trama0220Trn1756.substring(313,317), datosPrincipales.getCodigoTransaccion(),resultadoEntradaTrn1228);
            resultadoEntradaTrn1228 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220Trn1756.substring(317,332), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoEntradaTrn1228);
            resultadoEntradaTrn1228 = validarCampo(ConstantesIseries.TIPODOCUMENTO + AdministradorConstante.TRAMAINPUT, trama0220Trn1756.substring(332,333), datosPrincipales.getUsuario().getTipoDocumento(),resultadoEntradaTrn1228);
            resultadoEntradaTrn1228 = validarCampo(ConstantesIseries.FECHA + AdministradorConstante.TRAMAINPUT, trama0220Trn1756.substring(359,367), DateManager.obtenerFechaSistema("YYYYMMdd"),resultadoEntradaTrn1228);

            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(5,20), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.CODIGOERROR + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(69,72), datosPrincipales.getCodigoError(),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.TRACE + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(301,313), datosPrincipales.getTrace(),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.CODIGOTRN + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(313,317), datosPrincipales.getCodigoTransaccion(),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.DOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(317,332), StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.TIPODOCUMENTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(332,333), datosPrincipales.getUsuario().getTipoDocumento(),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.FECHA + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(349,357), DateManager.obtenerFechaSistema("YYYYMMdd"),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.TIPOPRODUCTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(407,416), listaProductosEprepago.get(0).getTipo().replace("MasterCard","e-Prepago"),resultadoSalidaTrn1228);
            resultadoSalidaTrn1228 = validarCampo(ConstantesIseries.NUMEROPRODUCTO + AdministradorConstante.TRAMAOUTPUT, trama0230Trn1756.substring(439,443), listaProductosEprepago.get(0).getNumero().replace("*",""),resultadoSalidaTrn1228);

            if (resultadoEntradaTrn1228 && resultadoSalidaTrn1228){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("Resultado del LogCanal Trn1228").
                    andContents(Serenity.sessionVariableCalled("informes_serenity"));
        }else{
            LOGGER.info("Sin registros: Transaccion 1228 Saldos consolidados eprepago");
        }
        return resultFinal;
    }
}

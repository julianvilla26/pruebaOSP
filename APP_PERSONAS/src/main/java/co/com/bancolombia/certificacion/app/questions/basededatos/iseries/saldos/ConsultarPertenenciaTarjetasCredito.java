package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.saldos;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.tarjetas.Tarjetas;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;

import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.formatoTarjetaCredito;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO_SALDOS_MOVIMIENTOS;

public class ConsultarPertenenciaTarjetasCredito implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarPertenenciaTarjetasCredito.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultFinal = false;
        List<Map<String, Object>> registros;
        List<Producto> producto = actor.recall(MODELO_PRODUCTO_SALDOS_MOVIMIENTOS);
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        registros = Tarjetas.pertenenciaTarjetas(actor);

        if (registros.size() > 0){
            Boolean resultadoRegistro = false;
            Boolean resultadoDato = false;
            String numeroCuentaBanco;
            String documentoClienteBanco;
            String numeroCuentaApp;
            String documentoClienteApp;
            String franquiciaBanco;
            String franquiciaApp;


            for(int i = 0; i < registros.size(); i++){
                Map<String, Object> filaRegistro = registros.get(i);
                numeroCuentaBanco = StringManager.ultimosCaracteres(filaRegistro.get("numero_tarjeta").toString().trim(),4);
                documentoClienteBanco = StringManager.formatoDocumento(filaRegistro.get("documento").toString().trim());
                franquiciaBanco = filaRegistro.get("franquicia").toString().trim();

                for(int j = 0; j < producto.size(); j++){
                    numeroCuentaApp = producto.get(j).getNumero().trim().replace("*","");
                    documentoClienteApp = StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
                    franquiciaApp = formatoTarjetaCredito(numeroCuentaApp, producto.get(j).getTipo().trim());

                    if (numeroCuentaApp.equals(numeroCuentaBanco)){
                        resultadoRegistro = true;
                        resultadoDato = true;
                        resultadoRegistro = validarCampo("NUMERO DE TARJETA", numeroCuentaBanco, numeroCuentaApp, resultadoDato);
                        resultadoRegistro = validarCampo("NUMERO DOCUMENTO CLIENTE", documentoClienteBanco, documentoClienteApp, resultadoDato);
                        resultadoRegistro = validarCampo("FRANQUICIA DE TARJETA", franquiciaBanco, franquiciaApp, resultadoDato);

                    }
                }
            }

            if (resultadoDato && resultadoRegistro){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("Verificacion Back Consolidado Tarjetas").andContents(Serenity.sessionVariableCalled("informes_serenity"));
        }else{
            LOGGER.info("Sin registros en la consulta");
        }
        return resultFinal;
    }
}

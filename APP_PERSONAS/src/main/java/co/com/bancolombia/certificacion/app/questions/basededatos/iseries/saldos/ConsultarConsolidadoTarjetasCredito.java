package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.saldos;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.tarjetas.Tarjetas;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.cerosIzquierda;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.tipoTarjetaPrefijo;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO_SALDOS_MOVIMIENTOS;

public class ConsultarConsolidadoTarjetasCredito implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarConsolidadoTarjetasCredito.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultFinal = false;
        List<Map<String, Object>> registros;
        List<Producto> producto = actor.recall(MODELO_PRODUCTO_SALDOS_MOVIMIENTOS);
        registros = Tarjetas.saldoConsolidadoTarjetas(actor);

        if (registros.size() > 0){
            Boolean resultadoDato = true;
            Boolean resultadoRegistro = true;

            for(int i = 0; i < registros.size(); i++){
                Map<String, Object> filaRegistro = registros.get(i);
                String numeroCuentaBanco = filaRegistro.get("lgdatos").toString().substring(12,16).trim();
                String tipoCuentaBanco = filaRegistro.get("lgdatos").toString().substring(33,34).trim();
                String saldoBanco = filaRegistro.get("lgdatos").toString().substring(403,421).trim();

                for(int j = 0; j < producto.size(); j++){
                    String numeroCuentaApp = producto.get(j).getNumero().trim().replace("*","");
                    String tipoCuentaApp =  tipoTarjetaPrefijo(producto.get(j).getTipo().trim());
                    String saldoApp = cerosIzquierda(producto.get(j).getSaldo().getSaldoDisponible().replace("$", "").replace(" ","").replace(".", "").replace(",",""),17);

                    if (numeroCuentaApp.equals(numeroCuentaBanco)){
                        resultadoRegistro = validarCampo("NUMERO DE TARJETA", numeroCuentaBanco, numeroCuentaApp, resultadoDato);
                        resultadoRegistro = validarCampo("TIPO DE TARJETA", tipoCuentaBanco, tipoCuentaApp, resultadoDato);
            resultadoRegistro = validarCampo("CUPO DE TARJETA", saldoBanco, saldoApp, resultadoDato);
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

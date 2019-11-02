package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.tarjetas;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.tarjetas.Eprepago;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager.ultimosCaracteres;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.clearReport;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO_SALDOS_MOVIMIENTOS;

public class ConsultarEprepagoEnCABFFTARJ implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarEprepagoEnCABFFTARJ.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        clearReport();
        Boolean resultFinal = false;
        List<Map<String, Object>> registros;
        List<Producto> producto = actor.recall(MODELO_PRODUCTO_SALDOS_MOVIMIENTOS);
        registros = Eprepago.verificoExistenciaDeLaEprepago(actor);

        if (!registros.isEmpty()){
            Boolean resultadoDato = false;
            Boolean resultadoRegistro = false;

            for(int i = 0; i < registros.size(); i++){
                Map<String, Object> filaRegistro = registros.get(i);
                String numeroCuentaBanco = ultimosCaracteres(filaRegistro.get("pnropseu").toString().trim(),4);
                String saldoDisponibleBanco = filaRegistro.get("nrotadic").toString().trim();

                for(int j = 0; j < producto.size(); j++){
                    String numeroCuentaApp = ultimosCaracteres(producto.get(j).getNumero().trim(),4);
                    String saldoDisponibleApp = producto.get(j).getSaldo().getSaldoDisponible().replace("$","").replace(".","").replace(",",".").replace(".00","").trim();
                    if (numeroCuentaApp.equals(numeroCuentaBanco)){
                        int k = j + 1;
                        resultadoDato = true;
                        resultadoRegistro = true;
                        resultadoRegistro = validarCampo("CUENTA # " + k, numeroCuentaBanco, numeroCuentaApp, resultadoDato);
                        resultadoRegistro = validarCampo("SALDO DISPONIBLE # " + k, saldoDisponibleBanco, saldoDisponibleApp,resultadoDato);
                    }
                }
            }

            if (resultadoDato && resultadoRegistro){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("Verificacion Back Existencia ePrepago").andContents(Serenity.sessionVariableCalled("informes_serenity"));
        }else{
            LOGGER.info("Sin registros en la consulta");
        }
        return resultFinal;
    }

}


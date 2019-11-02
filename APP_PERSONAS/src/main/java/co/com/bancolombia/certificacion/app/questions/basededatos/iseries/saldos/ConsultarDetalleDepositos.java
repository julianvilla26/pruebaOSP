package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.saldos;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.depositos.Depositos;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.tipoCuentaLetra;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;

public class ConsultarDetalleDepositos implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarDetalleDepositos.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultFinal = false;
        List<Map<String, Object>> registros;
        Producto producto = actor.recall(MODELO_DETALLE_PRODUCTO);
        registros = Depositos.saldoDepositosDetalle(actor);
        DecimalFormat formato = new DecimalFormat("#.00");

        if (!registros.isEmpty()){
            Boolean resultadoDato = true;

            Double valorDisponible = Double.parseDouble(registros.get(0).get("sdsdodsp").toString().trim());
            Double valorCanje =  Double.parseDouble(registros.get(0).get("sdfltdsp").toString().trim());
            String totalBack = formato.format(valorDisponible + valorCanje).replace(",",".");

            String saldoDisponibleFront = producto.getSaldo().getSaldoDisponible().replace("$","").replace(".","").replace(",",".").trim();
            String saldoCanjeFront = producto.getSaldo().getSaldoEnCanje().replace("$","").replace(".","").replace(",",".").trim();
            String saldoTotalFront = producto.getSaldo().getSaldoTotal().replace("$","").replace(".","").replace(",",".").trim();

            resultadoDato = validarCampo("TIPO CUENTA", registros.get(0).get("sdtipocta").toString().trim(), tipoCuentaLetra(producto.getTipo()),resultadoDato);
            resultadoDato = validarCampo("CUENTA", registros.get(0).get("sdcuenta").toString().trim(), producto.getNumero().replace("-",""),resultadoDato);
            resultadoDato = validarCampo("SALDO DISPONIBLE", registros.get(0).get("sdsdodsp").toString().trim(), saldoDisponibleFront,resultadoDato);
            resultadoDato = validarCampo("SALDO EN CANJE", registros.get(0).get("sdfltdsp").toString().trim(), saldoCanjeFront,resultadoDato);
            resultadoDato = validarCampo("SALDO TOTAL", totalBack, saldoTotalFront,resultadoDato);

            if (resultadoDato){
                resultFinal=true;
            }
            Serenity.recordReportData().withTitle("Verificacion Back Detalle Depositos").andContents(Serenity.sessionVariableCalled("informes_serenity"));
        }else{
            LOGGER.info("Sin registros en la consulta");
        }
        return resultFinal;
    }


}

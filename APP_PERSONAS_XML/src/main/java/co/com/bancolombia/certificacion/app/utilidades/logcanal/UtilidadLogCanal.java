package co.com.bancolombia.certificacion.app.utilidades.logcanal;


import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Utility manager.
 */
public class UtilidadLogCanal {

    private static final Logger LOGGER = LogManager.getLogger("LOG CANAL COMFFLGWWW");
    private static String reporteTrama = "";
    private static String resultadoCampo = "Resultado ";
    private static String respuestaOK = "  : OK";
    private static String respuestaERR = "  : ERROR";
    private static String log = "logcanal";

    private UtilidadLogCanal() {
        throw new IllegalStateException(TipoClaseConstante.UTILITY_CLASS);
    }

    /**
     * Format search factoria string.
     *
     * @param campo the name campo
     * @param valorObtenido   the value obtained
     * @param valorEsperado   the value expected
     * @param resultadoAntes   the result boolean
     *
     * @return the boolean
     */

    public static boolean validarCampo(String campo, String valorObtenido, String valorEsperado , Boolean resultadoAntes) {

        Boolean resultado;
        LOGGER.info("Valor Obtenido Campo " + campo + " : " + valorObtenido);
        LOGGER.info("Valor Esperado Campo " + campo + " : " + valorEsperado);
        reporteTrama += "Valor Obtenido Campo " + campo + " : " + valorObtenido + "\n" +
                        "Valor Esperado Campo " + campo + " : " + valorEsperado + "\n";

        try {
            if (valorObtenido.equalsIgnoreCase(valorEsperado)) {
                LOGGER.info(resultadoCampo + respuestaOK);
                reporteTrama += resultadoCampo + respuestaOK + "\n\n";
                Serenity.setSessionVariable(log).to(reporteTrama);
                resultado = true;
            }else{
                LOGGER.info(resultadoCampo + respuestaERR);
                reporteTrama += resultadoCampo + respuestaERR + "\n\n";
                Serenity.setSessionVariable(log).to(reporteTrama);
                resultado = false;
            }
        }catch (Exception e) {
            LOGGER.info(resultadoCampo + campo + respuestaERR);
            reporteTrama += resultadoCampo + respuestaERR + "\n\n";
            Serenity.setSessionVariable(log).to(reporteTrama);
            resultado = false;
        }

        return resultado && resultadoAntes;
    }

}

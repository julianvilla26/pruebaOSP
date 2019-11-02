package co.com.bancolombia.certificacion.app.utilidades.administradores;


import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerificarCampos {

    private static final Logger LOGGER = LogManager.getLogger("Verificacion de campos");
    private static String validadorDeInformes = "";
    private static String resultadoCampo = "Resultado ";
    private static String respuestaOK = "  : OK";
    private static String respuestaERR = "  : ERROR";
    private static String informes_serenity = "informes_serenity";

    private VerificarCampos() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }

    public static boolean validarCampo(String campo, String valorObtenido, String valorEsperado , Boolean resultadoAntes) {

        Boolean resultado;
        LOGGER.info("Valor Obtenido Campo " + campo + " : " + valorObtenido);
        LOGGER.info("Valor Esperado Campo " + campo + " : " + valorEsperado);
        validadorDeInformes += "Valor Obtenido Campo " + campo + " : " + valorObtenido + "\n" +
                        "Valor Esperado Campo " + campo + " : " + valorEsperado + "\n";

        try {
            if (valorObtenido.equalsIgnoreCase(valorEsperado)) {
                LOGGER.info(resultadoCampo + respuestaOK);
                validadorDeInformes += resultadoCampo + respuestaOK + "\n\n";
                Serenity.setSessionVariable(informes_serenity).to(validadorDeInformes);
                resultado = true;
            }else{
                LOGGER.info(resultadoCampo + respuestaERR);
                validadorDeInformes += resultadoCampo + respuestaERR + "\n\n";
                Serenity.setSessionVariable(informes_serenity).to(validadorDeInformes);
                resultado = false;
            }
        }catch (Exception e) {
            LOGGER.info(resultadoCampo + campo + respuestaERR);
            validadorDeInformes += resultadoCampo + respuestaERR + "\n\n";
            Serenity.setSessionVariable(informes_serenity).to(validadorDeInformes);
            resultado = false;
        }

        return resultado && resultadoAntes;
    }

    public static void clearReport() {
        validadorDeInformes = "";
    }

}

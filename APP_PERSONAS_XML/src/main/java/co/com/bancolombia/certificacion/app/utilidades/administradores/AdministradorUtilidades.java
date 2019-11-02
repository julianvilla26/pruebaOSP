package co.com.bancolombia.certificacion.app.utilidades.administradores;


import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The type Utility manager.
 */
public class AdministradorUtilidades {

    private static final Logger LOGGER = LogManager.getLogger(AdministradorUtilidades.class.getName());

    private AdministradorUtilidades() {
        throw new IllegalStateException(TipoClaseConstante.UTILITY_CLASS);
    }

    /**
     * Format deposit account string.
     *
     * @param depositAccount the deposit account
     * @return the string
     */
    public static String formatoCuentaDeposito(String depositAccount) {
        String depositAccountCeros = String.format("%011d", Long.parseLong(depositAccount));
        return depositAccountCeros.replaceFirst("(\\d{3})(\\d{6})(\\d{2})", "$1-$2-$3");

    }

    /**
     * Cast type account letter string.
     *
     * @param typeAccount the type account
     * @return the string
     */
    public static String tipoCuentaLetra(String typeAccount) {
        String typeAccountUpper = typeAccount.toUpperCase();
        String castTypeAccount = "";
        if (typeAccountUpper.contains("AHORRO")) {
            castTypeAccount = "S";
        } else if (typeAccountUpper.contains("CORRIENTE")) {
            castTypeAccount = "D";
        }
        return castTypeAccount;

    }

    /**
     * Cast type account number string.
     *
     * @param typeAccount the type account
     * @return the string
     */
    public static String formatoTipoCuentaNumero(String typeAccount) {
        String typeAccountUpper = typeAccount.toUpperCase();
        String castTypeAccount = "";
        if (typeAccountUpper.contains("AHORROS")) {
            castTypeAccount = "7";
        } else if (typeAccountUpper.contains("CORRIENTE")) {
            castTypeAccount = "1";
        }
        return castTypeAccount;

    }

    public static String searchProductFormat(String numberFormat, String typeFormat) {
        return String.format("%s - %s", typeFormat, numberFormat);
    }

    public static String cerosIzquierda(String data, int sizeTotal) {
        return StringUtils.leftPad(data, sizeTotal, "0");
    }

    public static String cerosDerecha(String data, int size) {
        return StringUtils.rightPad(data, data.length() + size, "0");
    }


    public static String castTypeDocument(String typeDocument) {
        String typeDocumentUpper = typeDocument.toUpperCase();
        String castTypeDocument = "";
        if (typeDocumentUpper.contains("CÉDULA")) {
            castTypeDocument = "1";
        } else if (typeDocumentUpper.contains("NIT")) {
            castTypeDocument = "3";
        }
        return castTypeDocument;

    }

    public static String subStringNumeroTarjetaCredito(String data) {
        return StringUtils.substring(data, data.length() - 4, data.length());
    }

    public static String formatoTarjetaCredito(String number, String accountType) {
        return accountType + " " + "****" + subStringNumeroTarjetaCredito(number);
    }

    public static String tipoTarjetaCreditoEnNumero(String accountType) {
        String accountTypeUpper = accountType.toUpperCase();
        String castAccountType = "";
        if (accountTypeUpper.contains("AMERICAN EXPRESS") || accountTypeUpper.contains("MASTERCARD") || accountTypeUpper.contains("VISA")) {
            castAccountType = "1";
        }
        return castAccountType;
    }

    public static String dateFormatCreditCard(String date) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyyMMdd");

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        String dateFormat = "";
        try {
            dateFormat = formatter.format(parser.parse(date));
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return dateFormat;
    }

}

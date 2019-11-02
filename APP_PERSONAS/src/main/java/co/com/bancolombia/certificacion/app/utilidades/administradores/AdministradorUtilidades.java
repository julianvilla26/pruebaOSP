package co.com.bancolombia.certificacion.app.utilidades.administradores;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_UTILIDAD;


public class AdministradorUtilidades {

    private static final Logger LOGGER = LogManager.getLogger(AdministradorUtilidades.class.getName());

    private AdministradorUtilidades() {
        throw new IllegalStateException(CLASE_UTILIDAD);
    }


    public static String formatoCuentaDeposito(String cuentaDeposito) {
        String cuentaDepositoCeros = String.format("%011d", Long.parseLong(cuentaDeposito));
        return cuentaDepositoCeros.replaceFirst("(\\d{3})(\\d{6})(\\d{2})", "$1-$2-$3");
    }

    public static String tipoCuentaLetra(String tipoCuenta) {
        String tipoCuentaMayuscula = tipoCuenta.toUpperCase();
        String tipoCuentaCasteo = "";
        if (tipoCuentaMayuscula.contains("AHORRO")) {
            tipoCuentaCasteo = "S";
        } else if (tipoCuentaMayuscula.contains("CORRIENTE")) {
            tipoCuentaCasteo = "D";
        } else if (tipoCuentaMayuscula.contains("ADELANTO")) {
            tipoCuentaCasteo = "D";
        }
        return tipoCuentaCasteo;

    }


    public static String formatoTipoCuentaNumero(String typeAccount) {
        String typeAccountUpper = typeAccount.toUpperCase();
        String castTypeAccount = "";
        if (typeAccountUpper.contains("AHORRO")) {
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

    public static String tipoTarjetaPrefijo(String accountType){
        String accountTypeUpper = accountType.toUpperCase();
        String castAccountType = "";
        if (accountTypeUpper.contains("AMERICAN EXPRESS")){
            castAccountType = "3";
        } else if (accountTypeUpper.contains("VISA")){
            castAccountType = "4";
        } else if (accountTypeUpper.contains("MASTERCARD")) {
            castAccountType = "5";
        }
        return castAccountType;
    }
}
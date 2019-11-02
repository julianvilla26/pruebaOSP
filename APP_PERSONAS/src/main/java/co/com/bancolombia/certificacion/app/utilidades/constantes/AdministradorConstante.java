package co.com.bancolombia.certificacion.app.utilidades.constantes;


public class AdministradorConstante {

    public static final String AUTENTICACION_TIPO_TRANSACCION = "autenticacion";
    public static final String AUTENTICACION_CODIGO_TRANSACCION = "0369";
    public static final String APERTURA_INVERSION_VIRTUAL_CODIGO_TRANSACCION = "0326";
    public static final String SIMULACION_INVERSION_VIRTUAL_CODIGO_TRANSACCION = "0325";
    public static final String FORMATO_HORA = "HHmmss";
    public static final String EMPTY = "";
    public static final String NUMBER_FORMAT = "###,###.###";
    public static final String TRANSFERENCIA_TIPO_TRANSACCION = "Transferencia";
    public static final String ACIERTO = "ACIERTO";
    public static final String MENSUAL = "Mensual";
    public static final String EXPIRACION = "Al vencimiento";
    public static final String CODIGO_TRANSACCION_ACH = "0638";
    public static final String TRANSACTION_CODE_BANCOLOMBIA_SAVING = "0538";
    public static final String TRANSACTION_CODE_BANCOLOMBIA_CURRENT = "0438";
    public static final String TRANSACTION_CODE_TO_FUNDS_SAVING = "0539";
    public static final String TRANSACTION_CODE_TO_FUNDS_CURRENT = "0439";
    public static final String TRANSACTION_CODE_FROM_FUNDS_SAVING = "0549";
    public static final String TRANSACTION_CODE_FROM_FUNDS_CURRENT = "0449";
    public static final String TRANSACTION_CODE_FUNDS = "1100";
    public static final String TRANSACTION_CODE_INSCRIPTION_BANCOLOMBIA = "0485";
    public static final String TRANSACTION_CODE_INSCRIPTION_OTHER_BANK = "0486";
    public static final String TRANSACTION_TYPE_INSCRIPTION = "Inscriptions";
    public static final String TRANSACTION_TYPE_CONSULT_DETAIL = "Consult detail";
    public static final String TRANSACTION_CODE_CONSULT_DETAIL_CREDIT_CARDS = "1260";
    public static final String DECIMAL_DOT = ".00";
    public static final String DECIMAL = "00";
    public static final String CODIGO_OPETACION_TRANSFERENCIA = "120";
    public static final String VERIFIED_ACCOUNT_STATUS = "V";
    public static final String DESCRIPTION_VERIFIED_ACCOUNT = "VERIFICADA";
    public static final String INSCRIPTION_OPERATE_CODE = "300";
    public static final String NATURE_CREDIT = "C";
    public static final String NATURE_DEBIT = "D";
    public static final String TRAMAINPUT = " TRAMA INPUT";
    public static final String TRAMAOUTPUT = " TRAMA OUTPUT";
    public static final String CODIGO_TRANSACCION_APERTURA_INVERSION_VIRTUAL = "0326";
    public static final String CODIGO_TRANSACCION_SIMULACION_INVERSION_VIRTUAL = "0325";
    public static final String GUION = "-";
    public static final String CODIGO_BANCO_EPREPAGO = "107";
    public static final String ESTADO_TARJETA_ACTIVA = "A";
    public static final String ESTADO_TARJETA_INACTIVA = "B";
    public static final String ALTERNO = "ALTERNO";
    public static final String LABEL_NO_EXISTE = "Label No Existe";
    public static final String NUMERO_BASE_EPREPAGO = "53069500";
    public static final String CODIGO_TRN_ACTIVATION_EPREPAGO = "1232";
    public static final String CODIGO_TRN_INACTIVATION_EPREPAGO = "1230";

    private AdministradorConstante() {

        throw new IllegalStateException(TipoClaseConstante.CLASE_CONSTANTE);
    }

}

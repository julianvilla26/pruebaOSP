package co.com.bancolombia.certificacion.app.models.productos;


import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante.*;

/**
 * The type Deposito account.
 */
public class CuentaDeposito extends Producto {

    private String typeAccountInLetter;
    private String typeAccountInNumber;
    private String accountNumberFormat;

    /**
     * Instantiates a new Deposito account.
     */
    public CuentaDeposito() {
        super();
    }

    /**
     * Instantiates a new Deposito account.
     *
     * @param number      the number
     * @param productType the factoria type
     */
    public CuentaDeposito(String number, String productType) {
        super(number, productType);
    }

    /**
     * Gets type account in letter.
     *
     * @return the type account in letter
     */
    public String getTypeAccountInLetter() {
        return typeAccountInLetter;
    }

    /**
     * Sets type account in letter.
     *
     * @param typeAccountInLetter the type account in letter
     */
    public void setTypeAccountInLetter(String typeAccountInLetter) {
        if (INI_CTA_AHORROS.equalsIgnoreCase(typeAccountInLetter) || INI_CTA_CORRIENTE.equalsIgnoreCase(typeAccountInLetter)) {
            this.typeAccountInLetter = typeAccountInLetter;
        } else {
            this.typeAccountInLetter = AdministradorUtilidades.tipoCuentaLetra(typeAccountInLetter);
        }

    }

    /**
     * Gets type account in number.
     *
     * @return the type account in number
     */
    public String getTypeAccountInNumber() {
        return typeAccountInNumber;
    }

    /**
     * Sets type account in number.
     *
     * @param typeAccountInNumber the type account in number
     */
    public void setTypeAccountInNumber(String typeAccountInNumber) {
        if (NUM_CTA_AHORROS.equalsIgnoreCase(typeAccountInNumber) || NUM_CTA_CORRIENTE.equalsIgnoreCase(typeAccountInNumber)) {
            this.typeAccountInNumber = typeAccountInNumber;
        } else {
            this.typeAccountInNumber = AdministradorUtilidades.formatoTipoCuentaNumero(typeAccountInNumber);
        }

    }

    /**
     * Gets account number format.
     *
     * @return the account number format
     */
    public String getAccountNumberFormat() {
        return accountNumberFormat;
    }

    /**
     * Sets account number format.
     *
     * @param accountNumberFormat the account number format
     */
    public void setAccountNumberFormat(String accountNumberFormat) {
        this.accountNumberFormat = AdministradorUtilidades.formatoCuentaDeposito(accountNumberFormat);
    }


}

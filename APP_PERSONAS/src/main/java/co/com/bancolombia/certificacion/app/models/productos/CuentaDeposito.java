package co.com.bancolombia.certificacion.app.models.productos;


import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoCuentas.AHORRO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoCuentas.CORRIENTE;

public class CuentaDeposito extends Producto {

    private String tipoCuentaEnLetra;
    private String tipoCuentaEnNumero;
    private String numeroCuentaFormateado;
    private String cuentaDepositoFormateado;


    public CuentaDeposito() {
        super();
    }

    public CuentaDeposito(String numero, String tipoProducto) {
        super(numero, tipoProducto);
    }

    public String getTipoCuentaEnLetra() {
        return tipoCuentaEnLetra;
    }

    public void setTipoCuentaEnLetras(String tipoCuentaEnLetras) {
        if (tipoCuentaEnLetras.equalsIgnoreCase(AHORRO.getLetra()) || tipoCuentaEnLetras.equalsIgnoreCase(CORRIENTE.getLetra())) {
            this.tipoCuentaEnLetra = tipoCuentaEnLetras;
        } else {
            this.tipoCuentaEnLetra = AdministradorUtilidades.tipoCuentaLetra(tipoCuentaEnLetras);
        }

    }

    public String getTipoCuentaEnNumero() {
        return tipoCuentaEnNumero;
    }

    public void setTipoCuentaEnNumeros(String tipoCuentaEnNumeros) {
        if (tipoCuentaEnNumeros.equalsIgnoreCase(CORRIENTE.getNumero()) || tipoCuentaEnNumeros.equalsIgnoreCase(AHORRO.getNumero())) {
            this.tipoCuentaEnNumero = tipoCuentaEnNumeros;
        } else {
            this.tipoCuentaEnNumero = AdministradorUtilidades.formatoTipoCuentaNumero(tipoCuentaEnNumeros);
        }

    }

    public String getNumeroCuentaFormateado() {
        return numeroCuentaFormateado;
    }

    public void setNumeroCuentaFormateado(String accountNumberFormat) {
        this.numeroCuentaFormateado = AdministradorUtilidades.formatoCuentaDeposito(accountNumberFormat);
    }

    public String getCuentaDepositoFormateado() {
        return cuentaDepositoFormateado;
    }

    public void setCuentaDepositoFormateado(String cuentaDepositoFormateado) {
        this.cuentaDepositoFormateado = cuentaDepositoFormateado;
    }

}

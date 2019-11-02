package co.com.bancolombia.certificacion.app.models.productos;


import co.com.bancolombia.certificacion.app.models.movimiento.Movimiento;
import co.com.bancolombia.certificacion.app.models.saldo.Saldo;
import co.com.bancolombia.certificacion.app.models.transaccion.Transferencias;

import java.util.List;

/**
 * The type Producto.
 */
public class Producto {

    private String numero;
    private String tipo;
    private String codigoBanco;
    private String nombreBanco;
    private String nombreProducto;
    private Saldo saldo;
    private List<Movimiento> movimientos;
    private Transferencias transferencias;
    private CuentaDeposito cuentaDeposito;


    public CuentaDeposito getCuentaDeposito() {
        return cuentaDeposito;
    }
    public void setCuentaDeposito(CuentaDeposito cuentaDeposito) {
        this.cuentaDeposito = cuentaDeposito;
    }

    public Transferencias getTransferencias() {
        return transferencias;
    }
    public void setTransferencias(Transferencias transferencias) {
        this.transferencias = transferencias;
    }

    /**
     * Gets saldo cuenta deposito
     * @return saldo
     */
    public Saldo getSaldo() {
        return saldo;
    }

    /**
     * Sets saldo cuenta deposito
     * @param saldo
     */
    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    /**
     * Gets movimientos.
     *
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * Sets movimientos.
     *
     * @param movimientos the movimientos
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }


    /**
     * Instantiates a new Producto.
     */
    public Producto() {
    }

    /**
     * Instantiates a new Producto.
     *
     * @param numero      the numero
     * @param tipo the factoria type
     */
    protected Producto(String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }



    /**
     * Gets numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets numero.
     *
     * @param numero the numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Gets factoria type.
     *
     * @return the factoria type
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets factoria type.
     *
     * @param tipoProducto the tipo producto
     */
    public void setTipo(String tipoProducto) {
        this.tipo = tipoProducto;
    }

    /**
     * Gets bank code.
     *
     * @return the bank code
     */
    public String getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * Sets bank code.
     *
     * @param codigoBanco the codigo banco
     */
    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    /**
     * Gets bank name.
     *
     * @return the bank name
     */
    public String getNombreBanco() {
        return nombreBanco;
    }

    /**
     * Sets bank name.
     *
     * @param nombreBanco the nombre banco
     */
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    /**
     * Gets factoria name.
     *
     * @return the factoria name
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Sets factoria name.
     *
     * @param nombreProducto the factoria name
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}

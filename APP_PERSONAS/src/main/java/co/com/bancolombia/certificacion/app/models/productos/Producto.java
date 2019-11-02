package co.com.bancolombia.certificacion.app.models.productos;

import co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder;
import co.com.bancolombia.certificacion.app.models.movimiento.Movimiento;
import co.com.bancolombia.certificacion.app.models.saldo.Saldo;

import java.util.List;

public class Producto {

    private String numero;
    private String tipo;
    private String codigoBanco;
    private String nombreBanco;
    private String nombreProducto;
    private Saldo saldo;
    private TarjetaCredito tarjetaCredito;
    private Credito credito;
    private List<Movimiento> movimientos;

    public Producto(){
        this.tipo="";
        this.numero="";
    }

    protected Producto(String numero, String tipoProducto) {
        this.numero = numero;
        this.tipo = tipoProducto;
    }

    protected Producto(String numero, String tipoProducto, Saldo saldo) {
        this.numero = numero;
        this.tipo = tipoProducto;
        this.saldo = saldo;
    }

    public Producto(ProductoBuilder productoBuilder){
        this.tipo = productoBuilder.getTipo();
        this.numero = productoBuilder.getNumero();
        this.codigoBanco = productoBuilder.getCodigoBanco();
        this.nombreBanco = productoBuilder.getNombreBanco();
        this.nombreProducto = productoBuilder.getNombreProducto();
        this.saldo = productoBuilder.getSaldo();
        this.tarjetaCredito=productoBuilder.getTarjetaCredito();
        this.credito=productoBuilder.getCredito();
        this.movimientos = productoBuilder.getMovimientos();
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
}
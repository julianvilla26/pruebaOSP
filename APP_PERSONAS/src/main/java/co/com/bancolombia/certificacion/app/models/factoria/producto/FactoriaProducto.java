package co.com.bancolombia.certificacion.app.models.factoria.producto;


import co.com.bancolombia.certificacion.app.exceptions.productos.ProductoFallido;
import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.models.productos.FondoInversion;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.productos.TarjetaCredito;

import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.FondoLibrerias.BIBLIOTECA_POR_CODIGO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoCuentas.AHORRO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoCuentas.CORRIENTE;

public class FactoriaProducto implements InterfazProducto {

    private static CuentaDeposito crearCuentaDeposito(String numero, String tipoCuenta) {
        CuentaDeposito cuentaActual = new CuentaDeposito();
        cuentaActual.setNumero(numero);
        cuentaActual.setTipo(tipoCuenta);
        cuentaActual.setTipoCuentaEnLetras(tipoCuenta);
        cuentaActual.setTipoCuentaEnNumeros(tipoCuenta);
        cuentaActual.setNumeroCuentaFormateado(numero);
        return cuentaActual;
    }

    private static FondoInversion crearFondoInversion(String numero, String tipoCuenta) {
        FondoInversion fondoInversionActual = new FondoInversion();
        fondoInversionActual.setNumero(numero);
        fondoInversionActual.setTipo(tipoCuenta);
        fondoInversionActual.setCodigoFondo(tipoCuenta);
        return fondoInversionActual;
    }

    private static TarjetaCredito crearTarjetaCredito(String numero, String tipoCuenta) {
        TarjetaCredito tarjetaCreditoActual = new TarjetaCredito(numero, tipoCuenta);
        tarjetaCreditoActual.setNumero(numero);
        tarjetaCreditoActual.setTipo(tipoCuenta);
        tarjetaCreditoActual.setFormatoTarjetaCredito(numero, tipoCuenta);
        tarjetaCreditoActual.setTipoTarjetaCreditoEnNumero(tipoCuenta);
        return tarjetaCreditoActual;
    }

    @Override
    public Producto crarProducto(String numero, String tipoProducto) {
        String tipo = tipoProducto.toUpperCase();

        if (tipo.contains(AHORRO.toString()) || tipo.contains(CORRIENTE.toString())) {

            return crearCuentaDeposito(numero, tipoProducto);

        } else if (existe(BIBLIOTECA_POR_CODIGO, tipo)) {

            return crearFondoInversion(numero, tipoProducto);

        } else if(tipo.contains("AMERICAN EXPRESS") || tipo.contains("MASTERCARD") || tipo.contains("VISA")) {

            return crearTarjetaCredito(numero, tipoProducto);

        }else {
            throw new ProductoFallido(tipoProducto);
        }
    }

    private boolean existe(Map<String, String> list, String productType) {
        String type = list.get(productType);
        return type != null;
    }

}

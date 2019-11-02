package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import net.serenitybdd.screenplay.Performable;

import static co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum.INVERSIONES;
import static co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum.TARJETAS_CREDITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarMovimientos {

    public static Performable deCuentas(String tipoCuenta, String numeroCuenta){
        return instrumented(ConsultarMovimientosCuentas.class, tipoCuenta, numeroCuenta);
    }

    public static Performable deTarjetasCredito(String tipoCuenta, String numeroCuenta){
        return instrumented(ConsultarMovimientosTarjetasInversiones.class, tipoCuenta, numeroCuenta, TARJETAS_CREDITO.getCategoria());
    }

    public static Performable deInversiones(String tipoCuenta, String numeroCuenta){
        return instrumented(ConsultarMovimientosTarjetasInversiones.class, tipoCuenta, numeroCuenta, INVERSIONES.getCategoria());
    }

    public static Performable deEprepago(String tipoCuenta, String numeroCuenta){
        return instrumented(ConsultarMovimientosEprepago.class, tipoCuenta, numeroCuenta);
    }
}
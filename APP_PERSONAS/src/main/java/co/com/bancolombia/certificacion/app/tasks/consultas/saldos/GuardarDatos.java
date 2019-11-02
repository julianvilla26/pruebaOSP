package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static co.com.bancolombia.certificacion.app.models.builders.SaldoBuilder.saldo;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_LISTA_CUENTAS_DEPOSITO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.getPlatformCapability;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GuardarDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        int iterador;
        List<Producto> listaProductos = new ArrayList<>();
        if ("Android".equalsIgnoreCase(getPlatformCapability()))
            iterador = 0;
        else
            iterador = 1;
        while (Verificar.elementoPresente(actor, CONTENEDOR_INFORMACION_PRODUCTO.of(String.valueOf(iterador)))) {
            listaProductos.add(elProducto()
                    .conTipoCuenta(LBL_TIPO_CUENTA_SALDOS_MOVIMIENTOS.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conNumero(LBL_NUMERO_CUENTA_SALDOS_MOVIMIENTOS.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conSaldo(
                            saldo()
                                    .conSaldoDisponible(LBL_SALDO_DISPONIBLE_SALDOS_MOVIMIENTOS.of(String.valueOf(iterador)).resolveFor(actor).getText()).build())
                    .build());
            iterador++;
        }
        actor.remember(MODELO_LISTA_CUENTAS_DEPOSITO, listaProductos);
    }

    public static Performable deProductos() {
        return instrumented(GuardarDatos.class);
    }
}
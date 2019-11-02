package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.models.productos.InversionVirtual;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante.EXPIRATION;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante.MONTHLY;


/**
 * The type Virtual investment entity.
 */
public class CargarEntidadInversionVirtual {

    private static InversionVirtual virtualInvestment = new InversionVirtual();

    private CargarEntidadInversionVirtual() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets inversion virtual.
     *
     * @return the inversion virtual
     */
    public static InversionVirtual getVirtualInvestment() {
        return virtualInvestment;
    }

    /**
     * Sets inversion virtual.
     *
     * @param data the data
     */
    public static void conEstos(List<String> data) {
        ConfiguracionTransaccion configuracionTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();
        CuentaDeposito depositAccount = new CuentaDeposito();

        if (AdministradorConstante.CODIGO_TRANSACCION_APERTURA_INVERSION_VIRTUAL.equals(configuracionTransaccion.getCodigoTransaccion())||
                AdministradorConstante.CODIGO_TRANSACCION_SIMULACION_INVERSION_VIRTUAL.equals(configuracionTransaccion.getCodigoTransaccion())){
            virtualInvestment.setPeriodicityPaymentInterest(data.get(0));
            virtualInvestment.setDaysTerm(data.get(1));
            virtualInvestment.setAnnualEffectiveRate(data.get(2));
        }else{
            virtualInvestment.setInvestmentValue(data.get(0));
            virtualInvestment.setDaysTerm(data.get(1));
            virtualInvestment.setPeriodicityPaymentInterest(data.get(2));
            virtualInvestment.setPeriodicityPaymentInterestNumber(castPeriodicity(data.get(2)));
            depositAccount.setAccountNumberFormat(data.get(3));
            depositAccount.setTipo(data.get(4));
        }
        virtualInvestment.setDepositAccount(depositAccount);

    }

    private static int castPeriodicity(String periodicity) {
        int result = 0;
        if (periodicity.equalsIgnoreCase(MONTHLY)) {
            result = 1;
        } else if (periodicity.equalsIgnoreCase(EXPIRATION)) {
            result = 2;
        }
        return result;
    }
}

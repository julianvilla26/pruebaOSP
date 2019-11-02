package co.com.bancolombia.certificacion.app.models.factoria;


import co.com.bancolombia.certificacion.app.exceptions.AfirmacionDelProducto;
import co.com.bancolombia.certificacion.app.models.productos.FondoInversion;
import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.constantes.FondoConstante;

import java.util.Map;

/**
 * The type Producto fabrica.
 */
public class FactoriaProducto implements FactoriaProductoMetodo {

    private static CuentaDeposito createDepositAcount(String number, String accountType) {
        CuentaDeposito currentAccount = new CuentaDeposito();
        currentAccount.setNumero(number);
        currentAccount.setTipo(accountType);
        currentAccount.setTypeAccountInLetter(accountType);
        currentAccount.setTypeAccountInNumber(accountType);
        currentAccount.setAccountNumberFormat(number);
        return currentAccount;
    }

    private static FondoInversion createInvestmentFund(String number, String accountType) {
        FondoInversion currentInvestmentFunds = new FondoInversion();
        currentInvestmentFunds.setNumero(number);
        currentInvestmentFunds.setTipo(accountType);
        currentInvestmentFunds.setFundCode(accountType);
        return currentInvestmentFunds;
    }

    @Override
    public Producto createProduct(String numberProduct, String productType) {
        productType = productType.toUpperCase();
        if (productType.contains("AHORROS") || productType.contains("CORRIENTE")) {
            return createDepositAcount(numberProduct, productType);
        } else if (isExist(FondoConstante.LIBRARY_BY_CODE, productType)) {
            return createInvestmentFund(numberProduct, productType);
        } else {
            throw new AfirmacionDelProducto(productType);
        }
    }

    private boolean isExist(Map<String, String> list, String productType) {
        String type = list.get(productType);
        return type != null;
    }

}

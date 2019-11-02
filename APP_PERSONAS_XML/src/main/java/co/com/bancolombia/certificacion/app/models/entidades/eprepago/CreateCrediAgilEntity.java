package co.com.bancolombia.certificacion.app.models.entidades.eprepago;

import co.com.bancolombia.certificacion.app.models.productos.CrediAgil;

import java.util.List;

/**
 * The type Create credi agil entity.
 */
public class CreateCrediAgilEntity {

    private static CrediAgil crediAgilValues;

    private CreateCrediAgilEntity() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Gets credi agil values.
     *
     * @return the credi agil values
     */
    public static CrediAgil getCrediAgilValues() {
        return crediAgilValues;
    }

    /**
     * Sets credi agil values.
     *
     * @param data the data
     */
    public static void setCrediAgilValues(List<String> data) {
        CrediAgil crediAgilValues = new CrediAgil();
        String destinyAccount;
        String[] valor = data.get(0).split(data.get(0).substring(3, 9));
        String valor2 = data.get(0).substring(3, 9);
        destinyAccount = (valor[0] + "-" + valor2 + "-" + valor[1]);
        crediAgilValues.setDestinyAccount(destinyAccount);
        crediAgilValues.setAmount((data.get(1)));
        crediAgilValues.setTerm(data.get(2));
        CreateCrediAgilEntity.crediAgilValues = crediAgilValues;
    }

}

package co.com.bancolombia.certificacion.app.models.transaccion;


import co.com.bancolombia.certificacion.app.models.productos.Producto;

/**
 * The type Transferencias.
 */
public class Transferencias extends Producto {

    private Producto originProduct;
    private Producto destinationProduct;
    private String amount;
    private String transferType;
    private String bank;
    private String description;
    private String additionalInformation;


    /**
     * Gets origin factoria.
     *
     * @return the origin factoria
     */
    public Producto getOriginProduct() {
        return originProduct;
    }

    /**
     * Sets origin factoria.
     *
     * @param originProduct the origin factoria
     */
    public void setOriginProduct(Producto originProduct) {
        this.originProduct = originProduct;
    }

    /**
     * Gets destination factoria.
     *
     * @return the destination factoria
     */
    public Producto getDestinationProduct() {
        return destinationProduct;
    }

    /**
     * Sets destination factoria.
     *
     * @param destinationProduct the destination factoria
     */
    public void setDestinationProduct(Producto destinationProduct) {
        this.destinationProduct = destinationProduct;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets transfer type.
     *
     * @return the transfer type
     */
    public String getTransferType() {
        return transferType;
    }

    /**
     * Sets transfer type.
     *
     * @param transferType the transfer type
     */
    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    /**
     * Gets bank.
     *
     * @return the bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * Sets bank.
     *
     * @param bank the bank
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets additional information.
     *
     * @return the additional information
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets additional information.
     *
     * @param additionalInformation the additional information
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}

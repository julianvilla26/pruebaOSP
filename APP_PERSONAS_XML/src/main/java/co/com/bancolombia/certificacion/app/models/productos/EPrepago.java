package co.com.bancolombia.certificacion.app.models.productos;

/**
 * The type E prepago.
 */
public class EPrepago {
    private String originAccount;
    private String amount;
    private String movementDate;
    private String movementDescription;
    private String movementValue;
    private String dateto;
    private String datefrom;
    private double balnceBefore;
    private double balanceAfter;
    private String tyc;
    private String listDescriptionMoments;
    private String listCoinMoments;


    /**
     * Gets list description moments.
     *
     * @return the list description moments
     */
    public String getListDescriptionMoments() {
        return listDescriptionMoments;
    }

    /**
     * Sets list description moments.
     *
     * @param listDescriptionMoments the list description moments
     */
    public void setListDescriptionMoments(String listDescriptionMoments) {
        this.listDescriptionMoments = listDescriptionMoments;
    }

    /**
     * Gets list coin moments.
     *
     * @return the list coin moments
     */
    public String getListCoinMoments() {
        return listCoinMoments;
    }

    /**
     * Sets list coin moments.
     *
     * @param listCoinMoments the list coin moments
     */
    public void setListCoinMoments(String listCoinMoments) {
        this.listCoinMoments = listCoinMoments;
    }

    /**
     * Gets datefrom.
     *
     * @return the datefrom
     */
    public String getDatefrom() {
        return datefrom;
    }

    /**
     * Sets datefrom.
     *
     * @param datefrom the datefrom
     */
    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    /**
     * Gets dateto.
     *
     * @return the dateto
     */
    public String getDateto() {
        return dateto;
    }

    /**
     * Sets dateto.
     *
     * @param dateto the dateto
     */
    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    /**
     * Gets movement date.
     *
     * @return the movement date
     */
    public String getMovementDate() {
        return movementDate;
    }

    /**
     * Sets movement date.
     *
     * @param movementDate the movement date
     */
    public void setMovementDate(String movementDate) {
        this.movementDate = movementDate;
    }

    /**
     * Gets movement description.
     *
     * @return the movement description
     */
    public String getMovementDescription() {
        return movementDescription;
    }

    /**
     * Sets movement description.
     *
     * @param movementDescription the movement description
     */
    public void setMovementDescription(String movementDescription) {
        this.movementDescription = movementDescription;
    }

    /**
     * Gets movement value.
     *
     * @return the movement value
     */
    public String getMovementValue() {
        return movementValue;
    }

    /**
     * Sets movement value.
     *
     * @param movementValue the movement value
     */
    public void setMovementValue(String movementValue) {
        this.movementValue = movementValue;
    }

    /**
     * Gets ty c.
     *
     * @return the ty c
     */
    public String getTyc() {
        return tyc;
    }

    /**
     * Sets ty c.
     *
     * @param tyc the ty c
     */
    public void setTyc(String tyc) {
        this.tyc = tyc;
    }

    /**
     * Gets balnce before.
     *
     * @return the balnce before
     */
    public double getBalnceBefore() {
        return balnceBefore;
    }

    /**
     * Sets balnce before.
     *
     * @param balnceBefore the balnce before
     */
    public void setBalnceBefore(double balnceBefore) {
        this.balnceBefore = balnceBefore;
    }

    /**
     * Gets balance after.
     *
     * @return the balance after
     */
    public double getBalanceAfter() {
        return balanceAfter;
    }

    /**
     * Sets balance after.
     *
     * @param balanceAfter the balance after
     */
    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    /**
     * Gets origin account.
     *
     * @return the origin account
     */
    public String getOriginAccount() {
        return originAccount;
    }

    /**
     * Sets origin account.
     *
     * @param originAccount the origin account
     */
    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
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

}

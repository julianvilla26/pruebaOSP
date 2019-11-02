package co.com.bancolombia.certificacion.app.models.productos;

/**
 * The type Credi agil.
 */
public class CrediAgil {
    private String destinyAccount;
    private String amount;
    private String term;
    private double availableBalanceBefore;
    private double availableBalanceAfter;

    /**
     * Gets available balance before.
     *
     * @return the available balance before
     */
    public double getAvailableBalanceBefore() {
        return availableBalanceBefore;
    }

    /**
     * Sets available balance before.
     *
     * @param availableBalanceBefore the available balance before
     */
    public void setAvailableBalanceBefore(double availableBalanceBefore) {
        this.availableBalanceBefore = availableBalanceBefore;
    }

    /**
     * Gets available balance after.
     *
     * @return the available balance after
     */
    public double getAvailableBalanceAfter() {
        return availableBalanceAfter;
    }

    /**
     * Sets available balance after.
     *
     * @param availableBalanceAfter the available balance after
     */
    public void setAvailableBalanceAfter(double availableBalanceAfter) {
        this.availableBalanceAfter = availableBalanceAfter;
    }

    /**
     * Gets destiny account.
     *
     * @return the destiny account
     */
    public String getDestinyAccount() {
        return destinyAccount;
    }

    /**
     * Sets destiny account.
     *
     * @param destinyAccount the destiny account
     */
    public void setDestinyAccount(String destinyAccount) {
        this.destinyAccount = destinyAccount;
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
     * Gets term.
     *
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets term.
     *
     * @param term the term
     */
    public void setTerm(String term) {
        this.term = term;
    }
}

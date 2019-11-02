package co.com.bancolombia.certificacion.app.models.movimiento;

/**
 * The type Movimiento.
 */
public class Movimiento {

    private String fecha;
    private String valorMovimiento;
    private String naturaleza;
    private String codigo;
    private String descripcion;
    private String valorPorUnidad;
    private String numeroUnidades;


    /**
     * Gets fecha.
     *
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Sets fecha.
     *
     * @param fecha the fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Gets movimiento value.
     *
     * @return the movimiento value
     */
    public String getValorMovimiento() {
        return valorMovimiento;
    }

    /**
     * Sets movimiento value.
     *
     * @param valorMovimiento the movimiento value
     */
    public void setValorMovimiento(String valorMovimiento) {
        this.valorMovimiento = valorMovimiento;
    }

    /**
     * Gets naturaleza.
     *
     * @return the naturaleza
     */
    public String getNaturaleza() {
        return naturaleza;
    }

    /**
     * Sets naturaleza.
     *
     * @param naturaleza the naturaleza
     */
    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets codigo.
     *
     * @param codigo the codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets value per unit.
     *
     * @return the value per unit
     */
    public String getValorPorUnidad() {
        return valorPorUnidad;
    }

    /**
     * Sets value per unit.
     *
     * @param valorPorUnidad the value per unit
     */
    public void setValorPorUnidad(String valorPorUnidad) {
        this.valorPorUnidad = valorPorUnidad;
    }

    /**
     * Gets number of units.
     *
     * @return the number of units
     */
    public String getNumeroUnidades() {
        return numeroUnidades;
    }

    /**
     * Sets number of units.
     *
     * @param numeroUnidades the number of units
     */
    public void setNumeroUnidades(String numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

}

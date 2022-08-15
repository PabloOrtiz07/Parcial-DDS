package FormaDePago;

import Entidades.BilleteraVirtual;

public class Tarjeta extends MetodoDePago{
    private String numeroTarjeta;
    private String titularTarjeta;

    private String cvv;
    private String fechaVencimiento;

    public Tarjeta(String numeroTarjeta, String cvv, String titularTarjeta, String fechaVencimiento) {
        super();
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.titularTarjeta = titularTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.pagoStrategy = new TarjetaStrategy();
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }



}

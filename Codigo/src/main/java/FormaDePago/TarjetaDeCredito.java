package FormaDePago;

import Entidades.BilleteraVirtual;

public class TarjetaDeCredito extends IngresoDeDinero {
    private String numeroTarjeta;
    private String titularTarjeta;
    private Boolean validarTarjeta;
    private String fechaInicio;
    private String fechaVencimiento;

    private Double montoMaximo;

    public Double getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(Double montoMaximo) {
        this.montoMaximo = montoMaximo;
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

    public Boolean getValidarTarjeta() {
        return validarTarjeta;
    }

    public void setValidarTarjeta(Boolean validarTarjeta) {
        this.validarTarjeta = validarTarjeta;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public TarjetaDeCredito(String numeroTarjeta, String titularTarjeta, String fechaVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.titularTarjeta = titularTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }


    @Override
    public void ingresarDinero(BilleteraVirtual billeteraVirtual, Double montoIngresado){
        if(this.validarTarjeta==true && this.montoMaximo<montoIngresado){
            System.out.println("Dinero ingresado satisfactoriamente: ");
            billeteraVirtual.ingresarDineroEnBilletera(montoIngresado);
        }else {
            System.out.println("Error en la carga de dinero: ");
        }
    }


}

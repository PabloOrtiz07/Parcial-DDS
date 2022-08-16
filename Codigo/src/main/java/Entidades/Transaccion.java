package Entidades;

import java.time.LocalDate;

public class Transaccion {

    public Transaccion(Oferta oferta,BilleteraVirtual billeteraVirutalComprador){
        this.oferta = oferta;
        this.billeteraVirtualvendedor = oferta.billeteraVendedor;
        this.billeteraVirutalComprador =  billeteraVirutalComprador;
        this.monedaComprada = oferta.getCriptoMoneda();
        this.cantidadComprada = oferta.getCantidadOfrecida();
        this.precio = oferta.getPrecioPorCantida(cantidadComprada);
    }
    protected Oferta oferta;
    protected String idTransaccion;
    protected BilleteraVirtual billeteraVirtualvendedor;
    protected BilleteraVirtual billeteraVirutalComprador;
    protected LocalDate fechaCompletada;
    protected CriptoMoneda monedaComprada;
    protected Double cantidadComprada;
    protected double precio;

    public void setFechaCompletada(LocalDate fechaCompletada) {
        this.fechaCompletada = fechaCompletada;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public Oferta getOferta() {
        return oferta;
    }
    public BilleteraVirtual getBilleteraVirutalComprador() {
        return billeteraVirutalComprador;
    }

    public BilleteraVirtual getVendedor() {
        return billeteraVirtualvendedor;
    }

    public LocalDate getFechaCompletada() {
        return fechaCompletada;
    }

    public CriptoMoneda getMonedaComprada() {
        return monedaComprada;
    }

    public Double getCantidadComprada() {
        return cantidadComprada;
    }

    public double getPrecio() {
        return precio;
    }
}



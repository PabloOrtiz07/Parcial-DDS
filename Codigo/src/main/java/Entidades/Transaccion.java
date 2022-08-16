package Entidades;

import java.time.LocalDate;

public class Transaccion {
    public BilleteraVirtual getBilleteraVirtualvendedor() {
        return billeteraVirtualvendedor;
    }

    public void setBilleteraVirtualvendedor(BilleteraVirtual billeteraVirtualvendedor) {
        this.billeteraVirtualvendedor = billeteraVirtualvendedor;
    }

    public Transaccion(Oferta oferta, Cliente cliente){
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual();
        this.oferta = oferta;
        this.billeteraVirtualvendedor = oferta.billeteraVendedor;
        this.billeteraVirutalComprador =  billeteraVirutalComprador;
        this.monedaComprada = oferta.getCriptoMoneda();
        this.cantidadComprada = oferta.getCantidadOfrecida();
        this.precio = oferta.getPrecioPorCantida(cantidadComprada);
        this.autorDeCompra = cliente;
    }

    public Cliente getAutorDeCompra() {
        return autorDeCompra;
    }

    public void setAutorDeCompra(Cliente autorDeCompra) {
        this.autorDeCompra = autorDeCompra;
    }

    protected Oferta oferta;
    protected String idTransaccion;
    protected BilleteraVirtual billeteraVirtualvendedor;
    protected BilleteraVirtual billeteraVirutalComprador;
    protected LocalDate fechaCompletada;
    protected CriptoMoneda monedaComprada;
    protected Double cantidadComprada;
    protected double precio;

    protected Cliente autorDeCompra;

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



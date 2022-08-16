package Facturas;


import Entidades.Transaccion;

public abstract class Comprobante {


    protected String vendedor;
    protected String comprador;
    protected Double precioTotal;
    protected String fechaCompra;
    protected String fechaVencimiento;
    protected String nombreDeCriptoComprada;

    public abstract void mostrarComprobante();


}

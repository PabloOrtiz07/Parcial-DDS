package Facturas;

import Entidades.Transaccion;

public class Factura extends  Comprobante{

    private String correoElectronico;

    public  Factura(Transaccion transaccion) {
        this.vendedor = transaccion.getBilleteraVirtualvendedor().getIdBilleteraVirtual();
        this.comprador= transaccion.getBilleteraVirutalComprador().getIdBilleteraVirtual();
        this.fechaCompra= String.valueOf(transaccion.getFechaCompletada());
        this.precioTotal=transaccion.getPrecio();
        this.fechaVencimiento= String.valueOf((transaccion.getFechaCompletada().plusDays(30)));
        this.nombreDeCriptoComprada=transaccion.getMonedaComprada().getName();
        this.correoElectronico=transaccion.getAutorDeCompra().getCorreo();
    }

    public void mostrarComprobante() {
        System.out.println(this.vendedor);
        System.out.println(this.comprador);
        System.out.println(this.fechaCompra);
        System.out.println(this.precioTotal);
        System.out.println(this.fechaCompra);
        System.out.println(this.nombreDeCriptoComprada);
        System.out.println(this.correoElectronico);
        System.out.println(this.fechaVencimiento);
    }
}

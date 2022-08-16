package Facturas;

import Entidades.Transaccion;

public class Ticket extends Comprobante{


    public  Ticket(Transaccion transaccion) {
            this.vendedor = transaccion.getBilleteraVirtualvendedor().getIdBilleteraVirtual();
            this.comprador= transaccion.getBilleteraVirutalComprador().getIdBilleteraVirtual();
            this.fechaCompra= String.valueOf(transaccion.getFechaCompletada());
            this.precioTotal=transaccion.getPrecio();
            this.nombreDeCriptoComprada=transaccion.getMonedaComprada().getName();
    }


    @Override
    public void mostrarComprobante() {
        System.out.println(this.vendedor);
        System.out.println(this.comprador);
        System.out.println(this.fechaCompra);
        System.out.println(this.precioTotal);
        System.out.println(this.fechaCompra);
        System.out.println(this.nombreDeCriptoComprada);
    }
}

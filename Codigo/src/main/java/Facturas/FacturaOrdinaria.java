package Facturas;

import Entidades.Transaccion;

public class FacturaOrdinaria extends Factura{


    public  FacturaOrdinaria(Transaccion transaccion) {
            this.vendedor = transaccion.getBilleteraVirtualvendedor().getIdBilleteraVirtual();
            this.comprador= transaccion.getBilleteraVirutalComprador().getIdBilleteraVirtual();
            this.fechaCompra= String.valueOf(transaccion.getFechaCompletada());
            this.precioTotal=transaccion.getPrecio();
            this.fechaVencimiento= String.valueOf((transaccion.getFechaCompletada().plusDays(30)));
            this.nombreDeCriptoComprada=transaccion.getMonedaComprada().getName();
    }


}

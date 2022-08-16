package Facturas;

import Entidades.Transaccion;

public class FacturaOnline extends  Factura{

    private String correoElectronico;

    public  FacturaOnline(Transaccion transaccion) {
            this.vendedor = transaccion.getBilleteraVirtualvendedor().getIdBilleteraVirtual();
            this.comprador= transaccion.getBilleteraVirutalComprador().getIdBilleteraVirtual();
            this.fechaCompra= String.valueOf(transaccion.getFechaCompletada());
            this.precioTotal=transaccion.getPrecio();
            this.fechaVencimiento= String.valueOf((transaccion.getFechaCompletada().plusDays(30)));
            this.nombreDeCriptoComprada=transaccion.getMonedaComprada().getName();
            this.correoElectronico=transaccion.getAutorDeCompra().getCorreo();
    }
}

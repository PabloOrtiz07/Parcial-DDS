package Facturas;

import Entidades.Transaccion;


public class ComprobanteFabrica {
    public Comprobante crearComprobante(Integer tipoDeComprobante, Transaccion transaccion){
        switch (tipoDeComprobante) {
            case 0:
                return new Ticket(transaccion);
            case 1:
                return new Factura(transaccion);
            default:
                throw new IllegalArgumentException("tipo de factura desconocida "+tipoDeComprobante);
        }
    }
}

package Facturas;

import Entidades.Transaccion;

public class FacturaFabrica {
    public Factura crearFactura(Integer tipoDeFactura, Transaccion transaccion){
        switch (tipoDeFactura) {
            case 0:
                return new FacturaOnline(transaccion);
            case 1:
                return new FacturaOrdinaria(transaccion);
            default:
                throw new IllegalArgumentException("tipo de factura desconocida "+tipoDeFactura);
        }
    }
}

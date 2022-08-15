package FormaDePago;


import Entidades.BilleteraVirtual;

public abstract class MetodoDePago {

    private Double dineroEnCuenta;
    protected PagoStrategy pagoStrategy;

    protected MetodoDePago(){
        this.dineroEnCuenta = Math.floor((Math.random() * (15000 - 1500 + 1) + 1500));
    }
}



package FormaDePago;

import Entidades.BilleteraVirtual;

public class CuentaBancaria extends MetodoDePago{
    private String cbu;
    private String RazonSocial;
    private String nombreBanco;
    private Double dineroEnCuenta;

    public CuentaBancaria(String cbu, String RazonSocial, String nombreBanco) {
        super();
        this.cbu = cbu;
        this.RazonSocial = RazonSocial;
        this.nombreBanco = nombreBanco;
        this.pagoStrategy = new TransferenciaStrategy();
    }

    public void agregarDinero(double dineroTransferido){
        this.dineroEnCuenta += dineroTransferido;
    }
    public void pagar(){
        this.dineroEnCuenta -= 1;
    }
}

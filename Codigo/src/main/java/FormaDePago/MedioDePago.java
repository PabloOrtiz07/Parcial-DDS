package FormaDePago;

public abstract class MedioDePago {
    protected Double dineroEnCuenta;

    private boolean puedePagar(Double cantidad){
        return dineroEnCuenta >= cantidad;
    }
    public boolean enviarDinero(Double cantidad, CuentaBancaria cuentaDestino){
        if(puedePagar(cantidad)) {
            dineroEnCuenta -= cantidad;
            cuentaDestino.agregarDinero(cantidad);
            return true;
        }
        return false;
    }

}

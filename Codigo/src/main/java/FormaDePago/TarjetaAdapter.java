package FormaDePago;

public class TarjetaAdapter extends MedioDePago {
    Tarjeta tarjeta;
    @Override
    public boolean enviarDinero(Double cantidad, CuentaBancaria cuentaDestino){
        if(puedePagar(cantidad)) {
            tarjeta.pagar(cantidad);
            cuentaDestino.agregarDinero(cantidad);
            return true;
        }
        return false;
    }

    private boolean puedePagar(Double cantidad){
        return tarjeta.puedePagar(cantidad);
    }
}

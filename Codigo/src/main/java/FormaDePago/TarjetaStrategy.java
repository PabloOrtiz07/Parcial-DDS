package FormaDePago;

public class TarjetaStrategy extends PagoStrategy {
    @Override
    public boolean pagar(Double cantidad) {
        return false;
    }
}

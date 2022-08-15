package Estados;

import Entidades.Cliente;

public class NivelPlus extends NivelUsuario {

    public NivelPlus(Cliente cliente) {
        super(cliente);
    }

    @Override
    public double comisionPorVentaP2P(Double precioVenta){
        return precioVenta * 0.8;
    }
    @Override
    public double recargoPorCompraAlExchange(Double precioCompra){
        return precioCompra * 0.10;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0.02 * valorACambiar;
    }
}

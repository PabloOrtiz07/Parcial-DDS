package Estados;

import Entidades.Cliente;

public class NivelPremium extends NivelUsuario {

    public NivelPremium(Cliente cliente) {
        super(cliente);
    }

    @Override
    public double comisionPorVentaP2P(Double precioVenta){
        return precioVenta * 0.5;
    }
    @Override
    public double recargoPorCompraAlExchange(Double precioCompra){
        return precioCompra * 0.8;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0;
    }
}

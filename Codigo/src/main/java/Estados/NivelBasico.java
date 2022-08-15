package Estados;

import Entidades.Cliente;

public class NivelBasico extends NivelUsuario {

    public NivelBasico(Cliente cliente) {
        super(cliente);
    }

    @Override
    public double comisionPorVentaP2P(Double precioVenta){
        return precioVenta * 0.10;
    }
    @Override
    public double recargoPorCompraAlExchange(Double precioCompra){
        return precioCompra * 0.15;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0.05 * valorACambiar;
    }
}

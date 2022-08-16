package Estados;

import Entidades.Cliente;

public class NivelBasico extends NivelUsuario {

    @Override
    public double comisionPorVenta(Double precioVenta){
        return precioVenta * 0.10;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0.05 * valorACambiar;
    }
}

package Estados;

import Entidades.Cliente;

public class NivelPlus extends NivelUsuario {


    @Override
    public double comisionPorVenta(Double precioVenta){
        return precioVenta * 0.8;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0.02 * valorACambiar;
    }
}

package Estados;

import Entidades.Cliente;

public class NivelPremium extends NivelUsuario {

    @Override
    public double comisionPorVenta(Double precioVenta){
        return precioVenta * 0.5;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0;
    }
}

package Estados;

import Entidades.Cliente;

public abstract class NivelUsuario {

    public abstract double comisionPorVenta(Double precioVenta);
    public abstract double comisionPorConversionCriptomonedas(Double valorEnDolares);

}


package Estados;

public abstract class NivelUsuario {

    public abstract double comisionPorVenta(Double precioVenta);
    public abstract double comisionPorConversionCriptomonedas(Double valorEnDolares);

    public abstract boolean puedePasarDeNivel(int cantidadDeTransacciones);
    public abstract NivelUsuario getNivelSiguiente();
}


package Estados;

public class NivelPremium extends NivelUsuario {

    public double comisionPorVenta(Double precioVenta){
        return precioVenta * 0.5;
    }

    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0;
    }

    public boolean puedePasarDeNivel(int cantidadDeTransacciones){
        return false; //es el nivel maximo
    }
    public NivelUsuario getNivelSiguiente() {
        return null;
    }
}

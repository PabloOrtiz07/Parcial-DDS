package Estados;

public class NivelPlus extends NivelUsuario {
    public NivelUsuario getNivelSiguiente(){
        return new NivelPremium();
    }
    @Override
    public double comisionPorVenta(Double precioVenta){
        return precioVenta * 0.8;
    }
    @Override
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0.02 * valorACambiar;
    }
    public boolean puedePasarDeNivel(int cantidadDeTransacciones){
        return cantidadDeTransacciones > 50; //
    }
}

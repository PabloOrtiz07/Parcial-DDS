package Estados;

public class NivelBasico extends NivelUsuario {

    public NivelUsuario getNivelSiguiente(){
        return new NivelPlus();
    }
    public boolean puedePasarDeNivel(int cantidadDeTransacciones){
        return cantidadDeTransacciones > 10; //
    }
    public double comisionPorVenta(Double precioVenta){
        return precioVenta * 0.10;
    }
    public double comisionPorConversionCriptomonedas(Double valorACambiar){
        return 0.05 * valorACambiar;
    }
}

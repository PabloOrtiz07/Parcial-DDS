package FormaDePago;

public class CuentaBancaria extends MedioDePago {
    private String cbu;
    private String RazonSocial;
    private String nombreBanco;

    public CuentaBancaria(String cbu, String RazonSocial, String nombreBanco) {
        this.cbu = cbu;
        this.RazonSocial = RazonSocial;
        this.nombreBanco = nombreBanco;
        this.dineroEnCuenta = Math.floor(Math.random()*(10500-1000+1)+1000);
    }
    public void agregarDinero(Double cantidad){
        dineroEnCuenta += cantidad;
    }
}

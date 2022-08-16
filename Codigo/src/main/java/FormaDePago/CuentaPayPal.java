package FormaDePago;

public class CuentaPayPal extends MedioDePago {
    private String nombreUsuario;
    private String email;
    private Double dineroEnCuenta;

    public CuentaPayPal(String nombreUsuario, String email) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.dineroEnCuenta = Math.floor(Math.random()*(4000-800+1)+800);
    }
}

package FormaDePago;

public class CuentaPayPal extends MetodoDePago {
    String correo;
    String id;
    String nombre;
    String apellido;

    public CuentaPayPal(String correo, String id, String nombre, String apellido){
        super();
        this.correo = correo;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pagoStrategy = new TransferenciaStrategy();
    }
    public boolean pagar(){
        return true;
    }
}

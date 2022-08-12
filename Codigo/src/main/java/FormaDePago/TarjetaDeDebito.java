package FormaDePago;


public class TarjetaDeDebito extends FormasDePago {
    private Integer numeroTarjeta;
    private String titularTarjeta;
    private Boolean validarTarjeta;
    private String fechaInicio;
    private String fechaVencimiento;

    @Override
    public void ingresarDinero() {

    }
}

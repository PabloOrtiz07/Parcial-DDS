package FormaDePago;

public class TarjetaDeCredito implements FormasDePago{
    private Integer numeroTarjeta;
    private String titularTarjeta;
    private Boolean validarTarjeta;
    private String fechaInicio;
    private String fechaVencimiento;

    @Override
    public void ingresarDinero() {

    }
}

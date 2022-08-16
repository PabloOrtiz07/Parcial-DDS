package FormaDePago;

public class Tarjeta{
    Double limiteCompra;
    private String numeroTarjeta;
    private String cvv;
    private String titularTarjeta;
    private EmisorTarjeta emisor;
    private double recargo;

    public Tarjeta(String numeroTarjeta, String cvv, String titularTarjeta, String emisor) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.titularTarjeta = titularTarjeta;
        this.emisor = EmisorTarjeta.valueOf(emisor);
        this.limiteCompra = Math.floor(Math.random()*(7000-500+1)+1000);
        this.recargo = 1.05; //Al pagar la tarjeta cobra un 5% de comision
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

   public boolean puedePagar(Double cantidad){
        return cantidad * recargo <= limiteCompra;
   }
    public boolean pagar(Double cantidad){
        if(puedePagar(cantidad)) {
            limiteCompra -= cantidad * recargo;
            return true;
        }
        return false;
    }
}

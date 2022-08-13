package FormaDePago;

import Entidades.BilleteraVirtual;

public class DepositoBancario extends IngresoDeDinero{
    private String cbu;
    private String titularBanco;
    private String nombreBanco;

    public DepositoBancario(String cbu, String titularBanco, String nombreBanco) {
        this.cbu = cbu;
        this.titularBanco = titularBanco;
        this.nombreBanco = nombreBanco;
    }

    @Override
    public void ingresarDinero(BilleteraVirtual billeteraVirtual, Double montoIngresado) {
        System.out.println("Dinero ingresado satisfactoriamente: ");
        billeteraVirtual.ingresarDineroEnBilletera(montoIngresado);
    }
}

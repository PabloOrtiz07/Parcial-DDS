package Compra;

import Entidades.BilleteraVirtual;
import Entidades.CriptoMoneda;

public class CompraConCripto extends Compra  {
    private String nombreCripto;

    @Override
    public void comprar (BilleteraVirtual billeteraVirtual, CriptoMoneda criptoMoneda) throws Exception {
       if( billeteraVirtual.getCriptoMoneda(nombreCripto).precioCriptoMoneda()>criptoMoneda.precioCriptoMoneda()){
           billeteraVirtual.agregarMoneda(criptoMoneda);
           billeteraVirtual.cobrarCriptoDeBilletera(nombreCripto,criptoMoneda.precioCriptoMoneda());
       }else{
           System.out.println("No tenes saldo suficiente en las criptos");
       }
    }




    public CompraConCripto(String nombreCripto) {
        this.nombreCripto=nombreCripto;
    }
}

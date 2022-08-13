package Compra;

import Entidades.BilleteraVirtual;
import Entidades.CriptoMoneda;

public class CompraConDineroFiat extends Compra{



    public Boolean puedePagar(CriptoMoneda criptoMoneda,Double montoEnCuenta) throws Exception {
        if(criptoMoneda.precioCriptoMoneda()<montoEnCuenta){
            return true;
        }
        return false;
    }
    @Override
    public void comprar (BilleteraVirtual billeteraVirtual, CriptoMoneda criptoMoneda) throws Exception {
        if(this.puedePagar(criptoMoneda,billeteraVirtual.getDineroFiat())==true){
            System.out.println("Compra realizada");
            billeteraVirtual.cobrarDinero(criptoMoneda.precioCriptoMoneda());
            billeteraVirtual.agregarMoneda(criptoMoneda);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
}

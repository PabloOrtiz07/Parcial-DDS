package Compra;

import Entidades.BilleteraVirtual;
import Entidades.CriptoMoneda;

public class CompraConDineroFiat extends Compra{



    public Boolean puedePagar(CriptoMoneda criptoMoneda,Double montoEnCuenta) throws Exception {
        if(criptoMoneda.precioCriptoMoneda()>montoEnCuenta){
            return true;
        }
        return false;
    }
    @Override
    public void comprar (BilleteraVirtual billeteraVirtual, CriptoMoneda criptoMoneda) throws Exception {
        if(this.puedePagar(criptoMoneda,billeteraVirtual.getDineroFiat())==true){
            billeteraVirtual.agregarMoneda(criptoMoneda);
        }else{

        }
    }
}

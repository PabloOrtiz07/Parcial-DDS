package Compra;

import Entidades.BilleteraVirtual;
import Entidades.Transaccion;

public class FacadeTransaccion {
    public void realizarTransaccion(Transaccion transaccion){
        BilleteraVirtual comprador = transaccion.getBilleteraVirutalComprador();
        BilleteraVirtual vendedor = transaccion.getBilleteraVirutalComprador();
        Double precio = transaccion.getPrecio();
        comprador.retirarDolares(precio);
        
    }
}

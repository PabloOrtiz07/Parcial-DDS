package Compra;

import Entidades.BilleteraVirtual;
import Entidades.Transaccion;
import Repositorios.RepositorioBilleteras;
import Repositorios.RepositorioOfertas;

public class FacadeTransaccion {
    public void realizarTransaccion(Transaccion transaccion){
        RepositorioBilleteras repositorioBilleteras = RepositorioBilleteras.getInstance();
        RepositorioOfertas repositorioOfertas = RepositorioOfertas.getInstance();
        BilleteraVirtual comprador = transaccion.getBilleteraVirutalComprador();
        BilleteraVirtual vendedor = transaccion.getBilleteraVirutalComprador();
        Double precio = transaccion.getPrecio();
        comprador.agregarCripto(transaccion.getMonedaComprada(), transaccion.getPrecio());
        vendedor.retirarCripto(transaccion.getMonedaComprada(), transaccion.getPrecio());
        repositorioOfertas.eliminarOfertas(transaccion.getOferta());
    }
}

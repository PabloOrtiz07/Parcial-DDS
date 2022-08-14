package Compra;

import Entidades.BilleteraVirtual;
import Entidades.CriptoMoneda;

public abstract class Compra {


    public abstract void comprar (BilleteraVirtual billeteraVirtual, CriptoMoneda criptoMoneda) throws Exception;


}


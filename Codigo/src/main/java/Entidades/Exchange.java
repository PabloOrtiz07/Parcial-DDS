package Entidades;

import FormaDePago.CuentaBancaria;

public class Exchange {

    private static Exchange instance = null;

    public  static Exchange getInstance() {
        if (instance == null)
            instance = new Exchange();
        return instance;
    }

    private BilleteraVirtual billeteraVirtualExchange;
    private CuentaBancaria cuentaBancaria;
}

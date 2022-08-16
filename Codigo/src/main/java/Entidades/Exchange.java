package Entidades;

import FormaDePago.CuentaBancaria;

public class Exchange {
    private static Exchange instance = null;

    public static Exchange getInstance() {
        if (instance == null)
            instance = new Exchange();
        return instance;
    }
    private CuentaBancaria cuentaBancaria;

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }
}

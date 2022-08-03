package Entidades;


import java.util.*;

public class BilleteraVirtual {

    private Integer dineroFiat;
    private List<CriptoMoneda> criptoMonedas = new ArrayList<>();
    private List<Transaccion> transacciones = new ArrayList<>();

    public Integer getDineroFiat() {
        return dineroFiat;
    }

    public void setDineroFiat(Integer dineroFiat) {
        this.dineroFiat = dineroFiat;
    }

    public List<CriptoMoneda> getCriptoMonedas() {
        return criptoMonedas;
    }

    public void setCriptoMonedas(List<CriptoMoneda> criptoMonedas) {
        this.criptoMonedas = criptoMonedas;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }


}

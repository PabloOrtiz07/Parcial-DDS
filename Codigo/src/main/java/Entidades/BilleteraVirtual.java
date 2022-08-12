package Entidades;


import java.util.*;
import java.util.stream.Collectors;

public class BilleteraVirtual {

    private List<CriptoMoneda> criptoMonedas = new ArrayList<>();
    private List<Transaccion> transacciones = new ArrayList<>();


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

    public Double cotizarTotalEnDolares(){
        return this.criptoMonedas.stream().map(criptoMoneda -> {
            try {
                return criptoMoneda.precioCriptoMoneda();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.summingDouble(Double::doubleValue));
    }

    public void guardarCripto(CriptoMoneda criptoMoneda){
        this.criptoMonedas.add(criptoMoneda);
    }



}

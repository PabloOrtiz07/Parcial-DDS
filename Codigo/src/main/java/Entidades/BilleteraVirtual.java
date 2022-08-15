package Entidades;


import java.util.*;
import java.util.stream.Collectors;

public class BilleteraVirtual {

    private Double dolaresEnCuenta = 0.0;
    private HashMap<CriptoMoneda, Double> criptoMonedas = new HashMap<>();
    private List<Transaccion> transacciones = new ArrayList<>();
    private String idBilleteraVirtual;

    public String getIdBilleteraVirtual() {
        return idBilleteraVirtual;
    }

    public void setIdBilleteraVirtual(String idBilleteraVirtual) {
        this.idBilleteraVirtual = idBilleteraVirtual;
    }

    public void sumarDolaresEnCuenta( Double cantidadAgregada){
        dolaresEnCuenta += cantidadAgregada;
    }

    public void restarDolaresEnCuenta(Double cantidadARestar){
        if(dolaresEnCuenta >= cantidadARestar)
            dolaresEnCuenta-= cantidadARestar;
        else
            throw new RuntimeException("No Hay fondos disponibles de este moneda para realizar la transaccion");
    }

    public void sumarCriptomoneda(CriptoMoneda moneda, Double cantidadAgregada){
        Double valorActual = getCantidadCriptomoneda(moneda);
        criptoMonedas.put(moneda, valorActual + cantidadAgregada);
    }

    public void restarCriptomonedas(CriptoMoneda moneda, Double precioRestado){
        Double valorActual = getCantidadCriptomoneda(moneda);
        if(valorActual >= precioRestado)
            criptoMonedas.put(moneda, valorActual - precioRestado);
        else
            throw new RuntimeException("No Hay fondos disponibles de esta criptomoneda");
    }


    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void agregarTransaccion(Transaccion transaccion){
        this.transacciones.add(transaccion);
    }

    private double getCantidadCriptomoneda(CriptoMoneda moneda){
        Double cantidad = criptoMonedas.get(moneda);
        if(cantidad == null)
            return 0;
        else
            return cantidad;
    }


}

package Entidades;


import Repositorios.RepositorioOfertas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BilleteraVirtual {

    private Double dolaresEnCuenta = 0.0;
    private HashMap<CriptoMoneda, Double> criptoMonedasDisponibles = new HashMap<>();
    private HashMap<CriptoMoneda, Double> criptoMonedasEnOferta = new HashMap<>();
    private List<Transaccion> transacciones = new ArrayList<>();
    private List<Oferta> ofertas = new ArrayList<>();
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

    public boolean restarDolaresEnCuenta(Double cantidadARestar){
        if(dolaresEnCuenta >= cantidadARestar){
            dolaresEnCuenta -= cantidadARestar;
            return true;
        }
        return false;
    }

    public void sumarCriptomoneda(CriptoMoneda moneda, Double cantidadAgregada){
        Double valorActual = getCantidadCriptomoneda(criptoMonedasDisponibles, moneda);
        criptoMonedasDisponibles.put(moneda, valorActual + cantidadAgregada);
    }

    public void ofertarCriptomonedas(CriptoMoneda moneda, Double precioPorUnidad, double cantidadOfertada){
        Oferta oferta = new Oferta(this, moneda, precioPorUnidad, cantidadOfertada);
        RepositorioOfertas.getInstance().agregarOfertas(oferta);

    }
    public void venderCriptomonedaOfertada(CriptoMoneda moneda, Double precioRestado){
        Double valorActual = getCantidadCriptomoneda(criptoMonedasEnOferta, moneda);
        if(valorActual >= precioRestado)
            criptoMonedasEnOferta.put(moneda, valorActual - precioRestado);
        else
            throw new RuntimeException("No Hay fondos disponibles de esta criptomoneda");
    }


    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void agregarTransaccion(Transaccion transaccion){
        this.transacciones.add(transaccion);
    }

    private double getCantidadCriptomoneda(HashMap<CriptoMoneda, Double> hm,CriptoMoneda moneda){
        Double cantidad = hm.get(moneda);
        if(cantidad == null)
            return 0;
        else
            return cantidad;
    }

    public Double getDolaresEnCuenta() {
        return dolaresEnCuenta;
    }

    public void retirarDolares(Double dolarCobrado){
        this.dolaresEnCuenta=this.dolaresEnCuenta-dolarCobrado;
    }

    public Oferta buscadorDeOfertaDeCripto(CriptoMoneda criptoMonedaBuscada, Integer cantidadDeCriptoBuscada){
        return ofertas.stream().filter(oferta ->oferta.getNombreDeLaCripto().equals(criptoMonedaBuscada.getName())).findAny().get();
    }

    public Oferta buscadorDeOfertaDeCripto(CriptoMoneda criptoMonedaBuscada, Double cantidadDeCriptoBuscada){
        return ofertas.stream().filter(oferta ->oferta.getNombreDeLaCripto().equals(criptoMonedaBuscada.getName())).
                filter(oferta->oferta.getCantidadOfrecida()<=cantidadDeCriptoBuscada).findAny().get();
    }

}

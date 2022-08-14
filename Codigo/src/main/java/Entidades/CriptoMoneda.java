package Entidades;

import Apis.CriptoApiCalls;

public class CriptoMoneda {

    private String name;

    private Integer cantidad;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double precioCriptoMoneda() throws Exception {
        CriptoApiCalls criptoApiCalls = new CriptoApiCalls();
        return criptoApiCalls.obtenerPrecioCriptoMoneda(this.name)*this.cantidad;
    }

    public Double cantidadPorPrecioIndicado(Double precioIndicado) throws Exception {
        return precioCriptoMoneda()/precioIndicado;
    }

    public CriptoMoneda(String name, Integer cantidad) {
        this.name = name;
        this.cantidad = cantidad;
    }

    public  void  modificarCriptoCantidad(Double cantidadIndicada){
        this.cantidad=this.cantidad-cantidadIndicada;
    }

}

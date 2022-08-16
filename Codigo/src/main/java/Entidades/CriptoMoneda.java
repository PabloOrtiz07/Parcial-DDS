package Entidades;

import Apis.CriptoApiCalls;

public class CriptoMoneda {

    private String name;

    public CriptoMoneda(String name) {
        this.name = name;
    }
    public Double precioUnitario() throws Exception {
        CriptoApiCalls criptoApiCalls = new CriptoApiCalls();
        return criptoApiCalls.obtenerPrecioCriptoMoneda(this.name);
    }

    public Double cantidadComprable(Double dineroAGastar) throws Exception {
        return dineroAGastar/precioUnitario();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package Entidades;

import Estados.EstadosDeTransaccion;


public class Transaccion {
    private String idTransaccion;
    private EstadosDeTransaccion estadosDeTransaccion;
    private BilleteraVirtual origen;
    private BilleteraVirtual destino;
    private String fecha;

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public EstadosDeTransaccion getEstadosDeTransaccion() {
        return estadosDeTransaccion;
    }

    public void setEstadosDeTransaccion(EstadosDeTransaccion estadosDeTransaccion) {
        this.estadosDeTransaccion = estadosDeTransaccion;
    }

    public BilleteraVirtual getOrigen() {
        return origen;
    }

    public void setOrigen(BilleteraVirtual origen) {
        this.origen = origen;
    }

    public BilleteraVirtual getDestino() {
        return destino;
    }

    public void setDestino(BilleteraVirtual destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}

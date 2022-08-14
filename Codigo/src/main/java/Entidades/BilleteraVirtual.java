package Entidades;


import java.util.*;
import java.util.stream.Collectors;

public class BilleteraVirtual {

    private List<CriptoMoneda> criptoMonedas = new ArrayList<>();
    private List<Transaccion> transacciones = new ArrayList<>();

    private String idBilleteraVirtual;

    public String getIdBilleteraVirtual() {
        return idBilleteraVirtual;
    }

    public void setIdBilleteraVirtual(String idBilleteraVirtual) {
        this.idBilleteraVirtual = idBilleteraVirtual;
    }

    private Double dineroFiat;

    public Double getDineroFiat() {
        return dineroFiat;
    }

    public void setDineroFiat(Double dineroFiat) {
        this.dineroFiat = dineroFiat;
    }

    public BilleteraVirtual(String idBilleteraVirtual, Double plataEnCuenta) {
        this.idBilleteraVirtual = idBilleteraVirtual;
        this.dineroFiat=plataEnCuenta;
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

    public void agregarMoneda(CriptoMoneda criptoMoneda){
        this.criptoMonedas.add(criptoMoneda);
    }

    public void agregarTransaccion(Transaccion transaccion){
        this.transacciones.add(transaccion);
    }

    public void cobrarDinero(Double precioRestado){
        this.dineroFiat=this.dineroFiat-precioRestado;
    }

    public  void  ingresarDineroEnBilletera (Double dineroIngresado){
        this.dineroFiat=this.dineroFiat+dineroIngresado;
    }

    public CriptoMoneda getCriptoMoneda (String nombreCripto){
        return  this.criptoMonedas.stream().filter(criptoMoneda -> criptoMoneda.getName().equals(nombreCripto)).findAny().get();
    }

    public void  cobrarCriptoDeBilletera (String nombreDeCripto, Double montoIndicado) throws Exception {
        Double cantidad;
        CriptoMoneda criptoMoneda= getCriptoMoneda(nombreDeCripto);
        cantidad=criptoMoneda.cantidadPorPrecioIndicado(montoIndicado);
        criptoMoneda.modificarCriptoCantidad(cantidad);
        criptoMonedas.add(criptoMoneda);
    }

}

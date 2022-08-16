package Entidades;
import Estados.*;
import FormaDePago.CuentaBancaria;
import FormaDePago.CuentaPayPal;
import FormaDePago.MedioDePago;
import FormaDePago.Tarjeta;

import java.time.LocalDate;
import java.util.*;

public class Cliente {

    private NivelUsuario nivelUsuario;
    public Cliente(String nombre, String apellido, String dni, String correo, String nombreUsuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nivelUsuario = new NivelBasico();
        this.billeteraVirtual = new BilleteraVirtual();
        this.cantidadCompras = 0;
    }

    public String getDni() {
        return dni;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }

    private String nombre;
    private String apellido;
    private String dni;
    private int cantidadCompras;
    private LocalDate fechaNacimiento;
    private String correo;
    private String nombreUsuario;
    private String contrasenia;

    private List<Tarjeta> tarjetas = new ArrayList<>();
    private CuentaBancaria cuentaBancaria;
    private CuentaPayPal cuentaPayPal;
    private BilleteraVirtual billeteraVirtual;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public boolean cargarDolares(MedioDePago medioDePago, Double cantidad){
        CuentaBancaria cuentaBancariaExchange =  Exchange.getInstance().getCuentaBancaria();
        if(medioDePago.enviarDinero(cantidad,cuentaBancariaExchange)) {
            billeteraVirtual.sumarDolaresEnCuenta(cantidad);
            return true;
        }
        return false;
    }

    public boolean retirarDolares(Double cantidad){
        if(billeteraVirtual.restarDolaresEnCuenta(cantidad))
        {
            cuentaBancaria.agregarDinero(cantidad);
            return true;
        }
        return false;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaPaypal(CuentaPayPal cuentaPaypal){
        this.cuentaPayPal = cuentaPaypal;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    public boolean coincideContraseña(String contrasenia){
        return this.contrasenia.equals(contrasenia);
    }

    public void agregarCompra(){
        cantidadCompras++;
        if(nivelUsuario.puedePasarDeNivel(cantidadCompras)){
            nivelUsuario = nivelUsuario.getNivelSiguiente();
        }
    }
}

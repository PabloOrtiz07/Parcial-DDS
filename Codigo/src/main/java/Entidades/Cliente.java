package Entidades;
import Estados.*;
import FormaDePago.CuentaBancaria;
import FormaDePago.CuentaPayPal;
import FormaDePago.Tarjeta;

import java.time.LocalDate;
import java.util.*;;

public class Cliente {

    private NivelUsuario nivelUsuario;
    public Cliente(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String correo, String nombreUsuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nivelUsuario = new NivelBasico(this);
    }

    private String nombre;
    private String apellido;
    private String tipoDni;
    private String dni;
    private LocalDate fechaNacimiento;
    private String correo;
    private String nombreUsuario;
    private String contrasenia;

    private List<Tarjeta> tarjetas = new ArrayList<>();
    private CuentaBancaria cuentaBancaria;
    private CuentaPayPal cuentaPayPal;
    private BilleteraVirtual billeteraVirtual;
    private List<Cliente> referidos = new ArrayList<>();



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    public void setBilleteraVirtual(BilleteraVirtual billeteraVirtual) {
        this.billeteraVirtual = billeteraVirtual;
    }

    public List<Cliente> getReferidos() {
        return referidos;
    }

    public void setReferidos(List<Cliente> referidos) {
        this.referidos = referidos;
    }
}

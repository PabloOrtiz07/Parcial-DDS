package Entidades;

import java.util.*;

public class Cliente {
    private String nombre;
    private String apellido;
    private String correo;
    private String tipoDni;
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

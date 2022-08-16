package Repositorios;

import Entidades.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTransacciones {
    private static RepositorioTransacciones repositorioTransacciones = null;
    public static RepositorioTransacciones getInstance(){
        if(repositorioTransacciones == null){
            repositorioTransacciones = new RepositorioTransacciones();
        }
        return repositorioTransacciones;
    }
    private List<Transaccion> transacciones=new ArrayList<>();

    public void agregarTransaccion(Transaccion transaccion){
        transacciones.add(transaccion);
    }

    public Transaccion getTransaccionPorId(String idTransaccion){
        return transacciones.stream().filter(transaccion -> idTransaccion.equals(transaccion.getIdTransaccion())).findAny().get();
    }

}

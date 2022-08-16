package Repositorios;

import Entidades.Cliente;
import java.util.*;
public class RepositorioCliente {
    private static RepositorioCliente repositorioCliente = null;
    private List<Cliente> clientes = new ArrayList<>();


    public static RepositorioCliente getInstance() {
        if(repositorioCliente == null) {
            repositorioCliente = new RepositorioCliente();
        }
        return repositorioCliente;
    }

    public void agregarCliente(Cliente cliente) throws Exception {
        if(repositorioCliente.existeUsuarioConNombre(cliente.getNombre()))
            throw new Exception("Ya existe usuario con ese nombre");
        clientes.add(cliente);
    }

    public boolean existeUsuarioConNombre(String nombreCliente){
        return clientes.stream().anyMatch(cliente ->nombreCliente.equals(cliente.getNombre()));
    }

    public Cliente getClientePorNombre(String nombre) throws NoSuchElementException {
        return clientes.stream().filter(cliente ->nombre.equals(cliente.getNombre())).findAny().get();
    }
}

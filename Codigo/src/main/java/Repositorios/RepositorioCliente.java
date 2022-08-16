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
        if(repositorioCliente.existeUsuarioConNombre(cliente.getNombreUsuario()))
            throw new Exception("Ya existe usuario con ese nombre de usuario");
        clientes.add(cliente);
    }

    public boolean existeUsuarioConNombre(String nombreUsuarioCliente){
        return clientes.stream().anyMatch(cliente ->nombreUsuarioCliente.equals(cliente.getNombreUsuario()));
    }

    public Cliente getClientePorNombreUsuario(String nombreUsuario) throws NoSuchElementException {
        return clientes.stream().filter(cliente ->nombreUsuario.equals(cliente.getNombreUsuario())).findAny().get();
    }
}

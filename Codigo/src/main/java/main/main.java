package main;

import Compra.FacadeTransaccion;
import Entidades.BilleteraVirtual;
import Entidades.Cliente;
import Entidades.Oferta;
import Entidades.Transaccion;
import Repositorios.RepositorioBilleteras;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioOfertas;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {

        public static void main (String[] args) throws Exception {
            Scanner entrada = new Scanner(System.in);
            int seleccion;
            do{
                System.out.println("Menu principal: Ingrese el numero de la opcion que quiere realizar");
                System.out.println("0.Salir\n1.Loguearse con nombre y contraseña");
                seleccion = entrada.nextInt();
                switch (seleccion){
                    case 0:
                        System.out.println("Saliendo del programa");
                        break;
                    case 1:
                        login();
                        break;
                    default:
                        System.out.println("Operacion invalida");
                        break;
                }
            }while(seleccion != 0);
        }

    private static void login() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Login: ");
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        String contrasena = entrada.nextLine();

        RepositorioCliente repositorioCliente = RepositorioCliente.getInstance();
        try{
            Cliente cliente = repositorioCliente.getClientePorNombre(nombre);
            opcionesConCliente(cliente);
        }
        catch (NoSuchElementException e){
            System.out.println("No existe ese cliente");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void opcionesConCliente(Cliente cliente) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int seleccion;
        do{
            System.out.println("Menu de operaciones: Ingrese el numero de la opcion que quiere realizar");
            System.out.println("0.Salir\n1.Comprar Cripto\n2.Ingresar Dinero a cuenta");
            seleccion = entrada.nextInt();
            switch (seleccion){
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    comprarCriptoMoneda(cliente);
                    break;
                case 2:
                    cargarDineroACuenta();
                    break;
                default:
                    System.out.println("Operacion invalida");
                    break;
            }
        }while(seleccion != 0);
    }

    private static void comprarCriptoMoneda(Cliente cliente) throws Exception {
        RepositorioBilleteras repositorioBilleteras = new RepositorioBilleteras();
        BilleteraVirtual billeteraVirtual;
        String nombreCripto, idBilleteraCliente;
        Double cantidadDeCripto;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cripto moneda que desea comprar: ");
        nombreCripto = entrada.nextLine();
        System.out.println("Ingrese la cantidad que desea comprar: ");
        cantidadDeCripto= entrada.nextDouble();
        try {
            RepositorioOfertas repositorioOfertas = new RepositorioOfertas();
            Oferta oferta=repositorioOfertas.buscadorDeOfertaDeCripto(nombreCripto,cantidadDeCripto);
            Transaccion transaccion = new Transaccion(oferta,cliente.getBilleteraVirtual());
            FacadeTransaccion facadeTransaccion = new FacadeTransaccion();
            facadeTransaccion.realizarTransaccion(transaccion);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

    private static void cargarDineroACuenta() throws Exception {

    }

}

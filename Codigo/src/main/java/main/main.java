package main;

import Compra.FacadeTransaccion;
import ConexionBS.ClienteDAO;
import Entidades.BilleteraVirtual;
import Entidades.Cliente;
import Entidades.Oferta;
import Entidades.Transaccion;
import Estados.NivelBasico;
import Facturas.ComprobanteFabrica;
import Repositorios.RepositorioBilleteras;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioOfertas;

import java.util.NoSuchElementException;
import FormaDePago.CuentaBancaria;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int seleccion;
        do {
            System.out.println("Menu principal: Ingrese el numero de la opcion que quiere realizar");
            System.out.println("0.Salir\n1.Loguearse con nombre de usuario y contraseña\n2.Crear cuenta");
            seleccion = entrada.nextInt();
            switch (seleccion) {
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    registro();
                    break;
                default:
                    System.out.println("Operacion invalida");
                    break;
            }
        } while (seleccion != 0);
    }

    private static void login() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Login: ");
        System.out.println("Ingrese su nombre de usuario: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        String contrasena = entrada.nextLine();

        RepositorioCliente repositorioCliente = RepositorioCliente.getInstance();
        try {
            Cliente cliente = repositorioCliente.getClientePorNombreUsuario(nombre);
            if(cliente.coincideContraseña(contrasena))
                opcionesConCliente(cliente);
            else
                System.out.println("Contraseña incorrecta");
        } catch (NoSuchElementException e) {
            System.out.println("No existe ese cliente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registro(){
        ClienteDAO clienteDAO= new ClienteDAO();
        System.out.println("Registro: ");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = entrada.nextLine();
        System.out.println("Ingrese su dni: ");
        String dni = entrada.nextLine();
        System.out.println("Ingrese su correo: ");
        String correo = entrada.nextLine();
        System.out.println("Ingrese su nombreUsuario: ");
        String nombreUsuario = entrada.nextLine();
        System.out.println("Ingrese su contrasenia: ");
        String contrasenia = entrada.nextLine();
        Cliente cliente = new Cliente(nombre,apellido,dni,correo,nombreUsuario,contrasenia);
        RepositorioCliente repositorioCliente = RepositorioCliente.getInstance();
        try {
            repositorioCliente.agregarCliente(cliente);
            clienteDAO.registerCliente(cliente);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void opcionesConCliente (Cliente cliente) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int seleccion;
        do {
            System.out.println("Menu de operaciones: Ingrese el numero de la opcion que quiere realizar");
            System.out.println("0.Salir\n1.Comprar Cripto\n2.Ingresar Dinero a cuenta");
            seleccion = entrada.nextInt();
            switch (seleccion) {
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
        } while (seleccion != 0);
    }

    private static void comprarCriptoMoneda (Cliente cliente) throws Exception {
        RepositorioBilleteras repositorioBilleteras = new RepositorioBilleteras();
        BilleteraVirtual billeteraVirtualCliente = cliente.getBilleteraVirtual();
        String nombreCripto, idBilleteraCliente;
        Double cantidadDeCripto;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cripto moneda que desea comprar: ");
        nombreCripto = entrada.nextLine();
        System.out.println("Ingrese la cantidad que desea comprar: ");
        cantidadDeCripto = entrada.nextDouble();
        try {
            RepositorioOfertas repositorioOfertas = new RepositorioOfertas();
            Oferta oferta = repositorioOfertas.buscadorDeOfertaDeCripto(nombreCripto, cantidadDeCripto);
            Transaccion transaccion = new Transaccion(oferta, cliente);
            FacadeTransaccion facadeTransaccion = new FacadeTransaccion();
            facadeTransaccion.realizarTransaccion(transaccion);
            billeteraVirtualCliente.agregarTransaccion(transaccion);
            generarComprobante(transaccion);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void generarComprobante (Transaccion transaccion) throws Exception {
        Integer opcionesDeComprobantes;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Menu de Comprobantes. Ingrese el tipo de Comprobante que desea generar");
        System.out.println("0.Ticket \n1.Factura");
        opcionesDeComprobantes=entrada.nextInt();
        ComprobanteFabrica comprobanteFabrica = new ComprobanteFabrica();
        comprobanteFabrica.obtenerComprobante(opcionesDeComprobantes,transaccion);
    }

    private static void cargarDineroACuenta () throws Exception {

    }


}

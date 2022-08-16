package main;

import Entidades.BilleteraVirtual;
import Repositorios.RepositorioBilleteras;
import Repositorios.RepositorioOfertas;

import java.util.Scanner;

public class main {

        public static void main (String[] args) throws Exception {
            Scanner entrada = new Scanner(System.in);
            int seleccion;
            do{
                System.out.println("Menu inicio: Ingrese el numero de la opcion que quiere realizar");
                System.out.println("0.Salir\n1.Comprar Cripto\n2.Ingresar Dinero a cuenta");
                seleccion = entrada.nextInt();
                switch (seleccion){
                    case 0:
                        System.out.println("Saliendo del programa");
                        break;
                    case 1:
                        comprarCriptoMoneda();
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

        private static void comprarCriptoMoneda() throws Exception {
            RepositorioBilleteras repositorioBilleteras = new RepositorioBilleteras();
            BilleteraVirtual billeteraVirtual;
            String nombreCripto, idBilleteraCliente;
            Integer cantidadDeCripto;
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese la cripto moneda que desea comprar: ");
            nombreCripto = entrada.nextLine();
            System.out.println("Ingrese la cantidad que desea comprar: ");
            cantidadDeCripto= entrada.nextInt();
            try {
                RepositorioOfertas repositorioOfertas = new //
                        oferta=repositorioOfertas.asdfadsf(critp,cantidad)
                        transaccion(oferta,cliente.billetera)

            }catch (Exception e){
                System.out.println(e.getMessage());
            }



        }

    private static void cargarDineroACuenta() throws Exception {

    }


}

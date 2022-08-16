package main;

import Compra.CompraConDineroFiat;
import Compra.CompraConCripto;
import Entidades.BilleteraVirtual;
import Entidades.CriptoMoneda;
import Repositorios.RepositorioBilleteras;
//import FormaDePago.CuentaBancaria;
//import FormaDePago.IngresoDeDinero;
//import FormaDePago.Tarjeta;
//import FormaDePago.TarjetaDeDebito;

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
        }

    private static void cargarDineroACuenta() throws Exception {

    }


}

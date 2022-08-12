package main;

import Entidades.CriptoMoneda;

import java.util.Scanner;

public class main {

        public static void main (String[] args) throws Exception {
            Scanner entrada = new Scanner(System.in);
            int seleccion;
            do{
                System.out.println("Menu inicio: Ingrese el numero de la opcion que quiere realizar");
                System.out.println("0.Salir\n1.Comprar Cripto");
                seleccion = entrada.nextInt();
                switch (seleccion){
                    case 0:
                        System.out.println("Saliendo del programa");
                        break;
                    case 1:
                        comprarCriptoMoneda();
                        break;
                    default:
                        System.out.println("Operacion invalida");
                        break;
                }
            }while(seleccion != 0);
        }

        private static void comprarCriptoMoneda(){
            Scanner entrada = new Scanner(System.in);
            String nombre;
            Integer cantidad;

            System.out.println("Ingrese que cripto desea comprar: ");
            nombre = entrada.nextLine();
            System.out.println("Ingrese la cantidad: ");
            cantidad = Integer.valueOf(entrada.nextLine());
            CriptoMoneda criptoMoneda = new CriptoMoneda(nombre,cantidad);
            try {
                System.out.println("Precio total de la compra: "+criptoMoneda.precioCriptoMoneda());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


}

package main;

import Compra.Compra;
import Compra.CompraConDineroFiat;
import Entidades.BilleteraVirtual;
import Entidades.CriptoMoneda;
import Entidades.RepositorioBilleteras;
import FormaDePago.DepositoBancario;
import FormaDePago.IngresoDeDinero;
import FormaDePago.TarjetaDeCredito;
import FormaDePago.TarjetaDeDebito;

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
            Compra unaCompra;
            Scanner entrada = new Scanner(System.in);
            String nombre, idBilletera;
            Integer cantidad;
            System.out.println("Ingrese id de la billetera con la que va a realizar la compra: ");
            idBilletera = entrada.nextLine();
            try{
                System.out.println("La billtera ingresada es valida");
                BilleteraVirtual billeteraVirtual = repositorioBilleteras.getBilleteraVirtualPorId(idBilletera);
                System.out.println("Ingrese que cripto desea comprar: ");
                nombre = entrada.nextLine();
                System.out.println("Ingrese la cantidad a comprar: ");
                cantidad = entrada.nextInt();
                CriptoMoneda criptoMoneda = new CriptoMoneda(nombre,cantidad);
                System.out.println("Precio total a pagar "+criptoMoneda.precioCriptoMoneda());
                System.out.println("Ingrese el metodo de comprar la cripto: ");
                System.out.println("0.Comprar con fiat\n1.Comprar Cripto");
                int seleccion;
                seleccion = entrada.nextInt();
                switch (seleccion){
                    case 0:
                        unaCompra = new CompraConDineroFiat();
                        unaCompra.comprar(billeteraVirtual, criptoMoneda);
                        break;
                    case 1:
                        // comprarCriptoMoneda();
                        break;
                    default:
                        System.out.println("Operacion invalida");
                        break;
                }
            }catch (Exception e){
                System.out.println("No se encontro la billtera");
            }

        }

    private static void cargarDineroACuenta() throws Exception {
        IngresoDeDinero ingresoDeDineroDinero;
        String  idBilletera,numeroTarjeta, titular, fechaVencimiento,numeroCBU,numeroBanco;;
        Double dineroIndicado;
        RepositorioBilleteras repositorioBilleteras = new RepositorioBilleteras();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese id de la billetera en la que va a ingresar el dinero : ");
        idBilletera = entrada.nextLine();
        try{
            System.out.println("La billtera ingresada es valida");
            BilleteraVirtual billeteraVirtual = repositorioBilleteras.getBilleteraVirtualPorId(idBilletera);
            System.out.println("Ingrese la cantidad de dinero que desea ingresar ");
            dineroIndicado = entrada.nextDouble();
            System.out.println("Total a ingresar "+dineroIndicado);
            System.out.println("Ingrese el metodo para ingresar dinero a la cuenta: ");
            System.out.println("0.Ingresar con Tarjeta de credito\n1.Ingresar con Tarjeta de Debito\nIngresar con cuenta bancaria\n");
            int seleccion;
            seleccion = entrada.nextInt();
            switch (seleccion){
                case 0:
                    System.out.println("Ingrese numero de la tarjeta: ");
                    numeroTarjeta = entrada.nextLine();
                    System.out.println("Ingrese titular de la tarjeta: ");
                    titular = entrada.nextLine();
                    System.out.println("Ingrese fechaVencimiento: ");
                    fechaVencimiento = entrada.nextLine();
                    ingresoDeDineroDinero =  new TarjetaDeCredito(numeroTarjeta,titular,fechaVencimiento);
                    ingresoDeDineroDinero.ingresarDinero(billeteraVirtual,dineroIndicado);
                    break;
                case 1:
                    System.out.println("Ingrese numero de la tarjeta: ");
                    numeroTarjeta = entrada.nextLine();
                    System.out.println("Ingrese titular de la tarjeta: ");
                    titular = entrada.nextLine();
                    System.out.println("Ingrese fechaVencimiento: ");
                    fechaVencimiento = entrada.nextLine();
                    ingresoDeDineroDinero =  new TarjetaDeDebito(numeroTarjeta,titular,fechaVencimiento);
                    ingresoDeDineroDinero.ingresarDinero(billeteraVirtual,dineroIndicado);
                    break;
                case 2:
                    System.out.println("Ingrese el CBU: ");
                    numeroCBU = entrada.nextLine();
                    System.out.println("Ingrese titular del banco: ");
                    titular = entrada.nextLine();
                    System.out.println("Ingrese el nombre de la entidad: ");
                    numeroBanco = entrada.nextLine();
                    ingresoDeDineroDinero =  new DepositoBancario(numeroCBU,titular,numeroBanco);
                    ingresoDeDineroDinero.ingresarDinero(billeteraVirtual,dineroIndicado);
                    break;
                default:
                    System.out.println("Operacion invalida");
                    break;
            }
        }catch (Exception e){
            System.out.println("No se encontro la billtera");
        }
    }


}

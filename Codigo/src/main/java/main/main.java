package main;

import Apis.CriptoApiCalls;
import org.apache.commons.lang3.StringUtils;


import java.util.Scanner;

public class main {
    public static void main (String[] args) throws Exception {

        String nombre;
        CriptoApiCalls criptoApiCalls = new CriptoApiCalls();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese una criptoMoneda");
        nombre =entrada.nextLine();
        String nombreMiniscula = StringUtils.lowerCase(nombre);
        criptoApiCalls.obtenerCriptoMoneda(nombreMiniscula);

    }
}

package Entidades;

import Entidades.BilleteraVirtual;
import Estados.EstadosDeTransaccion;


public class Transaccion {
    private EstadosDeTransaccion estadosDeTransaccion;
    private BilleteraVirtual origen;
    private BilleteraVirtual destino;
    private String fecha;
}

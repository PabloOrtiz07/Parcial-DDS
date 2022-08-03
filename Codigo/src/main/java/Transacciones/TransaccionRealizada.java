package Transacciones;

public class TransaccionRealizada implements EstadosDeTransaccion {

    @Override
    public void masInformacion(){
        System.out.println("La Transaccion ha sido realizada con exito");
    }
}

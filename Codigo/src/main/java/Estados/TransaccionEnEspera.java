package Estados;

public class TransaccionEnEspera implements EstadosDeTransaccion {

    @Override
    public void masInformacion(){
        System.out.println("La Transaccion sigue en espera");
    }
}
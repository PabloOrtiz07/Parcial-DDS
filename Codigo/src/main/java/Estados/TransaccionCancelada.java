package Estados;

public class TransaccionCancelada implements EstadosDeTransaccion {

    @Override
    public void masInformacion(){
        System.out.println("La Transaccion ha sido cancelada");
    }
}

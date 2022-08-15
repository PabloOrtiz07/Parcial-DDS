package FormaDePago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class TransferenciaStrategy extends PagoStrategy {
    @Override
    public boolean pagar(Double cantidad) {

            System.out.println("Pagando " + cantidad + " mediante transferencia.");
            return true;
    }

}
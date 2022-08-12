package Apis;


import Apis.dto.CriptoResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;

public class CriptoApiCalls {

    public void obtenerCriptoMoneda(String nombre) throws Exception {
        WebClient clientUsers = WebClient.create("https://api.coingecko.com/api/v3/simple/price?ids="+nombre+"&vs_currencies=usd");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Response response = clientUsers
                .header("Content-Type", "application/json")
                .get();

        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 200) {
            System.out.println("response = " + responseBody);

            CriptoResponse criptoResponse =objectMapper.readValue(responseBody, CriptoResponse.class);
            System.out.println("Nombre "+criptoResponse.getName());

        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a /api/user");
        }
    }
}

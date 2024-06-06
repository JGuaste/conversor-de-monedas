import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda (String baseCode, String targetCode, double cantidadAConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f6d9f5ba3aad491afce1732b/pair/"+baseCode+"/"+targetCode+"/"+cantidadAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré ese código de moneda.");
        }
    }
}

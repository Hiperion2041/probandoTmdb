package tmb;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class tmbd2 {

    public static void main(String[] args) {
        // Tu clave de API de TMDb
        String apiKey = "c7139779b236be0110d8190a5e11fd53";

        // ID de la película de la que deseas obtener las listas
        int movieId = 968051; // Reemplaza con el ID de la película

        try {
            // Realiza una solicitud GET para obtener las listas de una película
            HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/movie/" + movieId + "/lists")
                    .queryString("api_key", apiKey)
                    .asJson();

            // Verifica si la solicitud fue exitosa
            if (response.getStatus() == 200) {
                // La respuesta contiene información sobre las listas de la película
                JsonNode listsInfo = response.getBody();

                // Puedes procesar la información de las listas aquí
                System.out.println("Listas de la película: " + listsInfo);
            } else {
                System.err.println("Error al realizar la solicitud: " + response.getStatusText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

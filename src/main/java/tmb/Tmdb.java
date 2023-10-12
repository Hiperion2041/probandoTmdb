package tmb;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

public class Tmdb {

    public static void main(String[] args) {
        // Tu clave de API de TMDb
        String apiKey = "c7139779b236be0110d8190a5e11fd53";
        String language = "es";

        try {
            // Realiza una solicitud GET para obtener una lista de películas populares
            HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/movie/"+968051)
                    .queryString("api_key", apiKey)
                    .queryString("language", language)
                    .asJson();

            // Verifica si la solicitud fue exitosa
            if (response.getStatus() == 200) {
                // Extrae la matriz de resultados (películas populares)
                //JSONArray results = response.getBody().getObject().getJSONArray("results");
            	
            	String des=response.getBody().getObject().getString("overview");
            	
            	System.out.println(des);
            	

                // Itera a través de las películas e imprime sus títulos
//                for (int i = 0; i < results.length(); i++) {
//                    JSONObject movie = results.getJSONObject(i);
//                    String title = movie.getString("title");
//                    System.out.println("Película " + (i + 1) + ": " + title);
//                }
            } else {
                System.err.println("Error al realizar la solicitud: " + response.getStatusText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
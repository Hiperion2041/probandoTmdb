package tmb;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

public class Tmdb {

    public static void main(String[] args) {
        // Tu clave de la API y lenguaje
        String apiKey = "c7139779b236be0110d8190a5e11fd53";
        String language = "es";

        try {
            // Realizo la solicitud a la api
        	//en caso de usar linea 26,34 cambiar a este http https://api.themoviedb.org/3/movie/popular
            HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/movie/"+968051)
                    .queryString("api_key", apiKey)
                    .queryString("language", language)
                    .asJson();

            // Verifica si la solicitud fue exitosa
            if (response.getStatus() == 200) {
                // Lo de abajo era para antes traer el resultado de las peliculas mas populares
                //JSONArray results = response.getBody().getObject().getJSONArray("results");
            	
            	//guardo la descripcion de la pelicula en la variable Des
            	String des=response.getBody().getObject().getString("overview");
            	
            	System.out.println(des);
            	

                // Imprimo los titulos de las peliculas mas populares, esto iria con el codigo de la linea 26 y se deberia modifcar la 18
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
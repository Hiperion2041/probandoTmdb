package tmb;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TmbdImg {

    public static void main(String[] args) {
        // Tu clave de API de TMDb
        String apiKey = "c7139779b236be0110d8190a5e11fd53";

        try {
            // Realiza una solicitud GET para obtener la información de una película específica
            HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/movie/"+968051)
                    .queryString("api_key", apiKey)
                    .asJson();

            // Verifica si la solicitud fue exitosa
            if (response.getStatus() == 200) {
                // La respuesta contiene información sobre la película
                JsonNode movieInfo = response.getBody();

                // Obtiene la ruta del póster de la película
                String imagePath = movieInfo.getObject().getString("poster_path");

                // Muestra la imagen del póster de la película
                displayImageFromUrl("https://image.tmdb.org/t/p/w500" + imagePath);
            } else {
                System.err.println("Error al realizar la solicitud: " + response.getStatusText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar la imagen desde la URL
    public static void displayImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);

            // Muestra la imagen en una ventana
            ImageIcon icon = new ImageIcon(image);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(400, 400);
            JLabel lbl = new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


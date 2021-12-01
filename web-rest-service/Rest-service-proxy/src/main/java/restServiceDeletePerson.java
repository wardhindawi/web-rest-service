import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class restServiceDeletePerson {

    public static void main(String[] args) {

        try {

            URL url = new URL("http://localhost:8080/RESTfulWebServicesSample/rest/persons/0");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == 204) {
                System.out.println("successful");
            } else if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            conn.disconnect();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}

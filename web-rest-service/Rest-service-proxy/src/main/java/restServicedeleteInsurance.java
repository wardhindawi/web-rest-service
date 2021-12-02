import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class restServicedeleteInsurance {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8080/RESTfulWebServicesSample/rest/insurances/96");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != 204 && conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            conn.disconnect();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}

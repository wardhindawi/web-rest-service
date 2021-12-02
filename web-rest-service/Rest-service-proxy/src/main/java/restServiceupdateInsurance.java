import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.home.restful.entity.Insurance;

public class restServiceupdateInsurance {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/RESTfulWebServicesSample/rest/insurances/updateInsurance/96");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Insurance insurance = new Insurance();
            insurance.setName("test test test test");
            String json = gson.toJson(insurance);

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            System.out.println(json);
        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}

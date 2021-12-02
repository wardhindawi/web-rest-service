import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.home.restful.entity.Insurance;

public class restServicegetAllInsurances {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080/RESTfulWebServicesSample/rest/insurances");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            Gson gson = new Gson();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            Insurance insurance = new Insurance();
            String output = br.readLine();

            Insurance insuranceArr = gson.fromJson(output, Insurance.class);

            System.out.println(insuranceArr);

            conn.disconnect();
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}

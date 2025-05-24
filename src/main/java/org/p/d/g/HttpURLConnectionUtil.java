package org.p.d.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpURLConnectionUtil {
    private static String deleteStatus = "pao9485989ff514b5106b77dan38850fd73c23e8c1e3f7gou";
    public static String getStatus(String urlString){
        URL url = null;
        try {
            url = new URL(urlString);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            if (responseCode == java.net.HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String result = response.toString();
                if(result.contains(deleteStatus)){
                    return "delete";
                }
            } else {
                return "neterror";
            }
        } catch (MalformedURLException | ProtocolException e) {
            return "neterror";
        } catch (IOException e) {
            return "neterror";
        }
        return "normal";
    }
}

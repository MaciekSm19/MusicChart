package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URI;

public class DatabaseOperations {
    HttpURLConnection connect() {
        HttpURLConnection connection = null;
        try {
            URI uri = new URI("https://raw.githubusercontent.com/mhollingshead/billboard-hot-100/main/recent.json");
            connection = (HttpURLConnection) uri.toURL().openConnection();

            if(connection.getResponseCode() != 200) throw new JSONFileNotFoundException();
        } catch (IOException | URISyntaxException | JSONFileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    JSONObject getJSONObject(HttpURLConnection connection) {
        StringBuilder stringBuilder = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) stringBuilder.append(line);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assert stringBuilder != null;
        return new JSONObject(stringBuilder.toString());
    }
}

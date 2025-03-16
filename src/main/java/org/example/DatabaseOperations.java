package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class DatabaseOperations {
    private final URI uri;

    public DatabaseOperations(String uri) {
        this.uri = URI.create(uri);
    }

    String fetchJson() throws IOException {
        return readInputStream(connect().getInputStream());
    }

     private HttpURLConnection connect() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            if(connection.getResponseCode() != 200) {
                throw new JSONFileNotFoundException();
            }
        } catch (IOException | JSONFileNotFoundException e) {
            System.out.println(e.getMessage());
        }
         return connection;
    }

    private String readInputStream(InputStream inputStream) {
        StringBuilder stringBuilder = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) stringBuilder.append(line);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return stringBuilder.toString();
    }
}

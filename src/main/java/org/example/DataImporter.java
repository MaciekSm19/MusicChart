package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class JsonDataImporter {
    private ObjectMapper mapper = null;
    private JsonNode jsonRoot = null;

    public DataImporter(String address) {
        try {
            URI uri = new URI(address);
            this.mapper = new ObjectMapper();
            this.jsonRoot = mapper.readTree(uri.toURL());
        } catch (IOException | URISyntaxException  e) {
            System.out.println(e.getMessage());
        }
    }

    String getPublishDate() {
        return jsonRoot.get("date").asText();
    }

    List<Song> getSongs() throws JsonProcessingException {
        return mapper.readValue(jsonRoot.get("data").toString(), new TypeReference<>(){});
    }
}

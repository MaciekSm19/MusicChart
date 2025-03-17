package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class DataImporter {
    private final ObjectMapper mapper;
    private final JsonNode jsonRoot;

    public DataImporter(String address) {
        try {
            URI uri = new URI(address);
            this.mapper = new ObjectMapper();
            this.jsonRoot = mapper.readTree(uri.toURL());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException();
        }
    }

    String getPublishDate() {
        return jsonRoot.get("date").asText();
    }

    List<Song> getSongs() {
        try {
            return mapper.readValue(jsonRoot.get("data").toString(), new TypeReference<>(){});
        } catch (JsonProcessingException e) {
           throw new RuntimeException();
        }
    }
}

package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SongResponseFactory {
    private final JsonDataImporter jsonDataImporter;

    public SongResponseFactory(JsonDataImporter jsonDataImporter) {
        this.jsonDataImporter = jsonDataImporter;
    }

    SongResponse createSongResponse() throws JsonProcessingException {
        return new SongResponse(
                jsonDataImporter.getPublishDate(),
                jsonDataImporter.getSongs()
        );
    }
}

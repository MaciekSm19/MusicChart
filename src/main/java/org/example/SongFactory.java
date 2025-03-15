package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongFactory {
    private final DatabaseOperations databaseOperations;

    public SongFactory() {
        this.databaseOperations = new DatabaseOperations("https://raw.githubusercontent.com/mhollingshead/billboard-hot-100/main/recent.json");
    }

    public SongResponse fetch() throws IOException {
        return createResponse(new JSONObject(this.databaseOperations.fetchJson()));
    }

    private SongResponse createResponse(JSONObject jsonObject) {
        return new SongResponse(
                jsonObject.getString("date"),
                parseSongs(jsonObject.getJSONArray("data"))
        );
    }

    private List<Song> parseSongs(JSONArray jsonSongs) {
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < jsonSongs.length(); i++) {
            songs.add(createSong(jsonSongs.getJSONObject(i)));
        }

        return songs;
    }

    private Song createSong(JSONObject song) {
        return new Song(
                song.getString("song"),
                song.getString("artist"),
                song.getInt("this_week"),
                getIntOrNull(song),
                song.getInt("peak_position"),
                song.getInt("weeks_on_chart")
        );
    }

    private Integer getIntOrNull(JSONObject song) {
        if (song.isNull("last_week")) {
            return null;
        }
        return song.getInt("last_week");
    }
}

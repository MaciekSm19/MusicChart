package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChartOperations {
    String dateOfPublication;
    DatabaseOperations databaseOperations;
    JSONObject database;
    JSONArray data;

    public ChartOperations(DatabaseOperations databaseOperations, JSONObject database) {
        this.databaseOperations = databaseOperations;
        this.database = database;
        dateOfPublication = database.getString("date");
        data = database.getJSONArray("data");
    }

    ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            String title = data.getJSONObject(i).getString("song");
            String artist = data.getJSONObject(i).getString("artist");
            Integer thisWeek = data.getJSONObject(i).getInt("this_week");
            Integer lastWeek = null;

            if (!data.getJSONObject(i).isNull("last_week")) lastWeek = data.getJSONObject(i).getInt("last_week");

            Integer peakPosition = data.getJSONObject(i).getInt("peak_position");
            Integer weeksOnChart = data.getJSONObject(i).getInt("weeks_on_chart");
            songs.add(new Song(title, artist, thisWeek, lastWeek, peakPosition, weeksOnChart));
        }
        return songs;
    }

    ArrayList<Song> getTopChartedSongs(int quantity, ArrayList<Song> songs) {
        ArrayList<Song> topChartedSongs = new ArrayList<>();
        for (int i = 0; i < quantity; i++) topChartedSongs.add(songs.get(i));
        return topChartedSongs;
    }
}

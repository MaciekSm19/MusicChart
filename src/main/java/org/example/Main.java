package org.example;

import org.json.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        JSONObject database = databaseOperations.getJSONObject(databaseOperations.connect());
        ChartOperations chartOperations = new ChartOperations(databaseOperations, database);

        ArrayList<Song> topChartedSongs = chartOperations.getTopChartedSongs(5, chartOperations.getSongs());
        topChartedSongs.forEach(song -> System.out.println(song.getThisWeek() + ". " + song.getTitle() + " - " + song.getArtist()));

        topChartedSongs = chartOperations.getTopChartedSongs(10, chartOperations.getSongs());
        topChartedSongs.forEach(song -> System.out.println(song.getThisWeek() + ". " + song.getTitle() + " - " + song.getArtist()));
    }
}


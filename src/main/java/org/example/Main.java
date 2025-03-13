package org.example;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        DatabaseOperations databaseOperations = new DatabaseOperations();
        JSONObject database = databaseOperations.getJSONObject(databaseOperations.connect());
        ChartOperations chartOperations = new ChartOperations(databaseOperations, database);

        System.out.print("How many top charted songs would you like to see? ");
        int input = scanner.nextInt();
        ArrayList<Song> topChartedSongs = chartOperations.getTopChartedSongs(input, chartOperations.getSongs());
        topChartedSongs.forEach(song -> System.out.println(song.getThisWeek() + ". " + song.getTitle() + " - " + song.getArtist()));
    }
}


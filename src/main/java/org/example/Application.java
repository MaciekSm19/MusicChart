package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    void run() {
        SongResponse allSongs = null;

        try {
            allSongs = new SongResponseFactory(
                    new JsonDataImporter("https://raw.githubusercontent.com/mhollingshead/billboard-hot-100/main/recent.json")).createSongResponse();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assert allSongs != null;
        System.out.println("The chart was last updated on " + allSongs.publishDate());
        System.out.print("How many top charted songs would you like to see? ");
        int amountOfSongs = new Scanner(System.in).nextInt();

        allSongs.songs()
                .stream()
                .limit(amountOfSongs)
                .map(this::formatSongListItem)
                .forEach(System.out::println);
    }

    private String formatSongListItem(Song song) {
        return song.this_week() + ". " + song.song() + " - " + song.artist();
    }
}

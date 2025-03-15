package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        SongResponse allSongs = new SongFactory().fetch();

        System.out.println("The chart was last updated on " + allSongs.publishDate());
        System.out.print("How many top charted songs would you like to see? ");
        int amountOfSongs = new Scanner(System.in).nextInt();

        allSongs.songs()
                .stream()
                .limit(amountOfSongs)
                .map(Main::formatSongListItem)
                .forEach(System.out::println);
    }

    private static String formatSongListItem(Song song) {
        return song.thisWeek() + ". " + song.title() + " - " + song.artist();
    }
}


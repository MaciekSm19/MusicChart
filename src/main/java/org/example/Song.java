package org.example;

public class Song {
    private final String title;
    private final String artist;
    private final Integer thisWeek;
    private final Integer lastWeek;
    private final Integer peakPosition;
    private final Integer weeksOnChart;

    public Song(String title, String artist, Integer thisWeek, Integer lastWeek, Integer peakPosition, Integer weeksOnChart) {
        this.title = title;
        this.artist = artist;
        this.thisWeek = thisWeek;
        this.lastWeek = lastWeek;
        this.peakPosition = peakPosition;
        this.weeksOnChart = weeksOnChart;
    }


    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getThisWeek() {
        return thisWeek;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", thisWeek=" + thisWeek +
                ", lastWeek=" + lastWeek +
                ", peakPosition=" + peakPosition +
                ", weeksOnChart=" + weeksOnChart +
                '}';
    }
}

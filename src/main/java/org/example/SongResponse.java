package org.example;

import java.util.List;

public record SongResponse(
        String publishDate,
        List<Song> songs) {}

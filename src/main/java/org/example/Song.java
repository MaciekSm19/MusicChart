package org.example;

public record Song (
    String title,
    String artist,
    Integer thisWeek,
    Integer lastWeek,
    Integer peakPosition,
    Integer weeksOnChart ) {}

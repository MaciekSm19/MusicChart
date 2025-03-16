package org.example;

public record Song (
    String song,
    String artist,
    Integer this_week,
    Integer last_week,
    Integer peak_position,
    Integer weeks_on_chart) {}

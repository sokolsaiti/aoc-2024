package me.saiti.day3;

import me.saiti.Puzzle;

import java.io.IOException;

public class Day3 implements Puzzle {
    private int result1 = 0;
    private int result2 = 0;

    @Override
    public void solve() throws IOException {

    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + "\n-----------\nPart 1: " + result1 + "\nPart 2: " + result2 + "\n";
    }


    private final String title = "Day 3";
}

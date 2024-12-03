package me.saiti;

import me.saiti.day1.Day1;
import me.saiti.day2.Day2;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Puzzle> puzzles = new ArrayList<>() {
            {

                add(new Day2());
                add(new Day1());
            }
        };

        for (Puzzle puzzle : puzzles) {
            try {
                puzzle.solve();
            } catch (Exception e) {
                System.err.println("There was a problem solving " + puzzle.getTitle() + "\n" + e.getMessage());
            }
        }
    }
}
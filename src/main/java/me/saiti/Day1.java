package me.saiti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Day1 implements Puzzle {
    public String getTitle() {
        return title;
    }

    private final String title = "Day 1";
    private ArrayList<Integer> left = new ArrayList<>();
    private ArrayList<Integer> right = new ArrayList<>();
    private Integer result1 = 0;
    private Integer result2 = 0;

    @Override
    public void solve() throws IOException {
        InputStream fileFromResources = Util.getFileFromResources("day1/input");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileFromResources));

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String[] fields = line.split("   ");
            left.add(Integer.parseInt(fields[0]));
            right.add(Integer.parseInt(fields[1]));
        }

        reader.close();
        left.sort(Comparator.naturalOrder());
        right.sort(Comparator.naturalOrder());

        for (int i = 0; i < left.size(); i++) {
            int distance = Math.abs(left.get(i) - right.get(i));
            int frequency = Collections.frequency(right, left.get(i));

            result1 = result1 + distance;
            result2 = result2 + (left.get(i) * frequency);
        }

        System.out.println(this);
    }

    @Override
    public String toString() {
        return title + "\n-----------\nPart 1: " + result1 + "\nPart 2: " + result2 + "\n";
    }
}

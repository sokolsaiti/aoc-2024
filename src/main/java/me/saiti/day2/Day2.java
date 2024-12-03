package me.saiti.day2;

import com.google.common.collect.Range;
import me.saiti.Puzzle;
import me.saiti.Util;

import java.io.IOException;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Gatherers.windowSliding;

public class Day2 implements Puzzle {


    private long result1 = 0;
    private long result2 = 0;


    @Override
    public void solve() throws IOException {
        ArrayList<List<Integer>> reports = new ArrayList<>();

        Scanner scanner = new Scanner(Util.getFileFromResources("day2/input"));
        while (scanner.hasNextLine()) {
            reports.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());
        }

        result1 = reports.stream().filter(this::part1).count();
        result2 = reports.stream().filter(this::part2).count();
        System.out.println(this);

    }

    private boolean part1(List<Integer> report) {
        Set<Integer> diffs = report.stream().gather(windowSliding(2)).map(window -> window.getLast() - window.getFirst()).collect(toSet());
        return Range.closed(1, 3).containsAll(diffs) || Range.closed(-3, -1).containsAll(diffs);
    }

    private boolean part2(List<Integer> line) {
        if (part1(line)) return true;
        return IntStream.range(0, line.size()).anyMatch(i -> {
            List<Integer> sublist = new ArrayList<>(line);
            sublist.remove(i);
            return part1(sublist);
        });
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + "\n-----------\nPart 1: " + result1 + "\nPart 2: " + result2 + "\n";
    }


    private final String title = "Day 2";

}


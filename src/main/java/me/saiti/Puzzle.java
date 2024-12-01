package me.saiti;

import java.io.IOException;

public interface Puzzle {
    void solve() throws IOException;
    String getTitle();
}

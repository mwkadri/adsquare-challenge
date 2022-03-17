package com.adsquare.example.reader;

import java.io.IOException;
import java.util.Collection;

public interface FileParser {
    void loadFile(String relativePath);
    Collection<Integer> getNextChunk() throws IOException;
}

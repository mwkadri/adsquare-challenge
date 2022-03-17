package com.adsquare.example.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class FileParserMock implements FileParser{
    private ArrayList<Collection<Integer>> chunks;
    private int nextChunkPointer;

    public FileParserMock(ArrayList<Collection<Integer>> chunks) {
        this.chunks = chunks;
    }

    @Override
    public void loadFile(String relativePath) {
        nextChunkPointer = 0;
    }

    @Override
    public Collection<Integer> getNextChunk() throws IOException {
        if(nextChunkPointer >= chunks.size()){
            return new ArrayList<>();
        }
        return chunks.get(nextChunkPointer++);
    }
}

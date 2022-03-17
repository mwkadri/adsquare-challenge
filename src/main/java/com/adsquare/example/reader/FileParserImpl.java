package com.adsquare.example.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class FileParserImpl implements FileParser {
    private final int chunkSize = 1000;
    BufferedReader br;

    @Override
    public void loadFile(String relativePath) {
        try
        {
            String filePath = new File("").getAbsolutePath();
            br = new BufferedReader(new FileReader(filePath + "/" + relativePath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Integer> getNextChunk() throws IOException {
        ArrayList<Integer> chunkedSection = new ArrayList<>();

        while(chunkedSection.size() < chunkSize){
            String line = br.readLine();
            if (line == null){
                break;
            }
            if(!line.trim().isEmpty()){
                Integer parsedNumber = Integer.valueOf(line.trim());
                chunkedSection.add(parsedNumber);
            }
        }

        return chunkedSection;
    }
}


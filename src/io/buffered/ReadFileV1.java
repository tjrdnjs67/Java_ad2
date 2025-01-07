package io.buffered;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class ReadFileV1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);

        long startMs = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = fis.read()) != -1){
            fileSize++;
        }
        fis.close();

        long endMs = System.currentTimeMillis();

        System.out.println("File created : " + FILE_NAME);
        System.out.println("File size : " + fileSize / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endMs - startMs) / 1000 + "s");
    }
}

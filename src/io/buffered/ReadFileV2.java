package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);

        long startMs = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int fileSize = 0;
        int size;
        while ((size = fis.read(buffer, 0, buffer.length)) != -1){
            fileSize += size;
        }
        fis.close();

        long endMs = System.currentTimeMillis();

        System.out.println("File created : " + FILE_NAME);
        System.out.println("File size : " + fileSize / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endMs - startMs) + "ms");
    }
}

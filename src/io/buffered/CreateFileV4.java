package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

/*
  파일입출력 최적화 1 : 하나씩 쓰기
  프로그램 걸린 시간 : 15초
 */

public class CreateFileV4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        long startMs = System.currentTimeMillis();

        byte[] buffer = new byte[FILE_SIZE];
        for(int i = 0; i < FILE_SIZE; i++){
            buffer[i] = 1;
        }
        fos.write(buffer);
        fos.close();

        long endMs = System.currentTimeMillis();

        System.out.println("File created : " + FILE_NAME);
        System.out.println("File size : " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endMs - startMs) + "ms");
    }
}

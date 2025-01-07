package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

/*
  파일입출력 최적화 2 : buffer 사용
  프로그램 걸린 시간 : 15 밀리초
 */

public class CreateFileV2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        long startMs = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bufferIndex = 0;

        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[bufferIndex++] = 1;

            // 버퍼가 가득 차면 쓰고, 버퍼를 비운다.
            if(bufferIndex == BUFFER_SIZE){
                fos.write(buffer);
                bufferIndex = 0;
            }
        }

        // 끝 부분에 오면 버퍼가 가득차지 않고, 남아 있을 수 있기 때문에 버퍼 남은 부분 쓰기
        if(bufferIndex > 0){
            fos.write(buffer, 0, bufferIndex);
        }

        fos.close();

        long endMs = System.currentTimeMillis();

        System.out.println("File created : " + FILE_NAME);
        System.out.println("File size : " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endMs - startMs) + "ms");
    }
}

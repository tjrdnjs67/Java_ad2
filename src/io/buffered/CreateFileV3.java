package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

/*
  파일입출력 최적화 3 : Buffered 스트림 쓰기
  프로그램 걸린 시간 : 134 밀리초
  멀티스레드 환경을 고려해서 만든 클래스이기 때문에 싱글스레드 환경에서는 buffer를 직접 만드는 것이 성능상 더 좋을 수 있다.
 */

public class CreateFileV3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);

        long startMs = System.currentTimeMillis();

        for(int i = 0; i < FILE_SIZE; i++){
            bos.write(1);
        }

        bos.close();

        long endMs = System.currentTimeMillis();

        System.out.println("File created : " + FILE_NAME);
        System.out.println("File size : " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endMs - startMs) + "ms");
    }
}

package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat"); // 파일이 없으면 만들고 false(=default)이면 내용은 지우고 다시 저장
        byte[] input = {65, 66, 67};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        int readCount = fis.read(buffer, 1, 9);

        System.out.println("readCount = " + readCount);
        System.out.println(Arrays.toString(buffer));

        fis.close();
    }
}

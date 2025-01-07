package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false); // 파일이 없으면 만들고 false(=default)이면 내용은 지우고 다시 저장
        // FileOutputStream fos = new FileOutputStream("temp/hello.dat", true); 파일이 없으면 만들고 true 이면 내용을 지우지 않고 끝에 추가하여 저장
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");

        int data;
        while( (data = fis.read()) != -1 ){
            System.out.println(data);
        }

        fis.close();
    }
}

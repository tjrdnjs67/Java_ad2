package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;


public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC가";
        System.out.println("write String : " + writeString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        fw.write(writeString);
        fw.close();

        // 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        int ch;
        while( (ch = fr.read()) != -1 ){
            content.append((char) ch);
        }
        fr.close();

        String str = content.toString();
        System.out.println("read String : " + str);
    }
}

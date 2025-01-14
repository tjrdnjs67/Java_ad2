package io.streams;

import java.io.*;

public class DataStreamEtcMain {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/data.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원A");
        dos.writeInt(20); // 진짜 숫자 int를 저장 4bytes (자바가 20을 저장하는 바이트 그대로 저장하기 때문에 파일에서 읽을 수 없음)
        dos.writeDouble(10.5); // 8bytes
        dos.writeBoolean(true); // 1byte
        dos.close();

        // 데이터 읽기
        FileInputStream fis = new FileInputStream("temp/data.dat");
        DataInputStream dis = new DataInputStream(fis);
        // WARNING. 읽을 때 저장한 순서대로 읽어야 함
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        dis.close();
    }
}

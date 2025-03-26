package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결 : " + socket);

        // 외부에 데이터 보낼 때 socket.getOutputStream();
        // 서버에게 문자 보내기
        String toSend = "Hello";
        output.writeUTF(toSend);
        log("client -> server : " + toSend);

        // 외부에서 데이터를 받을 때 socket.getInputStream();
        // 서버로부터 문자 받기
        String received = input.readUTF();
        log("client <- server : " + received);

        // 자원 정리
        input.close();
        output.close();
        socket.close();


    }
}

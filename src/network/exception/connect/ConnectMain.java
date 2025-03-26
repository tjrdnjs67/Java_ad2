package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

    public static void main(String[] args) throws IOException {
        unknownHostEx1();
        unknownHostEx2();
        connectionRefused();
    }

    /*  호스트를 알 수 없음
        1. 999.999.999.999 : 이런 IP는 존재하지 않음
        2. google.gogo : 이런 도메인 이름은 존재하지 않음
     */
    private static void unknownHostEx1() throws IOException {
        try{
            Socket socket = new Socket("999.999.999.999", 80);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }

    private static void unknownHostEx2() throws IOException {
        try{
            Socket socket = new Socket("google.gogo", 80);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }

    /*  Connection refused
        - 연결이 거절되었다는 것은, 네트워크를 통해 해당 IP의 서버 컴퓨터에 접속했다는 뜻
        이유
            - IP에 해당하는 서버는 켜져있지만, 사용하는 PORT가 없을 때 주로 발생
            - 네트워크 방화벽 등에서 무단 연결로 인지하고 연결을 막을 때도 발생
        과정
            - 서버 컴퓨터의 OS는 거절할 때 RST(Reset) 패킷을 보내서 연결을 거절
            - 클라이언트가 연결 시도 중 RST 패킷을 받으면 이 예외가 발생
     */
    private static void connectionRefused() throws IOException {
        try{
            Socket socket = new Socket("localhost", 45678);
        }catch (ConnectException e){
            e.printStackTrace();
        }
    }

}

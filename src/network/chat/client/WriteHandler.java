package network.chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable{

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    private boolean closed = false; // 기본 값 : false

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try{
            // 이름 입력
            String username = inputUserName(scanner);

            // 서버 측에 접속 알림
            output.writeUTF("/join" + DELIMITER + username);

            while(true){
                String toSend = scanner.nextLine(); // 블로킹
                if(toSend.isEmpty()){
                    continue;
                }

                if(toSend.equals("/exit")){
                    output.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하면 명령어, 나머지는 일반 메시지
                if(toSend.startsWith("/")){
                    // "/users", "/change" 등
                    output.writeUTF(toSend);
                }else{
                    output.writeUTF("/message" + DELIMITER + toSend);
                }

            }

        }catch (IOException | NoSuchElementException e){ // NoSuchElementException : Scanner의 System.in을 close 해버리면 해당 예외 발생
            log(e);
        }finally {
            client.close();
        }
    }

    private static String inputUserName(Scanner scanner) {
        System.out.println("이름을 입력하세요.");

        // 이름 입력
        String username;
        do{
            username = scanner.nextLine();
        }while(username.isEmpty());

        return username;
    }

    public synchronized void close(){
        if(closed){
            return;
        }

        try {
            System.in.close(); // Scanner 입력 중지
        }catch (IOException e){
            log(e);
        }

        closed = true;
        log("WriteHandler 종료");

    }
}

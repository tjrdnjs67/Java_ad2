package was.v2_0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class Server {

    private final int PORT;
    private final SessionManager sessionManager;

    private ServerSocket serverSocket;

    public Server(int PORT, SessionManager sessionManager){
        this.PORT = PORT;
        this.sessionManager =sessionManager;
    }

    public void start() throws IOException {
        log("서버 시작");

        serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트 : " + PORT);

        // 셧다운 훅 등록
        addShutdownHook();
        // 프로그램 작동
        running();

    }

    private void addShutdownHook() {
        ShutdownHook target = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(target, "shutdown"));
    }

    private void running() {
        try{
            while(true){
                Socket socket = serverSocket.accept();
                log("소켓 연결 : " + socket);

                Session session = new Session(socket, sessionManager);
                Thread thread = new Thread(session);

                thread.start();
            }
        }catch(IOException e){
            log("서버 소켓 종료 : " + e);
        }
    }

    private class ShutdownHook implements Runnable{

        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        public ShutdownHook(ServerSocket serverSocket, SessionManager sessionManager){
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("shutdownHook 실행");

            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000); // 자원 정리 대기
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error = " + e);
            }
        }
    }
}

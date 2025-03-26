package network.tcp;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class SocketCloseUtil {

    public static void closeAll(Socket socket, InputStream input, OutputStream output){
        close(input);
        close(output);
        close(socket);
    }

    public static void closeAll(Socket socket, BufferedReader reader, PrintWriter writer){
        close(reader);
        close(writer);
        close(socket);
    }

    public static void close(InputStream input) {
        if(input != null){
            try{
                input.close();
            }catch(IOException e){
                log(e.getMessage());
            }
        }
    }

    public static void close(OutputStream output) {
        if(output != null){
            try{
                output.close();
            }catch(IOException e){
                log(e.getMessage());
            }
        }
    }

    public static void close(Socket socket) {
        if(socket != null){
            try{
                socket.close();
            }catch(IOException e){
                log(e.getMessage());
            }
        }
    }

    public static void close(BufferedReader reader) {
        if(reader != null){
            try{
                reader.close();
            }catch(IOException e){
                log(e.getMessage());
            }
        }
    }

    public static void close(PrintWriter writer) {
        if(writer != null){
            writer.close();
        }
    }


}

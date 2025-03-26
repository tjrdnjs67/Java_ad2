package network.chat.server.command;

import network.chat.server.Session;

import java.io.IOException;

public class ExitCommand implements Command{

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}

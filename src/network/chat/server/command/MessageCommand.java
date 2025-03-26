package network.chat.server.command;

import network.chat.server.Session;
import network.chat.server.SessionManager;

import java.io.IOException;

public class MessageCommand implements Command{

    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUsername() + "] " + message);
    }
}

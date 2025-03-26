package was.v2_0;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session){
        sessions.add(session);
    }

    public synchronized void remove(Session session){
        sessions.remove(session);
    }

    public synchronized void closeAll(){
        for (Session session : sessions) {
            session.close();
        }

        sessions.clear();
    }

}

package vslab2.src.Log;

import java.util.ArrayList;
import java.util.List;

public class ServerLogs {
    private List<ServerLog> logs = null;

    public ServerLogs() {
        logs = new ArrayList<ServerLog>();
    }

    public void addLog(ServerLog log) {
        if (log != null) {
            logs.add(log);
        }
    }

    public List<ServerLog> getServerLogs() {
        return logs;
    }
}

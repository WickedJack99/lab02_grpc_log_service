package vslab2.src.input;

public class ClientInformation {
    private String userId = null;

    private String serverIP = null;
    private int serverPort = 0;

    public synchronized String getUserId() {
        return userId;
    }

    public synchronized void setUserId(String userId) {
        this.userId = userId;
    }

    public synchronized String getServerIP() {
        return serverIP;
    }

    public synchronized void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public synchronized int getServerPort() {
        return serverPort;
    }

    public synchronized void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}

package vslab2.src.Log;

public class ServerLog {
    private static int rowNumberCounter = 0;

    private int rowNumber = 0;
    private String userID = null;
    private String logText = null;

    public ServerLog(String userID, String logText) {
        rowNumber = rowNumberCounter++;
        if (userID != null) {
            this.userID = userID;
        } else {
            this.userID = "undefined";
        }
        if (logText != null) {
            this.logText = logText;
        } else {
            this.logText = "undefined";
        }
    }

    public static int getRowNumberCounter() {
        return rowNumberCounter;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public String getUserID() {
        return userID;
    }

    public String getLogText() {
        return logText;
    }
}

package vslab2.src.input.commands;

public class Constants {
    public static final int COMMAND = 0;
    public static final int LOG_TEXT = 1;

    public static final String ADD_LOG = "AddLog";
    public static final String GET_LOG = "GetLog";
    public static final String LISTEN_LOG = "ListenLog";
    public static final String UNLISTEN_LOG = "UnlistenLog";
    public static final String HELP = "Help";
    public static final String EXIT = "Exit";

    public static final String[] COMMANDS = {
        "AddLog <LogText> // Add entry to log",
        "GetLog           // Get whole log at once",
        "ListenLog        // Subscribe to log stream",
        "UnlistenLog      // Unsubscribe from log stream",
        "Help             // Show help",
        "Exit             // Exit application"
    };
}

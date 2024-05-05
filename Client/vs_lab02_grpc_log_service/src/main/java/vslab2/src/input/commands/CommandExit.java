package vslab2.src.input.commands;

import vslab2.src.request.queues.RequestQueue;

public class CommandExit implements Executable {

    @Override
    public void execute(RequestQueue requestQueue) {
        // TODO stopp all threads.
    }

    @Override
    public ECommandType getType() {
        return ECommandType.UnlistenLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
    
}

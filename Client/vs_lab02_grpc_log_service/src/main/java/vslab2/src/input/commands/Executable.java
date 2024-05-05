package vslab2.src.input.commands;

import vslab2.src.request.queues.RequestQueue;

public interface Executable {
    public void execute(RequestQueue requestQueue);
    public ECommandType getType();
    public int getTypeId();
    public String toString();
}

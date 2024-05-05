package vslab2.src.input.commands;

import vslab2.src.request.queues.RequestQueue;

public class CommandHelp implements Executable {

    @Override
    public void execute(RequestQueue requestQueue) {
        System.out.println("-----------------------------------------------");
        System.out.println("Available commands:");
        for (String command : Constants.COMMANDS) {
            System.out.println(command);
        }
    }

    @Override
    public ECommandType getType() {
        return ECommandType.Help;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }

    
    
}

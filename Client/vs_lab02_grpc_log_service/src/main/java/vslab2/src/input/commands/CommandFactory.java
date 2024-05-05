package vslab2.src.input.commands;

import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.input.ClientInformation;

public class CommandFactory {
    /**
     * Creates command from given string which contains command name and arguments.
     * @param commandString string which contains command and arguments.
     * @return executable command.
     */
    public static Executable createCommandFromString(String commandString, ClientInformation clientInformation, GRPCInformation grpcInformation) {

        String[] commandStringParts = commandString.split(" ");

        String command = commandStringParts[Constants.COMMAND];

        switch (command) {
            case (Constants.ADD_LOG): {
                return new CommandAddLog(commandStringParts[Constants.LOG_TEXT], clientInformation, grpcInformation);
            }
            
            case (Constants.GET_LOG): {
                return new CommandGetLog(grpcInformation);
            }

            case (Constants.LISTEN_LOG): {
                return new CommandListenLog(clientInformation, grpcInformation);
            }

            case (Constants.UNLISTEN_LOG): {
                return new CommandUnlistenLog(clientInformation, grpcInformation);
            }

            case (Constants.HELP): {
                return new CommandHelp();
            }

            case (Constants.EXIT): {
                return new CommandExit();
            }
        
            default: {
                System.err.println("Error at CommandFactory:createCommandFromString, unknown command: " + command);
            }break;
        }

        return null;
    }
}

package vslab2.src.input;

import java.util.Scanner;

import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.input.commands.CommandFactory;
import vslab2.src.input.commands.Executable;
import vslab2.src.request.queues.RequestQueue;

public class InputThread extends Thread{
    private boolean inputThreadRunning = false;

    private ClientInformation clientInformation = null;
    private GRPCInformation grpcInformation = null;

    private RequestQueue requestQueue = null;

    public InputThread(ClientInformation clientInformation, GRPCInformation grpcInformation, RequestQueue requestQueue) {
        inputThreadRunning = true;
        this.clientInformation = clientInformation;
        this.requestQueue =  requestQueue;
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void run() {

        Scanner inputScanner = new Scanner(System.in);
        setUserId(inputScanner);
        setServerInformation(inputScanner);
        grpcInformation.initializeStub(clientInformation.getServerIP(), clientInformation.getServerPort());

        while (inputThreadRunning) {
            System.out.println("-------------------------------------------------");
            System.out.println("Enter command:");
            String inputString = null;
            try {
                inputString = inputScanner.nextLine();
            } catch (Exception e) {
                System.err.println("Error at InputThread:run, unable to resolve command from input scanner.");
            }
            if ((inputString != null) && (!inputString.equals(""))) {
                Executable command = CommandFactory.createCommandFromString(inputString, clientInformation, grpcInformation);
                if (command != null) {
                    command.execute(requestQueue);
                }
            }
        }
        inputScanner.close();
    }

    private void setUserId(Scanner inputScanner) {
        boolean validUserId = false;
        while (!validUserId) {
            System.out.println("-----------------------------------------------");
            System.out.println("Enter user id:");
            try {
                clientInformation.setUserId(inputScanner.nextLine());
                validUserId = true;
            } catch (Exception e) {
                System.err.println("Error: re-enter user id:");
            }
        }
    }

    private void setServerInformation(Scanner inputScanner) {
        boolean validIP = false;
        boolean validPort = false;

        while (!(validIP || validPort)) {
            System.out.println("-----------------------------------------------"); 
            System.out.println("Enter IP of server:");
            String ip = null;
            try {
                ip = inputScanner.nextLine();
                validIP = true;
            } catch (Exception e) {
                System.err.println("Error: enter ip in format x.x.x.x");
                validIP = false;
            }
            
            System.out.println("-----------------------------------------------"); 
            System.out.println("Enter Port of server:");
            int port = -1;
            try {
                port = Integer.valueOf(inputScanner.nextLine());
                validPort = (port > 0);
            } catch (Exception e) {
                System.err.println("Error: enter number.");
                validPort = false;
            }
            if (validIP && validPort) {
                clientInformation.setServerIP(ip);
                clientInformation.setServerPort(port);
            }
        }
    }
}

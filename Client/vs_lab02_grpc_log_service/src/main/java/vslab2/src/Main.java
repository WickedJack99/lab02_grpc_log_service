package vslab2.src;

import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.input.ClientInformation;
import vslab2.src.input.InputThread;
import vslab2.src.request.RequestExecuterThread;
import vslab2.src.request.queues.RequestQueue;

public class Main {
    public static void main(String[] args) {

        RequestQueue requestQueue = new RequestQueue();

        ClientInformation clientInformation = new ClientInformation();
        GRPCInformation grpcInformation = new GRPCInformation();

        RequestExecuterThread requestExecuterThread = new RequestExecuterThread(requestQueue);
        requestExecuterThread.start();

        InputThread inputThread = new InputThread(clientInformation, grpcInformation, requestQueue);
        inputThread.start();

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error in Main:main, inputThread was interrupted, before join.");
        }
        try {
            requestExecuterThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error in Main:main, requestExecuterThread was interrupted, before join.");
        }
    }
}
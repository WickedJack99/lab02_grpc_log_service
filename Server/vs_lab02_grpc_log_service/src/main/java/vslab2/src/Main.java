package vslab2.src;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import vslab2.src.Log.LogService;

public class Main {
    public static void main(String[] args) { 
        Server server = ServerBuilder.forPort(9090).addService(new LogService()).build();

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server is online at port: " + server.getPort());

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
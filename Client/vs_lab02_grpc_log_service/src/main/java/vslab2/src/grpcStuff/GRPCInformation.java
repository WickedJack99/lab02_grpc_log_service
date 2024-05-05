package vslab2.src.grpcStuff;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Log;
import vslab2.src.grpc.LogServiceGrpc;
import vslab2.src.response.observers.AddLogEmptyResponseObserver;

public class GRPCInformation {
    private LogServiceGrpc.LogServiceStub stub = null;

    private StreamObserver<Log> addLogStreamRequestObserver = null;

    public void initializeStub(String serverIP, int serverPort) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverIP, serverPort)
                .usePlaintext()
                .build();
        stub = LogServiceGrpc.newStub(channel);
    }

    public LogServiceGrpc.LogServiceStub getStub() {
        return stub;
    }

    public synchronized StreamObserver<Log> getAddLogStreamObserver() {
        return addLogStreamRequestObserver;
    }

    public synchronized void initializeAddLogStreamObserver() {
        this.addLogStreamRequestObserver = stub.addLog(new AddLogEmptyResponseObserver());
    }
}

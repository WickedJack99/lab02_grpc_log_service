package vslab2.src.User;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Log;

public class LogUser {
    private String id = null;

    private StreamObserver<Log> userResponseStreamObserver = null;

    public LogUser(String id, StreamObserver<Log> observer) {
        this.id = id;
        this.userResponseStreamObserver = observer;
    }
    
    public boolean equals(LogUser other) {
        return this.id.equals(other.id);
    }

    public StreamObserver<Log> getStreamObserver() {
        return userResponseStreamObserver;
    }
}

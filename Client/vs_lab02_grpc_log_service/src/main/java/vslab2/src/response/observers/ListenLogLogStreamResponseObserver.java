package vslab2.src.response.observers;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Log;

public class ListenLogLogStreamResponseObserver implements StreamObserver<Log> {

    @Override
    public void onNext(Log log) {
        System.out.println("-------------------------------------------------");
        System.out.println("Received new log:");
        System.out.println("| Row number\t| User Id\t| Text\t\t|");
        System.out.println("| " + log.getRowNumber() + "\t| " + log.getUserId() + "\t| " + log.getText() + "\t\t|");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("-------------------------------------------------");
        System.err.println("Error at ListenLogLogStreamResponseObserver.\n" + t.toString());
    }

    @Override
    public void onCompleted() {
        System.out.println("-------------------------------------------------");
        System.out.println("ListenLogLogStreamResponseObserver closed.");
    }
    
}

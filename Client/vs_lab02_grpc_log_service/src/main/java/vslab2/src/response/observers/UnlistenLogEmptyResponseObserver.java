package vslab2.src.response.observers;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Empty;

public class UnlistenLogEmptyResponseObserver implements StreamObserver<Empty>{

    @Override
    public void onNext(Empty value) {
        System.out.println("-----------------------------------------------");
        System.out.println("Unsubscribed from log stream.");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("-----------------------------------------------");
        System.err.println("Error at UnlistenLogEmptyResponseObserver.\n" + t.toString());
    }

    @Override
    public void onCompleted() {
        System.out.println("-----------------------------------------------");
        System.out.println("UnlistenLogEmptyResponseObserver closed.");
    }
    
}

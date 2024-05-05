package vslab2.src.response.observers;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Empty;

public class AddLogEmptyResponseObserver implements StreamObserver<Empty> {

    @Override
    public void onNext(Empty value) {
        System.out.println("-----------------------------------------------");
        System.out.println("Log was added successfully.");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("-----------------------------------------------");
        System.out.println("Error at AddLogEmptyResponseObserver.\n" + t.toString());
    }

    @Override
    public void onCompleted() {
        System.out.println("-----------------------------------------------");
        System.out.println("AddLogEmptyResponseObserver closed.");
    }
    
}

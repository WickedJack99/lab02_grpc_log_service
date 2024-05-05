package vslab2.src.response.observers;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Log;

public class ListenLogLogStreamResponseObserver implements StreamObserver<Log> {

    @Override
    public void onNext(Log log) {
        System.out.println("-----------------------------------------------");
        System.out.format("%010d\t%07d\t%s", log.getRowNumber(), log.getUserId(), log.getText());
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("-----------------------------------------------");
        System.err.println("Error at ListenLogLogStreamResponseObserver.\n" + t.toString());
    }

    @Override
    public void onCompleted() {
        System.out.println("-----------------------------------------------");
        System.out.println("ListenLogLogStreamResponseObserver closed.");
    }
    
}

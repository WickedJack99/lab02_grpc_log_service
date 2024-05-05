package vslab2.src.response.observers;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Log;
import vslab2.src.grpc.LogOuterClass.Logs;

public class GetLogLogsResponseObserver implements StreamObserver<Logs> {

    @Override
    public void onNext(Logs value) {
        System.out.println("-----------------------------------------------");
        System.out.println("Row Number\tUser Id\tText\n");
        
        for (Log log : value.getLogsList()) {
            System.out.format("%010d\t%07d\t%s", log.getRowNumber(), log.getUserId(), log.getText());
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("-----------------------------------------------");
        System.err.println("Error at GetLogLogsResponseObserver.\n" + t.toString());
    }

    @Override
    public void onCompleted() {
        System.out.println("-----------------------------------------------");
        System.out.println("GetLogLogsResponseObserver was closed.");
    }
    
}

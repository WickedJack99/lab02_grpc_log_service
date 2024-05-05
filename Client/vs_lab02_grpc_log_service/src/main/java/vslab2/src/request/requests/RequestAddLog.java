package vslab2.src.request.requests;

import vslab2.src.grpc.LogOuterClass.Log;
import vslab2.src.grpcStuff.GRPCInformation;

/**
 * AddLog request if request method is executed, will send new addLog request to server.
 */
public class RequestAddLog implements Requestable {

    private GRPCInformation grpcInformation = null;
    private Log log = null;

    public RequestAddLog(Log log, GRPCInformation grpcInformation) {
        this.grpcInformation = grpcInformation;
        this.log = log;
    }

    @Override
    public void request() {
        if (grpcInformation.getAddLogStreamObserver() == null) {
            grpcInformation.initializeAddLogStreamObserver();
        }
        grpcInformation.getAddLogStreamObserver().onNext(log);
    }

    @Override
    public ERequestType getType() {
        return ERequestType.AddLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
}

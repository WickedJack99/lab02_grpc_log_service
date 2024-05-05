package vslab2.src.request.requests;

import vslab2.src.grpc.LogOuterClass.Empty;
import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.response.observers.GetLogLogsResponseObserver;

public class RequestGetLog implements Requestable {

    private GRPCInformation grpcInformation = null;

    public RequestGetLog(GRPCInformation grpcInformation) {
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void request() {
        grpcInformation.getStub().getLog(Empty.getDefaultInstance(), new GetLogLogsResponseObserver());;
    }

    @Override
    public ERequestType getType() {
        return ERequestType.GetLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
    
}

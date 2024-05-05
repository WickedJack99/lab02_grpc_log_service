package vslab2.src.request.requests;

import vslab2.src.grpc.LogOuterClass.User;
import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.response.observers.ListenLogLogStreamResponseObserver;

public class RequestListenLog implements Requestable {

    private User user = null;
    private GRPCInformation grpcInformation = null;

    public RequestListenLog(User user, GRPCInformation grpcInformation) {
        this.user = user;
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void request() {
        grpcInformation.getStub().listenLog(user, new ListenLogLogStreamResponseObserver());
    }

    @Override
    public ERequestType getType() {
        return ERequestType.ListenLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
    
}

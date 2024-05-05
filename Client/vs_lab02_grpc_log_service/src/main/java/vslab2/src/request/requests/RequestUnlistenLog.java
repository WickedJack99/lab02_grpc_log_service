package vslab2.src.request.requests;

import vslab2.src.grpc.LogOuterClass.User;
import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.response.observers.UnlistenLogEmptyResponseObserver;

public class RequestUnlistenLog implements Requestable {

    private User user = null;
    private GRPCInformation grpcInformation = null;

    public RequestUnlistenLog(User user, GRPCInformation grpcInformation) {
        this.user = user;
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void request() {
        grpcInformation.getStub().unlistenLog(user, new UnlistenLogEmptyResponseObserver());
    }

    @Override
    public ERequestType getType() {
        return ERequestType.UnlistenLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
    
}

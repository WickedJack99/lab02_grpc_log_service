package vslab2.src.input.commands;

import vslab2.src.grpc.LogOuterClass.User;
import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.input.ClientInformation;
import vslab2.src.request.queues.RequestQueue;
import vslab2.src.request.requests.RequestUnlistenLog;

public class CommandUnlistenLog implements Executable {

    private ClientInformation clientInformation = null;
    private GRPCInformation grpcInformation = null;

    public CommandUnlistenLog(ClientInformation clientInformation, GRPCInformation grpcInformation) {
        this.clientInformation = clientInformation;
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void execute(RequestQueue requestQueue) {
        User user = User.newBuilder().setUserId(clientInformation.getUserId()).build();
        requestQueue.add(new RequestUnlistenLog(user, grpcInformation));
    }

    @Override
    public ECommandType getType() {
        return ECommandType.UnlistenLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
    
}

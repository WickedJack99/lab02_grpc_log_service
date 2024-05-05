package vslab2.src.input.commands;

import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.request.queues.RequestQueue;
import vslab2.src.request.requests.RequestGetLog;

public class CommandGetLog implements Executable {

    private GRPCInformation grpcInformation = null;

    public CommandGetLog(GRPCInformation grpcInformation) {
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void execute(RequestQueue requestQueue) {
        requestQueue.add(new RequestGetLog(grpcInformation));
    }

    @Override
    public ECommandType getType() {
        return ECommandType.GetLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
}

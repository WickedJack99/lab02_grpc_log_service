package vslab2.src.input.commands;

import vslab2.src.grpc.LogOuterClass.Log;
import vslab2.src.grpcStuff.GRPCInformation;
import vslab2.src.input.ClientInformation;
import vslab2.src.request.queues.RequestQueue;
import vslab2.src.request.requests.RequestAddLog;

public class CommandAddLog implements Executable {

    private String text = null;

    private ClientInformation clientInformation = null;
    private GRPCInformation grpcInformation = null;

    public CommandAddLog(String text, ClientInformation clientInformation, GRPCInformation grpcInformation) {
        this.text = text;
        this.clientInformation = clientInformation;
        this.grpcInformation = grpcInformation;
    }

    @Override
    public void execute(RequestQueue requestQueue) {
        Log log = Log.newBuilder().setUserId(clientInformation.getUserId()).setText(text).build();
        requestQueue.add(new RequestAddLog(log, grpcInformation));
    }

    @Override
    public ECommandType getType() {
        return ECommandType.AddLog;
    }

    @Override
    public int getTypeId() {
        return getType().ordinal();
    }
}

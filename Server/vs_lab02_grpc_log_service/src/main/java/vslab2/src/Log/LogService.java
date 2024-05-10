package vslab2.src.Log;

import io.grpc.stub.StreamObserver;
import vslab2.src.User.LogUser;
import vslab2.src.User.LogUserRegistry;
import vslab2.src.grpc.LogOuterClass.Empty;
import vslab2.src.grpc.LogOuterClass.Log;
import vslab2.src.grpc.LogOuterClass.Logs;
import vslab2.src.grpc.LogOuterClass.Logs.Builder;
import vslab2.src.grpc.LogOuterClass.User;
import vslab2.src.grpc.LogServiceGrpc.LogServiceImplBase;

public class LogService extends LogServiceImplBase {

    private ServerLogs logs = new ServerLogs();
    private LogUserRegistry users = new LogUserRegistry();

    @Override
    public StreamObserver<Log> addLog(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<Log>() {
            @Override
            public void onNext(Log log) {
                // Add now log to logs.
                logs.addLog(new ServerLog(log.getUserId(), log.getText()));
                Log logToSend = Log.newBuilder()
                    .setRowNumber(ServerLog.getRowNumberCounter()-1)
                    .setUserId(log.getUserId())
                    .setText(log.getText())
                    .build();
                // Send logs to clients
                for (Object subscribedUser : users.getRegisteredUsers().toArray()) {
                    ((LogUser)subscribedUser).getStreamObserver().onNext(logToSend);
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error at LogService:addLog,\n" + t.toString());
            }

            @Override
            public void onCompleted() {
                // Send Empty response to client to indicate, that stream to add messages was closed.
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void getLog(Empty request, StreamObserver<Logs> responseObserver) {
        Builder logsBuilder = Logs.newBuilder();

        // Add logs to builder
        for (ServerLog log : logs.getServerLogs()) {
            logsBuilder.addLogs(
                Log.newBuilder()
                    .setRowNumber(log.getRowNumber())
                    .setUserId(log.getUserID())
                    .setText(log.getLogText())
                    .build());
        }
        // Create response message
        Logs logsResponse = logsBuilder.build();
        
        // Send response and close response observer
        responseObserver.onNext(logsResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void listenLog(User request, StreamObserver<Log> responseObserver) {
        // Add user to UserRegistry, which administrates all users with their response observer streams
        users.registerUser(new LogUser(request.getUserId(), responseObserver));
    }

    @Override
    public void unlistenLog(User request, StreamObserver<Empty> responseObserver) {
        // Remove user from registry and close stream to client of user
        StreamObserver<Log> listenedStreamObserver = users.unregisterUser(new LogUser(request.getUserId(), null));
        if (listenedStreamObserver != null) {
            listenedStreamObserver.onCompleted();
        }
    }
}

package vslab2.src.User;

import java.util.HashSet;
import java.util.Set;

import io.grpc.stub.StreamObserver;
import vslab2.src.grpc.LogOuterClass.Log;

public class LogUserRegistry {
    private Set<LogUser> users = null;

    public LogUserRegistry() {
        users = new HashSet<LogUser>();
    }

    public Set<LogUser> getRegisteredUsers() {
        return users;
    } 

    public void registerUser(LogUser user) {
        if (user != null) {
            users.add(user);
        }
    }

    public StreamObserver<Log> unregisterUser(LogUser user) {
        StreamObserver<Log> streamObserver = null;
        if (user != null) {
            for (Object logUser : users.toArray()) {
                if (logUser.equals(user)) {
                    streamObserver = ((LogUser)logUser).getStreamObserver();
                    break;
                }
            }
            users.remove(user);
        }
        return streamObserver;
    }
}

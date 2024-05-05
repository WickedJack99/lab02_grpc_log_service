package vslab2.src.request.requests;

public interface Requestable {
    public void request();
    public ERequestType getType();
    public int getTypeId();
}

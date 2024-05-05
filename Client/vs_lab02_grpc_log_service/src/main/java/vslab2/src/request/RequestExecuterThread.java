package vslab2.src.request;

import vslab2.src.request.queues.RequestQueue;
import vslab2.src.request.requests.Requestable;

public class RequestExecuterThread extends Thread {
    private boolean requestExecuterThreadRunning = false;

    private RequestQueue requestQueue = null;

    public RequestExecuterThread(RequestQueue requestQueue) {
        requestExecuterThreadRunning = true;
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (requestExecuterThreadRunning) {
            if (requestQueue != null) {
                try {
                    Requestable request = requestQueue.take();
                    request.request();
                } catch (InterruptedException e) {
                    System.err.println("Error at RequestExecuterThread:run, request queue interrupted.");
                }
            }
        }
    }
}

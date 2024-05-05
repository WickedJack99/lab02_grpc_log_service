package vslab2.src.request.queues;

import java.util.concurrent.LinkedBlockingQueue;

import vslab2.src.request.requests.Requestable;

/**
 * Queue containing requests that will be send over stub.
 */
public class RequestQueue extends LinkedBlockingQueue<Requestable> {}

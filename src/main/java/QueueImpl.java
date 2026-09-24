import org.apache.log4j.Logger;

public class QueueImpl<E> implements Queue<E>{
    final static Logger logger = Logger.getLogger(QueueImpl.class);

    private E[] data;
    private int p;

    public QueueImpl(int len) {
        this.data = (E[])new Object[len];
        this.p = 0;
        logger.info("nova cua de " + len+" elements");

    }

    public void push(E e) throws FullQueueException {
        // TO-DO
        logger.info("pre: 'push' nou element "+ e);
        if (isFull()) {
            logger.error("Cua plena");
            throw new FullQueueException();
        }

        this.data[this.p++]=e;
        logger.info("post: nou element "+ e);

    }


    public E pop() throws EmptyQueueException {
        logger.info("pre: 'pop' nou element ");
        if (isEmpty()) {
            logger.error("Cua buida");
            throw new EmptyQueueException();
        }
        E element = this.data[--this.p];
        this.data[this.p] = null;
        logger.info("post: element extret "+ element);
        return element;
    }

    private boolean isFull() {
        return this.p == this.data.length;
    }

    private boolean isEmpty() {
        // TO-DO
        return this.p == 0;
    }

    public int size() {
        return this.p;
    }
}

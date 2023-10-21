package resources.configurations;

/**
 * The use of this class, is to make many thread with it's functionalities and
 * NullPointerException!!!
 */
public final class SecondaryThread {

    Thread thread;
    int numberOfWorks;
    int numBegginingWork;
    int numLimitWork;
    int currentThreadNumber;
    boolean threadHasFinishedWorking;
    boolean threadHasSuspended;

    public SecondaryThread() {
        this.threadHasSuspended = true;
    }

    // GETTERS
    public Thread getThread() {
        return thread;
    }

    public int getCurrentThreadNumber() {
        return currentThreadNumber;
    }

    public int getNumberOfWorks() {
        return numberOfWorks;
    }

    public int getNumBegginingWork() {
        return numBegginingWork;
    }

    public int getNumLimitWork() {
        return numLimitWork;
    }

    // SETTERS
    public void setCurrentThreadNumber(int currentThreadNumber) {
        this.currentThreadNumber = currentThreadNumber;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void setNumberOfWorks(int numberOfWorks) {
        this.numberOfWorks = numberOfWorks;
    }

    public void setNumBegginingWork(int numBegginingWork) {
        this.numBegginingWork = numBegginingWork;
    }

    public void setNumLimitWork(int numLimitWork) {
        this.numLimitWork = numLimitWork;
    }
}

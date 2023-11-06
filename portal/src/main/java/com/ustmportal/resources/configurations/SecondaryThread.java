package com.ustmportal.resources.configurations;

import lombok.Getter;
import lombok.Setter;

/**
 * The use of this class, is to make many thread with it's functionalities and
 * NullPointerException!!!
 */

@Getter
public final class SecondaryThread {
    @Setter
    private Thread thread;
    @Deprecated
    private int numberOfWorks;

    @Deprecated
    private int numBegginingWork;

    @Deprecated
    private int numLimitWork;

    @Deprecated
    private int currentThreadNumber;

    private boolean threadHasFinishedWorking;

    private boolean threadHasSuspended;

    @Setter
    private boolean threadHasBeenFinalized;

    @Setter
    private String currentWork;

    public SecondaryThread() {
        this.threadHasSuspended = true;
        this.threadHasBeenFinalized = false;
    }

    public void stopWork() {
        threadHasFinishedWorking = true;
        threadHasSuspended = true;
    }

    public void setSecondThreadWork(String threadWork) {
        currentWork = threadWork;
        startWork();
    }

    public void startWork() {
        threadHasFinishedWorking = false;
        threadHasSuspended = false;
    }

}

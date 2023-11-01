package com.ustmportal.resources.configurations;

import lombok.Getter;
import lombok.Setter;

/**
 * The use of this class, is to make many thread with it's functionalities and
 * NullPointerException!!!
 */
@Setter
@Getter
public final class SecondaryThread {

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

    public boolean threadHasSuspended;

    private String currentWork;

    public SecondaryThread() {
        this.threadHasSuspended = true;
    }

}

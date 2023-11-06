package com.ustmportal.resources.utilities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Generic<T> {
    private T genericObject;

    public Generic(T genericObject) {
        this.genericObject = genericObject;
    }
}

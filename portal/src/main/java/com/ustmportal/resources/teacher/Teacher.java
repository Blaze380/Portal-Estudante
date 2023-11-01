package com.ustmportal.resources.teacher;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class Teacher {
    private String name;
    private String lastName;
    private String birthDate;
    private int phone;
    private char gender;
    private String email;
    private String password;
    private String mastersDegreeIn;
    private String subjectConceived;
    private String classConceived;

}

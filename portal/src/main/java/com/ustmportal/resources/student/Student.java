package com.ustmportal.resources.student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class Student extends Subject {

    // PERSONAL DATA
    private String name;
    private String lastName;
    private String birthDate;
    private String nameInCharge;
    public SubjectBase a = new SubjectBase();
    private int phone;
    private char gender;
    private String email;

    // LOGIN DATA
    private String userName;
    private String password;

    // SCHOOL DATA
    private String course;
    private byte year;
    private byte number;
    private String stream;
    private int studentCode;

    // FINANCIAL DATA
    private double currentBalance;
    private double debtBalance;

    // CONSTRUTOR:
    public Student() {
        super();
        course = "Desenvolvimento de Software";
        year = 1;
        stream = "LDS1";
    }
}
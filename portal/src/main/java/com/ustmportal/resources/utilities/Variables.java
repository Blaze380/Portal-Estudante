package com.ustmportal.resources.utilities;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Variables {

    private Scanner scanner = new Scanner(System.in);

    private String password;
    private String user;

    private boolean hasAnimationDelay;
    private boolean quitLoop;

    private int teacherFreePosition;
    private int currentTeacherPosition;
    private int studentFreePosition;
    public int currentStudentPosition;
    private int option;

}

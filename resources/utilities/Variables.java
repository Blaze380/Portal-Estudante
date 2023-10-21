package resources.utilities;

import java.util.Scanner;

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

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public boolean isHasAnimationDelay() {
        return hasAnimationDelay;
    }

    public void setHasAnimationDelay(boolean hasAnimationDelay) {
        this.hasAnimationDelay = hasAnimationDelay;
    }

    public boolean isQuitLoop() {
        return quitLoop;
    }

    public void setQuitLoop(boolean quitLoop) {
        this.quitLoop = quitLoop;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTeacherFreePosition() {
        return teacherFreePosition;
    }

    public void setTeacherFreePosition(int teacherFreePosition) {
        this.teacherFreePosition = teacherFreePosition;
    }

    public int getStudentFreePosition() {
        return studentFreePosition;
    }

    public void setStudentFreePosition(int studentFreePosition) {
        this.studentFreePosition = studentFreePosition;
    }

    public int getCurrentTeacherPosition() {
        return currentTeacherPosition;
    }

    public void setCurrentTeacherPosition(int currentTeacherPosition) {
        this.currentTeacherPosition = currentTeacherPosition;
    }

    public int getCurrentStudentPosition() {
        return currentStudentPosition;
    }

    public void setCurrentStudentPosition(int currentStudentPosition) {
        this.currentStudentPosition = currentStudentPosition;
    }
}

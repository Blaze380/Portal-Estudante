package com.ustmportal.resources.student;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

//FUi Estendido kkkkk
@Setter
@Getter
public final class Student extends Subject {

    // PERSONAL DATA
    private String name;
    private String lastName;
    private String birthDate;
    private String nameInCharge;
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

    /**
     * Changes the Student data, by choosing which one
     * 
     * @param dataToChange It can be Phone, E-mail or Password
     */
    public void changeStudentData(String dataToChange, Scanner scanner) {
        switch (dataToChange) {
            case "phone":
                setPhone(scanner);
                break;
            case "email":
                setEmail(scanner);
                break;
            case "password":
                setPassword(scanner);
                break;
        }
    }

    /**
     * Saves the student's personal data including name, password,
     * telephone number, etc.
     */
    public void registerStudent(Scanner scanner) {
        setName(scanner);
        setLastName(scanner);
        setBirthDate(scanner);
        setNameInCharge(scanner);
        setPhone(scanner);
        setGender(scanner);
        setEmail(scanner);
        setUserName(scanner);
        setPassword(scanner);

    }

    // TODO send this setter methods to the Students menu and delete the scanner in
    // this class!
    // SETTERS
    public void setName(Scanner scanner) {
        System.out.print("Nome: ");
        name = scanner.next();
    }

    public void setPhone(Scanner scanner) {
        System.out.print("Celular: ");
        phone = scanner.nextInt();
    }

    public void setGender(Scanner scanner) {
        System.out.print("1 - Masculino \n2 - Femenino \n:");
        switch (scanner.nextInt()) {
            case 1:
                gender = 'M';
                break;
            case 2:
                gender = 'F';
                break;
        }
    }

    public void setNameInCharge(Scanner scanner) {
        System.out.print("Nome do encarregado: ");
        nameInCharge = scanner.next();
    }

    public void setEmail(Scanner scanner) {
        System.out.print("E-mail: ");
        email = scanner.next();
    }

    public void setUserName(Scanner scanner) {
        System.out.print("Nome do usuário: ");
        userName = scanner.next();
    }

    public void setPassword(Scanner scanner) {
        String password, confirmPassword;
        while (true) {
            System.out.print("password: ");
            password = scanner.next();
            System.out.print("Confirmar password: ");
            confirmPassword = scanner.next();
            if (password.equals(confirmPassword)) {
                this.password = password;
                break;
            } else {
                System.out.println("password Incorrecta!");
            }
        }
    }

    public void setBirthDate(Scanner scanner) {
        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        birthDate = scanner.next();
    }

    public void setLastName(Scanner scanner) {
        System.out.print("Sobrenome: ");
        lastName = scanner.next();
    }

}
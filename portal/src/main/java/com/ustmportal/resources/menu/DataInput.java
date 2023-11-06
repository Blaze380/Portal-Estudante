package com.ustmportal.resources.menu;

import java.util.Scanner;

import com.ustmportal.resources.logs.Log;
import com.ustmportal.resources.student.Student;
import com.ustmportal.resources.teacher.Teacher;
import com.ustmportal.resources.utilities.Animations;
import com.ustmportal.resources.utilities.SystemPrinting;

public final class DataInput {

    // HELPER OBJECTS
    private final Scanner scanner = new Scanner(System.in);
    private final Animations it = new Animations();
    private final SystemPrinting sys = new SystemPrinting();
    // PERSONAL DATA
    private String name;
    private String lastName;
    private String birthDate;
    private String nameInCharge;
    private int phone;
    private char gender;
    private String email;
    private String mastersDegreeIn;

    // LOGIN DATA
    private String userName;
    private String password;

    public String setMastersDegreeIn() {
        boolean quit = false;
        int option = 0;
        while (!quit) {
            sys.println("1 - Tecnologia \n2 - Matematica \n3 - Psicologia\n");
            sys.print("Mestrado em: ");
            option = Integer.parseInt(scanner.next());
            quit = true;
            switch (option) {
                case 1:
                    mastersDegreeIn = "tecnologia";
                    break;
                case 2:
                    mastersDegreeIn = "matematica";
                    break;
                case 3:
                    mastersDegreeIn = "psicologia";
                    break;

                default:
                    quit = false;
                    it.specificAnimatedMessage("opcao incorrecta!", 2000);
                    break;
            }
        }
        Log.info(("Setting masters degree in"));
        return mastersDegreeIn;
    }

    public String setName() {
        sys.print("Nome: ");
        name = scanner.next();
        Log.info("Setting name");
        return name;
    }

    public String setLastName() {
        sys.print("Sobrenome: ");
        lastName = scanner.next();
        Log.info("Setting lastname");
        return lastName;
    }

    public String setBirthDate() {
        boolean quit = false;
        while (!quit) {
            sys.print("Data de Nascimento(dd/mm/aaaa): ");
            birthDate = scanner.next();
            if (birthDate.length() == 10) {
                quit = !quit;
            } else {
                it.specificAnimatedMessage("Formato de data incorrecta! \nDeve ser por exemplo '11/05/2005' sem aspas.",
                        2000);
            }
        }
        Log.info("Setting Birthdate");
        return birthDate;
    }

    public String setNameInCharge() {
        sys.print("Nome do encarregado: ");
        nameInCharge = scanner.next();
        Log.info("Setting name in charge");
        return nameInCharge;
    }

    public int setPhone() {
        boolean quit = false;
        while (!quit) {
            try {
                sys.print("Celular: ");
                phone = Integer.parseInt(scanner.next());
                if (Integer.toString(phone).length() == 9) {
                    quit = !quit;
                } else {
                    it.specificAnimatedMessage("O numero deve ter 9 digitos!", 2000);
                }
            } catch (NumberFormatException e) {
                it.wrongOptionFormat();
                Log.error(e, "Error while converting string to int.");
            }
        }
        Log.info("Setting Phone number");
        return phone;
    }

    public char setGender() {
        boolean quit = false;
        int option = 0;
        while (!quit) {
            sys.print("1 - Masculino \n2 - Femenino \nGenero: ");
            try {
                option = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                it.wrongOptionFormat();
                Log.error(e, "Error while converting string to int.");
            }
            quit = true;
            switch (option) {
                case 1:
                    gender = 'M';
                    break;
                case 2:
                    gender = 'F';
                    break;
                default:
                    it.specificAnimatedMessage("opcao incorrecta!", 2000);
                    quit = false;
                    break;
            }
        }
        Log.info("Setting Gender");
        return gender;
    }

    public String setEmail() {
        boolean quit = false;
        while (!quit) {
            sys.print("E-mail: ");
            email = scanner.next().toLowerCase();
            if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com.br")) {
                quit = !quit;
            } else {
                it.specificAnimatedMessage("Formato de  E-mail invalido!", 2000);
            }
        }
        Log.info("Setting Email");
        return email;
    }

    public String setUserName() {
        sys.print("Nome do usuario: ");
        userName = scanner.next();
        Log.info("Setting user name");
        return userName;
    }

    public String setLoginPassword() {
        sys.print("Senha: ");
        password = scanner.next();
        Log.info("Setting password");
        return password;
    }

    public String setPassword() {
        String confirmPassword = "";
        boolean quit = false;
        while (!quit) {
            sys.print("Senha: ");
            password = scanner.next();
            sys.print("Confimar senha: ");
            confirmPassword = scanner.next();
            if (password.equals(confirmPassword)) {
                quit = !quit;
            } else {
                it.specificAnimatedMessage("A senha que voce digitou nao combinam! \nTente novamente!", 2000);
            }
        }
        Log.info("Setting creating password");
        return password;
    }

    public Teacher registerTeacher() {
        final Teacher teacher = new Teacher();
        teacher.setName(setName());
        teacher.setLastName(setLastName());
        teacher.setBirthDate(setBirthDate());
        teacher.setPhone(setPhone());
        teacher.setGender(setGender());
        teacher.setMastersDegreeIn(setMastersDegreeIn());
        teacher.setEmail(setEmail());
        teacher.setUserName(setUserName());
        teacher.setPassword(setPassword());
        Log.info("Teacher object created sucessifuly!");
        return teacher;
    }

    public Student registerStudent() {
        final Student student = new Student();
        student.setName(setName());
        student.setLastName(setLastName());
        student.setBirthDate(setBirthDate());
        student.setNameInCharge(setNameInCharge());
        student.setPhone(setPhone());
        student.setGender(setGender());
        student.setEmail(setEmail());
        student.setUserName(setUserName());
        student.setPassword(setPassword());
        Log.info("Student object created sucessifuly!");
        return student;
    }
}

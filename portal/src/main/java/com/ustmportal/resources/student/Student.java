package com.ustmportal.resources.student;

import java.util.Scanner;

import com.ustmportal.resources.utilities.Archive;
import com.ustmportal.resources.utilities.StringConversions;

//FUi Estendido kkkkk
public final class Student extends Subject {

    // PERSONAL DATA
    private String name;
    private String lastName;
    private String birthDate;
    private String nameInCharge;
    private int phone;
    private char gender;
    private String email;
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

    // MISC
    // private Scanner scanner = new Scanner(System.in);
    private StringConversions t = new StringConversions();
    private Archive file = new Archive();
    private String path;
    private int myPosition;

    // CONSTRUTOR:
    public Student() {
        super();
        this.course = "Desenvolvimento de Software";
        this.year = 1;
        this.stream = "LDS1";
    }

    public void setMyPosition(int myPosition) {
        this.myPosition = myPosition;
        String underline = "_" + myPosition;
        path = file.getStudentPath(getName()) + underline + "\\";
    }

    private void hasMyPath() {
        file.createDiretoryPath(path);
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
        setPassword(scanner);

    }

    public String printSchoolData() {
        String schoolData = "Nome: " + getName() +
                "\nCodigo: " + getStudentCode() +
                "\nCurso: " + getCourse() +
                "\nAno: " + getYear();
        return schoolData;
    }

    public String printSubjectData(int position) {
        String subjectData = subject[position].getName() + "  " + subject[position].getNote1() + "  "
                + subject[position].getNote2() + "  "
                + subject[position].getJob() + "  " + subject[position].getAverage() + "  "
                + subject[position].getExam() + "  "
                + subject[position].getFinalAverage() + "   " + subject[position].getObservation();
        return subjectData;
    }

    public String printFinancialData() {
        String financialData = "Nome: " + getName() +
                "\nSaldo: " + getCurrentBalance() +
                "\nSaldo em divida: " + getDebtBalance();
        return financialData;
    }

    public String printPersonalData() {
        String personalData = "Nome completo: " + getName() + " " + getLastName() +
                "\nData de Nascimento: " + getBirthDate() +
                "\nCelular: " + getPhone() +
                "\nE-mail: " + getEmail() +
                "\nNome do encarregado: " + getNameInCharge() +
                "\nSenha: ******";
        return personalData;
    }

    /**
     * It Saves the subject data
     */
    public void saveSubjectData(int position) {
        String subjectPath = path + "subjects\\";
        file.setProperties("observation", subject[position].getObservation());
        file.setProperties("finalaverage", t.doubToString(subject[position].getFinalAverage()));
        file.setProperties("exam", t.doubToString(subject[position].getExam()));
        file.setProperties("average", t.doubToString(subject[position].getAverage()));
        file.setProperties("job", t.doubToString(subject[position].getJob()));
        file.setProperties("note2", t.doubToString(subject[position].getNote2()));
        file.setProperties("note1", t.doubToString(subject[position].getNote1()));
        file.setProperties("name", subject[position].getName());
        file.createDiretoryPath(subjectPath);
        file.saveProperties(subjectPath, subject[position].getName(), "STUDENT SUBJECT DATA");
    }

    /**
     * Is saves the student login data
     */
    public void saveLoginData() {
        file.setProperties("password", getPassword());
        file.setProperties("username", getName());
        hasMyPath();
        file.saveProperties(path, "login", "STUDENT LOGIN DATA");
    }

    /**
     * Is saves the financial data
     */
    public void saveFinancialData() {
        file.setProperties("debtbalance", Double.toString(getDebtBalance()));
        file.setProperties("currentbalance", Double.toString(getCurrentBalance()));
        hasMyPath();
        file.saveProperties(path, "finances", "STUDENT FINANCIAL DATA");

    }

    /**
     * It saves all personal data (Except password)
     */
    public void savePersonalData() {
        file.setProperties("email", getEmail());
        file.setProperties("gender", t.charToString(getGender()));
        file.setProperties("phone", t.intToString(getPhone()));
        file.setProperties("nameincharge", getNameInCharge());
        file.setProperties("birthdate", getBirthDate());
        file.setProperties("lastname", getLastName());
        file.setProperties("name", getName());
        hasMyPath();
        file.saveProperties(path, "personal", "STUDENT PERSONAL DATA");
    }

    /**
     * It saves all school date and return in a string
     */
    public void saveSchoolData() {
        file.setProperties("studentcode", t.intToString(getStudentCode()));
        file.setProperties("stream", getStream());
        file.setProperties("number", t.byToString(getNumber()));
        file.setProperties("year", t.byToString(getYear()));
        file.setProperties("course", getCourse());
        hasMyPath();
        file.saveProperties(path, "school", "STUDENT SCHOOL DATA");

    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNameInCharge() {
        return nameInCharge;
    }

    public int getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCourse() {
        return course;
    }

    public byte getYear() {
        return year;
    }

    public byte getNumber() {
        return number;
    }

    public String getStream() {
        return stream;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getDebtBalance() {
        return debtBalance;
    }

    // SETTERS
    public void setName(Scanner scanner) {
        System.out.print("Nome: ");
        this.name = scanner.next();
    }

    public void setPhone(Scanner scanner) {
        System.out.print("Celular: ");
        this.phone = scanner.nextInt();
    }

    public void setGender(Scanner scanner) {
        System.out.print("1 - Masculino \n2 - Femenino \n:");
        switch (scanner.nextInt()) {
            case 1:
                this.gender = 'M';
                break;
            case 2:
                this.gender = 'F';
                break;
        }

    }

    public void setNameInCharge(Scanner scanner) {
        System.out.print("Nome do encarregado: ");
        this.nameInCharge = scanner.next();
    }

    public void setEmail(Scanner scanner) {
        System.out.print("E-mail: ");
        this.email = scanner.next();
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
        this.birthDate = scanner.next();
    }

    public void setLastName(Scanner scanner) {
        System.out.print("Sobrenome: ");
        this.lastName = scanner.next();
    }

    public void setYear(byte year) {
        this.year = year;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setDebtBalance(double debtBalance) {
        this.debtBalance = debtBalance;
    }
}

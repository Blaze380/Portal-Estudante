package resources.student;

import java.util.Scanner;

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
    private Scanner scanner = new Scanner(System.in);

    // CONSTRUTOR:
    public Student() {
        super();
        this.course = "Desenvolvimento de Software";
        this.year = 1;
        this.stream = "LDS1";
    }

    /**
     * Changes the Student data, by choosing which one
     * 
     * @param dataToChange It can be Phone, E-mail or Password
     */
    public void changeData(String dataToChange) {
        switch (dataToChange) {
            case "phone":
                setPhone();
                break;
            case "email":
                setEmail();
                break;
            case "password":
                setPassword();
                break;
        }
    }

    /**
     * Saves the student's personal data including name, password,
     * telephone number, etc.
     */
    public void registerStudent() {
        setName();
        setLastName();
        setBirthDate();
        setNameInCharge();
        setPhone();
        setGender();
        setEmail();
        setPassword();

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
     * 
     * @param name         The subject name
     * @param note1/2      The student note in the curren subject
     * @param job          The note of the given work
     * @param average      The division of note 1 and note 2 by two
     * @param exam         The note of the exam
     * @param finalAverage nem sei o que dizer kk
     * @param observation  tells the situation of the student, if he passed or not
     * @param position     The postion of the subject
     * @return subjectData
     */
    public String saveSubjectData(int position) {
        String subjectData = "";
        subjectData = "\"name\":" + subject[position].getName() +
                "\n\"note1\":" + subject[position].getNote1() +
                "\n\"note2\":" + subject[position].getNote2() +
                "\n\"job\":" + subject[position].getJob() +
                "\n\"average\":" + subject[position].getAverage() +
                "\n\"exam\":" + subject[position].getExam() +
                "\n\"finalaverage\":" + subject[position].getFinalAverage() +
                "\n\"observation\":" + subject[position].getObservation();

        return subjectData;
    }

    /**
     * Is saves the financial data
     * 
     * @param currentBalance The current balance
     * @param debtBalance    The balance in debt
     * @return financialData
     */
    public String saveFinancialData() {
        String financialData = "";
        financialData = "\"currentbalance\":" + getCurrentBalance() +
                "\n\"debtbalance\":" + getDebtBalance();
        return financialData;

    }

    /**
     * Is saves the login data
     * 
     * @param name     The student name
     * @param password Password
     * @return loginData
     */
    public String saveLoginData() {
        String loginData = "";
        loginData = "\"name\":" + getName() +
                "\n\"password\":" + getPassword();
        return loginData;
    }

    /**
     * It saves all personal data (Except password)
     * 
     * @param name      Name
     * @param lastName  the Lastname
     * @param birthDate date of birth
     * @param phone     Phone number
     * @param gender    gender
     * @param email     E-mail
     * @return personalData
     */
    public String savePersonalData() {
        String personalData = "";
        personalData = "\"name\":" + getName() +
                "\n\"lastname\":" + getLastName() +
                "\n\"birthdate\":" + getBirthDate() +
                "\n\"nameincharge\":" + getNameInCharge() +
                "\n\"phone\":" + getPhone() +
                "\n\"gender\":" + getGender() +
                "\n\"email\":" + getEmail();
        return personalData;
    }

    /**
     * It saves all school date and return in a string
     * 
     * @return schoolData
     */
    public String saveSchoolData() {
        String schoolData = "";
        schoolData = "\"course\":" + getCourse() +
                "\n\"year\":" + getYear() +
                "\n\"number\":" + getNumber() +
                "\n\"stream\":" + getStream() +
                "\n\"studentcode\":" + getStudentCode();
        return schoolData;
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
    public void setName() {
        System.out.print("Nome: ");
        this.name = scanner.next();
    }

    public void setPhone() {
        System.out.print("Celular: ");
        this.phone = scanner.nextInt();
    }

    public void setGender() {
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

    public void setNameInCharge() {
        System.out.print("Nome do encarregado: ");
        this.nameInCharge = scanner.next();
    }

    public void setEmail() {
        System.out.print("E-mail: ");
        this.email = scanner.next();
    }

    public void setPassword() {
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

    public void setBirthDate() {
        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        this.birthDate = scanner.next();
    }

    public void setLastName() {
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

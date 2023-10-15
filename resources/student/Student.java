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
    public void alterarDados(String dataToChange) {
        switch (dataToChange) {
            case "phone":
                changePhoneNumber();
                break;
            case "email":
                changeEmail();
                break;
            case "password":
                changePassword();
                break;
        }
    }

    private void changePhoneNumber() {
        System.out.print("Celular: ");
        setPhone(scanner.nextInt());
    }

    private void changeEmail() {
        System.out.print("E-mail: ");
        setEmail(scanner.next());
    }

    private void changePassword() {
        while (true) {
            String password, confirmPassword;
            System.out.print("Senha: ");
            password = scanner.next();
            System.out.print("Confirmar senha: ");
            confirmPassword = scanner.next();
            if (password.equals(confirmPassword)) {
                setPassword(confirmPassword);
                break;
            } else {
                System.out.println("password Incorrecta!");
            }
        }
    }

    /**
     * Records the student's personal data including name, password,
     * telephone number, etc.
     */
    public void registerStudent() {

        // NAME:
        System.out.print("Nome: ");
        setName(scanner.next());

        // LASTNOME:
        System.out.print("Sobrenome: ");
        setLastName(scanner.next());

        // BIRTH DATE
        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        setBirthDate(scanner.next());

        // NAME IN CHARGE
        System.out.print("Nome do encarregado: ");
        setNameInCharge(scanner.next());

        // PHONE NUMBER
        System.out.print("Celular: ");
        setPhone(scanner.nextInt());

        // GENDER
        System.out.print("1 - Masculino \n2 - Femenino \n:");
        switch (scanner.nextInt()) {
            case 1:
                setGender('M');
                break;
            case 2:
                setGender('F');
                break;
        }

        // E-MAIL:
        System.out.print("E-mail: ");
        setEmail(scanner.next());

        // password:
        while (true) {
            String password, confirmPassword;
            System.out.print("password: ");
            password = scanner.next();
            System.out.print("Confirmar password: ");
            confirmPassword = scanner.next();
            if (password.equals(confirmPassword)) {
                setPassword(confirmPassword);
                break;
            } else {
                System.out.println("password Incorrecta!");
            }
        }
    }

    // FIM MÉTODO REGISTRAR
    //////////////////////////////////////////////////////////////////////////////////
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
        subjectData = "\"nome\":" + subject[position].getName() +
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
        financialData = "\"currentbalance\":" + getCurrentBalance() + "\n\"debtbalance\":" + getDebtBalance();
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
        loginData = "\"name\":" + getName() + "\n\"password\":" + getPassword();
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
     * @param year       the current year in the school
     * @param course     course
     * @param number     position in the classrom
     * @param stream     the class
     * @param studenCode the unique student code
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNome) {
        this.lastName = lastNome;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNameInCharge() {
        return nameInCharge;
    }

    public void setNameInCharge(String nameInCharge) {
        this.nameInCharge = nameInCharge;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public byte getYear() {
        return year;
    }

    public void setYear(byte year) {
        this.year = year;
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getDebtBalance() {
        return debtBalance;
    }

    public void setDebtBalance(double debtBalance) {
        this.debtBalance = debtBalance;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}

package resources.teacher;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getMastersDegreeIn() {
        return mastersDegreeIn;
    }

    public void setMastersDegreeIn(String mastersDegreeIn) {
        this.mastersDegreeIn = mastersDegreeIn;
    }

    public String getSubjectConceived() {
        return subjectConceived;
    }

    public void setSubjectConceived(String subjectConceived) {
        this.subjectConceived = subjectConceived;
    }

    public String getClassConceived() {
        return classConceived;
    }

    public void setClassConceived(String classConceived) {
        this.classConceived = classConceived;
    }

}

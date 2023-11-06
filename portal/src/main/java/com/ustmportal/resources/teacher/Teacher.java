package com.ustmportal.resources.teacher;

import java.util.ArrayList;

import com.ustmportal.resources.student.Subject;

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
    private ArrayList<SubjectConceived> subjectConceived = new ArrayList<SubjectConceived>();
    private String classConceived;
    private String userName;

    public Teacher() {
        classConceived = "LDS1";
    }

    public void loadMastersDegreeIn() {
        switch (mastersDegreeIn) {
            case "psicologia":
                setPsicology();
                break;
            case "matematica":
                setMath();
                break;
            case "tecnologia":
                setTechnology();
                break;
        }
    }

    private void setPsicology() {
        loadSubjectArray(2);
        subjectConceived.get(0).setSucjectNumberReference(1);
        subjectConceived.get(0).setSubjectName("Etica fundamental");
        subjectConceived.get(1).setSucjectNumberReference(2);
        subjectConceived.get(1).setSubjectName("Metodologias de Pesquisa");
    }

    private void setMath() {
        loadSubjectArray(1);
        subjectConceived.get(0).setSucjectNumberReference(1);
        subjectConceived.get(0).setSubjectName("Analise Matematica I");
    }

    private void loadSubjectArray(int index) {
        for (int i = 0; i < index; i++) {
            subjectConceived.add(new SubjectConceived());
        }

    }

    private void setTechnology() {
        loadSubjectArray(2);
        subjectConceived.get(0).setSucjectNumberReference(1);
        subjectConceived.get(0).setSubjectName("Programacao I");
        subjectConceived.get(1).setSucjectNumberReference(2);
        subjectConceived.get(1).setSubjectName("Arquitetura de computadores");
    }
}

@Getter
@Setter
class SubjectConceived {
    private String subjectName;
    private int sucjectNumberReference;
}

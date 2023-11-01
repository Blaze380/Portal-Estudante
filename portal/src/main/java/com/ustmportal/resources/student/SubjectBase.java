package com.ustmportal.resources.student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class SubjectBase {
    /**
     * Esta Classe Serve como o objecto em Sim de nome da disciplina,notas,etc
     */
    private String name;
    private String observation = "not defined";

    private double note1, note2, job, average, exam, finalAverage;

    public void setAverage() {
        this.average = ((this.note1 + this.note2 / 2));
    }
}
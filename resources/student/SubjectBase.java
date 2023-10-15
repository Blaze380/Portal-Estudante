package resources.student;

public final class SubjectBase {
    /**
     * Esta Classe Serve como o objecto em Sim de nome da disciplina,notas,etc
     */
    private String name;
    private String observation;

    private double note1, note2, job, average, exam, finalAverage;

    public void setAverage() {
        this.average = ((this.note1 + this.note2 / 2));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public double getJob() {
        return job;
    }

    public void setJob(double job) {
        this.job = job;
    }

    public double getAverage() {
        return average;
    }

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public double getFinalAverage() {
        return finalAverage;
    }

    public void setFinalAverage(double finalAverage) {
        this.finalAverage = finalAverage;
    }

}

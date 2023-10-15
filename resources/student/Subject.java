package resources.student;

public abstract class Subject {
    /**
     * Esta classe serve como ponte para o objecto "subject" ser acessado
     * em cada objecto "estudante", por isso é declarada como pública
     */
    public SubjectBase subject[] = new SubjectBase[5];

    public Subject() {
        for (int i = 0; i < subject.length; i++) {
            subject[i] = new SubjectBase();
        }
        subject[0].setName("Analise Matematica I");
        subject[1].setName("Programacao I");
        subject[2].setName("Arquitetura de Computadores");
        subject[3].setName("Metodologias de Pesquisa");
        subject[4].setName("Etica fundamental");
    }
}

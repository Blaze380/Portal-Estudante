package estudante;

public abstract class Disciplina {
    /**
     * Esta classe serve como ponte para o objecto "disciplina" ser acessado
     * em cada objecto "estudante", por isso é declarada como pública
     */
    public BaseDisciplina disciplina[] = new BaseDisciplina[6];

    public Disciplina() {
        for (int i = 0; i < disciplina.length; i++) {
            disciplina[i] = new BaseDisciplina();
        }
    }
}

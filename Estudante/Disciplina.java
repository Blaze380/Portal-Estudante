package estudante;

public abstract class Disciplina {
    /**
     * Esta classe serve como ponte para o objecto "disciplina" ser acessado
     * em cada objecto "estudante", por isso é declarada como pública
     */
    public BaseDisciplina disciplina[] = new BaseDisciplina[5];

    public Disciplina() {
        for (int i = 0; i < disciplina.length; i++) {
            disciplina[i] = new BaseDisciplina();
        }
        disciplina[0].setNome("Analise Matematica I");
        disciplina[1].setNome("Programacao I");
        disciplina[2].setNome("Arquitetura de Computadores");
        disciplina[3].setNome("Metodologias de Pesquisa");
        disciplina[4].setNome("Etica fundamental");
    }
}

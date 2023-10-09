package estudante;

public final class BaseDisciplina {
    /**
     * Esta Classe Serve como o objecto em Sim de nome da disciplina,notas,etc
     */
    private String nome;
    private String observacao;

    private double nota1, nota2, trabalho, media, exame, mediaFinal;

    // GETTERS:
    public String getObservacao() {
        return observacao;
    }

    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getTrabalho() {
        return trabalho;
    }

    public double getMedia() {
        return media;
    }

    public double getExame() {
        return exame;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    // SETTERS:
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setMedia() {
        this.media = ((this.nota1 + this.nota2 / 2));
    }

    public void setExame(double exame) {
        this.exame = exame;
    }

    public void setMediaFinal() {
        this.mediaFinal = this.exame;
    }
}

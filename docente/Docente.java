package docente;

public final class Docente {
    private String nome;
    private String sobreNome;
    private String dataNascimento;
    private int celular;
    private char genero;
    private String email;
    private String senha;
    private String mestradoEm;
    private String disciplinaConcebida;
    private String turmaConcebida;

    // GETTERS:
    public char getGenero() {
        return genero;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public int getCelular() {
        return celular;
    }

    public String getTurmaConcebida() {
        return turmaConcebida;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getMestradoEm() {
        return mestradoEm;
    }

    public String getDisciplinaConcebida() {
        return disciplinaConcebida;
    }

    // SETTERS:
    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setMestradoEm(String mestradoEm) {
        this.mestradoEm = mestradoEm;
    }

    public void setDisciplinaConcebida(String disciplinaConcebida) {
        this.disciplinaConcebida = disciplinaConcebida;
    }

    public void setTurmaConcebida(String turmaConcebida) {
        this.turmaConcebida = turmaConcebida;
    }
}

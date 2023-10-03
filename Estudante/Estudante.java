package Estudante;

//FUi Estendido kkkkk
public final class Estudante extends Disciplina {
    // DADOS PESSOAIS:
    private String nome;
    private String sobreNome;
    private String dataNascimento;
    private String nomeEncarregado;
    private int celular;
    private String email;

    public Estudante() {
        super();
    }

    private String senha;

    // DADOS ESCOLARES:
    private String curso;
    private byte ano;
    private byte numero;
    private String turma;
    private int codigoEstudante;

    // DADOS FINANCEIROS:
    private double saldoAtual;
    private double saldoDivida;

    // GETTERS:
    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getNomeEncarregado() {
        return nomeEncarregado;
    }

    public int getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCurso() {
        return curso;
    }

    public byte getAno() {
        return ano;
    }

    public byte getNumero() {
        return numero;
    }

    public String getTurma() {
        return turma;
    }

    public int getCodigoEstudante() {
        return codigoEstudante;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public double getSaldoDivida() {
        return saldoDivida;
    }

    // SETTERS:
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNomeEncarregado(String nomeEncarregado) {
        this.nomeEncarregado = nomeEncarregado;
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

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setAno(byte ano) {
        this.ano = ano;
    }

    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setCodigoEstudante(int codigoEstudante) {
        this.codigoEstudante = codigoEstudante;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public void setSaldoDivida(double saldoDivida) {
        this.saldoDivida = saldoDivida;
    }

}

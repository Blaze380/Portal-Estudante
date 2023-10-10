package estudante;

import java.util.Scanner;

//FUi Estendido kkkkk
public final class Estudante extends Disciplina {
    // DADOS PESSOAIS:
    private String nome;
    private String sobreNome;
    private String dataNascimento;
    private String nomeEncarregado;
    private int celular;
    private char genero;
    private String email;
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

    // MISCELÂNEA
    private Scanner scanner = new Scanner(System.in);

    // CONSTRUTOR:
    public Estudante() {
        super();
        this.curso = "Desenvolvimento de Software";
        this.ano = 1;
        this.turma = "LDS1";
    }

    // MÉTODO ALTERAR DADOS()
    public void alterarDados(String dado) {
        switch (dado) {
            case "celular":

                System.out.print("Celular: ");
                setCelular(scanner.nextInt());
                break;
            case "email":
                System.out.print("E-mail: ");
                setEmail(scanner.next());
                break;
            case "senha":
                while (true) {
                    String senha, confSenha;
                    System.out.print("Senha: ");
                    senha = scanner.next();
                    System.out.print("Confirmar Senha: ");
                    confSenha = scanner.next();
                    if (senha.equals(confSenha)) {
                        setSenha(confSenha);
                        break;
                    } else {
                        System.out.println("Senha Incorrecta!");
                    }
                }
                break;
        }
    }

    // MÉTODO REGISTRAR
    //////////////////////////////////////////////////////////////////////////////////
    public void registrar() {

        // NOME:
        System.out.print("Nome: ");
        setNome(scanner.next());

        // SOBRENOME:
        System.out.print("Sobrenome: ");
        setSobreNome(scanner.next());

        // DATA DE NASCIMENTO:
        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        setDataNascimento(scanner.next());

        // NOME DO ENCARREGADO:
        System.out.print("Nome do encarregado: ");
        setNomeEncarregado(scanner.next());

        // NÚMERO DO CELULAR
        System.out.print("Celular: ");
        setCelular(scanner.nextInt());

        // GÊNERO:
        System.out.print("1 - Masculino \n2 - Femenino \n:");
        switch (scanner.nextInt()) {
            case 1:
                setGenero('M');
                break;
            case 2:
                setGenero('F');
                break;
        }

        // E-MAIL:
        System.out.print("E-mail: ");
        setEmail(scanner.next());

        // SENHA:
        while (true) {
            String senha, confSenha;
            System.out.print("Senha: ");
            senha = scanner.next();
            System.out.print("Confirmar Senha: ");
            confSenha = scanner.next();
            if (senha.equals(confSenha)) {
                setSenha(confSenha);
                break;
            } else {
                System.out.println("Senha Incorrecta!");
            }
        }
    }
    // FIM MÉTODO REGISTRAR
    //////////////////////////////////////////////////////////////////////////////////

    public String salvarDisciplina(int i) {
        String dados = "";
        dados = "\"nome\":" + disciplina[i].getNome() +
                "\n\"nota1\":" + disciplina[i].getNota1() +
                "\n\"nota2\":" + disciplina[i].getNota2() +
                "\n\"trabalho\":" + disciplina[i].getTrabalho() +
                "\n\"media\":" + disciplina[i].getMedia() +
                "\n\"exame\":" + disciplina[i].getExame() +
                "\n\"mediafinal\":" + disciplina[i].getMediaFinal() +
                "\n\"observacao\":" + disciplina[i].getObservacao();

        return dados;
    }

    public String salvarFinancas() {
        String dados = "";
        dados = "\"saldoatual\":" + getSaldoAtual() + "\n\"saldodivida\":" + getSaldoDivida();
        return dados;

    }

    public String salvarLogin() {
        String dados = "";
        dados = "\"nome\":" + getNome() + "\n\"senha\":" + getSenha();
        return dados;
    }

    public String salvarPessoal() {
        String dados = "";
        dados = "\"nome\":" + getNome() +
                "\n\"sobrenome\":" + getSobreNome() +
                "\n\"datanascimento\":" + getDataNascimento() +
                "\n\"nomeencarregado\":" + getNomeEncarregado() +
                "\n\"celular\":" + getCelular() +
                "\n\"genero\":" + getGenero() +
                "\n\"email\":" + getEmail();
        return dados;
    }

    public String salvarEscolar() {
        String dados = "";
        dados = "\"curso\":" + getCurso() +
                "\n\"ano\":" + getAno() +
                "\n\"numero\":" + getNumero() +
                "\n\"turma\":" + getTurma() +
                "\n\"codigoestudante\":" + getCodigoEstudante();
        return dados;
    }

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

package com.ustmportal;

import com.google.gson.Gson;

public class Teste {
    public static void main(String[] args) {
        // Crie um objeto Gson
        Gson gson = new Gson();

        // Crie um objeto Java da classe Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Exemplo");
        pessoa.setIdade(30);
        pessoa.setCidade("Exemploville");

        // Converter o objeto Java para JSON
        String json = gson.toJson(pessoa);

        // Imprimir o JSON gerado
        System.out.println("JSON gerado a partir do objeto: " + json);
    }
}

class Pessoa {
    private String nome;
    private int idade;
    private String cidade;

    // Getters e setters (outras anotações, construtores, etc.)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

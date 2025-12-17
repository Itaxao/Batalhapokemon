package br.com.cefetmg.batalhapokemon.model.enums;

public enum Sexo {
    MACHO('♂', "Macho"),
    FEMEA('♀', "Fêmea");

    private char simbolo;
    private String nome;

    Sexo(char simbolo, String nome) {
        this.simbolo = simbolo;
        this.nome = nome;
    }

    // Getters públicos
    public char getSimbolo() {
        return simbolo;
    }

    public String getNome() {
        return nome;
    }

    public static Sexo gerarAleatorio(){
        return Math.random() < 0.5 ? MACHO : FEMEA;
    }
}

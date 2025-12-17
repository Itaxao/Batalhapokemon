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

    public static Sexo gerarAleatorio(){
        return Math.random() < 0.5 ? MACHO : FEMEA;
    }
}

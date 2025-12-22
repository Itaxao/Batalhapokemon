package br.com.cefetmg.batalhapokemon.model.enums;

public enum Tipo {
    FOGO, AGUA, PLANTA, ELETRICO, NORMAL, TERRA;

    public static double obterMultiplicador(Tipo tipoAtaque, Tipo tipoDefensor) {
        return switch (tipoAtaque) {
            case FOGO -> switch (tipoDefensor) {
                case PLANTA -> 2.0;
                case AGUA, FOGO -> 0.5;
                case TERRA -> 0.5;
                default -> 1.0;
            };
            case AGUA -> switch (tipoDefensor) {
                case FOGO, TERRA -> 2.0;
                case PLANTA, AGUA -> 0.5;
                default -> 1.0;
            };
            case PLANTA -> switch (tipoDefensor) {
                case AGUA, TERRA -> 2.0;
                case FOGO, PLANTA -> 0.5;
                default -> 1.0;
            };
            case ELETRICO -> switch (tipoDefensor) {
                case AGUA -> 2.0;
                case PLANTA, ELETRICO -> 0.5;
                case TERRA -> 0.0; // Elétrico não afeta Terra
                default -> 1.0;
            };
            case TERRA -> switch (tipoDefensor) {
                case FOGO, ELETRICO -> 2.0;
                case PLANTA, AGUA -> 0.5;
                default -> 1.0;
            };
            default -> 1.0;
        };
    }
}
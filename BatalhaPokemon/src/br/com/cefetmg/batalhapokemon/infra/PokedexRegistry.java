package br.com.cefetmg.batalhapokemon.infra;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PokedexRegistry {
    // Mapa: Nome da Espécie -> Classe Java
    private static final Map<String, Class<? extends Pokemon>> REGISTRO = new HashMap<>();

    /**
     * Inicializa a Pokédex escaneando o pacote base e todos os subpacotes.
     * @param pacoteBase Ex: "br.com.cefetmg.batalhapokemon.model"
     */
    public static void inicializar(String pacoteBase) {
        REGISTRO.clear();
        System.out.println("🔍 Iniciando varredura recursiva em: " + pacoteBase);

        try {
            Set<Class<?>> classesEncontradas = new HashSet<>();
            buscarClassesRecursivamente(pacoteBase, classesEncontradas);

            System.out.println("📦 Total de classes encontradas: " + classesEncontradas.size());

            for (Class<?> clazz : classesEncontradas) {
                // Verifica se é filho de Pokemon e não é a própria classe Pokemon
                if (Pokemon.class.isAssignableFrom(clazz) && !clazz.equals(Pokemon.class)) {
                    registrarSeForEstagioUm(clazz);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro fatal ao inicializar a Pokédex: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("✅ Pokédex carregada! Total de espécies base encontradas: " + REGISTRO.size());
    }

    private static void registrarSeForEstagioUm(Class<?> clazz) {
        try {
            // Instancia um objeto temporário para verificar os dados
            Pokemon temp = (Pokemon) clazz.getConstructor(String.class).newInstance("TEMP_CHECK");

            // REGRA: Só registra se for Estágio 1 (Base)
            if (temp.getNivelEvolucao() == 1) {
                REGISTRO.put(temp.getEspecie(), (Class<? extends Pokemon>) clazz);
                System.out.println("   -> Registrado: " + temp.getEspecie());
            }
        } catch (NoSuchMethodException e) {
            // Ignora classes sem construtor público(String)
        } catch (Exception e) {
            System.err.println("   ⚠️ Erro ao verificar classe " + clazz.getSimpleName() + ": " + e.getMessage());
        }
    }

    private static void buscarClassesRecursivamente(String nomePacote, Set<Class<?>> classesDestino) throws Exception {
        String path = nomePacote.replace('.', '/');
        URL resource = Thread.currentThread().getContextClassLoader().getResource(path);

        if (resource == null) {
            return;
        }

        // CORREÇÃO: Decodifica a URL para lidar com espaços e caracteres especiais
        String caminhoDecodificado = URLDecoder.decode(resource.getFile(), StandardCharsets.UTF_8);
        File diretorio = new File(caminhoDecodificado);

        if (!diretorio.exists()) {
            System.err.println("⚠️ Diretório não encontrado: " + diretorio.getAbsolutePath());
            return;
        }

        File[] arquivos = diretorio.listFiles();
        if (arquivos == null) return;

        for (File arquivo : arquivos) {
            if (arquivo.isDirectory()) {
                // RECURSIVIDADE: Se for pasta, mergulha nela
                buscarClassesRecursivamente(nomePacote + "." + arquivo.getName(), classesDestino);
            } else if (arquivo.getName().endsWith(".class")) {
                // Remove a extensão .class para obter o nome da classe
                String nomeClasse = nomePacote + '.' + arquivo.getName().substring(0, arquivo.getName().length() - 6);

                try {
                    classesDestino.add(Class.forName(nomeClasse));
                } catch (ClassNotFoundException e) {
                    // Ignora arquivos que não são classes carregáveis
                }
            }
        }
    }

    public static Pokemon criar(String especie, String apelido) {
        Class<? extends Pokemon> classe = REGISTRO.get(especie);
        if (classe == null) {
            throw new IllegalArgumentException("Espécie não encontrada na Pokédex: " + especie);
        }
        try {
            return classe.getConstructor(String.class).newInstance(apelido);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar a instância de " + especie, e);
        }
    }

    public static List<String> getEspeciesDisponiveis() {
        List<String> lista = new ArrayList<>(REGISTRO.keySet());
        Collections.sort(lista);
        return lista;
    }
}
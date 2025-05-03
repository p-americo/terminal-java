package Terminal;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class FileManager {
    private DirectoryManager directoryManager; // Usa o DirectoryManager para pegar o diretório correto

    public FileManager(DirectoryManager directoryManager) {
        this.directoryManager = directoryManager;
    }

    public void criarArquivo(String nome) {
        Path novoArquivo = directoryManager.getCurrentDirectory().resolve(nome);
        try {
            Files.createFile(novoArquivo);
            System.out.println("Arquivo criado: " + novoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public void remover(String nome) {
        Path caminho = directoryManager.getCurrentDirectory().resolve(nome);
        try {
            if (Files.isDirectory(caminho)) {
                Files.walkFileTree(caminho, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("Diretório removido: " + nome);
            } else {
                Files.deleteIfExists(caminho);
                System.out.println("Arquivo removido: " + nome);
            }
        } catch (IOException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }

    public void escreverArquivo(String nome, String conteudo) {
        Path arquivo = directoryManager.getCurrentDirectory().resolve(nome);
        try {
            Files.write(arquivo, conteudo.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Texto escrito no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void lerArquivo(String nome) {
        Path arquivo = directoryManager.getCurrentDirectory().resolve(nome);
        try {
            List<String> linhas = Files.readAllLines(arquivo);
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}

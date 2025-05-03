package Terminal;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryManager {
    private Path diretorioAtual;

    public DirectoryManager() {
        this.diretorioAtual = Paths.get(System.getProperty("user.dir"));
    }

    public Path getCurrentDirectory() {
        return diretorioAtual;
    }

    public void changeDirectory(String novoDiretorio) {
        if (novoDiretorio.equals("..")) {
            diretorioAtual = diretorioAtual.getParent();
            if (diretorioAtual == null) {
                diretorioAtual = Paths.get(System.getProperty("user.dir"));
            }
        } else {
            Path novoPath = diretorioAtual.resolve(novoDiretorio).normalize();
            if (Files.isDirectory(novoPath)) {
                diretorioAtual = novoPath;
            } else {
                System.out.println("Diretório inválido.");
            }
        }
        System.out.println("Diretório atual: " + diretorioAtual);
    }

    public void listFiles() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(diretorioAtual)) {
            for (Path file : stream) {
                System.out.println((Files.isDirectory(file) ? "<DIR> " : "<FILE> ") + file.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar diretórios: " + e.getMessage());
        }
    }

    public void createDirectory(String nomeDiretorio) {
        Path caminho = diretorioAtual.resolve(nomeDiretorio);
        try {
            Files.createDirectory(caminho);
            System.out.println("Diretório criado: " + nomeDiretorio);
        } catch (IOException e) {
            System.out.println("Erro ao criar diretório: " + e.getMessage());
        }
    }
}

package Terminal;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class HistoryManager {
    private static final Path HISTORICO_PATH = Paths.get("history.txt");
    private List<String> history = new ArrayList<>();

    public HistoryManager() {
        carregarHistorico();
    }

    public void addCommand(String command) {
        history.add(command);
        salvarHistorico();
    }

    public List<String> getHistory() {
        return history;
    }

    private void salvarHistorico() {
        try {
            Files.write(HISTORICO_PATH, history);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico.");
        }
    }

    private void carregarHistorico() {
        try {
            if (Files.exists(HISTORICO_PATH)) {
                history = Files.readAllLines(HISTORICO_PATH);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar histórico.");
        }
    }

    // **NOVO MÉTODO PARA LIMPAR O HISTÓRICO**
    public void limparHistorico() {
        try {
            Files.write(HISTORICO_PATH, new ArrayList<>()); // Sobrescreve o arquivo vazio
            history.clear(); // Limpa a lista de histórico
            System.out.println("Histórico apagado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao limpar histórico.");
        }
    }
}

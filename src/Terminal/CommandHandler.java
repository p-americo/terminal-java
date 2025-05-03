package Terminal;

import java.util.Scanner;

public class CommandHandler {
    private DirectoryManager directoryManager;
    private FileManager fileManager;
    private HistoryManager historyManager;

    public CommandHandler(DirectoryManager directoryManager, FileManager fileManager, HistoryManager historyManager) {
        this.directoryManager = directoryManager;
        this.fileManager = fileManager;
        this.historyManager = historyManager;
    }

    public void processCommand(String command, Scanner scanner) {
        historyManager.addCommand(command);

        String[] parts = command.split(" ", 2);
        String cmd = parts[0];
        String arg = (parts.length > 1) ? parts[1] : null;

        switch (cmd) {
            case "pwd":
                System.out.println(directoryManager.getCurrentDirectory());
                break;
            case "ls":
                directoryManager.listFiles();
                break;
            case "cd":
                if (arg != null) directoryManager.changeDirectory(arg);
                else System.out.println("Uso: cd <diretório>");
                break;
            case "mkdir":
                if (arg != null) directoryManager.createDirectory(arg);
                else System.out.println("Uso: mkdir <nome>");
                break;
            case "touch":
                if (arg != null) fileManager.criarArquivo(arg);
                else System.out.println("Uso: touch <arquivo>");
                break;
            case "rm":
                if (arg != null) fileManager.remover(arg);
                else System.out.println("Uso: rm <arquivo/diretório>");
                break;
            case "cat":
                if (arg != null) fileManager.lerArquivo(arg);
                else System.out.println("Uso: cat <arquivo>");
                break;
            case "echo":
                if (arg != null) {
                    String[] echoParts = arg.split(">", 2);
                    if (echoParts.length == 2) {
                        String texto = echoParts[0].trim();
                        String arquivo = echoParts[1].trim();
                        fileManager.escreverArquivo(arquivo, texto);
                    } else {
                        System.out.println("Uso: echo <texto> > <arquivo>");
                    }
                } else {
                    System.out.println("Uso: echo <texto> > <arquivo>");
                }
                break;
            case "history":
                for (String histCmd : historyManager.getHistory()) {
                    System.out.println(histCmd);
                }
                break;
            case "clear":
                historyManager.limparHistorico();
                System.out.println("Histórico limpo.");
                break;
            case "exit":
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Comando não reconhecido.");
        }
    }
}

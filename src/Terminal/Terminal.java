package Terminal;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryManager directoryManager = new DirectoryManager();
        FileManager fileManager = new FileManager(directoryManager); // Passa o DirectoryManager
        HistoryManager historyManager = new HistoryManager();
        CommandHandler commandHandler = new CommandHandler(directoryManager, fileManager, historyManager);

        System.out.println("Bem-vindo ao Terminal Fake! Digite 'exit' para sair.");

        while (true) {
            System.out.print("> "); 
            String command = scanner.nextLine().trim(); 

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Encerrando terminal...");
                break;
            }

            commandHandler.processCommand(command, scanner); 
        }

        scanner.close();
    }
}

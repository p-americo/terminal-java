# Terminal Simulado em Java #

### Descrição ###

Este projeto implementa um terminal de comandos simples em Java, simulando funcionalidades básicas de um sistema operacional Linux.
O usuário pode navegar entre diretórios, criar e remover arquivos, listar conteúdo e registrar um histórico de comandos.

#### Funcionalidades ####

pwd: Exibe o diretório atual.

ls: Lista os arquivos e diretórios do diretório atual.

cd <diretório>: Navega entre diretórios.

mkdir : Cria um novo diretório.

touch : Cria um novo arquivo vazio.

rm <arquivo/diretório>: Remove um arquivo ou diretório.

cat : Exibe o conteúdo de um arquivo.

echo  > : Escreve texto em um arquivo.

history: Mostra o histórico de comandos digitados.

exit: Encerra o programa.

#### Estrutura do Projeto ####

O projeto está organizado nos seguintes arquivos:

Terminal.java: Classe principal que executa o terminal.

CommandHandler.java: Processa os comandos digitados.

DirectoryManager.java: Gerencia operações com diretórios.

FileManager.java: Manipula arquivos e suas operações.

HistoryManager.java: Registra e recupera o histórico de comandos digitados.

#### Como Usar: ####

Ao executar o programa, você pode digitar qualquer um dos comandos disponíveis.

Exemplo:

$ pwd
/home/usuario/projeto
$ mkdir novo_diretorio
$ cd novo_diretorio
$ touch arquivo.txt
$ echo "Ola, mundo!" > arquivo.txt
$ cat arquivo.txt
Ola, mundo!
$ history

#### Notas ####

O histórico de comandos é salvo em history.txt.

Arquivos e diretórios são criados no local onde o programa está rodando.

Utilize cd .. para voltar ao diretório anterior.

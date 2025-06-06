import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Sair", "Cliente", "Conta", "Operacoes"));
            int selecao = mainMenu.getSelection();
            if (selecao == 0) {
                System.out.println("Saindo do sistema...");
                executando = false;
            } 
            else if (selecao == 1) { 
                try {
                    System.out.println("Criando um novo cliente...");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nome do cliente:");
                    String nome = sc.nextLine();
                    System.out.println("CPF do cliente:");
                    String cpf = sc.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    FileUtils.salvarEmArquivo("clientes.txt", cliente.toString());
                } catch (Exception e) {
                    System.out.println("Erro ao criar cliente: " + e.getMessage());
                }
            }
            else if (selecao == 2) {
                System.out.println("Operações de Conta...");
                // Implementar operações de conta aqui
            } 
            else if (selecao == 3) { 
                System.out.println("Realizando operações...");
                // Implementar operações aqui
            }
            else {
                System.out.println("Opção inválida selecionada");
            }
            
            System.out.println("\nPressione ENTER para continuar...");
            try {
                System.in.read();
                while (System.in.available() > 0) {
                    System.in.read();
                }
            } catch (Exception e) {
                System.out.println("Erro ao ler entrada: " + e.getMessage());
            }
        }
        
        System.out.println("Fim");
    }
}
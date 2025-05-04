import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		boolean executando = true;

		while (executando) {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Sair", "Conta", "Cliente", "Operacoes"));
			int selecao = mainMenu.getSelection();

			if (selecao == 0) {
				System.out.println("Saindo do sistema...");
				executando = false;
			} else {
				System.out.println("Opção " + selecao + " - " +
						Arrays.asList("Conta", "Cliente", "Operacoes").get(selecao - 1) +
						" foi selecionada");
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
		}

		System.out.println("Fim");
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean executando = true;

		while (executando) {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Sair", "Criar Cliente", "Excluir Cliente", "Editar Cliente", "Buscar Cliente", "Conta", "Operacoes"));
			int selecao = mainMenu.getSelection();

			if (selecao == 0) {
				System.out.println("Saindo do sistema...");
				executando = false;
			}

			else if (selecao == 1) {
				try{
					System.out.println("Criando um novo cliente...");
					Scanner sc = new Scanner(System.in);
					System.out.println("Nome do cliente:");
					String nome = sc.nextLine();
					System.out.println("CPF do cliente:");
					String cpf = sc.nextLine();

					if (FileUtils.verificarCpfExistente("clientes.txt", cpf)) {
						System.out.println("Erro: Já existe um cliente cadastrado com este CPF!");
					} else {
						Cliente cliente = new Cliente(nome, cpf);
						FileUtils.salvarEmArquivo("clientes.txt", cliente.toString());
					}
				}
				catch (Exception e) {
					System.out.println("Erro ao criar cliente: " + e.getMessage());
				}
			} 
			
			else if (selecao == 2) {
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Informe o CPF do cliente a ser excluído:");
					String cpfParaExcluir = sc.nextLine();
					
					boolean excluido = FileUtils.excluirClientePorCpf("clientes.txt", cpfParaExcluir);
					if (excluido) {
						System.out.println("Cliente excluído com sucesso!");
					} else {
						System.out.println("Cliente com CPF informado não encontrado.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao excluir cliente: " + e.getMessage());
				}
			}

			else if (selecao == 3) {
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Informe o CPF do cliente a ser editado:");
					String cpfParaEditar = sc.nextLine();

					System.out.println("Novo nome para o cliente:");
					String novoNome = sc.nextLine();

					boolean editado = FileUtils.editarClientePorCpf("clientes.txt", cpfParaEditar, novoNome);
					if (editado) {
						System.out.println("Cliente editado com sucesso!");
					} else {
						System.out.println("Cliente com CPF informado não encontrado.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao editar cliente: " + e.getMessage());
				}
			}
			
			else if (selecao == 4) {
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Informe o CPF do cliente a ser buscado:");
					String cpfParaBuscar = sc.nextLine();
					
					String resultado = FileUtils.buscarClientePorCpf("clientes.txt", cpfParaBuscar);
					if (resultado != null) {
						System.out.println("Cliente encontrado:");
						System.out.println(resultado);
					} else {
						System.out.println("Cliente com CPF informado não encontrado.");
					}
					
					System.out.println("\nPressione ENTER para continuar...");
					System.in.read();
					while (System.in.available() > 0) {
						System.in.read();
					}
				} catch (Exception e) {
					System.out.println("Erro ao buscar cliente: " + e.getMessage());
				}
			}
			
			else if (selecao == 5) {
				try{
					Scanner sc = new Scanner(System.in);
					System.out.println("Número da conta:");
					String numero = sc.nextLine();
					System.out.println("CPF do titular:");
					String cpf = sc.nextLine();
				
					Conta conta = new Conta(numero, cpf);
					FileUtils.salvarEmArquivo("contas.txt", conta.toString());
				}
				catch (Exception e) {
					System.out.println("Erro ao criar conta: " + e.getMessage());
				}
			}
			else {
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
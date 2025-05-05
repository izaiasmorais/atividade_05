import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void salvarEmArquivo(String nomeArquivo, String conteudo) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(conteudo + "\n");
            System.out.println("Salvo com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public static boolean excluirClientePorCpf(String caminho, String cpf) throws IOException {
		File inputFile = new File(caminho);
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		boolean encontrado = false;

		while ((currentLine = reader.readLine()) != null) {
			if (currentLine.contains(cpf)) {
				encontrado = true;
				continue;
			}
			writer.write(currentLine + System.getProperty("line.separator"));
		}

		writer.close();
		reader.close();

		if (!inputFile.delete()) {
			System.out.println("Não foi possível deletar o arquivo original");
			return false;
		}

		if (!tempFile.renameTo(inputFile)) {
			System.out.println("Não foi possível renomear o arquivo temporário");
			return false;
		}

		return encontrado;
	}

	public static boolean editarClientePorCpf(String caminho, String cpf, String novoNome) throws IOException {
		File inputFile = new File(caminho);
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		boolean encontrado = false;

		while ((currentLine = reader.readLine()) != null) {
			if (currentLine.contains(cpf)) {
				encontrado = true;
				String novaLinha = "Cliente{nome='" + novoNome + "', cpf='" + cpf + "'}";
				writer.write(novaLinha + System.lineSeparator());
			} else {
				writer.write(currentLine + System.lineSeparator());
			}
		}

		writer.close();
		reader.close();

		if (!inputFile.delete()) return false;
		if (!tempFile.renameTo(inputFile)) return false;

		return encontrado;
	}

}

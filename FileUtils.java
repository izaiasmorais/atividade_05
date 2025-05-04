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
}

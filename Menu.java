import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;

	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public int getSelection() {
		int op = -1;
		while (op == -1) {
			System.out.println(title + "\n");
			int i = 0;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				op = -1;
			}
			if (op < 0 || op >= options.size()) {
				System.out.println("Opcao errada!");
				op = -1;
			}

		}
		return op;
	}
}

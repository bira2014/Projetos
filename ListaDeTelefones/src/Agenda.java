import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Agenda {

	public static void main(String[] args) throws IOException {
		Agenda lista = new Agenda();
		Scanner ler = new Scanner(System.in);
		int opcao;
		String Agenda;
		importar();

		do {
			System.out.printf("**** Menu Principal *****\n");
			System.out.printf("[ 1 ] Incluir Contato\n");
			System.out.printf("[ 2 ] Excluir Contato\n");
			System.out.printf("[ 3 ] Listar Contatos\n");
			System.out.printf("[ 4 ] Pesquisar Contato\n");
			System.out.printf("[ 9 ] Encerrar o Programa\n");
			System.out.printf("\nOpção Desejada: ");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				incluir();
				break;
			case 2:
				excluir();
				break;
			case 3:
				listar();
				break;
			case 4:
				pesquisar();
			}

			System.out.printf("\n\n");

		} while (opcao != 9);

		exportar();
	}

	public static void importar() {
		try {
			FileReader arq = new FileReader("agenda.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {
				Agenda.add(linha);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.",
					e.getMessage());
		}
	}

	private static void add(String linha) {
		

	}

	public static void exportar() throws IOException {
		FileWriter arq = new FileWriter("agenda.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		int i, n = Agenda.size();
		for (i = 0; i < n; i++) {
			gravarArq.printf("%s%n", Agenda.get(i));
		}
		gravarArq.close();
	}

	private static int size() {

		return 0;
	}

	private static Object get(int i) {

		return null;
	}

	public static void incluir() {
		Scanner ler = new Scanner(System.in);
		String nome, telefone;

		System.out.printf("\nInforme o nome do contato:\n");
		nome = ler.nextLine();

		System.out.printf("\nInforme o telefone do contato:\n");
		telefone = ler.nextLine();

		Agenda.add(nome + ";" + telefone);
	}

	public static void excluir() {
		Scanner ler = new Scanner(System.in);
		int i;

		listar();

		System.out.printf("\nInforme a posição a ser excluída:\n");
		i = ler.nextInt();

		try {
			Agenda.remove(i);
		} catch (IndexOutOfBoundsException e) {

			System.out.printf("\nErro: posição inválida (%s).\n\n",
					e.getMessage());
		}
	}

	private static void remove(int i) {

	}

	public static void listar() {
		System.out.printf("\nListadando os itens da Agenda:\n");
		int i, n = Agenda.size();
		for (i = 0; i < n; i++) {
			System.out.printf("Posição %d- %s\n", i, Agenda.get(i));
		}
		System.out.printf("***************************************"); 
	}

	public static void pesquisar() {
		Scanner ler = new Scanner(System.in);
		String s;

		System.out.printf("\nInforme o nome do contato:\n");
		s = ler.nextLine();

		int i, n = Agenda.size();
		s = s.toUpperCase();
		String dados[];
		for (i = 0; i < n; i++) {

			if (((String) Agenda.get(i)).toUpperCase().indexOf(s) != -1) {
				dados = ((String) Agenda.get(i)).split(";");
				System.out.printf("\nNome....: %s", dados[0]);
				System.out.printf("\nTelefone: %s\n", dados[1]);
			}
		}
	}

}

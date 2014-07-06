
	import java.io.*; 
	import java.util.*; 
   	import javax.swing.*; 
	public class PesqBin { 
	public static void main(String []args){ 
	  
		PesqBinAgTelef lista = new PesqBinAgTelef();	
	  String agenda;
	  importar();
		 
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
			Scanner entrada = new Scanner(System.in); 
	String nome[] = new String[4]; 
	int comeco, meio = 0, fim; 
	boolean acha = false; 
	String pesquisa = "", opcao = ""; 
	char continua = 'S'; 
	/* Entrada de dados */ 
	for (int i = 0; i < nome.length; i++){ 
	System.out.print("\nEntre com o " + (i+1) + "° nome !"); 
	nome<i> = entrada.next().toUpperCase(); 
	System.out.println("Posição Cadastro = " + i); 
	} 
	/* Comando de ordenação */ 
	Arrays.sort(nome); 
	System.out.println("\n \'Nomes em Ordem Crescente\' \n"); 
	for (int i = 0; i < nome.length; i++){ 
	System.out.println("Pos >> " + i + " >> " + nome<i>); 
	} 
	/* Método pesquisar */ 
	do{ 
	System.out.println("\nEntre com o nome a ser pesquisado !"); 
	pesquisa = entrada.next().toUpperCase(); 
	comeco = 0; 
	fim = nome.length - 1; 
	acha = false; 
	while((comeco <= fim) && (acha == false)){ 
	meio = ((comeco + fim)/2); 
	if(nome[0].toUpperCase().equalsIgnoreCase(pesquisa)){ 
	acha = true; 
	meio = 0; 
	break; 
	} 
	if(nome[meio].toUpperCase().equalsIgnoreCase(pesquisa)){ 
	acha = true; 
	break; 
	} 
	else{ 
	if(nome[meio].toUpperCase().startsWith(pesquisa)) 
	fim = meio - 1; 
	else 
	comeco = meio + 1; 
	} 
	} 
	/* Método que imprime o Resultado */ 
	if(acha){ 
	System.out.println("O nome \"" + pesquisa + "\" foi localizado na posição \'" + meio + "\'"); 
	}else{ 
	System.out.println("O nome \"" + pesquisa + "\" não foi localizado !"); 
	} 
	System.out.println("Deseja continuar, S/N ? "); 
	desejo = entrada.next().toUpperCase(); 
	continua = desejo.charAt(0); 
	}while(continua != 'N'); 
	System.in.read(); 
	}catch(Exception erro){ 
	System.exit(0); 
	} 
	} 
	}

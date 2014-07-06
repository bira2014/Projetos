//========================================//
// Implementa da Agenda com Pesq Binaria  //
//                                        //
//========================================//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Pesq {	public static void main(String []args){

	importar();

}
	private static void importar(){
		try { 
			FileReader arq = new FileReader("agenda.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {
								linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.",
					e.getMessage());
		}

		try{      
//***********AQUI VOCE TESTA OS REGISTROS PRESENTES NO ARQUIVO"agenda"********			
			
			
			Scanner entrada = new Scanner(System.in);
			String nome[] = new String[4];      
			int comeco, meio = 0, fim;      
			boolean acha = false;      
			String pesquisa = "", segue = "";      
			char continua= 'S';     

			/* Entrada de dados */     
			for (int a = 0; a < nome.length; a++){      
				System.out.print("\nEntre com o " + (a+1) + "° nome :");      
				nome[a] = entrada.next().toUpperCase();      
				System.out.println("Posição Cadastro = " + a);      
			}      
//*****************************************************************************
			/* Colocar os dados em Ordem */                   
			Arrays.sort(nome);      
			System.out.println("\n    \'Nomes em Ordem Crescente\' \n");      

			for (int i = 0; i < nome.length; i++){      
				System.out.println("Pos  >> "  + i + "  >>  "+ nome+"<i>");       
			}      

			/* Fazer pesquisa */                  
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
				segue = entrada.next().toUpperCase();      
				continua = segue.charAt(0);                    
			}while(continua != 'N');        
			System.in.read();      
		}catch(Exception erro){      
			System.exit(0);                  
		}          
	}
}




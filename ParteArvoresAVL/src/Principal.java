
public class Principal {


public static void main(String[] args)
	{
		 ArvoresDados<Integer> arvore = new ArvoresDados<Integer>();
		
		arvore.insere(6);
		arvore.insere(3);
		arvore.insere(-3);
		arvore.insere(7);
		arvore.insere(4);
		arvore.insere(5);
		arvore.insere(9);
		arvore.insere(8);
		arvore.insere(2);
		arvore.insere(1);
		
		System.out.println("Pr�-fixada");
		arvore.imprimeArvore('p');
		System.out.println("\nSim�trica");
		arvore.imprimeArvore('s');
		System.out.println("\nP�s-fixada");
		arvore.imprimeArvore('o');
		
	}

}

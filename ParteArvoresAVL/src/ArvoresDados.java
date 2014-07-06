
public class ArvoresDados<T>
{
	Nodo<T> raiz;
	
	public ArvoresDados()
	{
		this.raiz = null;
	}
	
	public void insere(T informacao)
	{
		Nodo<T> novo = new Nodo<T>();
		novo.setInformacao(informacao);

		if (this.raiz == null)
			this.raiz = novo;
		else
			insereOrdenado(this.raiz, novo);
	}
	
	private void insereOrdenado(Nodo<T> nodoAtual, Nodo<T> nodoNovo)
	{
		if (nodoNovo.getInformacao().toString().compareTo(
				nodoAtual.getInformacao().toString()) < 0)
		{
			if (nodoAtual.getEsquerdo() == null)
				nodoAtual.setEsquerdo(nodoNovo);
			else
				insereOrdenado(nodoAtual.getEsquerdo(), nodoNovo);
		}
		else
		{
			if (nodoAtual.getDireito() == null)
				nodoAtual.setDireito(nodoNovo);
			else
				insereOrdenado(nodoAtual.getDireito(), nodoNovo);
		}
	}
	
	public void imprimeArvore(char tipo)
	{
		switch (tipo)
		{
			case 's': // simetrica
				imprimeSimetrica(this.raiz);
			break;
			case 'p': // pré-fixada
				imprimePreFixada(this.raiz);
			break;
			case 'o': // pós-fixada
				imprimePosFixada(this.raiz);
			break;
		}
	}

	private void imprimePreFixada(Nodo<T> nodoAtual)
	{
		if (nodoAtual != null)
		{
			System.out.println(nodoAtual.getInformacao().toString());
			imprimePreFixada(nodoAtual.getEsquerdo());
			imprimePreFixada(nodoAtual.getDireito());
		}
	}

	private void imprimePosFixada(Nodo<T> nodoAtual)
	{
		if (nodoAtual != null)
		{
			imprimePosFixada(nodoAtual.getEsquerdo());
			imprimePosFixada(nodoAtual.getDireito());
			System.out.println(nodoAtual.getInformacao().toString());
		}
	}

	private void imprimeSimetrica(Nodo<T> nodoAtual)
	{
		if (nodoAtual != null)
		{
			imprimeSimetrica(nodoAtual.getEsquerdo());
			System.out.println(nodoAtual.getInformacao().toString());
			imprimeSimetrica(nodoAtual.getDireito());
		}
	}
}

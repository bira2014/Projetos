
public class Nodo<T>
{
	private T informacao;
	private Nodo<T> esquerdo;
	private Nodo<T> direito;

	
	
	public Nodo()
	{
		this.informacao = null;
		this.esquerdo = null;
		this.direito = null;
	}

	public T getInformacao()
	{
		return this.informacao;
	}

	public void setInformacao(T informacao)
	{
		this.informacao = informacao;
	}

	public Nodo<T> getEsquerdo()
	{
		return this.esquerdo;
	}

	public void setEsquerdo(Nodo<T> esquerdo)
	{
		this.esquerdo = esquerdo;
	}

	public Nodo<T> getDireito()
	{
		return this.direito;
	}

	public void setDireito(Nodo<T> direito)
	{
		this.direito = direito;
	}

}

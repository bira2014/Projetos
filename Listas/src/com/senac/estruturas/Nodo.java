package com.senac.estruturas;

import static java.lang.System.out;

public class Nodo {
	
	private int  dado;
	private Nodo next;

	private Nodo()
	{
		dado = 0;
	}
	
	private Nodo(int i)
	{
		dado = i;
		next = null;
	}
	
	private void setData(int i)
	{
		dado = i;
		next = null;
	}
	
	private int getData()
	{
		return dado;
	}

	private void setNext(Nodo next)
	{
		this.next = next;
	}
	
	private Nodo getNext()
	{
		return next;
	}
	
	private static void print(Nodo head)
	{
		Nodo elem = head;
		do {
			out.println(elem.getData());
			elem = elem.getNext();
		} while (elem != null);
	}
	
	private static void insertBefore(Nodo antigo, Nodo novo)
	{
		novo.setNext(antigo);
	}
	
	private static void insertAfter(Nodo novo, Nodo antigo)
	{
		novo.setNext(antigo.getNext());
		antigo.setNext(novo);
	}
	
	public static void main(String[] args) {
		// criar lista
		Nodo head = new Nodo(), novo;
		head.setData(2);
		
		novo = new Nodo(3);
		insertAfter(novo, head);
		
		novo = new Nodo(1);
		insertBefore(head, novo);
		
		head = novo;
		
		print(head);
	}

}

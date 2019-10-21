package pilha;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PilhaComArray<E> {

	E[] pecas;
	int tamanho;
	int ultimaPeca;

	public PilhaComArray(Class<E> classePilha) {
		pecas = (E[]) Array.newInstance(classePilha, 10);
		tamanho = 0;
	}

	public void empilhar(int posicao, E peca) {
		if (posicao < tamanho) {
			throw new IllegalArgumentException("índice inválido");

		}
		if (tamanho == pecas.length) {
			E[] novaPeca = Arrays.copyOf(pecas, Math.round(1.5f * tamanho));
			for (int i = 0; i < novaPeca.length; i++) {
				novaPeca[i] = pecas[i];
				pecas = novaPeca;

			}

		}
		for (int i = tamanho; i > posicao; i--) {
			pecas[i] = pecas[i - 1];
		}
		pecas[posicao] = peca;
		ultimaPeca = posicao;
		tamanho++;

	}

	public void desempilhar() {
		if (ultimaPeca < pecas.length) {
			for (int i = ultimaPeca; i >= 0; i--) {
				System.out.println("desemplilhando "+pecas[i]);
			}

		}
		
		}

	public int obterTamanho() {
		return tamanho;

	}

	
	public E mostrarPilha(int posicao) {
		if (posicao >= tamanho)
			throw new IllegalArgumentException("índice inválido");
		return pecas[posicao];
	}

	public static void main(String[] args) {
		PilhaComArray<Integer> pilha = new PilhaComArray<>(Integer.class);
		pilha.empilhar(0, 3);
		pilha.empilhar(1, 5);
      
		for (int i = 0; i < pilha.obterTamanho(); i++) {
			System.out.println("implilhando peça da pilha  "+pilha.mostrarPilha(i));
		

		}
		  pilha.desempilhar();
//		for (int j=0; j <= pilha.obterTamanho(); j++) {
//			System.out.println("desimplilhando peca da pilha  "+pilha.desempilhar(j));
//				}
	}
}
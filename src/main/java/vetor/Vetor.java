package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparator<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public Object remover(T o) {
		T resultado = null;
		for(int i = 0; i < this.arrayInterno.length; i++){
			if(this.arrayInterno[i].equals(o)){
				resultado = this.arrayInterno[i];
				this.arrayInterno[i] = this.arrayInterno[indice];
				this.arrayInterno[indice] = null;
				indice--;
			}
		}
		return resultado;
	}

	// Procura um elemento no vetor
	public Object procurar(T o) {
		T achou = null;
		for(int i = 0; i < this.arrayInterno.length; i++){
			if(this.arrayInterno[i].equals(o)){
				achou = this.arrayInterno[i];
			}
		}
		return achou;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice == this.tamanho - 1;
	}
}

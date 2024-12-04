package produto;

public interface RepositorioProdutos<T extends Produto> {

	int procurarIndice(int codigo);

	boolean existe(int codigo);

	void inserir(T produto);

	void atualizar(T produto);

	void remover(int codigo);

	Produto procurar(int codigo);
}

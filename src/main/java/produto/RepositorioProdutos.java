package produto;

public interface RepositorioProdutos<T extends Produto> {

	int procurarIndice(int codigo);

	boolean existe(int codigo);

	void inserir(Produto produto);

	void atualizar(Produto produto);

	void remover(int codigo);

	Produto procurar(int codigo);
}

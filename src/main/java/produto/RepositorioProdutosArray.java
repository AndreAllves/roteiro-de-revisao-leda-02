package produto;

public class RepositorioProdutosArray<T extends Produto> implements RepositorioProdutos<T> {
    private T[] produtos;
    private int index;

    public RepositorioProdutosArray(int size){
        super();
        this.produtos = (T[]) new Object[size]; 
        this.index = -1;

    }

    @Override
    public int procurarIndice(int codigo) {
        // TODO Auto-generated method stub
        for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i].getCodigo() == codigo) return i;
		}
		return -1;
	}

    @Override
    public boolean existe(int codigo) {
        if (procurarIndice(codigo) == -1) return false;
		return true; 
    }

    @Override
    public void inserir(T produto) {
        this.index++;
		this.produtos[this.index] = produto;
    }

    @Override
    public void atualizar(T produto) {
        Boolean achou = false;
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i].equals(produto)) {
				this.produtos[i] = produto;
				achou = true;
				break;
			}
		}

		if (!achou) new IllegalArgumentException("Produto não existente");
    }

    @Override
    public void remover(int codigo) {
        int pos = procurarIndice(codigo);
		if (pos == -1) new IllegalArgumentException("Produto não existente");
		
		this.produtos[pos] = null;
		for(int i = pos; i < this.produtos.length; i++) {
			this.produtos[pos] = this.produtos[pos+1];
			this.produtos[pos+1] = this.produtos[pos];
		}

		this.index--;
	}

    @Override
    public Produto procurar(int codigo) {
        int i = this.procurarIndice(codigo);
		if (i != -1) {
			return this.produtos[i];
		} else {
			return null;
		}
    }
}

public class Arvore {
    private No raiz;

    public Arvore(int raiz) {
        this.raiz = new No(raiz, null);
    }

    public void inserir(int numero){
        this.raiz.adicionarNumero(numero);
    }

    public boolean buscar(int numero) {
        return this.raiz.buscarNumero(numero);
    }

    public void remover(int numero) {
        this.raiz.excluirNo(numero);
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
}

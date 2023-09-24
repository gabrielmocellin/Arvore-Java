public class Arvore {
    private No raiz;

    public Arvore(int raiz) {this.raiz = new No(raiz, null);}
    public boolean isVazia(){return this.raiz == null;}
    public void inserir(int numero){this.raiz.adicionarNumero(numero);}
    public boolean buscar(int numero) {return this.raiz.buscarNumero(numero);}
    public void remover(int numero) {raiz = raiz.excluirNo(numero, raiz);}
    public No getRaiz() {return raiz;}
    public static Arvore criarArvore_Base() {
        Arvore arvore = new Arvore(50);
        arvore.inserir(70);
        arvore.inserir(30);
        arvore.inserir(80);
        arvore.inserir(20);
        arvore.inserir(60);
        arvore.inserir(40);
        return arvore;
    }
}

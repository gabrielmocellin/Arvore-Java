// Nó raiz é passado para a função remover como parametro inicial,
// e a navegação por dentro da árvore é feita comparando o dado armazenado no nó
// assim, norteando a busca para esquerda e direita da árvore.
// Verificar se o valor passado como parametro é maior ou menor que o valor do nó atual.
// Ao remover é necessário verificar se é nulo um dos lados.
// A raiz deve ser retornada ao invés do valor do nó removido
/*

 Requisitos Mínimos trabalho :

 BST (Binary Search Tree)
 - Insert
 - Remove
 - Busca
 - Impressão (pode copiar)

 Ponto extra :

 AVL e README GitHub CAPRICHADO (com imagens)

*/
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

    public void excluir() {

    }
}

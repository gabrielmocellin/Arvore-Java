public class No {
    private int informacao;
    private No noPai, filhoEsquerda, filhoDireita;

    public No(int informacao, No noPai){
        this.informacao = informacao;
        this.noPai = noPai;
        this.filhoEsquerda= null;
        this.filhoDireita = null;
    }

    public void adicionarNumero(int numero) {
    /* ALGORITMO
       1- Verifica se o número que deseja-se inserir é maior ou igual a informação do nó atual
       2- Caso positivo iremos inserir o número no filho a direita do nó atual
            2.1- Verifica se o filho a direita do nó atual é nulo
            2.2- Caso positivo é instanciando no filho a direita do nó atual um novo nó com o número desejado
            2.3- Caso negativo a função é chamada recursivamente no filho a direita do nó atual
       3- Caso negativo iremos inserir o número no filho a esquerda do nó atual com a mesma lógica descrita nos passos
          2.1 , 2.2 e 2.3
    */
        if(numero >= this.informacao){
            if (this.filhoDireita == null)
                this.filhoDireita = new No(numero, this);
            else
                this.filhoDireita.adicionarNumero(numero);
        } else {
            if (this.filhoEsquerda == null)
                this.filhoEsquerda = new No(numero, this);
            else
                filhoEsquerda.adicionarNumero(numero);
        }
    }

    public boolean buscarNumero(int numero) {
    /* ALGORITMO
       1- Verifica se a informação do nó atual bate com o número que está sendo buscado (caso positivo retorna true)
       2- Caso negativo verifica se o número que está sendo buscado é menor que o nó atual
       3- Caso seja menor, é verificado se o filho a esquerda do nó atual é nulo
       4- Caso seja nulo retornamos false (pois chegamos ao nó folha e o número buscado não está presente na árvore)
       5- Caso não seja nulo a função é chamada recursivamente no filho a esquerda do nó atual
    */
        if (numero == this.informacao) {
            return true;
        } else if (numero < this.informacao) {
            if (this.filhoEsquerda == null)
                return false;
            else
                return this.filhoEsquerda.buscarNumero(numero);
        } else {
            if (this.filhoDireita == null)
                return false;
            else
                return this.filhoEsquerda.buscarNumero(numero);
        }
    }

    public void excluirNo(int numero){
    /* ALGORITMO
       1- Verifica se a informação do nó atual bate com o número que está sendo buscado (caso positivo entra na outra verificação)
       2- Verifica se o filho da esquerda for nulo, caso ele seja nulo, ele verifica se a informação do nó atual (que está sendo excluido) é maior ou igual ao valor do nó pai,
       caso o nó pai seja menor atribui o filho direito do nó pai para o filho direito do nó atual. Senão
       3-
    */
        if (numero == this.informacao) {
            if (this.filhoEsquerda == null) {
                if (numero >= this.noPai.informacao)
                    this.noPai.filhoDireita = this.filhoDireita;
                else
                    this.noPai.filhoEsquerda = this.filhoDireita;
            } else if (filhoDireita == null) {
                if (numero >= this.noPai.informacao)
                    this.noPai.filhoDireita = this.filhoEsquerda;
                else
                    this.noPai.filhoEsquerda = this.filhoEsquerda;
            } else {
                No noTroca = this.filhoDireita;
                while (noTroca.filhoEsquerda != null) {
                    noTroca = noTroca.filhoEsquerda;
                }

            }
        } else {
            if (numero >= this.informacao)
                this.filhoDireita.excluirNo(numero);
            else
                this.filhoEsquerda.excluirNo(numero);
        }
    }
}
